package com.opentext.livelink.service.searchservices;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 3.1.2
 * 2015-08-13T14:09:27.297-07:00
 * Generated source version: 3.1.2
 * 
 */
@WebServiceClient(name = "IndexService", 
                  wsdlLocation = "file:/C:/Users/rhyse/Desktop/Content%20Server%20For%20AW16/code/contentServer.webServices/cs-index-service-ws/src/main/resources/IndexService.wsdl",
                  targetNamespace = "urn:SearchServices.service.livelink.opentext.com") 
public class IndexService_Service extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("urn:SearchServices.service.livelink.opentext.com", "IndexService");
    public final static QName BasicHttpBindingIndexService = new QName("urn:SearchServices.service.livelink.opentext.com", "BasicHttpBinding_IndexService");
    static {
        URL url = null;
        try {
            url = new URL("file:/C:/Users/rhyse/Desktop/Content%20Server%20For%20AW16/code/contentServer.webServices/cs-index-service-ws/src/main/resources/IndexService.wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(IndexService_Service.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "file:/C:/Users/rhyse/Desktop/Content%20Server%20For%20AW16/code/contentServer.webServices/cs-index-service-ws/src/main/resources/IndexService.wsdl");
        }
        WSDL_LOCATION = url;
    }

    public IndexService_Service(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public IndexService_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IndexService_Service() {
        super(WSDL_LOCATION, SERVICE);
    }
    
    public IndexService_Service(WebServiceFeature ... features) {
        super(WSDL_LOCATION, SERVICE, features);
    }

    public IndexService_Service(URL wsdlLocation, WebServiceFeature ... features) {
        super(wsdlLocation, SERVICE, features);
    }

    public IndexService_Service(URL wsdlLocation, QName serviceName, WebServiceFeature ... features) {
        super(wsdlLocation, serviceName, features);
    }    




    /**
     *
     * @return
     *     returns IndexService
     */
    @WebEndpoint(name = "BasicHttpBinding_IndexService")
    public IndexService getBasicHttpBindingIndexService() {
        return super.getPort(BasicHttpBindingIndexService, IndexService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IndexService
     */
    @WebEndpoint(name = "BasicHttpBinding_IndexService")
    public IndexService getBasicHttpBindingIndexService(WebServiceFeature... features) {
        return super.getPort(BasicHttpBindingIndexService, IndexService.class, features);
    }

}
