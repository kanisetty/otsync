package com.opentext.livelink.service.core;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.2
 * 2015-08-13T14:05:31.495-07:00
 * Generated source version: 3.1.2
 * 
 */
@WebService(targetNamespace = "urn:Core.service.livelink.opentext.com", name = "ContentService")
@XmlSeeAlso({ObjectFactory.class, com.opentext.ecm.api.ObjectFactory.class})
public interface ContentService {

    @WebMethod(operationName = "UploadContent", action = "urn:Core.service.livelink.opentext.com/UploadContent")
    @Action(input = "urn:Core.service.livelink.opentext.com/UploadContent", output = "urn:Core.service.livelink.opentext.com/ContentService/UploadContentResponse")
    @RequestWrapper(localName = "UploadContent", targetNamespace = "urn:Core.service.livelink.opentext.com", className = "com.opentext.livelink.service.core.UploadContent")
    @ResponseWrapper(localName = "UploadContentResponse", targetNamespace = "urn:Core.service.livelink.opentext.com", className = "com.opentext.livelink.service.core.UploadContentResponse")
    @WebResult(name = "UploadContentResult", targetNamespace = "urn:Core.service.livelink.opentext.com")
    public java.lang.String uploadContent(
        @WebParam(name = "contents", targetNamespace = "urn:Core.service.livelink.opentext.com")
        javax.activation.DataHandler contents
    );

    @WebMethod(operationName = "DownloadContent", action = "urn:Core.service.livelink.opentext.com/DownloadContent")
    @Action(input = "urn:Core.service.livelink.opentext.com/DownloadContent", output = "urn:Core.service.livelink.opentext.com/ContentService/DownloadContentResponse")
    @RequestWrapper(localName = "DownloadContent", targetNamespace = "urn:Core.service.livelink.opentext.com", className = "com.opentext.livelink.service.core.DownloadContent")
    @ResponseWrapper(localName = "DownloadContentResponse", targetNamespace = "urn:Core.service.livelink.opentext.com", className = "com.opentext.livelink.service.core.DownloadContentResponse")
    @WebResult(name = "DownloadContentResult", targetNamespace = "urn:Core.service.livelink.opentext.com")
    public javax.activation.DataHandler downloadContent(
        @WebParam(name = "contextID", targetNamespace = "urn:Core.service.livelink.opentext.com")
        java.lang.String contextID
    );
}