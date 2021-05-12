
package parqueaderoclienteescritorio.ws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the parqueaderoclienteescritorio.ws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ListarAddorEditResponse_QNAME = new QName("http://sercivios/", "listarAddorEditResponse");
    private final static QName _Listar_QNAME = new QName("http://sercivios/", "Listar");
    private final static QName _ListarResponse_QNAME = new QName("http://sercivios/", "ListarResponse");
    private final static QName _ListarAddorEdit_QNAME = new QName("http://sercivios/", "listarAddorEdit");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: parqueaderoclienteescritorio.ws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Listar }
     * 
     */
    public Listar createListar() {
        return new Listar();
    }

    /**
     * Create an instance of {@link ListarResponse }
     * 
     */
    public ListarResponse createListarResponse() {
        return new ListarResponse();
    }

    /**
     * Create an instance of {@link ListarAddorEditResponse }
     * 
     */
    public ListarAddorEditResponse createListarAddorEditResponse() {
        return new ListarAddorEditResponse();
    }

    /**
     * Create an instance of {@link ListarAddorEdit }
     * 
     */
    public ListarAddorEdit createListarAddorEdit() {
        return new ListarAddorEdit();
    }

    /**
     * Create an instance of {@link Registro }
     * 
     */
    public Registro createRegistro() {
        return new Registro();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarAddorEditResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sercivios/", name = "listarAddorEditResponse")
    public JAXBElement<ListarAddorEditResponse> createListarAddorEditResponse(ListarAddorEditResponse value) {
        return new JAXBElement<ListarAddorEditResponse>(_ListarAddorEditResponse_QNAME, ListarAddorEditResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Listar }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sercivios/", name = "Listar")
    public JAXBElement<Listar> createListar(Listar value) {
        return new JAXBElement<Listar>(_Listar_QNAME, Listar.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sercivios/", name = "ListarResponse")
    public JAXBElement<ListarResponse> createListarResponse(ListarResponse value) {
        return new JAXBElement<ListarResponse>(_ListarResponse_QNAME, ListarResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListarAddorEdit }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://sercivios/", name = "listarAddorEdit")
    public JAXBElement<ListarAddorEdit> createListarAddorEdit(ListarAddorEdit value) {
        return new JAXBElement<ListarAddorEdit>(_ListarAddorEdit_QNAME, ListarAddorEdit.class, null, value);
    }

}
