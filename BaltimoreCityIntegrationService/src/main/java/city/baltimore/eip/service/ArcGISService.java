/**
 * 
 */
package city.baltimore.eip.service;

import city.baltimore.eip.model.Geometry;

/**
 * @author Jun.Tao
 *
 */
public interface ArcGISService {

	/**
	 * Convert Salesforce Geometry to Cityworks MD State Plane using the Latitude and Longitude.
	 * @param x The Salesforce X Coordinate.
	 * @param y The Salesforce Y Coordinate.
	 * @return The Cityworks Geometry.
	 */
	public Geometry ArcGISConvertSalesforceGeometryToCityworks(Double x, Double y) throws Exception;
}