package city.baltimore.eip.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import city.baltimore.eip.model.motorola.csr.*;
import city.baltimore.eip.model.salesforce.CsrComment;



@Component
/**
 * @author 
 * Convert a query of the [CSRCOMMENTSINTERFACE] table to a CsrComments Object.
 */
public final class SalesforceCommentRowMapper implements RowMapper<CsrComment> {
	private static final Logger logger = Logger.getLogger(SalesforceCommentRowMapper.class);
	
	public CsrComment mapRow(ResultSet rs, int rowNum) throws SQLException{
		
		CsrComment obj = new CsrComment();
		obj.setSalesforceRequestId(rs.getString("SALESFORCEREQUESTID"));
		obj.setComment(rs.getString("COMMENT"));
		obj.setCwTableId(rs.getString("ID"));	
		logger.info("SalesForceRequestId String: " + rs.getString("SALESFORCEREQUESTID"));
		return obj;
	}
}