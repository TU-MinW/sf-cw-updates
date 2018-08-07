/**
 * 
 */
package city.baltimore.eip.model.cityworks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author James.Somerville
 * A domain class representing the required attributes of the Cityworks API's ProblemName object: http://cityworks.kci.com/BaltimoreCityworks/Services/Help/Types/Index#ProblemName
 */
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class ProblemName {
	private String problemcode;
	private int problemsid;
	
	public String getProblemcode() {
		return problemcode;
	}
	@JsonProperty("ProblemCode")
	public void setProblemcode(String problemcode) {
		this.problemcode = problemcode;
	}
	
	public int getProblemsid() {
		return problemsid;
	}
	@JsonProperty("ProblemSid")
	public void setProblemsid(int problemsid) {
		this.problemsid = problemsid;
	}
}
