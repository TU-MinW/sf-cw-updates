/**
 * 
 */
package city.baltimore.eip.model.cityworks;

import java.util.List;

//import lombok.Data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @author James.Somerville
 * The Cityworks problems' questions and corresponding possible answers to each question.
 */
//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class ProblemQA /*extends BaseCityworksTemplate*/ {
	private List<QuestionAnswerBase> answers;
	private List<ProblemQuestionBase> questions;
	
	public List<QuestionAnswerBase> getAnswers() {
		return answers;
	}
	public List<ProblemQuestionBase> getQuestions() {
		return questions;
	}
}
