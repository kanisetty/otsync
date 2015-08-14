
package com.opentext.livelink.service.core;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ValidateUserResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "validateUserResult"
})
@XmlRootElement(name = "ValidateUserResponse")
public class ValidateUserResponse {

    @XmlElement(name = "ValidateUserResult")
    protected String validateUserResult;

    /**
     * Gets the value of the validateUserResult property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValidateUserResult() {
        return validateUserResult;
    }

    /**
     * Sets the value of the validateUserResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValidateUserResult(String value) {
        this.validateUserResult = value;
    }

}