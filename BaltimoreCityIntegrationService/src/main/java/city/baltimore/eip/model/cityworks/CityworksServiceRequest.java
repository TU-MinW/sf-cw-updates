/**
 * 
 */
package city.baltimore.eip.model.cityworks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The needed attributes for a Cityworks Service Request. Can be serialized to JSON for a call to the Cityworks REST API- Create Service Request.
 * @author james.somerville
 *
 */
public class CityworksServiceRequest {
	private String address;
	private String aptNum;
	private ArrayList<ServiceRequestAnswer> answers;
	private String callerAddress;
	private String callerAptNum;
	private String callerCallTime;
	private String callerCellPhone;
	private String callerCity;
	private String callerDistrict;
	private String callerEmail;
	private String callerFirstName;
	private String callerLastName;
	private String callerHomePhone;
	private String callerMiddleInitial;
	private String callerOtherPhone;
	private String callerState;
	private String callerType;
	private String callerWorkPhone;
	private String callerZip;
	private String city;
	private String comments;
	private String details;
	private String district;
	private String priority;
	private int problemSid;
	private String problemCode;
	private int requestId;
	private String state;
	private String streetName;
	private String location;
	private String otherSystemId;
	private String text4;
	private Double x;
	private Double y;
	private String zip;

	public String getAddress() {
		return address;
	}	
	@JsonProperty("Address")
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAptNum() {
		return aptNum;
	}
	@JsonProperty("AptNum")
	public void setAptNum(String aptNum) {
		this.aptNum = aptNum;
	}
	public ArrayList<ServiceRequestAnswer> getAnswers() {
		return answers;
	}
	@JsonProperty("Answers")
	public void setAnswers(ArrayList<ServiceRequestAnswer> answers) {
		this.answers = answers;
	}
	public String getCallerAddress() {
		return callerAddress;
	}
	@JsonProperty("CallerAddress")
	public void setCallerAddress(String callerAddress) {
		this.callerAddress = callerAddress;
	}
	public String getCallerAptNum() {
		return callerAptNum;
	}
	@JsonProperty("CallerAptNum")
	public void setCallerAptNum(String callerAptNum) {
		this.callerAptNum = callerAptNum;
	}
	/**
	 * 
	 * @return formatted as "yyyy-MM-dd'T'HH:mm:ss"
	 */
	public String getCallerCallTime() {
		return callerCallTime;
	}
	/**
	 * 
	 * @param callerCallTime String should be formatted as "yyyy-MM-dd'T'HH:mm:ss"
	 */
	@JsonProperty("CallerCallTime")
	public void setCallerCallTime(String callerCallTime) {
		this.callerCallTime = callerCallTime;
	}
	public String getCallerCellPhone() {
		return callerCellPhone;
	}
	@JsonProperty("CallerCellPhone")
	public void setCallerCellPhone(String callerCellPhone) {
		this.callerCellPhone = callerCellPhone;
	}
	public String getCallerCity() {
		return callerCity;
	}
	@JsonProperty("CallerCity")
	public void setCallerCity(String callerCity) {
		this.callerCity = callerCity;
	}
	public String getCallerDistrict() {
		return callerDistrict;
	}
	@JsonProperty("CallerDistrict")
	public void setCallerDistrict(String callerDistrict) {
		this.callerDistrict = callerDistrict;
	}
	public String getCallerEmail() {
		return callerEmail;
	}
	@JsonProperty("CallerEmail")
	public void setCallerEmail(String callerEmail) {
		this.callerEmail = callerEmail;
	}
	public String getCallerFirstName() {
		return callerFirstName;
	}
	@JsonProperty("CallerFirstName")
	public void setCallerFirstName(String callerFirstName) {
		this.callerFirstName = callerFirstName;
	}
	public String getCallerLastName() {
		return callerLastName;
	}
	@JsonProperty("CallerLastName")
	public void setCallerLastName(String callerLastName) {
		this.callerLastName = callerLastName;
	}
	public String getCallerHomePhone() {
		return callerHomePhone;
	}
	@JsonProperty("CallerHomePhone")
	public void setCallerHomePhone(String callerHomePhone) {
		this.callerHomePhone = callerHomePhone;
	}
	public String getCallerMiddleInitial() {
		return callerMiddleInitial;
	}
	@JsonProperty("CallerMiddleInitial")
	public void setCallerMiddleInitial(String callerMiddleInitial) {
		this.callerMiddleInitial = callerMiddleInitial;
	}
	public String getCallerOtherPhone() {
		return callerOtherPhone;
	}
	@JsonProperty("CallerOtherPhone")
	public void setCallerOtherPhone(String callerOtherPhone) {
		this.callerOtherPhone = callerOtherPhone;
	}
	public String getCallerState() {
		return callerState;
	}
	@JsonProperty("CallerState")
	public void setCallerState(String callerState) {
		this.callerState = callerState;
	}
	public String getCallerType() {
		return callerType;
	}
	@JsonProperty("CallerType")
	public void setCallerType(String callerType) {
		this.callerType = callerType;
	}
	public String getCallerWorkPhone() {
		return callerWorkPhone;
	}
	@JsonProperty("CallerWorkPhone")
	public void setCallerWorkPhone(String callerWorkPhone) {
		this.callerWorkPhone = callerWorkPhone;
	}
	public String getCallerZip() {
		return callerZip;
	}
	@JsonProperty("CallerZip")
	public void setCallerZip(String callerZip) {
		this.callerZip = callerZip;
	}
	public String getCity() {
		return city;
	}
	@JsonProperty("City")
	public void setCity(String city) {
		this.city = city;
	}
	public String getComments() {
		return comments;
	}
	@JsonProperty("Comments")
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getDetails() {
		return details;
	}
	@JsonProperty("Details")
	public void setDetails(String details) {
		this.details = details;
	}
	public String getDistrict() {
		return district;
	}
	@JsonProperty("District")
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPriority() {
		return priority;
	}
	@JsonProperty("Priority")
	public void setPriority(String priority) {
		this.priority = priority;
	}
	public int getProblemSid() {
		return problemSid;
	}
	@JsonProperty("ProblemSid")
	public void setProblemSid(int problemSid) {
		this.problemSid = problemSid;
	}

	public String getProblemCode() {
		return problemCode;
	}
	@JsonProperty("ProblemCode")
	public void setProblemCode(String problemCode) {
		this.problemCode = problemCode;
	}
	public int getRequestId() {
		return requestId;
	}
	@JsonProperty("RequestId")
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getState() {
		return state;
	}
	@JsonProperty("State")
	public void setState(String state) {
		this.state = state;
	}
	public String getStreetName() {
		return streetName;
	}
	@JsonProperty("StreetName")
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	public String getLocation() {
		return location;
	}
	@JsonProperty("Location")
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOtherSystemId() {
		return otherSystemId;
	}
	@JsonProperty("OtherSystemId")
	public void setOtherSystemId(String text3) {
		this.otherSystemId = text3;
	}
	public String getText4() {
		return text4;
	}
	@JsonProperty("Text4")
	public void setText4(String text4) {
		this.text4 = text4;
	}
	public Double getX() {
		return x;
	}
	@JsonProperty("X")
	public void setX(Double x) {
		this.x = x;
	}
	public Double getY() {
		return y;
	}
	@JsonProperty("Y")
	public void setY(Double y) {
		this.y = y;
	}
	public String getZip() {
		return zip;
	}
	@JsonProperty("Zip")
	public void setZip(String zip) {
		this.zip = zip;
	}
}