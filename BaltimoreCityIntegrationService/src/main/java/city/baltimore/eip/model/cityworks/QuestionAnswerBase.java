/**
 * 
 */
package city.baltimore.eip.model.cityworks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author James.Somerville
 * A Cityworks answer for a particular question (questionid).
 */
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class QuestionAnswerBase {
	private int questionid;
	private int answerid;
	
	public int getQuestionid() {
		return questionid;
	}
	@JsonProperty("QuestionId")
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	public int getAnswerid() {
		return answerid;
	}
	@JsonProperty("AnswerId")
	public void setAnswerid(int answerid) {
		this.answerid = answerid;
	}
}
