package city.baltimore.eip.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.EnumUtils;

import city.baltimore.eip.dao.CityworksEndpointSource;
import city.baltimore.eip.dao.MappingsDao;
import city.baltimore.eip.dao.MotorolaCsrEndpointSource;
import city.baltimore.eip.dao.SalesforceEndpointSource;
import city.baltimore.eip.model.CsrElement;
import city.baltimore.eip.model.Geometry;
import city.baltimore.eip.model.cityworks.CityworksServiceRequest;
import city.baltimore.eip.model.cityworks.ServiceRequestAnswer;
import city.baltimore.eip.model.motorola.csr.*;
import city.baltimore.eip.model.salesforce.*;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.xml.transform.StringResult;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CsrToSrMappingServiceImpl implements CsrToSrMappingService {
	private static final Logger logger = Logger.getLogger(CsrToSrMappingServiceImpl.class);

	@Autowired
	ArcGISService arcgisService;

	@Autowired
	CityworksService cityworksApiService;

	@Autowired
	MappingsDao mappingsDao;

	/**
	 * Cityworks connection parameters. Should be loaded via dependency injection using config settings.
	 */
	@Autowired
	public CityworksEndpointSource cityworksEndpointSource;

	/**
	 * Motorola App Hub connection parameters. Should be loaded via dependency injection using config settings.
	 */
	@Autowired
	public MotorolaCsrEndpointSource motorolaAppHubCsrEndpointSource;

	/**
	 * Cityworks connection parameters. Should be loaded via dependency injection using config settings.
	 */
	@Autowired
	public SalesforceEndpointSource salesforceEndpointSource;

	final public static String SERVICE_REQUEST_VIEW_PATH = "WorkManagement/RequestEdit.aspx?RequestId=";

	public String getCityworksServiceRequestUrl() {
		return this.cityworksEndpointSource.getCityworksPublicBaseUrl().replace("Services", SERVICE_REQUEST_VIEW_PATH);
	}

	/**
	 * The value to put in the Cityworks Text4 field to denote that Othersystemid is for Morotorola CSR.
	 */
	@Value("${cityworks.text4.motorola}")
	public String motorolaText4Note;

	/**
	 * The value to put in the Cityworks Text4 field to denote that Othersystemid is for Salesforce.
	 */
	@Value("${cityworks.text4.salesforce}")
	public String salesforceText4Note;

	/**
	 * The Motorola App Hub param used to pass the Cityworks ID or URL).
	 */
	@Value("${motorola.cityworks-id.code}")
	public String motorolaCityworksIdCode;

	@Override
	public CityworksServiceRequest TranslateToSr(Document csrDocument) throws Exception {
		CityworksServiceRequest citySr = new CityworksServiceRequest();
		citySr.setText4(this.motorolaText4Note);

		/*
		 * The only parameter required by Cityworks for a new service request is the Problem ID, which will need to be obtained via the Prc_code.
		 * Throw an error if this code is not available.
		 */
		String prcCode = csrDocument.getPrcInstance().getPrcCode();
		String motorolaId = csrDocument.getPrcInstance().getPrcNumber();
		if (prcCode == null || prcCode.isEmpty())
			throw new IllegalArgumentException("New CSR (Motorola ID=" + motorolaId + ") must include the Prc_code to obtain a Cityworks problem ID. Aborting processing.");
		// Obtain the problemsid by calling the Cityworks API
		try {
			citySr.setProblemSid(cityworksApiService.GetProblemSid(prcCode));
		} catch (Throwable t) {
			throw new Exception("Error obtaining the ProblemSid from Cityworks for new CSR (Motorola ID=" + motorolaId + ") " + t.getMessage(), t);
		}
		// Obtain Cityworks answerids for the questions in the Motorola prc_attributes by calling the Cityworks API.
		ArrayList<String> questions = new ArrayList<String>();
		List<PrcAttributeType> questionAnswers = csrDocument.getPrcInstance().getPrcAttributes().getPrcAttribute();
		if (questionAnswers.size() > 0) {
			for (PrcAttributeType questionAnswer : questionAnswers) {
				questions.add(questionAnswer.getCustomAttributeDefsDesc());
			}
			Map<String, Integer> questionsAnswerIds;
			try {
				questionsAnswerIds = cityworksApiService.GetAnswerIds(citySr.getProblemSid(), questions);
			} catch (Throwable t) {
				throw new Exception("Error obtaining the Answerid(s) from Cityworks for new CSR (Motorola ID=" + motorolaId + ") " + t.getMessage(), t);
			}
			ArrayList<ServiceRequestAnswer> answers = new ArrayList<ServiceRequestAnswer>();
			for (Map.Entry<String, Integer> questionsAnswerId : questionsAnswerIds.entrySet()) {
				String question = questionsAnswerId.getKey();
				String answerValue = null;
				for (PrcAttributeType questionAnswer : questionAnswers) {
					if (questionAnswer.getCustomAttributeDefsDesc().equals(question)) {
						answerValue = questionAnswer.getAttributeValue();
						break;
					}
				}
				answers.add(new ServiceRequestAnswer(questionsAnswerId.getValue(), answerValue));
			}
			citySr.setAnswers(answers);
		}

		// Set the other attributes. If not found, will just be left null.
		String comments = csrDocument.getPrcInstance().getDetails();
		if (comments != null)
			comments = comments.replaceAll("\\[", " ").replaceAll("\\]", " ");
		citySr.setComments(comments);
		// Obtain the mapped Cityworks Priority from the translation list. If not found in the list, null.
		citySr.setPriority(mappingsDao.getPriorityMappings().get(csrDocument.getPrcInstance().getPriorityCode().trim()));
		// citySr.setComments(csrDocument.getPrcInstance().getPriorityCode());
		citySr.setOtherSystemId(motorolaId);

		// Find the latest historical area. Date format is "MM/DD/YYYY HH:MM:SS AM/PM".
		PrcHistoricalGeoAreaType lastPrcHistoricalGeoArea = GetMostRecent(csrDocument.getPrcInstance().getPrcHistoricalGeoAreas().getPrcHistoricalGeoArea());
		if (lastPrcHistoricalGeoArea != null)
			citySr.setDistrict(lastPrcHistoricalGeoArea.getConfigLocationCode());

		// Find the latest geolocation.
		LocationType lastLocation = GetMostRecent(csrDocument.getPrcInstance().getGeoLocations().getGeoLocation());
		if (lastLocation != null) {
			citySr.setAddress(lastLocation.getDisplayAddress());
			citySr.setAptNum(lastLocation.getUnitNumber());
			citySr.setCity(lastLocation.getCity());
			citySr.setState(lastLocation.getRegion());
			citySr.setStreetName(lastLocation.getStreetName() + " " + lastLocation.getStreetTypeCode());
			citySr.setX(lastLocation.getXValue().doubleValue());
			citySr.setY(lastLocation.getYValue().doubleValue());
			citySr.setZip(lastLocation.getCityZone());
			citySr.setLocation(lastLocation.getLocationDetails());
		}

		// Get the latest caller.
		List<PrcParticipantType> participants = csrDocument.getPrcInstance().getPrcParticipants().getPrcParticipant();
		PrcParticipantType lastParticipant = GetMostRecent(participants);
		if (lastParticipant != null) {
			citySr.setCallerType(lastParticipant.getResInstance().getResCode());

			citySr.setCallerCallTime(DateUtils.GetDateAsTextForCityworks(DateUtils.GetDate(lastParticipant.getCreatedDate())));
			// Get the list of phone number(s) for the latest participant.
			List<ResPhoneType> resPhones = lastParticipant.getResInstance().getResPhones().getResPhone();
			citySr.setCallerCellPhone(GetPhoneNumber(PhoneType.CELL, resPhones));
			citySr.setCallerHomePhone(GetPhoneNumber(PhoneType.HOME, resPhones));
			citySr.setCallerWorkPhone(GetPhoneNumber(PhoneType.WORK, resPhones));
			citySr.setCallerOtherPhone(GetPhoneNumber(PhoneType.OTHER, resPhones));

			// Get the last participant's last geolocation
			LocationType lastParticipantLastLocation = GetMostRecent(lastParticipant.getResInstance().getGeoLocations().getGeoLocation());
			if (lastParticipantLastLocation != null) {
				citySr.setCallerAddress(lastParticipantLastLocation.getDisplayAddress());
				citySr.setCallerAptNum(lastParticipantLastLocation.getUnitNumber());
				citySr.setCallerCity(lastParticipantLastLocation.getCity());
				citySr.setCallerDistrict(lastParticipantLastLocation.getDistrict());
				citySr.setCallerState(lastParticipantLastLocation.getRegion());
				citySr.setCallerZip(lastParticipantLastLocation.getCityZone());
			}

			ResElectronicAddressType lastElectronicAddress = GetMostRecent(lastParticipant.getResInstance().getResElectronicAddresses().getResElectronicAddress());
			if (lastElectronicAddress != null)
				citySr.setCallerEmail(lastElectronicAddress.getElectronicAddress());

			ResNameType lastResName = GetMostRecent(lastParticipant.getResInstance().getResNames().getResName());
			if (lastResName != null) {
				citySr.setCallerFirstName(lastResName.getNameField02());
				citySr.setCallerLastName(lastResName.getNameField04());
				citySr.setCallerMiddleInitial(lastResName.getNameField03());
			}
		}
		return citySr;
	}

	@Override
	public Document TranslateToCsr(CityworksServiceRequest cityworksServiceRequest) {
		Document csrDoc = new Document();
		PrcInstance prcInstance = new PrcInstance();
		prcInstance.setPrcNumber(cityworksServiceRequest.getOtherSystemId());
		PrcAttributesType prcAttributes = new PrcAttributesType();
		PrcAttributeType cityworksUrlAttribute = new PrcAttributeType();
		cityworksUrlAttribute.setCustomAttributeDefsCode(this.motorolaCityworksIdCode);
		cityworksUrlAttribute.setPrcCode(cityworksServiceRequest.getProblemCode());
		cityworksUrlAttribute.setAttributeValue(cityworksServiceRequest.getRequestId() + "");
		prcAttributes.getPrcAttribute().add(cityworksUrlAttribute);
		prcInstance.setPrcAttributes(prcAttributes);
		csrDoc.setPrcInstance(prcInstance);
		return csrDoc;
	}

	@Override
	public String WrapCsrDocInSoapXml(StringResult csrDocXml) {
		String csrXmlText = csrDocXml.toString();
		// Need to determine if this is a status update and set the correct event code in the XML message
		String eventCode;
		if (csrXmlText.indexOf("<Status_code>CLOSED</Status_code>") >= 0 || csrXmlText.indexOf("<Status_code>DUPCLOSD</Status_code>") >= 0)
			eventCode = "XUPDSR";
		else
			eventCode = "XAPPSR";

		StringBuilder soapMessageBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		soapMessageBuilder.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.hub.mot/\"><soapenv:Header /><soapenv:Body><web:asp_sendToCSR2><id>");
		soapMessageBuilder.append(this.motorolaAppHubCsrEndpointSource.getAppHubUserId());
		soapMessageBuilder.append("</id><pass>");
		soapMessageBuilder.append(this.motorolaAppHubCsrEndpointSource.getAppHubPassword());
		soapMessageBuilder.append("</pass><csrXml><![CDATA[<csreai:csreai-msg xmlns:csreai=\"http://www.motorola.com/Schema/csreai\" xmlns:csr=\"http://www.motorola.com/Schema/csr\"><csreai:header><csreai:eid /><csreai:reference_id>");
		soapMessageBuilder.append(String.valueOf(UUID.randomUUID()));
		soapMessageBuilder.append("</csreai:reference_id><csreai:event_date>");
		soapMessageBuilder.append(DateUtils.GetDateAsTextForMotorola(new Date()));
		soapMessageBuilder.append("</csreai:event_date><csreai:sr_type_code>");
		soapMessageBuilder.append(csrXmlText.substring(csrXmlText.indexOf("<Prc_code>") + 10, csrXmlText.indexOf("</Prc_code>")));
		soapMessageBuilder.append("</csreai:sr_type_code><csreai:event_type_code>REQUEST</csreai:event_type_code><csreai:eai_event_code>");
		soapMessageBuilder.append(eventCode);
		soapMessageBuilder.append("</csreai:eai_event_code><csreai:source_code>");
		soapMessageBuilder.append(this.motorolaAppHubCsrEndpointSource.getSourceCode());
		soapMessageBuilder.append("</csreai:source_code><csreai:target_code>PRIMAPP</csreai:target_code><csreai:status_code>OPEN</csreai:status_code><csreai:details /></csreai:header><csreai:body>");
		// Remove the XML opening tag on the Doc
		soapMessageBuilder.append(csrXmlText.substring(csrXmlText.indexOf(">") + 1));
		soapMessageBuilder.append("</csreai:body></csreai:csreai-msg>]]></csrXml></web:asp_sendToCSR2></soapenv:Body></soapenv:Envelope>");
		return soapMessageBuilder.toString();
	}

	@Override
	public String WrapCsrMsgInSoapXml(String csrXmlText) {
		StringBuilder soapMessageBuilder = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		soapMessageBuilder.append("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:web=\"http://webservice.hub.mot/\"><soapenv:Header /><soapenv:Body><web:asp_sendToCSR2><id>");
		soapMessageBuilder.append(this.motorolaAppHubCsrEndpointSource.getAppHubUserId());
		soapMessageBuilder.append("</id><pass>");
		soapMessageBuilder.append(this.motorolaAppHubCsrEndpointSource.getAppHubPassword());
		soapMessageBuilder.append("</pass><csrXml><![CDATA[");
		// Remove the message's XML tag if present
		if (csrXmlText.toLowerCase().indexOf("<?xml") >= 0)
			csrXmlText = csrXmlText.substring(csrXmlText.indexOf(">") + 1);
		soapMessageBuilder.append(csrXmlText);
		soapMessageBuilder.append("]]></csrXml></web:asp_sendToCSR2></soapenv:Body></soapenv:Envelope>");
		return soapMessageBuilder.toString();
	}

	/**
	 * Obtains the element that has been updated last (according to Updated_Date which must be in the form: "MM/DD/YYYY HH:MM:SS AM/PM").
	 * @param The list of elements to search.
	 * @return The most recent element in the list.
	 * @throws ParseException
	 */
	@SuppressWarnings("unchecked")
	public <T> T GetMostRecent(List<? extends CsrElement> elements) throws ParseException {
		T lastElement = null;
		if (elements.size() > 1) {
			Date mostRecent = DateUtils.GetDate(((CsrElement) (elements.get(0))).getUpdatedDate().toString());
			int mostRecentIndex = 0;
			int i = 0;
			for (CsrElement element : elements) {
				Date date = DateUtils.GetDate(((CsrElement) element).getUpdatedDate().toString());
				int p = mostRecent.compareTo(date);
				// if p < 0 then the new date is more recent than the saved date
				if (p < 0) {
					mostRecent = date;
					mostRecentIndex = i;
				}
				i++;
			}
			lastElement = (T) elements.get(mostRecentIndex);
		} else if (elements.size() == 1)
			lastElement = (T) elements.get(0);
		return lastElement;
	}

	/**
	 * Obtain the corresponding phone number for a particular code.
	 * @param phoneCode The phone code to find the corresponding number.
	 * @param resPhones The list of phone entries to search.
	 * @return The phone number corresponding to that code, or null if not found.
	 */
	public String GetPhoneNumber(PhoneType phoneCode, List<ResPhoneType> resPhones) {
		String cellNum = null;
		for (ResPhoneType resPhone : resPhones) {
			if (resPhone.getPhoneCode().equals(phoneCode.name())) {
				return resPhone.getPhoneNumber();
				// There are other types of codes coming back from Motorola
				// (e.g. PHONE3), so Cityworks Other phone number just look for
				// one of the non-standard phone codes.
			} else if (phoneCode.name() == PhoneType.OTHER.toString() && !EnumUtils.isValidEnum(PhoneType.class, resPhone.getPhoneCode())) {
				return resPhone.getPhoneNumber();
			}
		}
		return cellNum;
	}

	/**
	 * Types of phone numbers. The enums must exactly match the codes sent from Motorola, except for OTHER.
	 * 
	 * @author James.Somerville
	 *
	 */
	public enum PhoneType {
		CELL, HOME, WORK, OTHER
	}

	@Override
	public CityworksServiceRequest SalesforceTranslateToSr(SalesforceRequest salesforceRequest) throws Exception {
		CityworksServiceRequest citySr = new CityworksServiceRequest();
		String serviceCode = salesforceRequest.getServiceCode();
		String salesforceId = salesforceRequest.getServiceRequestId();

		citySr.setText4(this.salesforceText4Note);

		// The only parameter required by Cityworks for a new service request is the Problem ID, which will need to be obtained via the service_code
		citySr.setProblemSid(cityworksApiService.GetProblemSid(serviceCode));

		// Obtain Cityworks answerids for the questions in the Salesforce attributes by querying the Cityworks Database.
		List<Attribute> questionAnswers = salesforceRequest.getAttributes();
		if (questionAnswers.size() > 0) {
			ArrayList<ServiceRequestAnswer> answers = new ArrayList<ServiceRequestAnswer>();
			HashMap<String, Integer> questionsAnswerIds = mappingsDao.getSalesforeCityworksQuestionAnswerMappings(citySr.getProblemSid());
			for (Map.Entry<String, Integer> questionsAnswerId : questionsAnswerIds.entrySet()) {
				String question = questionsAnswerId.getKey();
				for (Attribute questionAnswer : questionAnswers) {
					if (questionAnswer.getCode().equals(question) && questionAnswer.getValues().size() > 0) {
						answers.add(new ServiceRequestAnswer(questionsAnswerId.getValue(), questionAnswer.getValues().get(0).getAnswerValue()));
						break;
					}
				}
			}
			citySr.setAnswers(answers);
		}

		// Set the attachments into comments.
		String comments = "";
		List<Attachment> attachments = salesforceRequest.getMediaUrl();
		if (attachments != null) {
			comments += "Attachment: ";
			for (Attachment attachment : attachments) {
				comments += attachment.getUrl() + "\n\n";
			}
		}
		citySr.setComments(comments);

		// Set the other attributes. If not found, will just be left null.
		String description = salesforceRequest.getDescription();
		if (description != null)
			description = description.replaceAll("\\[", " ").replaceAll("\\]", " ");
		citySr.setDetails(description);

		// Obtain the mapped Cityworks Priority from the translation list. If not found in the list, null.
		citySr.setPriority(mappingsDao.getPriorityMappings().get(salesforceRequest.getPriority().trim().toUpperCase()));

		citySr.setOtherSystemId(salesforceId);
		citySr.setAddress(salesforceRequest.getAddress());
		Geometry geometry = arcgisService.ArcGISConvertSalesforceGeometryToCityworks(salesforceRequest.getLongitude(), salesforceRequest.getLatitude());
		citySr.setX(geometry.getX().doubleValue());
		citySr.setY(geometry.getY().doubleValue());
		citySr.setZip(salesforceRequest.getZipcode());
		citySr.setLocation(salesforceRequest.getAddressDetails());
		// Get the caller.
		Contact contact = salesforceRequest.getContact();
		citySr.setCallerFirstName(contact.getFirstName());
		citySr.setCallerLastName(contact.getLastName());
		citySr.setCallerHomePhone(contact.getPhone());
		citySr.setCallerEmail(contact.getEmail());

		return citySr;
	}

	@Override
	public ExternalSystemIdUpdate TranslateToSalesforceExternalSystemObj(CityworksServiceRequest cityworksServiceRequest) {
		ExternalSystemIdUpdate obj = new ExternalSystemIdUpdate();
		obj.setApiKey(salesforceEndpointSource.getSalesforceAPIKey());
		obj.setRequestId(cityworksServiceRequest.getOtherSystemId());
		obj.setExternalSystemId(cityworksServiceRequest.getRequestId() + "");
		return obj;
	}

	@Override
	public ActivityUpdate TranslateToSalesforceActivityObj(String activities) {
		logger.info("TranslateToSalesforceActivityObj String: " + activities);
		ActivityUpdate obj = new ActivityUpdate();
		obj.setApiKey(salesforceEndpointSource.getSalesforceAPIKey());
		obj.setRequestId(activities.substring(activities.indexOf("<Service_request_id>") + 20, activities.indexOf("</Service_request_id>")));
		//obj.setActivityCode(activities.substring(activities.indexOf("<Activity_code>") + 15, activities.indexOf("</Activity_code>")));
		//obj.setOutcomeCode(activities.substring(activities.indexOf("<Outcome_code>") + 14, activities.indexOf("</Outcome_code>")));
		if (activities.indexOf("<Comments>") > -1)
			obj.setAdditionalComments(activities.substring(activities.indexOf("<Comments>") + 10, activities.indexOf("</Comments>")));
		return obj;
	}
	
	/*@Override	
	public CsrCommentUpdate TranslateToSalesforceCommentObj(CsrComment csrComment) {
		logger.info("TranslateToSalesforceCommentObj String: " + csrComment.toString());
		
		CsrCommentUpdate obj = new CsrCommentUpdate();
		obj.setApiKey(salesforceEndpointSource.getSalesforceAPIKey());
		obj.setSalesforceRequestId(csrComment.getSalesforceRequestId());
		obj.setComment(csrComment.getComment());
		//obj.setOutcomeCode("12AAX-CLOSBYAGCY");
		
		return obj;	
	}*/
	
}