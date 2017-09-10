package com.biscuit.product.service.soap.controller.v1001;

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
import com.biscuit.product.service.rest.types.ProductDetails;
import com.biscuit.product.service.rest.types.ProductIdentity;
import com.biscuit.product.service.rest.types.ProductValuationDetails;
import com.biscuit.product.service.rest.types.ProductValue;
import com.biscuit.soap.product.service.v1001.GetAllProductValuation;
import com.biscuit.soap.product.service.v1001.GetAllProductValuationResponse;
import com.biscuit.soap.product.service.v1001.GetProductDetailByProId;
import com.biscuit.soap.product.service.v1001.GetProductDetailByProIdResponse;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
@Endpoint("ProductSoapWebServiceControllerV1001")
public class ProductSoapWebServiceControllerV1001 {

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductSoapWebServiceControllerV1001.class);

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
	 * business processing for the getProductDetailByProId operation
	 * 
	 * @param GetProductDetailByProId
	 * @param MessageContext
	 * @return GetProductDetailByProIdResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/10.01/getProductDetailByProId")
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

		com.biscuit.soap.product.service.v1001.ProductDetails valueXml = new com.biscuit.soap.product.service.v1001.ProductDetails();

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

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/10.01/getAllProductValuation")
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

			com.biscuit.soap.product.service.v1001.ProductValuationDetails productValuationDetailsXml = new com.biscuit.soap.product.service.v1001.ProductValuationDetails();
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

}
