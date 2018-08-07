/**
 * 
 */
package city.baltimore.eip.service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import city.baltimore.eip.model.cityworks.CityworksServiceRequest;

/**
 * @author James.Somerville
 *
 */
public interface CityworksService {
	/**
	 * Check if a Service Request exists in Cityworks for the given Other System ID.
	 * @param otherSystemId The Other System ID (e.g. Motorola CSR system ID)
	 * @return True if exists, false if not found.
	 */
	public boolean SrExistsInCityworks(String otherSystemId) throws Exception;
	
	/**
	 * Obtain the applicable ProblemSid from Cityworks for the code specified.
	 * @param ProblemCode The code to get the ProblemSid for.
	 * @return The ProblemSid
	 */
	public Integer GetProblemSid(String ProblemCode) throws Exception;
	
	/**
	 * Obtain a list of Cityworks answerids for the question text(s) given.
	 * @param problemSid The Cityworks problem id to find questions and answers for.
	 * @param questions The text of the questions to find in Cityworks.
	 * @return A set of key/value entries with the question passed in as the key and the corresponding answer id as the value.
	 */
	public Map<String, Integer> GetAnswerIds(int problemSid, List<String> questions) throws Exception;
	
	/**
	 * Create a new Service Request in Cityworks.
	 * @param newServiceRequest The Cityworks service request to create.
	 * @throws JsonProcessingException 
	 * @throws IOException 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 */
	public CityworksServiceRequest InsertNewServiceRequest(CityworksServiceRequest newServiceRequest) throws JsonProcessingException, Exception;
}