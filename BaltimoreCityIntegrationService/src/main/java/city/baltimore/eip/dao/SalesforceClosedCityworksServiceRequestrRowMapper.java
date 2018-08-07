package city.baltimore.eip.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import city.baltimore.eip.model.salesforce.*;
import city.baltimore.eip.service.CsrToSrMappingServiceImpl;

@Component
/**
 * @author Jun.Tao
 * Convert a query of the [INTERFACE_CLOSED_SRS] table to a Salesforce StatusUpdate.
 */
public final class SalesforceClosedCityworksServiceRequestrRowMapper implements RowMapper<StatusUpdate> {
	private static final Logger logger = Logger.getLogger(SalesforceClosedCityworksServiceRequestrRowMapper.class);
	/**
	 * Cityworks connection parameters. Should be loaded via dependency injection using config settings.
	 */
	@Autowired
	public SalesforceEndpointSource salesforceEndpointSource;

	public StatusUpdate mapRow(ResultSet rs, int rowNum) throws SQLException {
		StatusUpdate obj = new StatusUpdate();
		obj.setApiKey(salesforceEndpointSource.getSalesforceAPIKey());
		obj.setRequestId(rs.getString("CSRID"));
		obj.setOutcomeCode(salesforceEndpointSource.getSrcloseOutcomeCode());
		obj.setCwTableId(rs.getString("ID"));
		logger.info("SalesforceClosedCityworks String: " + rs.getString("CSRID"));
		return obj;
	}
}