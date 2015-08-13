
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
 *         &lt;element name="GetReleaseResult" type="{urn:DocMan.service.livelink.opentext.com}CompoundDocRelease" minOccurs="0"/&gt;
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
    "getReleaseResult"
})
@XmlRootElement(name = "GetReleaseResponse")
public class GetReleaseResponse {

    @XmlElement(name = "GetReleaseResult")
    protected CompoundDocRelease getReleaseResult;

    /**
     * Gets the value of the getReleaseResult property.
     * 
     * @return
     *     possible object is
     *     {@link CompoundDocRelease }
     *     
     */
    public CompoundDocRelease getGetReleaseResult() {
        return getReleaseResult;
    }

    /**
     * Sets the value of the getReleaseResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompoundDocRelease }
     *     
     */
    public void setGetReleaseResult(CompoundDocRelease value) {
        this.getReleaseResult = value;
    }

}
