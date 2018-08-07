package city.baltimore.eip.model.salesforce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jun.Tao
 * The Salesforce Attribute Value.
 */
//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class AttributeValue {
	private String answer;
	private String answerValue;

	public String getAnswer() {
		return answer;
	}

	@JsonProperty("answer")
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getAnswerValue() {
		return answerValue;
	}

	@JsonProperty("answer_value")
	public void setAnswerValue(String answerValue) {
		this.answerValue = answerValue;
	}
}