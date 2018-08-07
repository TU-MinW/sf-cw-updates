package city.baltimore.eip.model.cityworks;

//import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class AuthTokenParent extends BasicParent {
	private AuthToken value;
	
	public AuthToken getValue() {
		return value;
	}
	
	//Can't use Lombok data for auto-generating getter/setters, and have to enter JSON property to match the attribute returned by Cityworks.
	// This is due to Cityworks response's starting with capital letters for attribute names.
	@JsonProperty("Value")
	public void setValue(AuthToken value) {
		this.value = value;
	}
}
