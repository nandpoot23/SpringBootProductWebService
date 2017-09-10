package com.biscuit.product.service.soap.controller.v1405;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.biscuit.product.service.rest.impl.ProductService;
import com.biscuit.product.service.rest.types.BiscuitDetails;
import com.biscuit.product.service.rest.types.BiscuitIdentity;
import com.biscuit.product.service.rest.types.BiscuitName;
import com.biscuit.product.service.rest.types.BiscuitSeason;
import com.biscuit.product.service.rest.types.BiscuitType;
import com.biscuit.product.service.rest.types.BrandName;
import com.biscuit.product.service.rest.types.BrandStock;
import com.biscuit.product.service.rest.types.ProductDetails;
import com.biscuit.product.service.rest.types.ProductIdentity;
import com.biscuit.product.service.rest.types.ProductMarket;
import com.biscuit.product.service.rest.types.ProductName;
import com.biscuit.product.service.rest.types.ProductValuationDetails;
import com.biscuit.product.service.rest.types.ProductValue;
import com.biscuit.soap.product.service.v1405.DeleteProductFromCurrent;
import com.biscuit.soap.product.service.v1405.DeleteProductFromCurrentResponse;
import com.biscuit.soap.product.service.v1405.GetAllBrandBiscuitTypeBySeason;
import com.biscuit.soap.product.service.v1405.GetAllBrandBiscuitTypeBySeasonResponse;
import com.biscuit.soap.product.service.v1405.GetAllBrandEverGreenBiscuit;
import com.biscuit.soap.product.service.v1405.GetAllBrandEverGreenBiscuitResponse;
import com.biscuit.soap.product.service.v1405.GetAllProductValuation;
import com.biscuit.soap.product.service.v1405.GetAllProductValuationResponse;
import com.biscuit.soap.product.service.v1405.GetBiscuitByBrandType;
import com.biscuit.soap.product.service.v1405.GetBiscuitByBrandTypeResponse;
import com.biscuit.soap.product.service.v1405.GetBiscuitByStock;
import com.biscuit.soap.product.service.v1405.GetBiscuitByStockResponse;
import com.biscuit.soap.product.service.v1405.GetBiscuitDetailsById;
import com.biscuit.soap.product.service.v1405.GetBiscuitDetailsByIdResponse;
import com.biscuit.soap.product.service.v1405.GetProductDetailByProId;
import com.biscuit.soap.product.service.v1405.GetProductDetailByProIdResponse;
import com.biscuit.soap.product.service.v1405.GetProductMarketRate;
import com.biscuit.soap.product.service.v1405.GetProductMarketRateResponse;
import com.biscuit.soap.product.service.v1405.GetProductName;
import com.biscuit.soap.product.service.v1405.GetProductNameResponse;
import com.biscuit.soap.product.service.v1405.GetProductType;
import com.biscuit.soap.product.service.v1405.GetProductTypeResponse;
import com.biscuit.soap.product.service.v1405.InsertNewBrandBiscuit;
import com.biscuit.soap.product.service.v1405.InsertNewBrandBiscuitResponse;
import com.biscuit.soap.product.service.v1405.InsertNewProductDetail;
import com.biscuit.soap.product.service.v1405.InsertNewProductDetailResponse;
import com.biscuit.soap.product.service.v1405.ProductMarketRate;
import com.biscuit.soap.product.service.v1405.ProductType;
import com.biscuit.soap.product.service.v1405.UpdateProductMarketValue;
import com.biscuit.soap.product.service.v1405.UpdateProductMarketValueResponse;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
@Endpoint("ProductSoapWebServiceControllerV1405")
public class ProductSoapWebServiceControllerV1405 {

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductSoapWebServiceControllerV1405.class);

	private static final String NAMESPACE_URI = "http://service.product.soap.biscuit.com/";

	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productServiceImpl;

	public ProductService getProductServiceImpl() {
		return productServiceImpl;
	}

	public void setProductServiceImpl(ProductService productServiceImpl) {
		this.productServiceImpl = productServiceImpl;
	}

	/*
	 * This is the default version, so need to write the version number as
	 * /14.05 in local part.
	 */

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getProductDetailByProId operation
	 * 
	 * @param GetProductDetailByProId
	 * @param MessageContext
	 * @return GetProductDetailByProIdResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getProductDetailByProId")
	@ResponsePayload
	public GetProductDetailByProIdResponse getProductDetailByProId(
			@RequestPayload GetProductDetailByProId getProductDetailByProIdRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getProductDetailByProId "
				+ getProductDetailByProIdRequest);

		ProductIdentity restProId = new ProductIdentity();

		restProId.setProductId(getProductDetailByProIdRequest.getArg0()
				.getProductId());

		ProductDetails restProductDetails = getProductServiceImpl()
				.getProductDetailByProId(restProId);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getProductDetailByProId");

		GetProductDetailByProIdResponse getProductDetailByProIdResponse = new GetProductDetailByProIdResponse();

		com.biscuit.soap.product.service.v1405.ProductDetails valueXml = new com.biscuit.soap.product.service.v1405.ProductDetails();
		valueXml.setId(restProductDetails.getId());
		valueXml.setProductName(restProductDetails.getProductName());
		valueXml.setProductType(restProductDetails.getProductType());
		valueXml.setProductValue(restProductDetails.getProductValue());
		valueXml.setMarketValue(restProductDetails.getMarketValue());

		getProductDetailByProIdResponse.setReturn(valueXml);

		LOG.info("SOAP Response Of getProductDetailByProId "
				+ getProductDetailByProIdResponse);

		return getProductDetailByProIdResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getAllProductValuation operation
	 * 
	 * @param GetAllProductValuationResponse
	 * @param MessageContext
	 * @return GetAllProductValuation
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getAllProductValuation")
	@ResponsePayload
	public GetAllProductValuationResponse getAllProductValuation(
			@RequestPayload GetAllProductValuation getAllProductValuationRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getAllProductValuation "
				+ getAllProductValuationRequest);

		ProductValue proValueRest = new ProductValue();

		proValueRest.setProValuation(getAllProductValuationRequest.getArg0()
				.getProValuation());

		List<ProductValuationDetails> restProductValuationDetailsList = getProductServiceImpl()
				.getAllProductValuation(proValueRest);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getAllProductValuation");

		GetAllProductValuationResponse getAllProductValuationResponse = new GetAllProductValuationResponse();

		for (ProductValuationDetails productValuationDetails : restProductValuationDetailsList) {

			com.biscuit.soap.product.service.v1405.ProductValuationDetails productValuationDetailsXml = new com.biscuit.soap.product.service.v1405.ProductValuationDetails();
			productValuationDetailsXml.setMarketValue(productValuationDetails
					.getMarketValue());
			productValuationDetailsXml.setProductName(productValuationDetails
					.getProductName());
			productValuationDetailsXml.setProductValue(productValuationDetails
					.getProductValue());
			getAllProductValuationResponse.getReturn().add(
					productValuationDetailsXml);
		}

		LOG.info("SOAP Response Of getAllProductValuation "
				+ getAllProductValuationResponse);

		return getAllProductValuationResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getProductName operation
	 * 
	 * @param GetProductName
	 * @param MessageContext
	 * @return GetProductNameResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getProductName")
	@ResponsePayload
	public GetProductNameResponse getProductName(
			@RequestPayload GetProductName getProductNameRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getProductName "
				+ getProductNameRequest);

		ProductIdentity proId = new ProductIdentity();
		proId.setProductId(getProductNameRequest.getArg0().getProductId());

		ProductName restProductName = getProductServiceImpl().getProductName(
				proId);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getProductName");

		GetProductNameResponse getProductNameResponse = new GetProductNameResponse();

		com.biscuit.soap.product.service.v1405.ProductName value = new com.biscuit.soap.product.service.v1405.ProductName();
		value.setProductName(restProductName.getProductName());

		getProductNameResponse.setReturn(value);

		LOG.info("SOAP Response Of getProductName " + getProductNameResponse);

		return getProductNameResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getProductType operation
	 * 
	 * @param GetProductType
	 * @param MessageContext
	 * @return GetProductTypeResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getProductType")
	@ResponsePayload
	public GetProductTypeResponse getProductType(
			@RequestPayload GetProductType getProductTypeRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getProductType "
				+ getProductTypeRequest);

		ProductIdentity restProId = new ProductIdentity();
		restProId.setProductId(getProductTypeRequest.getArg0().getProductId());

		com.biscuit.product.service.rest.types.ProductType restProductType = getProductServiceImpl()
				.getProductType(restProId);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getProductType");

		GetProductTypeResponse getProductTypeResponse = new GetProductTypeResponse();

		ProductType productTypeXml = new ProductType();
		productTypeXml.setProductType(restProductType.getProductType());

		getProductTypeResponse.setReturn(productTypeXml);

		LOG.info("SOAP Response Of getProductType " + getProductTypeResponse);

		return getProductTypeResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getProductMarketRate operation
	 * 
	 * @param GetProductMarketRate
	 * @param MessageContext
	 * @return GetProductMarketRateResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getProductMarketRate")
	@ResponsePayload
	public GetProductMarketRateResponse getProductMarketRate(
			@RequestPayload GetProductMarketRate getProductMarketRateRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getProductMarketRate "
				+ getProductMarketRateRequest);

		ProductIdentity restProId = new ProductIdentity();
		restProId.setProductId(getProductMarketRateRequest.getArg0()
				.getProductId());

		com.biscuit.product.service.rest.types.ProductMarketRate restProductType = getProductServiceImpl()
				.getProductMarketRate(restProId);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getProductMarketRate");

		GetProductMarketRateResponse getProductMarketRateResponse = new GetProductMarketRateResponse();

		ProductMarketRate productMarketRateXml = new ProductMarketRate();
		productMarketRateXml.setProdMarketRate(restProductType
				.getProdMarketRate());

		getProductMarketRateResponse.setReturn(productMarketRateXml);

		LOG.info("SOAP Response Of getProductMarketRate "
				+ getProductMarketRateResponse);

		return getProductMarketRateResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getBiscuitDetailsById operation
	 * 
	 * @param GetBiscuitDetailsById
	 * @param MessageContext
	 * @return GetBiscuitDetailsByIdResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getBiscuitDetailsById")
	@ResponsePayload
	public GetBiscuitDetailsByIdResponse getBiscuitDetailsById(
			@RequestPayload GetBiscuitDetailsById getBiscuitDetailsByIdRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getBiscuitDetailsById "
				+ getBiscuitDetailsByIdRequest);

		BiscuitIdentity restBisId = new BiscuitIdentity();
		restBisId.setBiscuitId(getBiscuitDetailsByIdRequest.getArg0()
				.getBiscuitId());

		BiscuitDetails restBiscuitDetails = getProductServiceImpl()
				.getBiscuitDetailsById(restBisId);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getBiscuitDetailsById");

		GetBiscuitDetailsByIdResponse getBiscuitDetailsByIdResponse = new GetBiscuitDetailsByIdResponse();

		com.biscuit.soap.product.service.v1405.BiscuitDetails biscuitDetailsXml = new com.biscuit.soap.product.service.v1405.BiscuitDetails();
		biscuitDetailsXml.setBiscuitId(restBiscuitDetails.getBiscuitId());
		biscuitDetailsXml.setBiscuitName(restBiscuitDetails.getBiscuitName());
		biscuitDetailsXml.setBiscuitType(restBiscuitDetails.getBiscuitType());
		biscuitDetailsXml.setBiscuitStock(restBiscuitDetails.getBiscuitStock());
		biscuitDetailsXml.setBiscuitBrandName(restBiscuitDetails
				.getBiscuitBrandName());

		getBiscuitDetailsByIdResponse.setReturn(biscuitDetailsXml);

		LOG.info("SOAP Response Of getBiscuitDetailsById "
				+ getBiscuitDetailsByIdResponse);

		return getBiscuitDetailsByIdResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getBiscuitByBrandType operation
	 * 
	 * @param GetBiscuitByBrandType
	 * @param MessageContext
	 * @return GetBiscuitByBrandTypeResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getBiscuitByBrandType")
	@ResponsePayload
	public GetBiscuitByBrandTypeResponse getBiscuitByBrandType(
			@RequestPayload GetBiscuitByBrandType getBiscuitByBrandTypeRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getBiscuitByBrandType "
				+ getBiscuitByBrandTypeRequest);

		BiscuitName restBisName = new BiscuitName();
		restBisName.setBiscuitName(getBiscuitByBrandTypeRequest.getArg0()
				.getBiscuitName());

		List<BrandName> restBrandName = getProductServiceImpl()
				.getBiscuitByBrandType(restBisName);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getBiscuitByBrandType");

		GetBiscuitByBrandTypeResponse getBiscuitByBrandTypeResponse = new GetBiscuitByBrandTypeResponse();

		for (BrandName brandName : restBrandName) {
			com.biscuit.soap.product.service.v1405.BrandName brandNameXml = new com.biscuit.soap.product.service.v1405.BrandName();
			brandNameXml.setBiscuitBrand(brandName.getBiscuitBrand());
			brandNameXml.setBiscuitType(brandName.getBiscuitType());
			getBiscuitByBrandTypeResponse.getReturn().add(brandNameXml);
		}

		LOG.info("SOAP Response Of getBiscuitByBrandType "
				+ getBiscuitByBrandTypeResponse);

		return getBiscuitByBrandTypeResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getBiscuitByStock operation
	 * 
	 * @param GetBiscuitByStock
	 * @param MessageContext
	 * @return GetBiscuitByStockResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getBiscuitByStock")
	@ResponsePayload
	public GetBiscuitByStockResponse getBiscuitByStock(
			@RequestPayload GetBiscuitByStock getBiscuitByStockRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getBiscuitByStock "
				+ getBiscuitByStockRequest);

		BiscuitIdentity restBisId = new BiscuitIdentity();

		restBisId.setBiscuitId(getBiscuitByStockRequest.getArg0()
				.getBiscuitId());

		BrandStock restBrandStock = getProductServiceImpl().getBiscuitByStock(
				restBisId);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getBiscuitByStock");

		GetBiscuitByStockResponse getBiscuitByStockResponse = new GetBiscuitByStockResponse();

		com.biscuit.soap.product.service.v1405.BrandStock brandStockXml = new com.biscuit.soap.product.service.v1405.BrandStock();

		brandStockXml.setBiscuitBrand(restBrandStock.getBiscuitBrand());
		brandStockXml.setBiscuitStock(restBrandStock.getBiscuitStock());

		getBiscuitByStockResponse.setReturn(brandStockXml);

		LOG.info("SOAP Response Of getBiscuitByStock "
				+ getBiscuitByStockResponse);

		return getBiscuitByStockResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getAllBrandBiscuitTypeBySeason operation
	 * 
	 * @param GetAllBrandBiscuitTypeBySeason
	 * @param MessageContext
	 * @return GetAllBrandBiscuitTypeBySeasonResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getAllBrandBiscuitTypeBySeason")
	@ResponsePayload
	public GetAllBrandBiscuitTypeBySeasonResponse getAllBrandBiscuitTypeBySeason(
			@RequestPayload GetAllBrandBiscuitTypeBySeason getAllBrandBiscuitTypeBySeasonRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getAllBrandBiscuitTypeBySeason "
				+ getAllBrandBiscuitTypeBySeasonRequest);

		BiscuitSeason restBiscuitSeason = new BiscuitSeason();
		restBiscuitSeason.setSeason(getAllBrandBiscuitTypeBySeasonRequest
				.getArg0());

		List<BiscuitType> restBiscuitTypeList = getProductServiceImpl()
				.getAllBrandBiscuitTypeBySeason(restBiscuitSeason);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getAllBrandBiscuitTypeBySeason");

		GetAllBrandBiscuitTypeBySeasonResponse getAllBrandBiscuitTypeBySeasonResponse = new GetAllBrandBiscuitTypeBySeasonResponse();

		for (BiscuitType biscuitType : restBiscuitTypeList) {
			com.biscuit.soap.product.service.v1405.BiscuitType biscuitTypeXml = new com.biscuit.soap.product.service.v1405.BiscuitType();
			biscuitTypeXml.setBiscuitName(biscuitType.getBiscuitName());
			biscuitTypeXml.setBiscuitType(biscuitType.getBiscuitType());
			getAllBrandBiscuitTypeBySeasonResponse.getReturn().add(
					biscuitTypeXml);
		}

		LOG.info("SOAP Response Of getAllBrandBiscuitTypeBySeason "
				+ getAllBrandBiscuitTypeBySeasonResponse);

		return getAllBrandBiscuitTypeBySeasonResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getAllBrandEverGreenBiscuit operation
	 * 
	 * @param GetAllBrandEverGreenBiscuit
	 * @param MessageContext
	 * @return GetAllBrandEverGreenBiscuitResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/getAllBrandEverGreenBiscuit")
	@ResponsePayload
	public GetAllBrandEverGreenBiscuitResponse getAllBrandEverGreenBiscuit(
			@RequestPayload GetAllBrandEverGreenBiscuit getAllBrandEverGreenBiscuitRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of getAllBrandEverGreenBiscuit "
				+ getAllBrandEverGreenBiscuitRequest);

		BiscuitName restBisName = new BiscuitName();
		restBisName.setBiscuitName(getAllBrandEverGreenBiscuitRequest.getArg0()
				.getBiscuitName());

		List<BiscuitType> restBiscuitTypeList = getProductServiceImpl()
				.getAllBrandEverGreenBiscuit(restBisName);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for getAllBrandEverGreenBiscuit");

		GetAllBrandEverGreenBiscuitResponse getAllBrandEverGreenBiscuitResponse = new GetAllBrandEverGreenBiscuitResponse();

		for (BiscuitType biscuitType : restBiscuitTypeList) {

			com.biscuit.soap.product.service.v1405.BiscuitType biscuitTypeXml = new com.biscuit.soap.product.service.v1405.BiscuitType();
			biscuitTypeXml.setBiscuitName(biscuitType.getBiscuitName());
			biscuitTypeXml.setBiscuitType(biscuitType.getBiscuitType());
			getAllBrandEverGreenBiscuitResponse.getReturn().add(biscuitTypeXml);
		}

		LOG.info("SOAP Response Of getAllBrandEverGreenBiscuit "
				+ getAllBrandEverGreenBiscuitResponse);

		return getAllBrandEverGreenBiscuitResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the insertNewBrandBiscuit operation
	 * 
	 * @param InsertNewBrandBiscuit
	 * @param MessageContext
	 * @return InsertNewBrandBiscuitResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/insertNewBrandBiscuit")
	@ResponsePayload
	public InsertNewBrandBiscuitResponse insertNewBrandBiscuit(
			@RequestPayload InsertNewBrandBiscuit insertNewBrandBiscuitRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of insertNewBrandBiscuit "
				+ insertNewBrandBiscuitRequest);

		BiscuitDetails restBiscuitDetails = new BiscuitDetails();
		restBiscuitDetails.setBiscuitId(insertNewBrandBiscuitRequest.getArg0()
				.getBiscuitId());
		restBiscuitDetails.setBiscuitName(insertNewBrandBiscuitRequest
				.getArg0().getBiscuitName());
		restBiscuitDetails.setBiscuitType(insertNewBrandBiscuitRequest
				.getArg0().getBiscuitType());
		restBiscuitDetails.setBiscuitStock(insertNewBrandBiscuitRequest
				.getArg0().getBiscuitStock());
		restBiscuitDetails.setBiscuitBrandName(insertNewBrandBiscuitRequest
				.getArg0().getBiscuitBrandName());

		String restImpl = getProductServiceImpl().insertNewBrandBiscuit(
				restBiscuitDetails);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for insertNewBrandBiscuit");

		InsertNewBrandBiscuitResponse insertNewBrandBiscuitResponse = new InsertNewBrandBiscuitResponse();

		insertNewBrandBiscuitResponse.setReturn(restImpl);

		LOG.info("SOAP Response Of insertNewBrandBiscuit "
				+ insertNewBrandBiscuitResponse);

		return insertNewBrandBiscuitResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the insertNewProductDetail operation
	 * 
	 * @param InsertNewProductDetail
	 * @param MessageContext
	 * @return InsertNewProductDetailResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/insertNewProductDetail")
	@ResponsePayload
	public InsertNewProductDetailResponse insertNewProductDetail(
			@RequestPayload InsertNewProductDetail insertNewProductDetailRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of insertNewProductDetail "
				+ insertNewProductDetailRequest);

		ProductDetails restProductDetails = new ProductDetails();
		restProductDetails.setId(insertNewProductDetailRequest.getArg0()
				.getId());
		restProductDetails.setProductName(insertNewProductDetailRequest
				.getArg0().getProductName());
		restProductDetails.setProductType(insertNewProductDetailRequest
				.getArg0().getProductType());
		restProductDetails.setProductValue(insertNewProductDetailRequest
				.getArg0().getProductValue());
		restProductDetails.setMarketValue(insertNewProductDetailRequest
				.getArg0().getMarketValue());

		String restImpl = getProductServiceImpl().insertNewProductDetail(
				restProductDetails);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for insertNewProductDetail");

		InsertNewProductDetailResponse insertNewProductDetailResponse = new InsertNewProductDetailResponse();

		insertNewProductDetailResponse.setReturn(restImpl);

		LOG.info("SOAP Response Of insertNewProductDetail "
				+ insertNewProductDetailResponse);

		return insertNewProductDetailResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the updateProductMarketValue operation
	 * 
	 * @param UpdateProductMarketValue
	 * @param MessageContext
	 * @return UpdateProductMarketValueResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/updateProductMarketValue")
	@ResponsePayload
	public UpdateProductMarketValueResponse updateProductMarketValue(
			@RequestPayload UpdateProductMarketValue updateProductMarketValueRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of updateProductMarketValue "
				+ updateProductMarketValueRequest);

		ProductMarket restProductMarket = new ProductMarket();
		restProductMarket.setProductId(updateProductMarketValueRequest
				.getArg0().getProductId());
		restProductMarket.setProductValue(updateProductMarketValueRequest
				.getArg0().getProductValue());
		restProductMarket.setMarketValue(updateProductMarketValueRequest
				.getArg0().getMarketValue());

		String restImpl = getProductServiceImpl().updateProductMarketValue(
				restProductMarket);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for updateProductMarketValue");

		UpdateProductMarketValueResponse updateProductMarketValueResponse = new UpdateProductMarketValueResponse();

		updateProductMarketValueResponse.setReturn(restImpl);

		LOG.info("SOAP Response Of updateProductMarketValue "
				+ updateProductMarketValueResponse);

		return updateProductMarketValueResponse;
	}

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the deleteProductFromCurrent operation
	 * 
	 * @param DeleteProductFromCurrent
	 * @param MessageContext
	 * @return DeleteProductFromCurrentResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/deleteProductFromCurrent")
	@ResponsePayload
	public DeleteProductFromCurrentResponse deleteProductFromCurrent(
			@RequestPayload DeleteProductFromCurrent deleteProductFromCurrentRequest,
			MessageContext messageContext) throws Exception {

		LOG.info("SOAP Request Received Of deleteProductFromCurrent "
				+ deleteProductFromCurrentRequest);

		ProductIdentity restProId = new ProductIdentity();
		restProId.setProductId(deleteProductFromCurrentRequest.getArg0()
				.getProductId());

		String restImpl = getProductServiceImpl().deleteProductFromCurrent(
				restProId);

		if (LOG.isDebugEnabled())
			LOG.debug("Returning Response for deleteProductFromCurrent");

		DeleteProductFromCurrentResponse deleteProductFromCurrentResponse = new DeleteProductFromCurrentResponse();

		deleteProductFromCurrentResponse.setReturn(restImpl);

		LOG.info("SOAP Response Of deleteProductFromCurrent "
				+ deleteProductFromCurrentResponse);

		return deleteProductFromCurrentResponse;
	}

}
