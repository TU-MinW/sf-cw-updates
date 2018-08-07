package city.baltimore.eip.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Jun.Tao
 * The Geometry.
 */
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
@JsonRootName(value = "geometries")
public class Geometry {
	private Double x;
	private Double y;

	public Double getX() {
		return x;
	}

	@JsonProperty("x")
	public void setX(Double x) {
		this.x = x;
	}

	public Double getY() {
		return y;
	}

	@JsonProperty("y")
	public void setY(Double y) {
		this.y = y;
	}
}