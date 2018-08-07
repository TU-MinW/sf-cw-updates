package city.baltimore.eip.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import city.baltimore.eip.model.cityworks.BasicParent;
import city.baltimore.eip.model.cityworks.ProblemsParent;
import city.baltimore.eip.model.salesforce.SalesforceRequest;

/**
 * The data access class for the Salesforce API.
 * 
 * @author Jun.Tao
 *
 */
@Repository
public class SalesforceDao {
	private static final Logger logger = Logger.getLogger(SalesforceDao.class);

	/**
	 * Salesforce Polling Peroid for date range.
	 */
	@Value("${salesforce.newrequest.pollingperoiddate}")
	public int pollingPeroidDate;

	/**
	 * Salesforce Polling Peroid for minute range.
	 */
	@Value("${salesforce.newrequest.pollingperoidminute}")
	public int pollingPeroidMinute;

	/**
	 * Salesforce connection parameters. Should be loaded via dependency injection using config settings.
	 */
	@Autowired
	public SalesforceEndpointSource salesforceEndpointSource;

	public Map<String, ?> getRequesturl() {
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("requesturl", salesforceEndpointSource.getSalesforceBaseUrl() + "/requests.json");

		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm':00Z'");
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		SimpleDateFormat minsFormat = new SimpleDateFormat("mm");
		Calendar cal = Calendar.getInstance();
		if (Integer.parseInt(minsFormat.format(cal.getTime())) < 3) {
			cal.add(Calendar.DATE, -1 * pollingPeroidDate);
		} else {
			cal.add(Calendar.MINUTE, -1 * pollingPeroidMinute);
		}
		logger.info("Query Salesforce Start Date: " + dateFormat.format(cal.getTime()));
		variables.put("params", "status=open&start_date=" + dateFormat.format(cal.getTime()) + "&api_key=" + salesforceEndpointSource.getSalesforceAPIKey());

		return variables;
	}

	/**
	 * Obtain Salesforce Request Details using the serviceRequestId.
	 * @param serviceRequestId The ID.
	 * @return The Salesforce Request.
	 */
	public SalesforceRequest GetRequestDetails(String serviceRequestId) throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		SalesforceRequest responseObj = null;
		try {
			String url = salesforceEndpointSource.getSalesforceBaseUrl() + "/requests/" + serviceRequestId + ".json?api_key=" + salesforceEndpointSource.getSalesforceAPIKey();
			SalesforceRequest[] responses = restTemplate.getForObject(url, SalesforceRequest[].class);
			if (responses[0] != null) {
				responseObj = responses[0];
			}
		} catch (Throwable t) {
			throw new Exception("Error obtaining the Request Details from Salesforce (ID=" + serviceRequestId + ") " + t.getMessage(), t);
		}
		return responseObj;
	}

}
