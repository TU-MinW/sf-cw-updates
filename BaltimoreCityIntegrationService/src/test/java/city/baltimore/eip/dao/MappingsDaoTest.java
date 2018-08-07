package city.baltimore.eip.dao;

import static org.junit.Assert.*;

import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import city.baltimore.eip.app.BaltimoreCityIntegrationServiceApplication;
import city.baltimore.eip.model.salesforce.CsrComment;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/**
 * Tests of the Mappings class
 * @author James.Somerville, Jun Tao
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BaltimoreCityIntegrationServiceApplication.class)
public class MappingsDaoTest {

	@Autowired
	MappingsDao mappingsDao;

	private HashMap<String, String> priorityMappings;
	private HashMap<String, Integer> qaMappings;

	@Before
	public void setUpBeforeClass() throws Exception {
		this.priorityMappings = mappingsDao.getPriorityMappings();
		System.out.print(priorityMappings.toString());

		this.qaMappings = mappingsDao.getSalesforeCityworksQuestionAnswerMappings(8870);//problemSid 8870
		System.out.print(qaMappings.toString());
	}

	/**
	 * Test method for {@link city.baltimore.eip.dao.MappingsDao#getPriorityMappings()}.
	 * Check that the priority mappings list has values.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Test
	public void testGetPriorityMappingsNotEmpty() throws JsonParseException, JsonMappingException, IOException {
		if (priorityMappings == null)
			fail("Priority mappings list is null.");
		else if (priorityMappings.size() <= 0)
			fail("Priority mappings list has no entries.");
	}

	/**
	 * Test method for {@link city.baltimore.eip.dao.MappingsDao#getQuestionAnswerMappings()}.
	 * Check that the question answer mappings list has values.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Test
	public void testGetQuestionAnswerMappingsNotEmpty() throws JsonParseException, JsonMappingException, IOException {
		if (qaMappings == null)
			fail("QuestionAnswer mappings list is null.");
		else if (qaMappings.size() <= 0)
			fail("QuestionAnswer mappings list has no entries.");
	}

	/**
	 * Test method for {@link city.baltimore.eip.dao.MappingsDao#getPriorityMappings()}.
	 * Check that priority mappings Cityworks values are the expected values.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Test
	public void testGetPriorityMappingsMatch() throws JsonParseException, JsonMappingException, IOException {
		assertTrue("Emergency priority mapping doesn't match.", priorityMappings.get("EMERGNCY").equalsIgnoreCase("1"));
		assertTrue("Urgent priority mapping doesn't match.", priorityMappings.get("URGENT").equalsIgnoreCase("2"));
		assertTrue("Priority priority mapping doesn't match.", priorityMappings.get("PRIORITY").equalsIgnoreCase("6"));
	}

	/**
	 * Test method for {@link city.baltimore.eip.dao.MappingsDao#getQuestionAnswerMappings()}.
	 * Check that question answer mappings Cityworks values are the expected values.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Test
	public void testGetQuestionAnswerMappingsMatch() throws JsonParseException, JsonMappingException, IOException {
		assertTrue("10WWP-THROENTHSE question answer mapping doesn't match.", qaMappings.get("10WWP-THROENTHSE").equals(164));
		assertTrue("10WWP-ONLYONEAFF question answer mapping doesn't match.", qaMappings.get("10WWP-ONLYONEAFF").equals(167));
		assertTrue("10WWP-HYDRTINUSE question answer mapping doesn't match.", qaMappings.get("10WWP-HYDRTINUSE").equals(170));
	}

	/**
	 * Test method for {@link city.baltimore.eip.dao.MappingsDao#getPriorityMappings()}.
	 * Check that priority mappings Cityworks values are the expected values.
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonParseException 
	 */
	@Test
	public void testGetPriorityMappingsNoMatch() throws JsonParseException, JsonMappingException, IOException {
		assertNull("A wrong CSR priority code that does not have a corresponding code mapped for Cityworks should be null, but was not null.", priorityMappings.get("DERP"));
	}
	
	
}