package city.baltimore.eip.model.cityworks;

import com.fasterxml.jackson.annotation.JsonProperty;

/*
 * The response by the caller to a question (corresponding the answerid stored in Cityworks). 
 */
public class ServiceRequestAnswer {
	private int answerId;
	private String answerValue;

	public ServiceRequestAnswer(int answerId, String answerValue) {
		this.answerId = answerId;
		this.answerValue = answerValue;
	}
	
	public int getAnswerId() {
		return answerId;
	}
	@JsonProperty("AnswerId")
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	
	public String getAnswerValue() {
		return answerValue;
	}
	@JsonProperty("AnswerValue")
	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}
}
