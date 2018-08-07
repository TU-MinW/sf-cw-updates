/**
 * 
 */
package city.baltimore.eip.dao;

/**
 * The Salesforce URL and authentication credentials.
 * @author Jun.Tao
 *
 */
public class SalesforceEndpointSource {
	private String salesforceBaseUrl;
	private String salesforceAPIKey;
	private String srcloseActivtyCode;
	private String srcloseOutcomeCode;

	public SalesforceEndpointSource() {

	}
	
	public String getSalesforceBaseUrl() {
		return salesforceBaseUrl;		
	}

	public void setSalesforceBaseUrl(String salesforceBaseUrl) {
		this.salesforceBaseUrl = salesforceBaseUrl;
	}
		
	public String getSalesforceAPIKey() {
		return salesforceAPIKey;
	}

	public void setSalesforceAPIKey(String salesforceAPIKey) {
		this.salesforceAPIKey = salesforceAPIKey;
	}

	public String getSrcloseActivtyCode() {
		return srcloseActivtyCode;
	}

	public void setSrcloseActivtyCode(String srcloseActivtyCode) {
		this.srcloseActivtyCode = srcloseActivtyCode;
	}

	public String getSrcloseOutcomeCode() {
		return srcloseOutcomeCode;
	}

	public void setSrcloseOutcomeCode(String srcloseOutcomeCode) {
		this.srcloseOutcomeCode = srcloseOutcomeCode;
	}
}
