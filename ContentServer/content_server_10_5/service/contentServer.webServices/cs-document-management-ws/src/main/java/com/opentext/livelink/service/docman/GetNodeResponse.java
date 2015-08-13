
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
 *         &lt;element name="GetNodeResult" type="{urn:DocMan.service.livelink.opentext.com}Node" minOccurs="0"/&gt;
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
    "getNodeResult"
})
@XmlRootElement(name = "GetNodeResponse")
public class GetNodeResponse {

    @XmlElement(name = "GetNodeResult")
    protected Node getNodeResult;

    /**
     * Gets the value of the getNodeResult property.
     * 
     * @return
     *     possible object is
     *     {@link Node }
     *     
     */
    public Node getGetNodeResult() {
        return getNodeResult;
    }

    /**
     * Sets the value of the getNodeResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Node }
     *     
     */
    public void setGetNodeResult(Node value) {
        this.getNodeResult = value;
    }

}
