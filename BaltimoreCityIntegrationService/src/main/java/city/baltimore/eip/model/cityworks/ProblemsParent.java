package city.baltimore.eip.model.cityworks;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class ProblemsParent extends BasicParent {
	ArrayList<ProblemName> value;

	public ArrayList<ProblemName> getValue() {
		return value;
	}
	
	@JsonProperty("Value")
	public void setValue(ArrayList<ProblemName> value) {
		this.value = value;
	}
}
