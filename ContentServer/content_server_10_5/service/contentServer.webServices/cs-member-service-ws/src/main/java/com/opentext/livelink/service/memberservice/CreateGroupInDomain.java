
package com.opentext.livelink.service.memberservice;

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
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="leaderID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="domainID" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
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
    "name",
    "leaderID",
    "domainID"
})
@XmlRootElement(name = "CreateGroupInDomain")
public class CreateGroupInDomain {

    protected String name;
    @XmlElement(required = true, type = Long.class, nillable = true)
    protected Long leaderID;
    protected long domainID;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the leaderID property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLeaderID() {
        return leaderID;
    }

    /**
     * Sets the value of the leaderID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLeaderID(Long value) {
        this.leaderID = value;
    }

    /**
     * Gets the value of the domainID property.
     * 
     */
    public long getDomainID() {
        return domainID;
    }

    /**
     * Sets the value of the domainID property.
     * 
     */
    public void setDomainID(long value) {
        this.domainID = value;
    }

}