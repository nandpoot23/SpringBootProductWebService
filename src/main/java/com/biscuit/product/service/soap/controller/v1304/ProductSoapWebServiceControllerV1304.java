package com.biscuit.product.service.soap.controller.v1304;

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
import com.biscuit.product.service.rest.types.BiscuitIdentity;
import com.biscuit.product.service.rest.types.BiscuitSeason;
import com.biscuit.product.service.rest.types.BiscuitType;
import com.biscuit.product.service.rest.types.BrandStock;
import com.biscuit.soap.product.service.v1304.GetAllBrandBiscuitTypeBySeason;
import com.biscuit.soap.product.service.v1304.GetAllBrandBiscuitTypeBySeasonResponse;
import com.biscuit.soap.product.service.v1304.GetBiscuitByStock;
import com.biscuit.soap.product.service.v1304.GetBiscuitByStockResponse;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
@Endpoint("ProductSoapWebServiceControllerV1304")
public class ProductSoapWebServiceControllerV1304 {

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductSoapWebServiceControllerV1304.class);

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
	 * business processing for the getBiscuitByStock operation
	 * 
	 * @param GetBiscuitByStock
	 * @param MessageContext
	 * @return GetBiscuitByStockResponse
	 */

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/13.04/getBiscuitByStock")
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

		com.biscuit.soap.product.service.v1304.BrandStock brandStockXml = new com.biscuit.soap.product.service.v1304.BrandStock();

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

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "/13.04/getAllBrandBiscuitTypeBySeason")
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
			com.biscuit.soap.product.service.v1304.BiscuitType biscuitTypeXml = new com.biscuit.soap.product.service.v1304.BiscuitType();
			biscuitTypeXml.setBiscuitName(biscuitType.getBiscuitName());
			biscuitTypeXml.setBiscuitType(biscuitType.getBiscuitType());
			getAllBrandBiscuitTypeBySeasonResponse.getReturn().add(
					biscuitTypeXml);
		}

		LOG.info("SOAP Response Of getAllBrandBiscuitTypeBySeason "
				+ getAllBrandBiscuitTypeBySeasonResponse);

		return getAllBrandBiscuitTypeBySeasonResponse;
	}

}
