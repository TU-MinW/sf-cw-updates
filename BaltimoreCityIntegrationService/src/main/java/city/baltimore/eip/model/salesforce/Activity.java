package city.baltimore.eip.model.salesforce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jun.Tao
 * The Salesforce Activity.
 */
//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class Activity {
	private String code;
	private Integer order;
	private String description;
	private String status;
	private String dueDate;
	private String completionDate;

	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	public Integer getOrder() {
		return order;
	}

	@JsonProperty("order")
	public void setOrder(Integer order) {
		this.order = order;
	}

	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	public String getDueDate() {
		return dueDate;
	}

	@JsonProperty("due_date")
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public String getCompletionDate() {
		return completionDate;
	}

	@JsonProperty("completion_date")
	public void setCompletionDate(String completionDate) {
		this.completionDate = completionDate;
	}
}