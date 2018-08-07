//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.02 at 04:00:13 PM EST 
//


package city.baltimore.eip.model.motorola.csr;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Id" minOccurs="0"/>
 *         &lt;element ref="{}Manager_res_id" minOccurs="0"/>
 *         &lt;element ref="{}Method_received_code" minOccurs="0"/>
 *         &lt;element ref="{}Method_received_description" minOccurs="0"/>
 *         &lt;element ref="{}Prc_code" minOccurs="0"/>
 *         &lt;element ref="{}Prc_description" minOccurs="0"/>
 *         &lt;element ref="{}Priority_code" minOccurs="0"/>
 *         &lt;element ref="{}Priority_description" minOccurs="0"/>
 *         &lt;element ref="{}Owner_group_code" minOccurs="0"/>
 *         &lt;element ref="{}Owner_group_description" minOccurs="0"/>
 *         &lt;element ref="{}Jurisdiction_code" minOccurs="0"/>
 *         &lt;element ref="{}Jurisdiction_description" minOccurs="0"/>
 *         &lt;element ref="{}Creation_reason_code" minOccurs="0"/>
 *         &lt;element ref="{}Creation_reason_description" minOccurs="0"/>
 *         &lt;element ref="{}Status_code" minOccurs="0"/>
 *         &lt;element ref="{}Status_description" minOccurs="0"/>
 *         &lt;element ref="{}Status_date" minOccurs="0"/>
 *         &lt;element ref="{}Prc_number" minOccurs="0"/>
 *         &lt;element ref="{}Details" minOccurs="0"/>
 *         &lt;element ref="{}Begin_resolution_date" minOccurs="0"/>
 *         &lt;element ref="{}Duration_days_to_complete" minOccurs="0"/>
 *         &lt;element ref="{}Created_by" minOccurs="0"/>
 *         &lt;element ref="{}Created_by_description" minOccurs="0"/>
 *         &lt;element ref="{}Created_date" minOccurs="0"/>
 *         &lt;element ref="{}Updated_by" minOccurs="0"/>
 *         &lt;element ref="{}Updated_by_description" minOccurs="0"/>
 *         &lt;element ref="{}Updated_date" minOccurs="0"/>
 *         &lt;element ref="{}Record_version" minOccurs="0"/>
 *         &lt;element ref="{}Prc_attributes" minOccurs="0"/>
 *         &lt;element ref="{}Prc_participants" minOccurs="0"/>
 *         &lt;element ref="{}Prc_activities" minOccurs="0"/>
 *         &lt;element ref="{}Prc_linked_processes" minOccurs="0"/>
 *         &lt;element ref="{}Prc_historical_geo_areas" minOccurs="0"/>
 *         &lt;element ref="{}Geo_locations" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "id",
    "managerResId",
    "methodReceivedCode",
    "methodReceivedDescription",
    "prcCode",
    "prcDescription",
    "priorityCode",
    "priorityDescription",
    "ownerGroupCode",
    "ownerGroupDescription",
    "jurisdictionCode",
    "jurisdictionDescription",
    "creationReasonCode",
    "creationReasonDescription",
    "statusCode",
    "statusDescription",
    "statusDate",
    "prcNumber",
    "details",
    "beginResolutionDate",
    "durationDaysToComplete",
    "createdBy",
    "createdByDescription",
    "createdDate",
    "updatedBy",
    "updatedByDescription",
    "updatedDate",
    "recordVersion",
    "prcAttributes",
    "prcParticipants",
    "prcActivities",
    "prcLinkedProcesses",
    "prcHistoricalGeoAreas",
    "geoLocations"
})
@XmlRootElement(name = "Prc_instance")
public class PrcInstance {

