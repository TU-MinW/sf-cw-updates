//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.02 at 04:00:13 PM EST 
//


package city.baltimore.eip.model.motorola.csr;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for resInstanceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="resInstanceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Id" minOccurs="0"/>
 *         &lt;element ref="{}Res_code" minOccurs="0"/>
 *         &lt;element ref="{}Res_description" minOccurs="0"/>
 *         &lt;element ref="{}Category_code" minOccurs="0"/>
 *         &lt;element ref="{}Owner_group_code" minOccurs="0"/>
 *         &lt;element ref="{}Owner_group_description" minOccurs="0"/>
 *         &lt;element ref="{}Start_date" minOccurs="0"/>
 *         &lt;element ref="{}Stop_date" minOccurs="0"/>
 *         &lt;element ref="{}Created_by" minOccurs="0"/>
 *         &lt;element ref="{}Created_date" minOccurs="0"/>
 *         &lt;element ref="{}Updated_by" minOccurs="0"/>
 *         &lt;element ref="{}Updated_date" minOccurs="0"/>
 *         &lt;element ref="{}Record_version" minOccurs="0"/>
 *         &lt;element ref="{}Geo_locations" minOccurs="0"/>
 *         &lt;element ref="{}Res_names" minOccurs="0"/>
 *         &lt;element ref="{}Res_attributes" minOccurs="0"/>
 *         &lt;element ref="{}Res_phones" minOccurs="0"/>
 *         &lt;element ref="{}Res_electronic_addresses" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "resInstanceType", propOrder = {
    "id",
    "resCode",
    "resDescription",
    "categoryCode",
    "ownerGroupCode",
    "ownerGroupDescription",
    "startDate",
    "stopDate",
    "createdBy",
    "createdDate",
    "updatedBy",
    "updatedDate",
    "recordVersion",
    "geoLocations",
    "resNames",
    "resAttributes",
    "resPhones",
    "resElectronicAddresses"
})
public class ResInstanceType {

    @XmlElement(name = "Id")
    protected BigInteger id;
    @XmlElement(name = "Res_code")
    protected String resCode;
    @XmlElement(name = "Res_description")
    protected String resDescription;
    @XmlElement(name = "Category_code")
    protected String categoryCode;
    @XmlElement(name = "Owner_group_code")
    protected String ownerGroupCode;
    @XmlElement(name = "Owner_group_description")
    protected String ownerGroupDescription;
    @XmlElement(name = "Start_date")
    protected String startDate;
    @XmlElement(name = "Stop_date")
    protected String stopDate;
    @XmlElement(name = "Created_by")
    protected BigInteger createdBy;
    @XmlElement(name = "Created_date")
    protected String createdDate;
    @XmlElement(name = "Updated_by")
    protected BigInteger updatedBy;
    @XmlElement(name = "Updated_date")
    protected String updatedDate;
    @XmlElement(name = "Record_version")
    protected BigInteger recordVersion;
    @XmlElement(name = "Geo_locations")
    protected LocationsType geoLocations;
    @XmlElement(name = "Res_names")
    protected ResNamesType resNames;
    @XmlElement(name = "Res_attributes")
    protected ResAttributesType resAttributes;
    @XmlElement(name = "Res_phones")
    protected ResPhonesType resPhones;
    @XmlElement(name = "Res_electronic_addresses")
    protected ResElectronicAddressesType resElectronicAddresses;

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
     * Gets the value of the resCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResCode() {
        return resCode;
    }

    /**
     * Sets the value of the resCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResCode(String value) {
        this.resCode = value;
    }

    /**
     * Gets the value of the resDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResDescription() {
        return resDescription;
    }

    /**
     * Sets the value of the resDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResDescription(String value) {
        this.resDescription = value;
    }

    /**
     * Gets the value of the categoryCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Sets the value of the categoryCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoryCode(String value) {
        this.categoryCode = value;
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
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the stopDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStopDate() {
        return stopDate;
    }

    /**
     * Sets the value of the stopDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStopDate(String value) {
        this.stopDate = value;
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

    /**
     * Gets the value of the resNames property.
     * 
     * @return
     *     possible object is
     *     {@link ResNamesType }
     *     
     */
    public ResNamesType getResNames() {
        return resNames;
    }

    /**
     * Sets the value of the resNames property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResNamesType }
     *     
     */
    public void setResNames(ResNamesType value) {
        this.resNames = value;
    }

    /**
     * Gets the value of the resAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link ResAttributesType }
     *     
     */
    public ResAttributesType getResAttributes() {
        return resAttributes;
    }

    /**
     * Sets the value of the resAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResAttributesType }
     *     
     */
    public void setResAttributes(ResAttributesType value) {
        this.resAttributes = value;
    }

    /**
     * Gets the value of the resPhones property.
     * 
     * @return
     *     possible object is
     *     {@link ResPhonesType }
     *     
     */
    public ResPhonesType getResPhones() {
        return resPhones;
    }

    /**
     * Sets the value of the resPhones property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResPhonesType }
     *     
     */
    public void setResPhones(ResPhonesType value) {
        this.resPhones = value;
    }

    /**
     * Gets the value of the resElectronicAddresses property.
     * 
     * @return
     *     possible object is
     *     {@link ResElectronicAddressesType }
     *     
     */
    public ResElectronicAddressesType getResElectronicAddresses() {
        return resElectronicAddresses;
    }

    /**
     * Sets the value of the resElectronicAddresses property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResElectronicAddressesType }
     *     
     */
    public void setResElectronicAddresses(ResElectronicAddressesType value) {
        this.resElectronicAddresses = value;
    }

}