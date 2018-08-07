package city.baltimore.eip.model.salesforce;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jun.Tao
 * The Request Comment.
 */
//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class CsrComment {
	private String salesforceCaseId;
	private String comment;
	private String cwTableId;
	

	public String getSalesforceRequestId() {
		return salesforceCaseId;
	}

	@JsonProperty("salesforceCaseId")
	public void setSalesforceRequestId(String salesforceCaseId) {
		this.salesforceCaseId = salesforceCaseId;
	}

	public String getComment() {
		return comment;
	}

	@JsonProperty("comment")
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public String getCwTableId() {
		return cwTableId;
	}
	
	@JsonIgnore
	public void setCwTableId(String cwTableId) {
		this.cwTableId = cwTableId;
	}

}