    @XmlElement(name = "Id")
    protected BigInteger id;
    @XmlElement(name = "Manager_res_id")
    protected BigInteger managerResId;
    @XmlElement(name = "Method_received_code")
    protected String methodReceivedCode;
    @XmlElement(name = "Method_received_description")
    protected String methodReceivedDescription;
    @XmlElement(name = "Prc_code")
    protected String prcCode;
    @XmlElement(name = "Prc_description")
    protected String prcDescription;
    @XmlElement(name = "Priority_code")
    protected String priorityCode;
    @XmlElement(name = "Priority_description")
    protected String priorityDescription;
    @XmlElement(name = "Owner_group_code")
    protected String ownerGroupCode;
    @XmlElement(name = "Owner_group_description")
    protected String ownerGroupDescription;
    @XmlElement(name = "Jurisdiction_code")
    protected String jurisdictionCode;
    @XmlElement(name = "Jurisdiction_description")
    protected String jurisdictionDescription;
    @XmlElement(name = "Creation_reason_code")
    protected String creationReasonCode;
    @XmlElement(name = "Creation_reason_description")
    protected String creationReasonDescription;
    @XmlElement(name = "Status_code")
    protected String statusCode;
    @XmlElement(name = "Status_description")
    protected String statusDescription;
    @XmlElement(name = "Status_date")
    protected String statusDate;
    @XmlElement(name = "Prc_number")
    protected String prcNumber;
    @XmlElement(name = "Details")
    protected String details;
    @XmlElement(name = "Begin_resolution_date")
    protected String beginResolutionDate;
    @XmlElement(name = "Duration_days_to_complete")
    protected BigDecimal durationDaysToComplete;
    @XmlElement(name = "Created_by")
    protected BigInteger createdBy;
    @XmlElement(name = "Created_by_description")
    protected String createdByDescription;
    @XmlElement(name = "Created_date")
    protected String createdDate;
    @XmlElement(name = "Updated_by")
    protected BigInteger updatedBy;
    @XmlElement(name = "Updated_by_description")
    protected String updatedByDescription;
    @XmlElement(name = "Updated_date")
    protected String updatedDate;
    @XmlElement(name = "Record_version")
    protected BigInteger recordVersion;
    @XmlElement(name = "Prc_attributes")
    protected PrcAttributesType prcAttributes;
    @XmlElement(name = "Prc_participants")
    protected PrcParticipantsType prcParticipants;
    @XmlElement(name = "Prc_activities")
    protected PrcActivitiesType prcActivities;
    @XmlElement(name = "Prc_linked_processes")
    protected PrcLinkedProcessesType prcLinkedProcesses;
    @XmlElement(name = "Prc_historical_geo_areas")
    protected PrcHistoricalGeoAreasType prcHistoricalGeoAreas;
    @XmlElement(name = "Geo_locations")
    protected LocationsType geoLocations;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setId(BigInteger value) {
        this.id = value;
    }

    /**
     * Gets the value of the managerResId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getManagerResId() {
        return managerResId;
    }

    /**
     * Sets the value of the managerResId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setManagerResId(BigInteger value) {
        this.managerResId = value;
    }

    /**
     * Gets the value of the methodReceivedCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethodReceivedCode() {
        return methodReceivedCode;
    }

    /**
     * Sets the value of the methodReceivedCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethodReceivedCode(String value) {
        this.methodReceivedCode = value;
    }

    /**
     * Gets the value of the methodReceivedDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMethodReceivedDescription() {
        return methodReceivedDescription;
    }

    /**
     * Sets the value of the methodReceivedDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMethodReceivedDescription(String value) {
        this.methodReceivedDescription = value;
    }

    /**
     * Gets the value of the prcCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcCode() {
        return prcCode;
    }

    /**
     * Sets the value of the prcCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcCode(String value) {
        this.prcCode = value;
    }

    /**
     * Gets the value of the prcDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcDescription() {
        return prcDescription;
    }

    /**
     * Sets the value of the prcDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcDescription(String value) {
        this.prcDescription = value;
    }

    /**
     * Gets the value of the priorityCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriorityCode() {
        return priorityCode;
    }

    /**
     * Sets the value of the priorityCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriorityCode(String value) {
        this.priorityCode = value;
    }

    /**
     * Gets the value of the priorityDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriorityDescription() {
        return priorityDescription;
    }

    /**
     * Sets the value of the priorityDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriorityDescription(String value) {
        this.priorityDescription = value;
    }

    /**
     * Gets the value of the ownerGroupCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerGroupCode() {
        return ownerGroupCode;
    }

    /**
     * Sets the value of the ownerGroupCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerGroupCode(String value) {
        this.ownerGroupCode = value;
    }

    /**
     * Gets the value of the ownerGroupDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOwnerGroupDescription() {
        return ownerGroupDescription;
    }

    /**
     * Sets the value of the ownerGroupDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOwnerGroupDescription(String value) {
        this.ownerGroupDescription = value;
    }

    /**
     * Gets the value of the jurisdictionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdictionCode() {
        return jurisdictionCode;
    }

    /**
     * Sets the value of the jurisdictionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdictionCode(String value) {
        this.jurisdictionCode = value;
    }

    /**
     * Gets the value of the jurisdictionDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getJurisdictionDescription() {
        return jurisdictionDescription;
    }

    /**
     * Sets the value of the jurisdictionDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setJurisdictionDescription(String value) {
        this.jurisdictionDescription = value;
    }

    /**
     * Gets the value of the creationReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationReasonCode() {
        return creationReasonCode;
    }

    /**
     * Sets the value of the creationReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationReasonCode(String value) {
        this.creationReasonCode = value;
    }

    /**
     * Gets the value of the creationReasonDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationReasonDescription() {
        return creationReasonDescription;
    }

    /**
     * Sets the value of the creationReasonDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationReasonDescription(String value) {
        this.creationReasonDescription = value;
    }

    /**
     * Gets the value of the statusCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusCode() {
        return statusCode;
    }

    /**
     * Sets the value of the statusCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusCode(String value) {
        this.statusCode = value;
    }

    /**
     * Gets the value of the statusDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDescription() {
        return statusDescription;
    }

    /**
     * Sets the value of the statusDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDescription(String value) {
        this.statusDescription = value;
    }

    /**
     * Gets the value of the statusDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDate() {
        return statusDate;
    }

    /**
     * Sets the value of the statusDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDate(String value) {
        this.statusDate = value;
    }

    /**
     * Gets the value of the prcNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrcNumber() {
        return prcNumber;
    }

    /**
     * Sets the value of the prcNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrcNumber(String value) {
        this.prcNumber = value;
    }

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetails(String value) {
        this.details = value;
    }

    /**
     * Gets the value of the beginResolutionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginResolutionDate() {
        return beginResolutionDate;
    }

    /**
     * Sets the value of the beginResolutionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginResolutionDate(String value) {
        this.beginResolutionDate = value;
    }

    /**
     * Gets the value of the durationDaysToComplete property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDurationDaysToComplete() {
        return durationDaysToComplete;
    }

    /**
     * Sets the value of the durationDaysToComplete property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDurationDaysToComplete(BigDecimal value) {
        this.durationDaysToComplete = value;
    }

    /**
     * Gets the value of the createdBy property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCreatedBy() {
        return createdBy;
    }

    /**
     * Sets the value of the createdBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCreatedBy(BigInteger value) {
        this.createdBy = value;
    }

    /**
     * Gets the value of the createdByDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedByDescription() {
        return createdByDescription;
    }

    /**
     * Sets the value of the createdByDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedByDescription(String value) {
        this.createdByDescription = value;
    }

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedDate(String value) {
        this.createdDate = value;
    }

    /**
     * Gets the value of the updatedBy property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUpdatedBy() {
        return updatedBy;
    }

    /**
     * Sets the value of the updatedBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUpdatedBy(BigInteger value) {
        this.updatedBy = value;
    }

    /**
     * Gets the value of the updatedByDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedByDescription() {
        return updatedByDescription;
    }

    /**
     * Sets the value of the updatedByDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedByDescription(String value) {
        this.updatedByDescription = value;
    }

    /**
     * Gets the value of the updatedDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdatedDate() {
        return updatedDate;
    }

    /**
     * Sets the value of the updatedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdatedDate(String value) {
        this.updatedDate = value;
    }

    /**
     * Gets the value of the recordVersion property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getRecordVersion() {
        return recordVersion;
    }

    /**
     * Sets the value of the recordVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setRecordVersion(BigInteger value) {
        this.recordVersion = value;
    }

    /**
     * Gets the value of the prcAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link PrcAttributesType }
     *     
     */
    public PrcAttributesType getPrcAttributes() {
        return prcAttributes;
    }

