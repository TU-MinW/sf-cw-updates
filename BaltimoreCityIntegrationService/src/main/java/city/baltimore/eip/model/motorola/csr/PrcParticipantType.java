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

import city.baltimore.eip.model.CsrElement;


/**
 * <p>Java class for prcParticipantType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="prcParticipantType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{}Id" minOccurs="0"/>
 *         &lt;element ref="{}Prc_instance_id" minOccurs="0"/>
 *         &lt;element ref="{}Prc_participant_def_id" minOccurs="0"/>
 *         &lt;element ref="{}Res_instance_id" minOccurs="0"/>
 *         &lt;element ref="{}Is_source_of_prc_ind" minOccurs="0"/>
 *         &lt;element ref="{}Created_by" minOccurs="0"/>
 *         &lt;element ref="{}Created_date" minOccurs="0"/>
 *         &lt;element ref="{}Updated_by" minOccurs="0"/>
 *         &lt;element ref="{}Updated_date" minOccurs="0"/>
 *         &lt;element ref="{}Record_version" minOccurs="0"/>
 *         &lt;element ref="{}Participant_code" minOccurs="0"/>
 *         &lt;element ref="{}Participant_description" minOccurs="0"/>
 *         &lt;element ref="{}Res_instance" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "prcParticipantType", propOrder = {
    "id",
    "prcInstanceId",
    "prcParticipantDefId",
    "resInstanceId",
    "isSourceOfPrcInd",
    "createdBy",
    "createdDate",
    "updatedBy",
    "updatedDate",
    "recordVersion",
    "participantCode",
    "participantDescription",
    "resInstance"
})

/**
 * A caller or participant. Added the interface implementation after auto-generation using JAXB. This was for compatibility in generic methods of the CsrToSrMappingServiceImpl.
 * @author james.somerville
 *
 */
public class PrcParticipantType implements CsrElement {

    @XmlElement(name = "Id")
    protected BigInteger id;
    @XmlElement(name = "Prc_instance_id")
    protected BigInteger prcInstanceId;
    @XmlElement(name = "Prc_participant_def_id")
    protected BigInteger prcParticipantDefId;
    @XmlElement(name = "Res_instance_id")
    protected BigInteger resInstanceId;
    @XmlElement(name = "Is_source_of_prc_ind")
    protected String isSourceOfPrcInd;
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
    @XmlElement(name = "Participant_code")
    protected String participantCode;
    @XmlElement(name = "Participant_description")
    protected String participantDescription;
    @XmlElement(name = "Res_instance")
    protected ResInstanceType resInstance;

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
     * Gets the value of the prcInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrcInstanceId() {
        return prcInstanceId;
    }

    /**
     * Sets the value of the prcInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrcInstanceId(BigInteger value) {
        this.prcInstanceId = value;
    }

    /**
     * Gets the value of the prcParticipantDefId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getPrcParticipantDefId() {
        return prcParticipantDefId;
    }

    /**
     * Sets the value of the prcParticipantDefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setPrcParticipantDefId(BigInteger value) {
        this.prcParticipantDefId = value;
    }

    /**
     * Gets the value of the resInstanceId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getResInstanceId() {
        return resInstanceId;
    }

    /**
     * Sets the value of the resInstanceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setResInstanceId(BigInteger value) {
        this.resInstanceId = value;
    }

    /**
     * Gets the value of the isSourceOfPrcInd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsSourceOfPrcInd() {
        return isSourceOfPrcInd;
    }

    /**
     * Sets the value of the isSourceOfPrcInd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsSourceOfPrcInd(String value) {
        this.isSourceOfPrcInd = value;
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
    @SuppressWarnings("unchecked")
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
     * Gets the value of the participantCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipantCode() {
        return participantCode;
    }

    /**
     * Sets the value of the participantCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipantCode(String value) {
        this.participantCode = value;
    }

    /**
     * Gets the value of the participantDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParticipantDescription() {
        return participantDescription;
    }

    /**
     * Sets the value of the participantDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParticipantDescription(String value) {
        this.participantDescription = value;
    }

    /**
     * Gets the value of the resInstance property.
     * 
     * @return
     *     possible object is
     *     {@link ResInstanceType }
     *     
     */
    public ResInstanceType getResInstance() {
        return resInstance;
    }

    /**
     * Sets the value of the resInstance property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResInstanceType }
     *     
     */
    public void setResInstance(ResInstanceType value) {
        this.resInstance = value;
    }

}
