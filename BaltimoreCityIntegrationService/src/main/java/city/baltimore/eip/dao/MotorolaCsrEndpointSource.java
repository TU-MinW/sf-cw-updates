/**
 * 
 */
package city.baltimore.eip.dao;

/**
 * The Cityworks URL and authentication credentials.
 * @author james.somerville
 *
 */
public class MotorolaCsrEndpointSource {
	private String appHubUserId;
	private String appHubPassword;
	private String sourceCode;
	private String csrAppHubUrl;
	
	public MotorolaCsrEndpointSource() {
		
	}

	public String getAppHubUserId() {
		return appHubUserId;
	}

	public void setAppHubUserId(String appHubUserId) {
		this.appHubUserId = appHubUserId;
	}

	public String getAppHubPassword() {
		return appHubPassword;
	}

	public void setAppHubPassword(String appHubPassword) {
		this.appHubPassword = appHubPassword;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}
	
	public String getCsrAppHubUrl() {
		return csrAppHubUrl;
	}

	public void setCsrAppHubUrl(String csrAppHubUrl) {
		this.csrAppHubUrl = csrAppHubUrl;
	}
}
