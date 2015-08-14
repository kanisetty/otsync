
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
 *         &lt;element name="GetNodeByNameResult" type="{urn:DocMan.service.livelink.opentext.com}Node" minOccurs="0"/&gt;
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
    "getNodeByNameResult"
})
@XmlRootElement(name = "GetNodeByNameResponse")
public class GetNodeByNameResponse {

    @XmlElement(name = "GetNodeByNameResult")
    protected Node getNodeByNameResult;

    /**
     * Gets the value of the getNodeByNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link Node }
     *     
     */
    public Node getGetNodeByNameResult() {
        return getNodeByNameResult;
    }

    /**
     * Sets the value of the getNodeByNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link Node }
     *     
     */
    public void setGetNodeByNameResult(Node value) {
        this.getNodeByNameResult = value;
    }

}