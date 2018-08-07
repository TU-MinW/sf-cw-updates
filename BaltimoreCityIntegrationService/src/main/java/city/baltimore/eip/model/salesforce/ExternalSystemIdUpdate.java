package city.baltimore.eip.model.salesforce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Salesforce ExternalSystemIdUpdate.
 * @author Jun.Tao
 */
public class ExternalSystemIdUpdate implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apiKey;
	private String requestId;
	private String externalSystemId;

	public String getApiKey() {
		return apiKey;
	}

	@JsonProperty("api_key")
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getRequestId() {
		return requestId;
	}

	@JsonProperty("requestid")
	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getExternalSystemId() {
		return externalSystemId;
	}

	@JsonProperty("external_system[id]")
	public void setExternalSystemId(String externalSystemId) {
		this.externalSystemId = externalSystemId;
	}
}