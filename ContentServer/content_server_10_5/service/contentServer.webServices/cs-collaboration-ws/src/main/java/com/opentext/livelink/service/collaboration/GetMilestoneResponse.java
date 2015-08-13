
package com.opentext.livelink.service.collaboration;

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
 *         &lt;element name="GetMilestoneResult" type="{urn:Collaboration.service.livelink.opentext.com}MilestoneInfo" minOccurs="0"/&gt;
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
    "getMilestoneResult"
})
@XmlRootElement(name = "GetMilestoneResponse")
public class GetMilestoneResponse {

    @XmlElement(name = "GetMilestoneResult")
    protected MilestoneInfo getMilestoneResult;

    /**
     * Gets the value of the getMilestoneResult property.
     * 
     * @return
     *     possible object is
     *     {@link MilestoneInfo }
     *     
     */
    public MilestoneInfo getGetMilestoneResult() {
        return getMilestoneResult;
    }

    /**
     * Sets the value of the getMilestoneResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link MilestoneInfo }
     *     
     */
    public void setGetMilestoneResult(MilestoneInfo value) {
        this.getMilestoneResult = value;
    }

}
