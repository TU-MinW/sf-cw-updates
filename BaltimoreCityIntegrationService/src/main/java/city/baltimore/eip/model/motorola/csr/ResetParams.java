//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.03.02 at 04:00:13 PM EST 
//


package city.baltimore.eip.model.motorola.csr;

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
 *         &lt;element name="Reset_interface_code" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Reset_start_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Reset_stop_date" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "resetInterfaceCode",
    "resetStartDate",
    "resetStopDate"
})
@XmlRootElement(name = "Reset_params")
public class ResetParams {

    @XmlElement(name = "Reset_interface_code", required = true)
    protected String resetInterfaceCode;
    @XmlElement(name = "Reset_start_date", required = true)
    protected String resetStartDate;
    @XmlElement(name = "Reset_stop_date", required = true)
    protected String resetStopDate;

    /**
     * Gets the value of the resetInterfaceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResetInterfaceCode() {
        return resetInterfaceCode;
    }

    /**
     * Sets the value of the resetInterfaceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResetInterfaceCode(String value) {
        this.resetInterfaceCode = value;
    }

    /**
     * Gets the value of the resetStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResetStartDate() {
        return resetStartDate;
    }

    /**
     * Sets the value of the resetStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResetStartDate(String value) {
        this.resetStartDate = value;
    }

    /**
     * Gets the value of the resetStopDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResetStopDate() {
        return resetStopDate;
    }

    /**
     * Sets the value of the resetStopDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResetStopDate(String value) {
        this.resetStopDate = value;
    }

}
