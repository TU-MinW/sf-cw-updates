/**
 * 
 */
package city.baltimore.eip.model.salesforce;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The attributes of a Salesforce Service Request Details.
 * @author Jun.Tao
 *
 */
//@Data //Provides getters, setters, to string methods without explicitly creating
@JsonIgnoreProperties(ignoreUnknown = true) //Directs template to ignore properties not expressed in POJO
public class SalesforceRequest {
	private String serviceRequestId;
	private String status;
	private String statusNotes;
	private String serviceName;
	private String serviceCode;
	private String description;
	private String agencyResponsible;
	private String serviceNotice;
	private String requestedDatetime;
	private String updatedDatetime;
	private String expectedDatetime;
	private String address;
	private String addressId;
	private String zipcode;
	private Double latitude;
	private Double longitude;
	private List<Attachment> mediaUrl;
	private String priority;
	private String addressDetails;
	private Contact contact;
	private List<Attribute> attributes;
	private List<Activity> activities;

	public String getServiceRequestId() {
		return serviceRequestId;
	}

	@JsonProperty("service_request_id")
	public void setServiceRequestId(String serviceRequestId) {
		this.serviceRequestId = serviceRequestId;
	}

	public String getStatus() {
		return status;
	}

	@JsonProperty("status")
	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusNotes() {
		return statusNotes;
	}

	@JsonProperty("status_notes")
	public void setStatusNotes(String statusNotes) {
		this.statusNotes = statusNotes;
	}

	public String getServiceName() {
		return serviceName;
	}

	@JsonProperty("service_name")
	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	@JsonProperty("service_code")
	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getDescription() {
		return description;
	}

	@JsonProperty("description")
	public void setDescription(String description) {
		this.description = description;
	}

	public String getAgencyResponsible() {
		return agencyResponsible;
	}

	@JsonProperty("agency_responsible")
	public void setAgencyResponsible(String agencyResponsible) {
		this.agencyResponsible = agencyResponsible;
	}

	public String getServiceNotice() {
		return serviceNotice;
	}

	@JsonProperty("service_notice")
	public void setServiceNotice(String serviceNotice) {
		this.serviceNotice = serviceNotice;
	}

	public String getRequestedDatetime() {
		return requestedDatetime;
	}

	@JsonProperty("requested_datetime")
	public void setRequestedDatetime(String requestedDatetime) {
		this.requestedDatetime = requestedDatetime;
	}

	public String getUpdatedDatetime() {
		return updatedDatetime;
	}

	@JsonProperty("updated_datetime")
	public void setUpdatedDatetime(String updatedDatetime) {
		this.updatedDatetime = updatedDatetime;
	}

	public String getExpectedDatetime() {
		return expectedDatetime;
	}

	@JsonProperty("expected_datetime")
	public void setExpectedDatetime(String expectedDatetime) {
		this.expectedDatetime = expectedDatetime;
	}

	public String getAddress() {
		return address;
	}

	@JsonProperty("address")
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressId() {
		return addressId;
	}

	@JsonProperty("address_id")
	public void setAddressId(String addressId) {
		this.addressId = addressId;
	}

	public String getZipcode() {
		return zipcode;
	}

	@JsonProperty("zipcode")
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public Double getLatitude() {
		return latitude;
	}

	@JsonProperty("lat")
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	@JsonProperty("long")
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public List<Attachment> getMediaUrl() {
		return mediaUrl;
	}

	@JsonProperty("media_url")
	public void setMediaUrl(List<Attachment> mediaUrl) {
		this.mediaUrl = mediaUrl;
	}

	public String getPriority() {
		return priority;
	}

	@JsonProperty("priority")
	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getAddressDetails() {
		return addressDetails;
	}

	@JsonProperty("address_details")
	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}

	public Contact getContact() {
		return contact;
	}

	@JsonProperty("contact")
	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public List<Attribute> getAttributes() {
		return attributes;
	}

	@JsonProperty("attributes")
	public void setAttributes(List<Attribute> attributes) {
		this.attributes = attributes;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	@JsonProperty("activities")
	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}
}