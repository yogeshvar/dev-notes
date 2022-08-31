
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
 *         &lt;element name="GetIpLocation_2_0Result" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "getIpLocation20Result"
})
@XmlRootElement(name = "GetIpLocation_2_0Response")
public class GetIpLocation20Response {

    @XmlElement(name = "GetIpLocation_2_0Result")
    protected String getIpLocation20Result;

    /**
     * Gets the value of the getIpLocation20Result property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGetIpLocation20Result() {
        return getIpLocation20Result;
    }

    /**
     * Sets the value of the getIpLocation20Result property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGetIpLocation20Result(String value) {
        this.getIpLocation20Result = value;
    }

}
