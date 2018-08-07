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
import city.baltimore.eip.dao.SalesforceEndpointSource;
import city.baltimore.eip.model.motorola.csr.LocationType;
import city.baltimore.eip.model.motorola.csr.ResPhoneType;
import city.baltimore.eip.model.salesforce.CsrComment;
import city.baltimore.eip.model.salesforce.CsrCommentUpdate;
import city.baltimore.eip.service.CsrToSrMappingServiceImpl.PhoneType;

/**
 * Tests of the class that translates a Document object (service request) from Motorola to a Cityworks service request object.
 * @author james.somerville
 *
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = BaltimoreCityIntegrationServiceApplication.class)
//@WebAppConfiguration
public class CsrToSrMappingServiceImplTest {	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#TranslateToSr(city.baltimore.eip.model.motorola.csr.Document)}.
	 */
	@Test
	public void testTranslateToSr() {
		
	}
	
	@Test
	public void testTranslateToCSR() {
		
	}

	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetMostRecent(java.util.List)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetMostRecent() throws ParseException {
		BigInteger expectedId = BigInteger.valueOf(2);
		CsrToSrMappingServiceImpl service = new CsrToSrMappingServiceImpl();
		
		ArrayList<LocationType> locations = new ArrayList<LocationType>();
		LocationType location1 = new LocationType();
		location1.setUpdatedDate("04/01/2015 01:01:01 AM");
		location1.setLocationId(BigInteger.valueOf(1));
		locations.add(location1);
		LocationType location2 = new LocationType();
		location2.setUpdatedDate("04/02/2015 01:01:01 AM");
		location2.setLocationId(BigInteger.valueOf(2));
		locations.add(location2);
		LocationType location3 = new LocationType();
		location3.setUpdatedDate("04/02/2015 01:01:00 AM");
		location3.setLocationId(BigInteger.valueOf(3));
		locations.add(location3);
		
		BigInteger actualId = ((LocationType)service.GetMostRecent(locations)).getLocationId();
		assertEquals(expectedId, actualId);
	}
	
	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetMostRecent(java.util.List)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetMostRecentSame() throws ParseException {
		BigInteger expectedId = BigInteger.valueOf(1);
		CsrToSrMappingServiceImpl service = new CsrToSrMappingServiceImpl();
		
		ArrayList<LocationType> locations = new ArrayList<LocationType>();
		LocationType location1 = new LocationType();
		location1.setUpdatedDate("04/01/2015 01:01:01 AM");
		location1.setLocationId(BigInteger.valueOf(1));
		locations.add(location1);
		LocationType location2 = new LocationType();
		location2.setUpdatedDate("04/01/2015 01:01:01 AM");
		location2.setLocationId(BigInteger.valueOf(1));
		locations.add(location2);
		
		BigInteger actualId = ((LocationType)service.GetMostRecent(locations)).getLocationId();
		assertEquals(expectedId, actualId);
	}
	
	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetMostRecent(java.util.List)}.
	 * @throws ParseException 
	 */
	@Test
	public void testGetMostRecentOne() throws ParseException {
		BigInteger expectedId = BigInteger.valueOf(1);
		CsrToSrMappingServiceImpl service = new CsrToSrMappingServiceImpl();
		
		ArrayList<LocationType> locations = new ArrayList<LocationType>();
		LocationType location1 = new LocationType();
		location1.setUpdatedDate("04/01/2015 01:01:01 AM");
		location1.setLocationId(BigInteger.valueOf(1));
		locations.add(location1);
		
		BigInteger actualId = ((LocationType)service.GetMostRecent(locations)).getLocationId();
		assertEquals(expectedId, actualId);
	}
	
	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetMostRecent(java.util.List)}.
	 * @throws ParseException 
	 */
	public void testGetMostRecentNone() throws ParseException {
		BigInteger expectedId = BigInteger.valueOf(1);
		CsrToSrMappingServiceImpl service = new CsrToSrMappingServiceImpl();
		ArrayList<LocationType> locations = new ArrayList<LocationType>();
		assertNull(service.GetMostRecent(locations));
	}

	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetPhoneNumber(city.baltimore.eip.service.CsrToSrMappingServiceImpl.PhoneType, java.util.List)}.
	 */
	@Test
	public void testGetPhoneNumberHome() {
		String expectedPhone = "4";
		
		List<ResPhoneType> resPhones = new ArrayList<ResPhoneType>();
		ResPhoneType resPhone = new ResPhoneType();
		resPhone.setPhoneCode("PHONE3");
		resPhone.setPhoneNumber("1");
		resPhones.add(resPhone);
		ResPhoneType resPhone2 = new ResPhoneType();
		resPhone2.setPhoneCode("CELL");
		resPhone2.setPhoneNumber("2");
		resPhones.add(resPhone2);
		ResPhoneType resPhone3 = new ResPhoneType();
		resPhone3.setPhoneCode("OTHER");
		resPhone3.setPhoneNumber("3");
		resPhones.add(resPhone3);
		ResPhoneType resPhone4 = new ResPhoneType();
		resPhone4.setPhoneCode("HOME");
		resPhone4.setPhoneNumber(expectedPhone);
		resPhones.add(resPhone4);
		
		CsrToSrMappingServiceImpl service = new CsrToSrMappingServiceImpl();
		String actualPhone = service.GetPhoneNumber(PhoneType.HOME, resPhones);
		
		assertSame(expectedPhone, actualPhone);
	}
	
	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetPhoneNumber(city.baltimore.eip.service.CsrToSrMappingServiceImpl.PhoneType, java.util.List)}.
	 */
	@Test
	public void testGetPhoneNumberOther() {
		String expectedPhone = "1";
		
		List<ResPhoneType> resPhones = new ArrayList<ResPhoneType>();
		ResPhoneType resPhone = new ResPhoneType();
		resPhone.setPhoneCode("PHONE3");
		resPhone.setPhoneNumber("1");
		resPhones.add(resPhone);
		ResPhoneType resPhone2 = new ResPhoneType();
		resPhone2.setPhoneCode("CELL");
		resPhone2.setPhoneNumber("2");
		resPhones.add(resPhone2);
		ResPhoneType resPhone4 = new ResPhoneType();
		resPhone4.setPhoneCode("HOME");
		resPhone4.setPhoneNumber(expectedPhone);
		resPhones.add(resPhone4);
		
		CsrToSrMappingServiceImpl service = new CsrToSrMappingServiceImpl();
		String actualPhone = service.GetPhoneNumber(PhoneType.OTHER, resPhones);
		
		assertSame(expectedPhone, actualPhone);
	}
	
	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetPhoneNumber(city.baltimore.eip.service.CsrToSrMappingServiceImpl.PhoneType, java.util.List)}.
	 */
	@Test
	public void testGetPhoneNumberNoCell() {
		List<ResPhoneType> resPhones = new ArrayList<ResPhoneType>();
		ResPhoneType resPhone = new ResPhoneType();
		resPhone.setPhoneCode("PHONE3");
		resPhone.setPhoneNumber("1");
		resPhones.add(resPhone);
		ResPhoneType resPhone4 = new ResPhoneType();
		resPhone4.setPhoneCode("HOME");
		resPhone4.setPhoneNumber("2");
		resPhones.add(resPhone4);
		
		CsrToSrMappingServiceImpl service = new CsrToSrMappingServiceImpl();
		String actualPhone = service.GetPhoneNumber(PhoneType.CELL, resPhones);
		
		assertNull(actualPhone);
	}
	
	/**
	 * Test method for {@link city.baltimore.eip.service.CsrToSrMappingServiceImpl#GetPhoneNumber(city.baltimore.eip.service.CsrToSrMappingServiceImpl.PhoneType, java.util.List)}.
	 */
	@Test
	public void testGetPhoneNumberEmptyList() {
		List<ResPhoneType> resPhones = new ArrayList<ResPhoneType>();
		
		CsrToSrMappingServiceImpl service = new CsrToSrMappingServiceImpl();
		String actualPhone = service.GetPhoneNumber(PhoneType.HOME, resPhones);
		
		assertNull(actualPhone);
	}

	
	
	
}
