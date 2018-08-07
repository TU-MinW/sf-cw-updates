/**
 * 
 */
package city.baltimore.eip.model.cityworks;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author James.Somerville
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class ProblemQAValue {
	ArrayList<ProblemQuestionBase> questions;
	ArrayList<QuestionAnswerBase> answers;
	
	public ArrayList<ProblemQuestionBase> getQuestions() {
		return questions;
	}
	@JsonProperty("Questions")
	public void setQuestions(ArrayList<ProblemQuestionBase> questions) {
		this.questions = questions;
	}
	public ArrayList<QuestionAnswerBase> getAnswers() {
		return answers;
	}
	@JsonProperty("Answers")
	public void setAnswers(ArrayList<QuestionAnswerBase> answers) {
		this.answers = answers;
	}
}
