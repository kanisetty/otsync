
package com.opentext.livelink.service.docman;

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
 *         &lt;element name="PromoteVersionResult" type="{urn:DocMan.service.livelink.opentext.com}Version" minOccurs="0"/&gt;
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
    "promoteVersionResult"
})
@XmlRootElement(name = "PromoteVersionResponse")
public class PromoteVersionResponse {

    @XmlElement(name = "PromoteVersionResult")
    protected Version promoteVersionResult;

    /**
     * Gets the value of the promoteVersionResult property.
     * 
     * @return
     *     possible object is
     *     {@link Version }
     *     
     */
    public Version getPromoteVersionResult() {
        return promoteVersionResult;
    }

    /**
     * Sets the value of the promoteVersionResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Version }
     *     
     */
    public void setPromoteVersionResult(Version value) {
        this.promoteVersionResult = value;
    }

}
