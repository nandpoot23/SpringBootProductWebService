package com.biscuit.product.service.soap.controller.v1203;

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
import com.biscuit.product.service.rest.types.BrandName;
import com.biscuit.soap.product.service.v1203.GetBiscuitByBrandType;
import com.biscuit.soap.product.service.v1203.GetBiscuitByBrandTypeResponse;
import com.biscuit.soap.product.service.v1203.GetBiscuitDetailsById;
import com.biscuit.soap.product.service.v1203.GetBiscuitDetailsByIdResponse;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
@Endpoint("ProductSoapWebServiceControllerV1203")
public class ProductSoapWebServiceControllerV1203 {

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductSoapWebServiceControllerV1203.class);

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
	 * business processing for the getBiscuitDetailsById operation
	 * 
	 * @param GetBiscuitDetailsById
	 * @param MessageContext
	 * @return GetBiscuitDetailsByIdResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/12.03/getBiscuitDetailsById")
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

		com.biscuit.soap.product.service.v1203.BiscuitDetails biscuitDetailsXml = new com.biscuit.soap.product.service.v1203.BiscuitDetails();
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

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/12.03/getBiscuitByBrandType")
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
			com.biscuit.soap.product.service.v1203.BrandName brandNameXml = new com.biscuit.soap.product.service.v1203.BrandName();
			brandNameXml.setBiscuitBrand(brandName.getBiscuitBrand());
			brandNameXml.setBiscuitType(brandName.getBiscuitType());
			getBiscuitByBrandTypeResponse.getReturn().add(brandNameXml);
		}

		LOG.info("SOAP Response Of getBiscuitByBrandType "
				+ getBiscuitByBrandTypeResponse);

		return getBiscuitByBrandTypeResponse;
	}

}
