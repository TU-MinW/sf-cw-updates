/**
 * 
 */
package city.baltimore.eip.dao;

import java.io.IOException;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Obtains the Priority mappings between Motorola CSR and Cityworks.
 * @author james.somerville
 */
@Repository
public class MappingsDao {
	@Value("${mappings.location.priority}")
	private String priorityMappingsFilePath;

	@Autowired
	JdbcTemplate jdbcTemplate;

	public MappingsDao() {
	}

	@Cacheable(value = "cityworkscsrprioritymappings")
	public HashMap<String, String> getPriorityMappings() throws JsonParseException, JsonMappingException, IOException {
		Gson gson = new Gson();
		Type type = new TypeToken<HashMap<String, String>>() {
		}.getType();
		HashMap<String, String> priorityMap = gson.fromJson(Resources.toString(Resources.getResource(priorityMappingsFilePath), Charsets.UTF_8), type);
		System.out.println("Read priority mappings file");
		return priorityMap;
	}

	
	@Cacheable(value = "cityworkssalesforcequestionanswermappings")
	public HashMap<String, Integer> getSalesforeCityworksQuestionAnswerMappings(Integer problemSid) throws JsonParseException, JsonMappingException, SQLException {
		HashMap<String, Integer> questionanswerMap = new HashMap<String, Integer>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList("SELECT SF_CODE, ANSWERID FROM [azteca].[xRef_Salesforce_QAs] WHERE PROBLEMSID =" + problemSid + " ORDER BY ANSWERID");
		
		for(Map row : rows) {
			questionanswerMap.put(row.get("SF_CODE").toString(), Integer.valueOf(row.get("ANSWERID").toString()));
			System.out.println(row.get("SF_CODE") + " ---- " +  row.get("ANSWERID"));
		}
		
		//This method is not used because rs.next() moves the cursor from first row to the second. Reading first row is skipped. 
		/*jdbcTemplate.query("SELECT SF_CODE, ANSWERID FROM [azteca].[xRef_Salesforce_QAs] WHERE PROBLEMSID =" + problemSid + " ORDER BY ANSWERID", (ResultSet rs) -> {			
			while(rs.next()){  
				questionanswerMap.put(rs.getString("SF_CODE"), rs.getInt("ANSWERID"));	
				//System.out.println("GET " + questionanswerMap.get(rs.getString("SF_CODE")));
				System.out.println(rs.getString("SF_CODE") + " ---- " +  rs.getInt("ANSWERID"));
			}
		});*/
		
		System.out.println("Load answer mappings from database");
		return questionanswerMap;
	}
}