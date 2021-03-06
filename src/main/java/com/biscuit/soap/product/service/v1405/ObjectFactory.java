package com.biscuit.soap.product.service.v1405;

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

    private final static QName _GetAllBrandEverGreenBiscuitResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getAllBrandEverGreenBiscuitResponse");
    private final static QName _GetProductDetailByProIdResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getProductDetailByProIdResponse");
    private final static QName _DeleteProductFromCurrent_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "deleteProductFromCurrent");
    private final static QName _GetBiscuitByBrandTypeResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getBiscuitByBrandTypeResponse");
    private final static QName _InsertNewBrandBiscuit_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "insertNewBrandBiscuit");
    private final static QName _GetAllBrandEverGreenBiscuit_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getAllBrandEverGreenBiscuit");
    private final static QName _GetProductTypeResponse_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getProductTypeResponse");
    private final static QName _ServiceFault_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "serviceFault");
    private final static QName _GetProductType_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getProductType");
    private final static QName _GetBiscuitDetailsByIdResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getBiscuitDetailsByIdResponse");
    private final static QName _GetAllProductValuation_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getAllProductValuation");
    private final static QName _UpdateProductMarketValueResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "updateProductMarketValueResponse");
    private final static QName _InsertNewProductDetailResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "insertNewProductDetailResponse");
    private final static QName _GetProductDetailByProId_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getProductDetailByProId");
    private final static QName _GetBiscuitByStockResponse_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getBiscuitByStockResponse");
    private final static QName _GetBiscuitByStock_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getBiscuitByStock");
    private final static QName _GetProductMarketRateResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getProductMarketRateResponse");
    private final static QName _GetProductName_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getProductName");
    private final static QName _UpdateProductMarketValue_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "updateProductMarketValue");
    private final static QName _GetProductMarketRate_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getProductMarketRate");
    private final static QName _InsertNewBrandBiscuitResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "insertNewBrandBiscuitResponse");
    private final static QName _GetProductNameResponse_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getProductNameResponse");
    private final static QName _GetAllBrandBiscuitTypeBySeasonResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getAllBrandBiscuitTypeBySeasonResponse");
    private final static QName _GetAllProductValuationResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getAllProductValuationResponse");
    private final static QName _GetBiscuitByBrandType_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getBiscuitByBrandType");
    private final static QName _InsertNewProductDetail_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "insertNewProductDetail");
    private final static QName _GetBiscuitDetailsById_QNAME = new QName("http://service.product.soap.biscuit.com/",
            "getBiscuitDetailsById");
    private final static QName _GetAllBrandBiscuitTypeBySeason_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "getAllBrandBiscuitTypeBySeason");
    private final static QName _DeleteProductFromCurrentResponse_QNAME = new QName(
            "http://service.product.soap.biscuit.com/", "deleteProductFromCurrentResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of
     * schema derived classes for package: com.biscuit.soap.product.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link UpdateProductMarketValue }
     * 
     */
    public UpdateProductMarketValue createUpdateProductMarketValue() {
        return new UpdateProductMarketValue();
    }

    /**
     * Create an instance of {@link GetProductMarketRate }
     * 
     */
    public GetProductMarketRate createGetProductMarketRate() {
        return new GetProductMarketRate();
    }

    /**
     * Create an instance of {@link GetBiscuitByStockResponse }
     * 
     */
    public GetBiscuitByStockResponse createGetBiscuitByStockResponse() {
        return new GetBiscuitByStockResponse();
    }

    /**
     * Create an instance of {@link GetProductMarketRateResponse }
     * 
     */
    public GetProductMarketRateResponse createGetProductMarketRateResponse() {
        return new GetProductMarketRateResponse();
    }

    /**
     * Create an instance of {@link GetProductName }
     * 
     */
    public GetProductName createGetProductName() {
        return new GetProductName();
    }

    /**
     * Create an instance of {@link GetBiscuitByStock }
     * 
     */
    public GetBiscuitByStock createGetBiscuitByStock() {
        return new GetBiscuitByStock();
    }

    /**
     * Create an instance of {@link GetAllBrandBiscuitTypeBySeason }
     * 
     */
    public GetAllBrandBiscuitTypeBySeason createGetAllBrandBiscuitTypeBySeason() {
        return new GetAllBrandBiscuitTypeBySeason();
    }

    /**
     * Create an instance of {@link DeleteProductFromCurrentResponse }
     * 
     */
    public DeleteProductFromCurrentResponse createDeleteProductFromCurrentResponse() {
        return new DeleteProductFromCurrentResponse();
    }

    /**
     * Create an instance of {@link InsertNewProductDetail }
     * 
     */
    public InsertNewProductDetail createInsertNewProductDetail() {
        return new InsertNewProductDetail();
    }

    /**
     * Create an instance of {@link GetBiscuitDetailsById }
     * 
     */
    public GetBiscuitDetailsById createGetBiscuitDetailsById() {
        return new GetBiscuitDetailsById();
    }

    /**
     * Create an instance of {@link GetProductNameResponse }
     * 
     */
    public GetProductNameResponse createGetProductNameResponse() {
        return new GetProductNameResponse();
    }

    /**
     * Create an instance of {@link GetAllProductValuationResponse }
     * 
     */
    public GetAllProductValuationResponse createGetAllProductValuationResponse() {
        return new GetAllProductValuationResponse();
    }

    /**
     * Create an instance of {@link GetBiscuitByBrandType }
     * 
     */
    public GetBiscuitByBrandType createGetBiscuitByBrandType() {
        return new GetBiscuitByBrandType();
    }

    /**
     * Create an instance of {@link GetAllBrandBiscuitTypeBySeasonResponse }
     * 
     */
    public GetAllBrandBiscuitTypeBySeasonResponse createGetAllBrandBiscuitTypeBySeasonResponse() {
        return new GetAllBrandBiscuitTypeBySeasonResponse();
    }

    /**
     * Create an instance of {@link InsertNewBrandBiscuitResponse }
     * 
     */
    public InsertNewBrandBiscuitResponse createInsertNewBrandBiscuitResponse() {
        return new InsertNewBrandBiscuitResponse();
    }

    /**
     * Create an instance of {@link GetProductTypeResponse }
     * 
     */
    public GetProductTypeResponse createGetProductTypeResponse() {
        return new GetProductTypeResponse();
    }

    /**
     * Create an instance of {@link ServiceFault }
     * 
     */
    public ServiceFault createServiceFault() {
        return new ServiceFault();
    }

    /**
     * Create an instance of {@link GetAllBrandEverGreenBiscuit }
     * 
     */
    public GetAllBrandEverGreenBiscuit createGetAllBrandEverGreenBiscuit() {
        return new GetAllBrandEverGreenBiscuit();
    }

    /**
     * Create an instance of {@link InsertNewBrandBiscuit }
     * 
     */
    public InsertNewBrandBiscuit createInsertNewBrandBiscuit() {
        return new InsertNewBrandBiscuit();
    }

    /**
     * Create an instance of {@link GetProductDetailByProIdResponse }
     * 
     */
    public GetProductDetailByProIdResponse createGetProductDetailByProIdResponse() {
        return new GetProductDetailByProIdResponse();
    }

    /**
     * Create an instance of {@link GetAllBrandEverGreenBiscuitResponse }
     * 
     */
    public GetAllBrandEverGreenBiscuitResponse createGetAllBrandEverGreenBiscuitResponse() {
        return new GetAllBrandEverGreenBiscuitResponse();
    }

    /**
     * Create an instance of {@link GetBiscuitByBrandTypeResponse }
     * 
     */
    public GetBiscuitByBrandTypeResponse createGetBiscuitByBrandTypeResponse() {
        return new GetBiscuitByBrandTypeResponse();
    }

    /**
     * Create an instance of {@link DeleteProductFromCurrent }
     * 
     */
    public DeleteProductFromCurrent createDeleteProductFromCurrent() {
        return new DeleteProductFromCurrent();
    }

    /**
     * Create an instance of {@link InsertNewProductDetailResponse }
     * 
     */
    public InsertNewProductDetailResponse createInsertNewProductDetailResponse() {
        return new InsertNewProductDetailResponse();
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
     * Create an instance of {@link UpdateProductMarketValueResponse }
     * 
     */
    public UpdateProductMarketValueResponse createUpdateProductMarketValueResponse() {
        return new UpdateProductMarketValueResponse();
    }

    /**
     * Create an instance of {@link GetProductType }
     * 
     */
    public GetProductType createGetProductType() {
        return new GetProductType();
    }

    /**
     * Create an instance of {@link GetBiscuitDetailsByIdResponse }
     * 
     */
    public GetBiscuitDetailsByIdResponse createGetBiscuitDetailsByIdResponse() {
        return new GetBiscuitDetailsByIdResponse();
    }

    /**
     * Create an instance of {@link MessagesType }
     * 
     */
    public MessagesType createMessagesType() {
        return new MessagesType();
    }

    /**
     * Create an instance of {@link BiscuitDetails }
     * 
     */
    public BiscuitDetails createBiscuitDetails() {
        return new BiscuitDetails();
    }

    /**
     * Create an instance of {@link ProductDetails }
     * 
     */
    public ProductDetails createProductDetails() {
        return new ProductDetails();
    }

    /**
     * Create an instance of {@link BrandStock }
     * 
     */
    public BrandStock createBrandStock() {
        return new BrandStock();
    }

    /**
     * Create an instance of {@link ProductName }
     * 
     */
    public ProductName createProductName() {
        return new ProductName();
    }

    /**
     * Create an instance of {@link MessageType }
     * 
     */
    public MessageType createMessageType() {
        return new MessageType();
    }

    /**
     * Create an instance of {@link ProductType }
     * 
     */
    public ProductType createProductType() {
        return new ProductType();
    }

    /**
     * Create an instance of {@link ProductMarketRate }
     * 
     */
    public ProductMarketRate createProductMarketRate() {
        return new ProductMarketRate();
    }

    /**
     * Create an instance of {@link ProductValuationDetails }
     * 
     */
    public ProductValuationDetails createProductValuationDetails() {
        return new ProductValuationDetails();
    }

    /**
     * Create an instance of {@link BrandName }
     * 
     */
    public BrandName createBrandName() {
        return new BrandName();
    }

    /**
     * Create an instance of {@link ProductIdentity }
     * 
     */
    public ProductIdentity createProductIdentity() {
        return new ProductIdentity();
    }

    /**
     * Create an instance of {@link BiscuitIdentity }
     * 
     */
    public BiscuitIdentity createBiscuitIdentity() {
        return new BiscuitIdentity();
    }

    /**
     * Create an instance of {@link ProductMarket }
     * 
     */
    public ProductMarket createProductMarket() {
        return new ProductMarket();
    }

    /**
     * Create an instance of {@link BiscuitType }
     * 
     */
    public BiscuitType createBiscuitType() {
        return new BiscuitType();
    }

    /**
     * Create an instance of {@link ProductValue }
     * 
     */
    public ProductValue createProductValue() {
        return new ProductValue();
    }

    /**
     * Create an instance of {@link BiscuitName }
     * 
     */
    public BiscuitName createBiscuitName() {
        return new BiscuitName();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetAllBrandEverGreenBiscuitResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getAllBrandEverGreenBiscuitResponse")
    public JAXBElement<GetAllBrandEverGreenBiscuitResponse> createGetAllBrandEverGreenBiscuitResponse(
            GetAllBrandEverGreenBiscuitResponse value) {
        return new JAXBElement<GetAllBrandEverGreenBiscuitResponse>(_GetAllBrandEverGreenBiscuitResponse_QNAME,
                GetAllBrandEverGreenBiscuitResponse.class, null, value);
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
     * {@link DeleteProductFromCurrent }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "deleteProductFromCurrent")
    public JAXBElement<DeleteProductFromCurrent> createDeleteProductFromCurrent(DeleteProductFromCurrent value) {
        return new JAXBElement<DeleteProductFromCurrent>(_DeleteProductFromCurrent_QNAME,
                DeleteProductFromCurrent.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetBiscuitByBrandTypeResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getBiscuitByBrandTypeResponse")
    public JAXBElement<GetBiscuitByBrandTypeResponse> createGetBiscuitByBrandTypeResponse(
            GetBiscuitByBrandTypeResponse value) {
        return new JAXBElement<GetBiscuitByBrandTypeResponse>(_GetBiscuitByBrandTypeResponse_QNAME,
                GetBiscuitByBrandTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link InsertNewBrandBiscuit }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "insertNewBrandBiscuit")
    public JAXBElement<InsertNewBrandBiscuit> createInsertNewBrandBiscuit(InsertNewBrandBiscuit value) {
        return new JAXBElement<InsertNewBrandBiscuit>(_InsertNewBrandBiscuit_QNAME, InsertNewBrandBiscuit.class, null,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetAllBrandEverGreenBiscuit }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getAllBrandEverGreenBiscuit")
    public JAXBElement<GetAllBrandEverGreenBiscuit> createGetAllBrandEverGreenBiscuit(GetAllBrandEverGreenBiscuit value) {
        return new JAXBElement<GetAllBrandEverGreenBiscuit>(_GetAllBrandEverGreenBiscuit_QNAME,
                GetAllBrandEverGreenBiscuit.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetProductTypeResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getProductTypeResponse")
    public JAXBElement<GetProductTypeResponse> createGetProductTypeResponse(GetProductTypeResponse value) {
        return new JAXBElement<GetProductTypeResponse>(_GetProductTypeResponse_QNAME, GetProductTypeResponse.class,
                null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductType }
     * {@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getProductType")
    public JAXBElement<GetProductType> createGetProductType(GetProductType value) {
        return new JAXBElement<GetProductType>(_GetProductType_QNAME, GetProductType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetBiscuitDetailsByIdResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getBiscuitDetailsByIdResponse")
    public JAXBElement<GetBiscuitDetailsByIdResponse> createGetBiscuitDetailsByIdResponse(
            GetBiscuitDetailsByIdResponse value) {
        return new JAXBElement<GetBiscuitDetailsByIdResponse>(_GetBiscuitDetailsByIdResponse_QNAME,
                GetBiscuitDetailsByIdResponse.class, null, value);
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
     * {@link UpdateProductMarketValueResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "updateProductMarketValueResponse")
    public JAXBElement<UpdateProductMarketValueResponse> createUpdateProductMarketValueResponse(
            UpdateProductMarketValueResponse value) {
        return new JAXBElement<UpdateProductMarketValueResponse>(_UpdateProductMarketValueResponse_QNAME,
                UpdateProductMarketValueResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link InsertNewProductDetailResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "insertNewProductDetailResponse")
    public JAXBElement<InsertNewProductDetailResponse> createInsertNewProductDetailResponse(
            InsertNewProductDetailResponse value) {
        return new JAXBElement<InsertNewProductDetailResponse>(_InsertNewProductDetailResponse_QNAME,
                InsertNewProductDetailResponse.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetBiscuitByStockResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getBiscuitByStockResponse")
    public JAXBElement<GetBiscuitByStockResponse> createGetBiscuitByStockResponse(GetBiscuitByStockResponse value) {
        return new JAXBElement<GetBiscuitByStockResponse>(_GetBiscuitByStockResponse_QNAME,
                GetBiscuitByStockResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetBiscuitByStock }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getBiscuitByStock")
    public JAXBElement<GetBiscuitByStock> createGetBiscuitByStock(GetBiscuitByStock value) {
        return new JAXBElement<GetBiscuitByStock>(_GetBiscuitByStock_QNAME, GetBiscuitByStock.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetProductMarketRateResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getProductMarketRateResponse")
    public JAXBElement<GetProductMarketRateResponse> createGetProductMarketRateResponse(
            GetProductMarketRateResponse value) {
        return new JAXBElement<GetProductMarketRateResponse>(_GetProductMarketRateResponse_QNAME,
                GetProductMarketRateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetProductName }
     * {@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getProductName")
    public JAXBElement<GetProductName> createGetProductName(GetProductName value) {
        return new JAXBElement<GetProductName>(_GetProductName_QNAME, GetProductName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link UpdateProductMarketValue }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "updateProductMarketValue")
    public JAXBElement<UpdateProductMarketValue> createUpdateProductMarketValue(UpdateProductMarketValue value) {
        return new JAXBElement<UpdateProductMarketValue>(_UpdateProductMarketValue_QNAME,
                UpdateProductMarketValue.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetProductMarketRate }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getProductMarketRate")
    public JAXBElement<GetProductMarketRate> createGetProductMarketRate(GetProductMarketRate value) {
        return new JAXBElement<GetProductMarketRate>(_GetProductMarketRate_QNAME, GetProductMarketRate.class, null,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link InsertNewBrandBiscuitResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "insertNewBrandBiscuitResponse")
    public JAXBElement<InsertNewBrandBiscuitResponse> createInsertNewBrandBiscuitResponse(
            InsertNewBrandBiscuitResponse value) {
        return new JAXBElement<InsertNewBrandBiscuitResponse>(_InsertNewBrandBiscuitResponse_QNAME,
                InsertNewBrandBiscuitResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetProductNameResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getProductNameResponse")
    public JAXBElement<GetProductNameResponse> createGetProductNameResponse(GetProductNameResponse value) {
        return new JAXBElement<GetProductNameResponse>(_GetProductNameResponse_QNAME, GetProductNameResponse.class,
                null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetAllBrandBiscuitTypeBySeasonResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getAllBrandBiscuitTypeBySeasonResponse")
    public JAXBElement<GetAllBrandBiscuitTypeBySeasonResponse> createGetAllBrandBiscuitTypeBySeasonResponse(
            GetAllBrandBiscuitTypeBySeasonResponse value) {
        return new JAXBElement<GetAllBrandBiscuitTypeBySeasonResponse>(_GetAllBrandBiscuitTypeBySeasonResponse_QNAME,
                GetAllBrandBiscuitTypeBySeasonResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetBiscuitByBrandType }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getBiscuitByBrandType")
    public JAXBElement<GetBiscuitByBrandType> createGetBiscuitByBrandType(GetBiscuitByBrandType value) {
        return new JAXBElement<GetBiscuitByBrandType>(_GetBiscuitByBrandType_QNAME, GetBiscuitByBrandType.class, null,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link InsertNewProductDetail }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "insertNewProductDetail")
    public JAXBElement<InsertNewProductDetail> createInsertNewProductDetail(InsertNewProductDetail value) {
        return new JAXBElement<InsertNewProductDetail>(_InsertNewProductDetail_QNAME, InsertNewProductDetail.class,
                null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetBiscuitDetailsById }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getBiscuitDetailsById")
    public JAXBElement<GetBiscuitDetailsById> createGetBiscuitDetailsById(GetBiscuitDetailsById value) {
        return new JAXBElement<GetBiscuitDetailsById>(_GetBiscuitDetailsById_QNAME, GetBiscuitDetailsById.class, null,
                value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link GetAllBrandBiscuitTypeBySeason }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "getAllBrandBiscuitTypeBySeason")
    public JAXBElement<GetAllBrandBiscuitTypeBySeason> createGetAllBrandBiscuitTypeBySeason(
            GetAllBrandBiscuitTypeBySeason value) {
        return new JAXBElement<GetAllBrandBiscuitTypeBySeason>(_GetAllBrandBiscuitTypeBySeason_QNAME,
                GetAllBrandBiscuitTypeBySeason.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}
     * {@link DeleteProductFromCurrentResponse }{@code >}
     * 
     */
    @XmlElementDecl(namespace = "http://service.product.soap.biscuit.com/", name = "deleteProductFromCurrentResponse")
    public JAXBElement<DeleteProductFromCurrentResponse> createDeleteProductFromCurrentResponse(
            DeleteProductFromCurrentResponse value) {
        return new JAXBElement<DeleteProductFromCurrentResponse>(_DeleteProductFromCurrentResponse_QNAME,
                DeleteProductFromCurrentResponse.class, null, value);
    }

}
