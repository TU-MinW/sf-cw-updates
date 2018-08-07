package city.baltimore.eip.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import city.baltimore.eip.model.Geometries;
import city.baltimore.eip.model.Geometry;

/**
 * The data access class for the ArcGIS Services.
 * 
 * @author Jun.Tao
 *
 */
@Repository
public class ArcGISDao {
	private static final Logger logger = Logger.getLogger(SalesforceDao.class);

	/**
	 * The ArcGIS Geometry Service URL.
	 */
	@Value("${arcgis.geometryserviceurl}")
	public String geometryServiceUrl;

	/**
	 * The Salesforce inSR.
	 */
	@Value("${arcgis.geometrysalesforceinsr}")
	public String salesforceinSR;

	/**
	 * The Cityworks outSR.
	 */
	@Value("${arcgis.geometrycityworksoutsr}")
	public String cityworksoutSR;

	/**
	 * Convert Salesforce Geometry to Cityworks MD State Plane using the Latitude and Longitude.
	 * @param x The Salesforce X Coordinate.
	 * @param y The Salesforce Y Coordinate.
	 * @return The Cityworks Geometry.
	 */
	public Geometry ConvertSalesforceGeometryToCityworks(Double x, Double y) throws Exception {
		RestTemplate restTemplate = new RestTemplate();

		//Handle text/plain response
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
		List<MediaType> mediaTypes = new ArrayList<MediaType>();
		mediaTypes.add(MediaType.TEXT_PLAIN);
		messageConverter.setSupportedMediaTypes(mediaTypes);
		messageConverters.add(messageConverter);
		restTemplate.setMessageConverters(messageConverters);

		Geometry responseObj = null;
		try {
			String url = geometryServiceUrl + "/project?inSR=" + salesforceinSR + "&outSR=" + cityworksoutSR + "&geometries=" + x + "," + y + "&f=pjson";
			Geometries responses = restTemplate.getForObject(url, Geometries.class);
			if (responses.getGeometries().get(0) != null) {
				responseObj = responses.getGeometries().get(0);
			}
		} catch (Throwable t) {
			throw new Exception("Error converting the Latitude and Longitude coordinates (" + x + "," + y + ") " + t.getMessage(), t);
		}
		return responseObj;
	}
}