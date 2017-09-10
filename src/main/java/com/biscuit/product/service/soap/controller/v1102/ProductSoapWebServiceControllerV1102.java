package com.biscuit.product.service.soap.controller.v1102;

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
import com.biscuit.product.service.rest.types.ProductIdentity;
import com.biscuit.product.service.rest.types.ProductName;
import com.biscuit.soap.product.service.v1102.GetProductMarketRate;
import com.biscuit.soap.product.service.v1102.GetProductMarketRateResponse;
import com.biscuit.soap.product.service.v1102.GetProductName;
import com.biscuit.soap.product.service.v1102.GetProductNameResponse;
import com.biscuit.soap.product.service.v1102.GetProductType;
import com.biscuit.soap.product.service.v1102.GetProductTypeResponse;
import com.biscuit.soap.product.service.v1102.ProductMarketRate;
import com.biscuit.soap.product.service.v1102.ProductType;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
@Endpoint("ProductSoapWebServiceControllerV1102")
public class ProductSoapWebServiceControllerV1102 {

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductSoapWebServiceControllerV1102.class);

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

	/**
	 * This method is use to consume soap request and internally calling
	 * business processing for the getProductName operation
	 * 
	 * @param GetProductName
	 * @param MessageContext
	 * @return GetProductNameResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/11.02/getProductName")
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

		com.biscuit.soap.product.service.v1102.ProductName value = new com.biscuit.soap.product.service.v1102.ProductName();
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

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/11.02/getProductType")
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

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/11.02/getProductMarketRate")
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

}
