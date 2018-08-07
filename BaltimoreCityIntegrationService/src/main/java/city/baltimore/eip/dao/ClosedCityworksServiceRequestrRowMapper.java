package city.baltimore.eip.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import city.baltimore.eip.model.motorola.csr.*;
import city.baltimore.eip.service.DateUtils;



@Component
/**
 * @author james.somerville
 * Convert a query of the [INTERFACE_CLOSED_SRS] table to a CSR Document.
 */
public final class ClosedCityworksServiceRequestrRowMapper implements RowMapper<DocumentEnvelope> {
	public DocumentEnvelope mapRow(ResultSet rs, int rowNum) throws SQLException {
		DocumentEnvelope csrDoc = new DocumentEnvelope();
    	PrcInstance prcInstance = new PrcInstance();
    	prcInstance.setPrcNumber(rs.getString("CSRID"));
    	prcInstance.setStatusCode(rs.getString("STATUS"));
    	prcInstance.setPrcCode(rs.getString("SR_CODE"));
    	Date changeDate = rs.getDate("DATETIMECLOSED");
    	if (changeDate == null)
    		changeDate = new Date();
    	prcInstance.setStatusDate(DateUtils.GetDateAsTextForMotorola(changeDate));
    	csrDoc.setPrcInstance(prcInstance);
    	csrDoc.ID = rs.getInt("ID");
        return csrDoc;
    }
}
