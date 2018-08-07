package city.baltimore.eip.service;

import static org.junit.Assert.*;

import java.io.IOException;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import city.baltimore.eip.app.BaltimoreCityIntegrationServiceApplication;
import city.baltimore.eip.dao.SalesforceDao;
//import city.baltimore.eip.dao.SalesforceEndpointSource;
import city.baltimore.eip.model.salesforce.ActivityUpdate;
import city.baltimore.eip.model.salesforce.CsrComment;
import city.baltimore.eip.model.salesforce.CsrCommentUpdate;



@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BaltimoreCityIntegrationServiceApplication.class)
//@WebAppConfiguration

public class CsrTranslateServiceTest{
	@Autowired
	CsrToSrMappingServiceImpl csrToSrMappingService;
	
	@Test
	public void testTranslateSFCommentObj() {
		
		String xmlFormat = "<csreai:csreai-msg xmlns:csr=\"http://www.motorola.com/Schema/csr\" xmlns:csreai=\"http://www.motorola.com/Schema/csreai\"><csreai:body>"
				+ "<Service_request_id>18-00000839</Service_request_id><Activity_code /><Outcome_code />"
				+ "<Completed_date>Jul 02, 2018 3:30PM</Completed_date>"
				+ "<Comments>Work Order #415358 closed on  Jul 02, 2018 3:30PM.\r\n Description: STORM MAINLINE CHOKE.\\r\\nComments: child of child workorder</Comments>"
				+ "</csreai:body></csreai:csreai-msg>";
				
		
		ActivityUpdate obj = new ActivityUpdate();
		obj = csrToSrMappingService.TranslateToSalesforceActivityObj(xmlFormat);
		
		//assertNotNull(csrCommentUpdate);
		assertEquals("18-00000839", obj.getRequestId());
		
	}
}