package city.baltimore.eip.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import java.lang.reflect.Type;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import city.baltimore.eip.model.cityworks.*;
import city.baltimore.eip.service.CsrToSrMappingServiceImpl;

/**
 * The data access class for the Cityworks API.
 * 
 * @author James.Somerville
 *
 */
@Repository
public class CityworksDao {
	private static final Logger logger = Logger.getLogger( CityworksDao.class );
	
	final public static String AUTHENTICATION_PATH = "/Authentication/Authenticate";
	final public static String SERVICE_REQUEST_PATH = "/AMS/ServiceRequest";
	final public static String SERVICE_REQUEST_PROBLEMS_PATH = "/Problems";
	final public static String SERVICE_REQUEST_QA_PATH = "/QA";
	final public static String SERVICE_REQUEST_OTHERSYSTEMID_PATH = "/ByOtherSystemId";
	
	/**
	 * Cityworks connection parameters. Should be loaded via dependency injection using config settings.
	 */
	@Autowired
	public CityworksEndpointSource cityworksEndpointSource;
	
	private String currentCityworksToken;
	
	/**
	 * Obtain the current Cityworks token for the bean.
	 * @return token
	 */
	public String getCurrentCityworksToken() {
		return currentCityworksToken;
	}

	private Date tokenExpiration;
	
	/**
	 * The token expiration date. The token is internally managed by the bean. Thus, this parameter is only intended for testing utilization.
	 * @return The date and time of expiration.
	 */
	public Date getTokenExpiration() {
		return tokenExpiration;
	}

	/**
	 * Sets the token expiration date. The token is internally managed by the bean. Thus, this parameter is only intended for testing utilization.
	 * @param tokenExpiration The date of expiration to set in the bean. Does nothing to an actual token in Cityworks.
	 */
	public void setTokenExpiration(Date tokenExpiration) {
		this.tokenExpiration = tokenExpiration;
	}

	/**
	 * Retrieves a full URL to the Cityworks authentication endpoint, according to the injected data source and internal properties.
	 * @return URL, not including a token.
	 */
	public String getCityworksAuthenticationUrl() {
		return cityworksEndpointSource.getCityworksBaseUrl().concat(AUTHENTICATION_PATH);
	}

	/**
	 * Retrieves a full URL to the Cityworks service endpoint, according to the injected data source and internal properties.
	 * @return URL, not including a token.
	 */
	public String getCityworksServiceRequestUrl() {
		return cityworksEndpointSource.getCityworksBaseUrl().concat(SERVICE_REQUEST_PATH);
	}
	
	/**
	 * Retrieves a full URL to the Cityworks Service Request Problems endpoint, according to the injected data source and internal properties.
	 * @return URL, not including a token.
	 */
	public String getCityworksServiceRequestProblemsUrl() {
		return cityworksEndpointSource.getCityworksBaseUrl().concat(SERVICE_REQUEST_PATH).concat(SERVICE_REQUEST_PROBLEMS_PATH);
	}
	
	/**
	 * Retrieves a full URL to the Cityworks  Service Request Question/Answer endpoint, according to the injected data source and internal properties.
	 * @return URL, not including a token.
	 */
	public String getCityworksServiceRequestQAUrl() {
		return cityworksEndpointSource.getCityworksBaseUrl().concat(SERVICE_REQUEST_PATH).concat(SERVICE_REQUEST_QA_PATH);
	}
	
	/**
	 * Retrieves a full URL to the Cityworks Service Request OtherSystemId query endpoint, according to the injected data source and internal properties.
	 * @return URL, not including a token.
	 */
	public String getCityworksServiceRequestOtherSystemIdUrl() {
		return cityworksEndpointSource.getCityworksBaseUrl().concat(SERVICE_REQUEST_PATH).concat(SERVICE_REQUEST_OTHERSYSTEMID_PATH);
	}
	
	/**
	 * Obtain a Cityworks Service Request using the Other System ID field. See: http://cityworks.kci.com/BaltimoreCityworks/Services/Help/AMS/ServiceRequestService#ByOtherSystemId
	 * Note: Other System ID is not unique. If more than one SR exists with this ID, Cityworks returns only 1 randomly chosen SR.
	 * @param otherSystemId The ID.
	 * @return The Service Request.
	 */
	public CityworksServiceRequest GetServiceRequestByOtherSystemId(String otherSystemId) throws Exception {
		//Include the problem id in the query string.
		String queryString = "{\"OtherSystemId\":\"" + otherSystemId + "\"}";
		CityworksServiceRequestParent parent = getCityworksResponse(getCityworksServiceRequestOtherSystemIdUrl(), queryString, CityworksServiceRequestParent.class, true);
		return parent.getValue();
	}
	
	/**
	 * Retrieve a list of all problems setup in Cityworks. See: http://cityworks.kci.com/BaltimoreCityworks/Services/Help/AMS/ServiceRequestService#Problems
	 * @return The list of problems.
	 */
	@SuppressWarnings("unchecked")
	@Cacheable(value="cityworksservicerequestproblemnames")
	public List<ProblemName> GetServiceRequestProblems() throws Exception {
		//Type listType = new TypeToken<List<ProblemName>>() {}.getType();
		/* The Spring RestTemplate does not handle lists of classes, so the second parameter is a workaround.
				For a similar discussion, see: http://stackoverflow.com/questions/18471701/passing-a-class-with-type-parameter-as-type-parameter-for-generic-method-in-java
		*/
		//return getCityworksResponse(getCityworksServiceRequestProblemsUrl(), null, (new ArrayList<ProblemName>()).getClass(), true);
		ProblemsParent problemsParent = getCityworksResponse(getCityworksServiceRequestProblemsUrl(), "{\"ForPublicOnly\":true}", ProblemsParent.class, true);
		System.out.println("Hit cityworks for problemnames");
		return problemsParent.getValue();
	}
	
