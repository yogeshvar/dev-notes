
package com.lavasoft;

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
 *         &lt;element name="GetCountryISO2ByNameResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getCountryISO2ByNameResult"
})
@XmlRootElement(name = "GetCountryISO2ByNameResponse")
public class GetCountryISO2ByNameResponse {

    @XmlElement(name = "GetCountryISO2ByNameResult")
    protected String getCountryISO2ByNameResult;

    /**
     * Gets the value of the getCountryISO2ByNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetCountryISO2ByNameResult() {
        return getCountryISO2ByNameResult;
    }

    /**
     * Sets the value of the getCountryISO2ByNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetCountryISO2ByNameResult(String value) {
        this.getCountryISO2ByNameResult = value;
    }

}
