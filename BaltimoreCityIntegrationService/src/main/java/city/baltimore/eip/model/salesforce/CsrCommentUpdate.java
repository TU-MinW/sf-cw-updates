package city.baltimore.eip.model.salesforce;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.*;

public class CsrCommentUpdate implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String apiKey;
	private String salesforceRequestId;
	private String outcomeCode;
	private String comment;
	
	
	public String getApiKey() {
		return apiKey;
	}
	
	@JsonProperty("api_key")
	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}
	
	public String getSalesforceRequestId() {
		return salesforceRequestId;
	}
	
	@JsonProperty("requestid")
	public void setSalesforceRequestId(String salesforceRequestId) {
		this.salesforceRequestId = salesforceRequestId;
	}
	
	/*public String getOutcomeCode() {
		return outcomeCode;
	}
	
	@JsonProperty("outcome_code")
	public void setOutcomeCode(String outcomeCode) {
		this.outcomeCode = outcomeCode;
	}*/
	
	public String getComment() {
		return comment;
	}
	
	@JsonProperty("internal_comments")
	public void setComment(String comment) {
		this.comment = comment;
	}
}