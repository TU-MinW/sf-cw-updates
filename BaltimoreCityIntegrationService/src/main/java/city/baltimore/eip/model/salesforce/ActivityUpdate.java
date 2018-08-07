package city.baltimore.eip.model.salesforce;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Salesforce ActivityUpdate.
 * @author Jun.Tao
 */
public class ActivityUpdate implements Serializable {

	private static final long serialVersionUID = 1L;

	private String apiKey;
	private String requestId;
	private String activityCode;
	private String outcomeCode;
	private String additionalComments;

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

/*	public String getActivityCode() {
		return activityCode;
	}

	@JsonProperty("activitycode")
	public void setActivityCode(String activityCode) {
		this.activityCode = activityCode;
	}

	public String getOutcomeCode() {
		return outcomeCode;
	}

	@JsonProperty("outcome_code")
	public void setOutcomeCode(String outcomeCode) {
		this.outcomeCode = outcomeCode;
	}*/

	public String getAdditionalComments() {
		return additionalComments;
	}

	@JsonProperty("additional_comments")
	public void setAdditionalComments(String additionalComments) {
		this.additionalComments = additionalComments;
	}
}