package city.baltimore.eip.model.salesforce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Jun.Tao
 * The Salesforce Attribute.
 */
//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class Attribute {
	private String code;
	private String description;
	private Integer order;
	private List<AttributeValue> values;

	public String getCode() {
		return code;
	}

	@JsonProperty("code")
	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getOrder() {
		return order;
	}

	@JsonProperty("order")
	public void setOrder(Integer order) {
		this.order = order;
	}

	public List<AttributeValue> getValues() {
		return values;
	}

	@JsonProperty("values")
	public void setValues(List<AttributeValue> values) {
		this.values = values;
	}
}