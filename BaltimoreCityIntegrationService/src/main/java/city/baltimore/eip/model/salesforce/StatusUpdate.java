package city.baltimore.eip.model.salesforce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Salesforce StatusUpdate.
 * @author Jun.Tao
 */
public class StatusUpdate implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apiKey;
	private String requestId;
	private String outcomeCode;
	private String cwTableId;

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

	public String getOutcomeCode() {
		return outcomeCode;
	}

	@JsonProperty("outcome_code")
	public void setOutcomeCode(String outcomeCode) {
		this.outcomeCode = outcomeCode;
	}

	public String getCwTableId() {
		return cwTableId;
	}

	@JsonIgnore
	public void setCwTableId(String cwTableId) {
		this.cwTableId = cwTableId;
	}
}