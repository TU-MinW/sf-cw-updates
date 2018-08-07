/**
 * 
 */
package city.baltimore.eip.service;

import city.baltimore.eip.model.salesforce.SalesforceRequest;
import city.baltimore.eip.model.salesforce.SalesforceQueryRequest;

/**
 * @author Jun.Tao
 *
 */
public interface SalesforceService {

	/**
	 * Obtain the Salesforce Service Request Details.
	 * @param request The Query Result of Service Request.
	 * @return SalesforceRequest
	 */
	public SalesforceRequest SalesforceGetServiceRequestDetails(SalesforceQueryRequest request) throws Exception;
}