    /**
     * Sets the value of the prcAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrcAttributesType }
     *     
     */
    public void setPrcAttributes(PrcAttributesType value) {
        this.prcAttributes = value;
    }

    /**
     * Gets the value of the prcParticipants property.
     * 
     * @return
     *     possible object is
     *     {@link PrcParticipantsType }
     *     
     */
    public PrcParticipantsType getPrcParticipants() {
        return prcParticipants;
    }

    /**
     * Sets the value of the prcParticipants property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrcParticipantsType }
     *     
     */
    public void setPrcParticipants(PrcParticipantsType value) {
        this.prcParticipants = value;
    }

    /**
     * Gets the value of the prcActivities property.
     * 
     * @return
     *     possible object is
     *     {@link PrcActivitiesType }
     *     
     */
    public PrcActivitiesType getPrcActivities() {
        return prcActivities;
    }

    /**
     * Sets the value of the prcActivities property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrcActivitiesType }
     *     
     */
    public void setPrcActivities(PrcActivitiesType value) {
        this.prcActivities = value;
    }

    /**
     * Gets the value of the prcLinkedProcesses property.
     * 
     * @return
     *     possible object is
     *     {@link PrcLinkedProcessesType }
     *     
     */
    public PrcLinkedProcessesType getPrcLinkedProcesses() {
        return prcLinkedProcesses;
    }

    /**
     * Sets the value of the prcLinkedProcesses property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrcLinkedProcessesType }
     *     
     */
    public void setPrcLinkedProcesses(PrcLinkedProcessesType value) {
        this.prcLinkedProcesses = value;
    }

    /**
     * Gets the value of the prcHistoricalGeoAreas property.
     * 
     * @return
     *     possible object is
     *     {@link PrcHistoricalGeoAreasType }
     *     
     */
    public PrcHistoricalGeoAreasType getPrcHistoricalGeoAreas() {
        return prcHistoricalGeoAreas;
    }

    /**
     * Sets the value of the prcHistoricalGeoAreas property.
     * 
     * @param value
     *     allowed object is
     *     {@link PrcHistoricalGeoAreasType }
     *     
     */
    public void setPrcHistoricalGeoAreas(PrcHistoricalGeoAreasType value) {
        this.prcHistoricalGeoAreas = value;
    }

    /**
     * Gets the value of the geoLocations property.
     * 
     * @return
     *     possible object is
     *     {@link LocationsType }
     *     
     */
    public LocationsType getGeoLocations() {
        return geoLocations;
    }

    /**
     * Sets the value of the geoLocations property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationsType }
     *     
     */
    public void setGeoLocations(LocationsType value) {
        this.geoLocations = value;
    }

}
