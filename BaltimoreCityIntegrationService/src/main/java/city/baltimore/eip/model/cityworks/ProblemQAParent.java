package city.baltimore.eip.model.cityworks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class ProblemQAParent extends BasicParent {
	ProblemQAValue value;

	public ProblemQAValue getValue() {
		return value;
	}
	
	@JsonProperty("Value")
	public void setValue(ProblemQAValue value) {
		this.value = value;
	}
}