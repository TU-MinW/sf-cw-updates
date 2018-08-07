package city.baltimore.eip.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.core.MessageSelector;
import org.springframework.messaging.Message;

import city.baltimore.eip.model.salesforce.SalesforceQueryRequest;

/**
 * A Spring Integration message filter expression implementation to reject service requests that already exist in Cityworks.
 * 
 * @author Jun.Tao
 *
 */
public class SalesforceCityworksFilterMessageSelector implements MessageSelector {
	@Autowired
	CityworksService cityworksApiService;

	private static final Logger logger = Logger.getLogger(SalesforceCityworksFilterMessageSelector.class);

	public SalesforceCityworksFilterMessageSelector() {
	}

	/*
	 * Check whether the Salesforce Request exists in Cityworks. For use as a message filter to reject a message if the Request already exists.
	 * Check whether the Salesforce Service Code exists in Cityworks. For use as a message filter to reject a message if the ProblemSid not exists.
	 * Expects a city.baltimore.eip.model.salesforce.SalesforceQueryRequest object as payload of message.
	 * (non-Javadoc)
	 * @see org.springframework.integration.core.MessageSelector#accept(org.springframework.messaging.Message)
	 */
	@Override
	public boolean accept(Message<?> Msg) {
		SalesforceQueryRequest request = (SalesforceQueryRequest) Msg.getPayload();
		String salesforceId = request.getServiceRequestId();
		String serviceCode = request.getServiceCode();
		// Inverse logic of method, because if the service request already exists, then do not want to accept the message.
		// Only accept the problemsid exists in Cityworks.
		boolean exists = false;
		try {
			exists = cityworksApiService.SrExistsInCityworks(salesforceId);
			if (!exists) {
				exists = (cityworksApiService.GetProblemSid(serviceCode) == null);
			}
		} catch (Exception e) {
			return !exists;
		}
		return !exists;
	}
}