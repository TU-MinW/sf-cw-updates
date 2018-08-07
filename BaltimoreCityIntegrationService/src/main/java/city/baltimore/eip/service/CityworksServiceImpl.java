/**
 * 
 */
package city.baltimore.eip.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;

import city.baltimore.eip.dao.CityworksDao;
import city.baltimore.eip.model.cityworks.CityworksServiceRequest;
import city.baltimore.eip.model.cityworks.ProblemName;
import city.baltimore.eip.model.cityworks.ProblemQA;
import city.baltimore.eip.model.cityworks.ProblemQAValue;
import city.baltimore.eip.model.cityworks.ProblemQuestionBase;
import city.baltimore.eip.model.cityworks.QuestionAnswerBase;

/**
 * 
 * @author James.Somerville
 *
 */
@Service
public class CityworksServiceImpl implements CityworksService {	
	@Autowired
	private CityworksDao cityworksDao;
	
	/*
	 * (non-Javadoc)
	 * @see city.baltimore.eip.service.CityworksApiService#SrExistsInCityworks(java.lang.String)
	 */
	@Override
	public boolean SrExistsInCityworks(String otherSystemId) throws Exception {
		//Attempt to obtain a service request from Cityworks with the Other System ID. API returns null if no SR found.
		CityworksServiceRequest serviceRequest = cityworksDao.GetServiceRequestByOtherSystemId(otherSystemId);
		if (serviceRequest == null)
			return false;
		else 
			return true;
	}

	/* (non-Javadoc)
	 * @see city.baltimore.eip.service.CityworksApiService#GetProblemSid(java.lang.String)
	 */
	@Override
	public Integer GetProblemSid(String problemCode) throws Exception {
		Integer problemsid = null;
		//Obtain the list of service request problems from Cityworks
        List<ProblemName> problems = cityworksDao.GetServiceRequestProblems();
        //Find the corresponding problem id corresponding to the problem code passed in.
        for (ProblemName problem : problems) {
        	if (problem.getProblemcode().equals(problemCode)) {
        		problemsid = problem.getProblemsid();
        		break;
        	}
        }
        return problemsid;
	}

	/* (non-Javadoc)
	 * @see city.baltimore.eip.service.CityworksApiService#GetAnswerIds(int, java.util.List)
	 */
	@Override
	public Map<String, Integer> GetAnswerIds(int problemSid, List<String> questions) throws Exception {
		HashMap<String, Integer> questionsAnswerIds = new HashMap<String, Integer>();
		//Obtain the lists of question and answers from Cityworks
		ProblemQAValue problemQA = cityworksDao.GetServiceRequestProblemQAs(problemSid);
		/* For each question passed in, attempt to find a corresponding question id in the list from the Cityworks response.
		 * 		Then, using that question id, find the corresponding answer id in the other list from the Cityworks response.
		 */
		for (String question : questions) {
			for (ProblemQuestionBase problemQuestion : problemQA.getQuestions()) {
				if (problemQuestion.getQuestion().equals(question)) {
					int questionId = problemQuestion.getQuestionid();
					for (QuestionAnswerBase questionAnswer : problemQA.getAnswers()) {
						if (questionAnswer.getQuestionid() == questionId) {
							int answerId = questionAnswer.getAnswerid();
							questionsAnswerIds.put(question, answerId);
							break;
						}
					}
					break;
				}
			}
		}
		return questionsAnswerIds;
	}

	/*
	 * (non-Javadoc)
	 * @see city.baltimore.eip.service.CityworksApiService#InsertNewServiceRequest(city.baltimore.eip.model.cityworks.CityworksServiceRequest)
	 */
	@Override
	public CityworksServiceRequest InsertNewServiceRequest(CityworksServiceRequest serviceRequest) throws JsonProcessingException, Exception {
		CityworksServiceRequest sr = cityworksDao.CreateServiceRequest(serviceRequest);
		return sr;
	}
}