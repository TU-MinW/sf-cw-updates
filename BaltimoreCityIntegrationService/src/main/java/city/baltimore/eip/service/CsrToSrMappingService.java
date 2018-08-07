package city.baltimore.eip.service;

import java.text.ParseException;

import org.springframework.xml.transform.StringResult;

import city.baltimore.eip.model.cityworks.CityworksServiceRequest;
import city.baltimore.eip.model.motorola.csr.Document;
import city.baltimore.eip.model.salesforce.ActivityUpdate;
import city.baltimore.eip.model.salesforce.CsrCommentUpdate;
import city.baltimore.eip.model.salesforce.CsrComment;
//import city.baltimore.eip.model.salesforce.CommentUpdate;
import city.baltimore.eip.model.salesforce.ExternalSystemIdUpdate;
import city.baltimore.eip.model.salesforce.SalesforceRequest;

public interface CsrToSrMappingService {
	/**
	 * Map a Motorola service request to a Cityworks service request.
	 * @param csrDocument The Motorola document object originating from the XML app hub.
	 * @return A Cityworks service request object.
	 * @throws ParseException
	 * @throws Exception
	 */
	public CityworksServiceRequest TranslateToSr(Document csrDocument) throws ParseException, Exception;

	/**
	 * Map a Cityworks service request to a Motorola CSR Document. Warning: Not a complete translation- only required parameters mapped.
	 * @param cityworksServiceRequest The Cityworks service request object.
	 * @return A Motorola CSR service request Document. May not be fully populated by all Cityworks parameters.
	 */
	public Document TranslateToCsr(CityworksServiceRequest cityworksServiceRequest);

	/**
	 * Wrap a CSR Document with the SOAP metadata and csreai-msg for the web service call to Motorola CSR App Hub. 
	 * @param csrDocXml The CSR Document respresented as XML- including XML opening tag.
	 * @return The fully-populated SOAP XML message for an HTTP post to Motorola CSR App Hub.
	 */
	public String WrapCsrDocInSoapXml(StringResult csrDocXml);

	/**
	 * Wrap a csreai-msg with the SOAP metadata for the web service call to Motorola CSR App Hub.
	 * @param csrMsgXml
	 * @return
	 */
	public String WrapCsrMsgInSoapXml(String csrXmlText);

	/**
	 * Map a Salesforce service request to a Cityworks service request.
	 * @param salesforceRequest The Salesforce service request object.
	 * @return A Cityworks service request object.
	 * @throws Exception
	 */
	public CityworksServiceRequest SalesforceTranslateToSr(SalesforceRequest salesforceRequest) throws Exception;

	/**
	 * Map a Cityworks service request to a Salesforce ExternalSystemIdUpdate.
	 * @param cityworksServiceRequest The Cityworks service request object.
	 * @return A Salesforce ExternalSystemIdUpdate.
	 */
	public ExternalSystemIdUpdate TranslateToSalesforceExternalSystemObj(CityworksServiceRequest cityworksServiceRequest);

	/**
	 * Translate the activities string from Cityworks to a Salesforce ActivityUpdate.
	 * @param activities The string from Cityworks Database stored procedure.
	 * @return A Salesforce ActivityUpdate.
	 */
	public ActivityUpdate TranslateToSalesforceActivityObj(String activities);
	
	/** Motified based on activities
	 * Translate the comments string from Cityworks to a Salesforce CommentUpdate.
	 * @param comments The string from Cityworks Database stored procedure.? Procedure or Table
	 * @return A Salesforce CommentUpdate.
	 */
//	public CsrCommentUpdate TranslateToSalesforceCommentObj(CsrComment comment);
}