package com.biscuit.soap.product.service.v1405;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by the JAX-WS RI. JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "ProductService", targetNamespace = "http://service.product.soap.biscuit.com/")
@XmlSeeAlso({ ObjectFactory.class })
public interface ProductService {

    /**
     * 
     * @param arg0
     * @return returns java.lang.String
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "deleteProductFromCurrent", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.DeleteProductFromCurrent")
    @ResponseWrapper(localName = "deleteProductFromCurrentResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.DeleteProductFromCurrentResponse")
    public String deleteProductFromCurrent(@WebParam(name = "arg0", targetNamespace = "") ProductIdentity arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns com.biscuit.soap.product.service.BrandStock
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBiscuitByStock", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetBiscuitByStock")
    @ResponseWrapper(localName = "getBiscuitByStockResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetBiscuitByStockResponse")
    public BrandStock getBiscuitByStock(@WebParam(name = "arg0", targetNamespace = "") BiscuitIdentity arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns com.biscuit.soap.product.service.ProductName
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProductName", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetProductName")
    @ResponseWrapper(localName = "getProductNameResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetProductNameResponse")
    public ProductName getProductName(@WebParam(name = "arg0", targetNamespace = "") ProductIdentity arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns java.lang.String
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertNewBrandBiscuit", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.InsertNewBrandBiscuit")
    @ResponseWrapper(localName = "insertNewBrandBiscuitResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.InsertNewBrandBiscuitResponse")
    public String insertNewBrandBiscuit(@WebParam(name = "arg0", targetNamespace = "") BiscuitDetails arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns java.lang.String
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "updateProductMarketValue", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.UpdateProductMarketValue")
    @ResponseWrapper(localName = "updateProductMarketValueResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.UpdateProductMarketValueResponse")
    public String updateProductMarketValue(@WebParam(name = "arg0", targetNamespace = "") ProductMarket arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns com.biscuit.soap.product.service.ProductMarketRate
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProductMarketRate", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetProductMarketRate")
    @ResponseWrapper(localName = "getProductMarketRateResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetProductMarketRateResponse")
    public ProductMarketRate getProductMarketRate(@WebParam(name = "arg0", targetNamespace = "") ProductIdentity arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns
     *         java.util.List<com.biscuit.soap.product.service.BiscuitType>
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllBrandEverGreenBiscuit", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetAllBrandEverGreenBiscuit")
    @ResponseWrapper(localName = "getAllBrandEverGreenBiscuitResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetAllBrandEverGreenBiscuitResponse")
    public List<BiscuitType> getAllBrandEverGreenBiscuit(@WebParam(name = "arg0", targetNamespace = "") BiscuitName arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns com.biscuit.soap.product.service.ProductType
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProductType", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetProductType")
    @ResponseWrapper(localName = "getProductTypeResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetProductTypeResponse")
    public ProductType getProductType(@WebParam(name = "arg0", targetNamespace = "") ProductIdentity arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns
     *         java.util.List<com.biscuit.soap.product.service.ProductValuationDetails
     *         >
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllProductValuation", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetAllProductValuation")
    @ResponseWrapper(localName = "getAllProductValuationResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetAllProductValuationResponse")
    public List<ProductValuationDetails> getAllProductValuation(
            @WebParam(name = "arg0", targetNamespace = "") ProductValue arg0) throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns
     *         java.util.List<com.biscuit.soap.product.service.BrandName>
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBiscuitByBrandType", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetBiscuitByBrandType")
    @ResponseWrapper(localName = "getBiscuitByBrandTypeResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetBiscuitByBrandTypeResponse")
    public List<BrandName> getBiscuitByBrandType(@WebParam(name = "arg0", targetNamespace = "") BiscuitName arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns java.lang.String
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "insertNewProductDetail", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.InsertNewProductDetail")
    @ResponseWrapper(localName = "insertNewProductDetailResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.InsertNewProductDetailResponse")
    public String insertNewProductDetail(@WebParam(name = "arg0", targetNamespace = "") ProductDetails arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns com.biscuit.soap.product.service.BiscuitDetails
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getBiscuitDetailsById", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetBiscuitDetailsById")
    @ResponseWrapper(localName = "getBiscuitDetailsByIdResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetBiscuitDetailsByIdResponse")
    public BiscuitDetails getBiscuitDetailsById(@WebParam(name = "arg0", targetNamespace = "") BiscuitIdentity arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns
     *         java.util.List<com.biscuit.soap.product.service.BiscuitType>
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getAllBrandBiscuitTypeBySeason", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetAllBrandBiscuitTypeBySeason")
    @ResponseWrapper(localName = "getAllBrandBiscuitTypeBySeasonResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetAllBrandBiscuitTypeBySeasonResponse")
    public List<BiscuitType> getAllBrandBiscuitTypeBySeason(@WebParam(name = "arg0", targetNamespace = "") String arg0)
            throws ProductServiceFault;

    /**
     * 
     * @param arg0
     * @return returns com.biscuit.soap.product.service.ProductDetails
     * @throws ProductServiceFault
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getProductDetailByProId", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetProductDetailByProId")
    @ResponseWrapper(localName = "getProductDetailByProIdResponse", targetNamespace = "http://service.product.soap.biscuit.com/", className = "com.biscuit.soap.product.service.GetProductDetailByProIdResponse")
    public ProductDetails getProductDetailByProId(@WebParam(name = "arg0", targetNamespace = "") ProductIdentity arg0)
            throws ProductServiceFault;

}