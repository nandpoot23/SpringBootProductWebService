package com.biscuit.soap.product.service.v1001;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the com.biscuit.soap.product.service package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetProductDetailByProIdResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getProductDetailByProIdResponse");
    private final static QName _GetAllProductValuation_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getAllProductValuation");
    private final static QName _GetAllProductValuationResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getAllProductValuationResponse");
    private final static QName _ServiceFault_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "serviceFault");
    private final static QName _GetProductDetailByProId_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getProductDetailByProId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: com.biscuit.soap.product.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ServiceFault }
     * 
     */
    public ServiceFault createServiceFault() {
        return new ServiceFault();
    }

    /**
     * Create an instance of {@link GetProductDetailByProId }
     * 
     */
    public GetProductDetailByProId createGetProductDetailByProId() {
        return new GetProductDetailByProId();
    }

    /**
     * Create an instance of {@link GetAllProductValuation }
     * 
     */
    public GetAllProductValuation createGetAllProductValuation() {
        return new GetAllProductValuation();
    }

    /**
     * Create an instance of {@link GetAllProductValuationResponse }
     * 
     */
    public GetAllProductValuationResponse createGetAllProductValuationResponse() {
        return new GetAllProductValuationResponse();
    }

    /**
     * Create an instance of {@link GetProductDetailByProIdResponse }
     * 
     */
    public GetProductDetailByProIdResponse createGetProductDetailByProIdResponse() {
        return new GetProductDetailByProIdResponse();
    }

    /**
     * Create an instance of {@link ProductValuationDetails }
     * 
     */
    public ProductValuationDetails createProductValuationDetails() {
        return new ProductValuationDetails();
    }

    /**
     * Create an instance of {@link ProductValue }
     * 
     */
    public ProductValue createProductValue() {
        return new ProductValue();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link MessagesType }
     * 
     */
    public MessagesType createMessagesType() {
        return new MessagesType();
    }

    /**
     * Create an instance of {@link ProductIdentity }
     * 
     */
    public ProductIdentity createProductIdentity() {
        return new ProductIdentity();
    }

    /**
     * Create an instance of {@link ProductDetails }
     * 
     */
    public ProductDetails createProductDetails() {
        return new ProductDetails();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetProductDetailByProIdResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getProductDetailByProIdResponse")
    public JAXBElement<GetProductDetailByProIdResponse> createGetProductDetailByProIdResponse(
            GetProductDetailByProIdResponse value) {
        return new JAXBElement<GetProductDetailByProIdResponse>(_GetProductDetailByProIdResponse_QNAME,
                GetProductDetailByProIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetAllProductValuation }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getAllProductValuation")
    public JAXBElement<GetAllProductValuation> createGetAllProductValuation(GetAllProductValuation value) {
        return new JAXBElement<GetAllProductValuation>(_GetAllProductValuation_QNAME, GetAllProductValuation.class,
                null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetAllProductValuationResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getAllProductValuationResponse")
    public JAXBElement<GetAllProductValuationResponse> createGetAllProductValuationResponse(
            GetAllProductValuationResponse value) {
        return new JAXBElement<GetAllProductValuationResponse>(_GetAllProductValuationResponse_QNAME,
                GetAllProductValuationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ServiceFault }
     * {@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "serviceFault")
    public JAXBElement<ServiceFault> createServiceFault(ServiceFault value) {
        return new JAXBElement<ServiceFault>(_ServiceFault_QNAME, ServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetProductDetailByProId }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getProductDetailByProId")
    public JAXBElement<GetProductDetailByProId> createGetProductDetailByProId(GetProductDetailByProId value) {
        return new JAXBElement<GetProductDetailByProId>(_GetProductDetailByProId_QNAME, GetProductDetailByProId.class,
                null, value);
    }

}
