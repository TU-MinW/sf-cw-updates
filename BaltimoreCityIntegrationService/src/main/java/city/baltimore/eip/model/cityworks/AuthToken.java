/**
 * 
 */
package city.baltimore.eip.model.cityworks;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

//import lombok.Data;
/**
 * A domain class representing the required attributes of the Cityworks API's AuthToken object: http://cityworks.kci.com/BaltimoreCityworks/Services/Help/Types/Index#AuthToken
 * @author James.Somerville
 */
//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class AuthToken {
	private String expires;
	private String token;
	
	public String getExpires() {
		return expires;
	}
	@JsonProperty("Expires")
	public void setExpires(String expires) {
		this.expires = expires;
	}
	public String getToken() {
		return token;
	}
	@JsonProperty("Token")
	public void setToken(String token) {
		this.token = token;
	}
}
