/**
 * 
 */
package city.baltimore.eip.dao;

/**
 * The Cityworks URL and authentication credentials.
 * @author james.somerville
 *
 */
public class CityworksEndpointSource {
	private String cityworksUserName;
	private String cityworksPassword;
	private String cityworksBaseUrl;
	private String cityworksPublicBaseUrl;

	public CityworksEndpointSource() {
		
	}

	public String getCityworksUserName() {
		return cityworksUserName;
	}

	public void setCityworksUserName(String cityworksUserName) {
		this.cityworksUserName = cityworksUserName;
	}

	public String getCityworksPassword() {
		return cityworksPassword;
	}

	public void setCityworksPassword(String cityworksPassword) {
		this.cityworksPassword = cityworksPassword;
	}

	public String getCityworksBaseUrl() {
		return cityworksBaseUrl;
	}

	public void setCityworksBaseUrl(String cityworksBaseUrl) {
		this.cityworksBaseUrl = cityworksBaseUrl;
	}
	
	public String getCityworksPublicBaseUrl() {
		return cityworksPublicBaseUrl;
	}

	public void setCityworksPublicBaseUrl(String cityworksPublicBaseUrl) {
		this.cityworksPublicBaseUrl = cityworksPublicBaseUrl;
	}
}
