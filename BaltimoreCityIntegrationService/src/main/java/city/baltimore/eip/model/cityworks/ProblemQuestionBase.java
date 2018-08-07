package city.baltimore.eip.model.cityworks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author James.Somerville
 * A Cityworks question.
 */
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class ProblemQuestionBase {
	private int questionid;
	private String question;
	
	public int getQuestionid() {
		return questionid;
	}
	@JsonProperty("QuestionId")
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public String getQuestion() {
		return question;
	}
	@JsonProperty("Question")
	public void setQuestion(String question) {
		this.question = question;
	}
}
