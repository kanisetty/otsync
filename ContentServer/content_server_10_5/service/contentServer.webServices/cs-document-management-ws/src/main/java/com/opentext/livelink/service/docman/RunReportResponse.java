
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
 *         &lt;element name="RunReportResult" type="{urn:DocMan.service.livelink.opentext.com}ReportResult" minOccurs="0"/&gt;
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
    "runReportResult"
})
@XmlRootElement(name = "RunReportResponse")
public class RunReportResponse {

    @XmlElement(name = "RunReportResult")
    protected ReportResult runReportResult;

    /**
     * Gets the value of the runReportResult property.
     * 
     * @return
     *     possible object is
     *     {@link ReportResult }
     *     
     */
    public ReportResult getRunReportResult() {
        return runReportResult;
    }

    /**
     * Sets the value of the runReportResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ReportResult }
     *     
     */
    public void setRunReportResult(ReportResult value) {
        this.runReportResult = value;
    }

}
