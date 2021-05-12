
package parqueaderoclienteescritorio.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "webServices", targetNamespace = "http://sercivios/", wsdlLocation = "http://localhost:8090/parqueaderoSOAP/webServices?wsdl")
public class WebServices_Service
    extends Service
{

    private final static URL WEBSERVICES_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICES_EXCEPTION;
    private final static QName WEBSERVICES_QNAME = new QName("http://sercivios/", "webServices");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8090/parqueaderoSOAP/webServices?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICES_WSDL_LOCATION = url;
        WEBSERVICES_EXCEPTION = e;
    }

    public WebServices_Service() {
        super(__getWsdlLocation(), WEBSERVICES_QNAME);
    }

    public WebServices_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICES_QNAME, features);
    }

    public WebServices_Service(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICES_QNAME);
    }

    public WebServices_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICES_QNAME, features);
    }

    public WebServices_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServices_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServices
     */
    @WebEndpoint(name = "webServicesPort")
    public WebServices getWebServicesPort() {
        return super.getPort(new QName("http://sercivios/", "webServicesPort"), WebServices.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServices
     */
    @WebEndpoint(name = "webServicesPort")
    public WebServices getWebServicesPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://sercivios/", "webServicesPort"), WebServices.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICES_EXCEPTION!= null) {
            throw WEBSERVICES_EXCEPTION;
        }
        return WEBSERVICES_WSDL_LOCATION;
    }

}
