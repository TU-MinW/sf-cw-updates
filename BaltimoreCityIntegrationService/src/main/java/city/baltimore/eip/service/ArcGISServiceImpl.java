/**
 * 
 */
package city.baltimore.eip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import city.baltimore.eip.dao.ArcGISDao;
import city.baltimore.eip.model.Geometry;

/**
 * 
 * @author Jun.Tao
 *
 */
@Service
public class ArcGISServiceImpl implements ArcGISService {
	@Autowired
	private ArcGISDao arcgisDao;

	/*
	 * (non-Javadoc)
	 * @see city.baltimore.eip.service.ArcGISService#ArcGISConvertSalesforceGeometryToCityworks(Double, Double)
	 */
	@Override
	public Geometry ArcGISConvertSalesforceGeometryToCityworks(Double x, Double y) throws Exception {
		Geometry geometry = arcgisDao.ConvertSalesforceGeometryToCityworks(x, y);
		return geometry;
	}
}