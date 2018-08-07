/**
 * 
 */
package city.baltimore.eip.model.cityworks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author James.Somerville
 *
 */

//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class CityworksServiceRequestParent extends BasicParent {
	private CityworksServiceRequest value;

	public CityworksServiceRequest getValue() {
		return value;
	}
	@JsonProperty("Value")
	public void setValue(CityworksServiceRequest value) {
		this.value = value;
	}
}
