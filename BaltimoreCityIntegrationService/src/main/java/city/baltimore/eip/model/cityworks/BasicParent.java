package city.baltimore.eip.model.cityworks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class BasicParent {
	private Integer status;
	private String message;

	public Integer getStatus() {
		return status;
	}
	
	@JsonProperty("Status")
	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}
	
	@JsonProperty("Message")
	public void setMessage(String message) {
		this.message = message;
	}
}