	/**
	 * For a particular Cityworks problem, retrieve lists of the applicable questions and their corresponding potential answers. See: http://cityworks.kci.com/BaltimoreCityworks/Services/Help/AMS/ServiceRequestService#QA
	 * @param problemSid The particular problem to obtain questions/answers for.
	 * @return An object containing the lists. The items in the questions and answers lists can be correlated by questionid.
	 */
	@Cacheable(value="cityworksservicerequestproblemqavalue")
	public ProblemQAValue GetServiceRequestProblemQAs(Integer problemSid) throws Exception {
		//Include the problem id in the query string.
		ProblemQAParent parent = getCityworksResponse(getCityworksServiceRequestQAUrl(), "{\"ProblemSid\":" + Integer.toString(problemSid) + "}", ProblemQAParent.class, true);
		System.out.println("Hit cityworks for problemqavalues");
		return parent.getValue();
	}
	
	/**
	 * Insert a new service request into Cityworks.
	 * @param serviceRequest The service request values to insert.
	 * @return 
	 * @throws JsonProcessingException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public CityworksServiceRequest CreateServiceRequest(CityworksServiceRequest serviceRequest) throws JsonProcessingException, Exception {
		//Need to serialize the object, then insert into query string
		ObjectMapper mapper = new ObjectMapper();
		String data = mapper.writeValueAsString(serviceRequest);
		//getCityworksResponse(getCityworksServiceRequestUrl() + "/Create", data, Object.class, true);
		CityworksServiceRequestParent srParent = getCityworksResponse(getCityworksServiceRequestUrl() + "/Create", data, CityworksServiceRequestParent.class, true);
		return srParent.getValue();
	}
	
	/**
	 * Makes a call to Cityworks, given the parameters supplied. The function handles acquiring a valid token, if needed. Returns the response.
	 * @param url The full URL to the desired Cityworks API endpoint.
	 * @param dataParamJson The JSON data object to pass to Cityworks.
	 * @param returnType The model object expected in the response.
	 * @param requiresAuthToken True if the call needs an authentication token. False, if the API call is accessible without being logged in.
	 * @return The value object response of the type passed in.
	 */
	public <T> T getCityworksResponse(String url, String dataParamJson, Class<T> returnType, boolean requiresAuthToken) throws Exception {
		if (requiresAuthToken)
			//Obtain a valid token
			url = getUrlWithCityworksToken(url);
		RestTemplate restTemplate = new RestTemplate();
		T responseObj = null;
		if(dataParamJson != null && !dataParamJson.isEmpty()) {
			/*Due to the funkiness of the Cityworks api, where input data is expressed as JSON in the query string "data" parameter,
			 	while the Spring resttemplate considers curly braces {...} in the given URL as a placeholder for URI variables, we need to pass
			 	the JSON into a variable. See: http://stackoverflow.com/a/21819399/2807423 */
			url = addQueryStringParamToUrl(url, "data", "{data}");
			responseObj = restTemplate.getForObject(url, returnType, dataParamJson);
		} else
			responseObj = restTemplate.getForObject(url, returnType);
		BasicParent response = BasicParent.class.cast(responseObj);
		if (response.getStatus()!=0) {
			logger.info("Error Cityworks Request Data: " + dataParamJson);
			throw new Exception("Error Cityworks Response Status: " + response.getStatus() + " with Message: " + response.getMessage() + " for " + url);
		} else {
			logger.info("Cityworks Response Status: " + response.getStatus() + " for " + url);
			logger.info("Cityworks Request Data: " + dataParamJson);
		}
		return responseObj;
	}
	
	/**
	 * Obtains a valid Cityworks token to make calls to the API. See: http://cityworks.kci.com/BaltimoreCityworks/Services/Help/AuthenticationService
	 * @param url The desired API URL that you need a token for.
	 * @return The desired API URL with a query string parameter containing the token. Creates the query string "?" if not present in the passed-in URL.
	 */
	protected String getUrlWithCityworksToken(String url) throws Exception {
		if (tokenExpiration == null || (new Date().after(DateUtils.addDays(tokenExpiration, -1)))) {
			//Get new token if within one day of token expiration
			AuthTokenParent authTokenParent = getCityworksResponse(getCityworksAuthenticationUrl(), "{\"LoginName\":\"" + cityworksEndpointSource.getCityworksUserName() + "\",\"Password\":\"" + cityworksEndpointSource.getCityworksPassword() + "\"}", AuthTokenParent.class, false);
			currentCityworksToken = authTokenParent.getValue().getToken();
			try {
				tokenExpiration = city.baltimore.eip.service.DateUtils.GetDate2(authTokenParent.getValue().getExpires());
			} catch (ParseException e) {
				logger.warn("Error obtaining auth. token expiration date from Cityworks. ", e);
			}
		}
		return addQueryStringParamToUrl(url, "token", currentCityworksToken);
	}
	
	/**
	 * Append a URI string with a query string parameter and its corresponding value. Does not perform any encoding.
	 * @param url The base URI to append. Can already include query string parameter(s).
	 * @param paramName The name of the query string parameter.
	 * @param paramValue The value of the parameter.
	 * @return The URL passed in with the new query string param/value appended.
	 */
	public String addQueryStringParamToUrl(String url, String paramName, String paramValue) {
		if (!url.contains("?"))
			url = new StringBuilder(url).append("?").append(paramName).append("=").append(paramValue).toString();
		else
			url = new StringBuilder(url).append("&").append(paramName).append("=").append(paramValue).toString();
		return url;
	}
}