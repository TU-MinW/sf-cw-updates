package city.baltimore.eip.service;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import city.baltimore.eip.app.BaltimoreCityIntegrationServiceApplication;
import city.baltimore.eip.model.motorola.csr.LocationType;
import city.baltimore.eip.model.motorola.csr.ResPhoneType;
import city.baltimore.eip.service.CsrToSrMappingServiceImpl.PhoneType;

/**
 * Tests of the date utility class.
 * @author james.somerville
 *
 */
public class DateUtilsTest {
	
	/**
	 * Test method for {@link city.baltimore.eip.service.DateUtils#GetDate(java.lang.String)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetDate() throws ParseException {
		Date date = null;
		
		date = DateUtils.GetDate("01/01/1970 12:01:00 AM");
		assertNotNull(date);
		assertTrue(date.getTime() > 0);
	}

	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetDateAsTextForCityworks(java.util.Date)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetDateAsText() throws ParseException {
		Date date = null;
		String dateText;
		
		//AM test
		date = (new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa")).parse("05/13/1980 04:22:47 AM");
		dateText = DateUtils.GetDateAsTextForCityworks(date);
		assertEquals("1980-05-13T04:22:47", dateText);
		//PM test
		date = (new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa")).parse("09/24/2015 11:09:47 PM");
		dateText = DateUtils.GetDateAsTextForCityworks(date);
		assertEquals("2015-09-24T23:09:47", dateText);
	}

}
