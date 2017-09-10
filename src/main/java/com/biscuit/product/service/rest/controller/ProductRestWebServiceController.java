package com.biscuit.product.service.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
import com.biscuit.product.service.rest.types.ProductMarketRate;
import com.biscuit.product.service.rest.types.ProductName;
import com.biscuit.product.service.rest.types.ProductType;
import com.biscuit.product.service.rest.types.ProductValuationDetails;
import com.biscuit.product.service.rest.types.ProductValue;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@RestController
@RequestMapping(value = "/api/product/v1", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductRestWebServiceController {

	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductRestWebServiceController.class);

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getProductDetailByProId", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductDetails> getProductDetailByProId(
			@RequestBody ProductIdentity proId) {

		LOG.info("starting with request ........." + proId);

		LOG.debug("Request Received for getProductDetailByProId {} ", proId);

		ProductDetails response = productService.getProductDetailByProId(proId);

		LOG.debug("Returning Response for getProductDetailByProId");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<ProductDetails>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getAllProductValuation", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<ProductValuationDetails>> getAllProductValuation(
			@RequestBody ProductValue proValue) {

		LOG.info("starting with request ........." + proValue);

		LOG.debug("Request Received for getAllProductValuation {} ", proValue);

		List<ProductValuationDetails> response = productService
				.getAllProductValuation(proValue);

		LOG.debug("Returning Response for getAllProductValuation");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<List<ProductValuationDetails>>(response,
				HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getProductName", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductName> getProductName(
			@RequestBody ProductIdentity proId) {

		LOG.info("starting with request ........." + proId);

		LOG.debug("Request Received for getProductName {} ", proId);

		ProductName response = productService.getProductName(proId);

		LOG.debug("Returning Response for getProductName");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<ProductName>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getProductType", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductType> getProductType(
			@RequestBody ProductIdentity proId) {

		LOG.info("starting with request ........." + proId);

		LOG.debug("Request Received for getProductType {} ", proId);

		ProductType response = productService.getProductType(proId);

		LOG.debug("Returning Response for getProductType");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<ProductType>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getProductMarketRate", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ProductMarketRate> getProductMarketRate(
			@RequestBody ProductIdentity proId) {

		LOG.info("starting with request ........." + proId);

		LOG.debug("Request Received for getProductMarketRate {} ", proId);

		ProductMarketRate response = productService.getProductMarketRate(proId);

		LOG.debug("Returning Response for getProductMarketRate");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<ProductMarketRate>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getBiscuitDetailsById", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BiscuitDetails> getBiscuitDetailsById(
			@RequestBody BiscuitIdentity bisId) {

		LOG.info("starting with request ........." + bisId);

		LOG.debug("Request Received for getBiscuitDetailsById {} ", bisId);

		BiscuitDetails response = productService.getBiscuitDetailsById(bisId);

		LOG.debug("Returning Response for getBiscuitDetailsById");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<BiscuitDetails>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getBiscuitByBrandType", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<BrandName>> getBiscuitByBrandType(
			@RequestBody BiscuitName bisName) {

		LOG.info("starting with request ........." + bisName);

		LOG.debug("Request Received for getBiscuitByBrandType {} ", bisName);

		List<BrandName> response = productService
				.getBiscuitByBrandType(bisName);

		LOG.debug("Returning Response for getBiscuitByBrandType");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<List<BrandName>>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getBiscuitByStock", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<BrandStock> getBiscuitByStock(
			@RequestBody BiscuitIdentity bisId) {

		LOG.info("starting with request ........." + bisId);

		LOG.debug("Request Received for getBiscuitByStock {} ", bisId);

		BrandStock response = productService.getBiscuitByStock(bisId);

		LOG.debug("Returning Response for getBiscuitByStock");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<BrandStock>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getAllBrandBiscuitTypeBySeason", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<BiscuitType>> getAllBrandBiscuitTypeBySeason(
			@RequestBody BiscuitSeason season) {

		LOG.info("starting with request ........." + season);

		LOG.debug("Request Received for getAllBrandBiscuitTypeBySeason {} ",
				season.getSeason());

		List<BiscuitType> response = productService
				.getAllBrandBiscuitTypeBySeason(season);

		LOG.debug("Returning Response for getAllBrandBiscuitTypeBySeason");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<List<BiscuitType>>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/getAllBrandEverGreenBiscuit", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<BiscuitType>> getAllBrandEverGreenBiscuit(
			@RequestBody BiscuitName bisName) {

		LOG.info("starting with request ........." + bisName);

		LOG.debug("Request Received for getAllBrandEverGreenBiscuit {} ",
				bisName);

		List<BiscuitType> response = productService
				.getAllBrandEverGreenBiscuit(bisName);

		LOG.debug("Returning Response for getAllBrandEverGreenBiscuit");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<List<BiscuitType>>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/insertNewBrandBiscuit", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> insertNewBrandBiscuit(
			@RequestBody BiscuitDetails biscuitDetails) {

		LOG.info("starting with request ........." + biscuitDetails);

		LOG.debug("Request Received for insertNewBrandBiscuit {} ",
				biscuitDetails);

		String response = productService.insertNewBrandBiscuit(biscuitDetails);

		LOG.debug("Returning Response for insertNewBrandBiscuit");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/insertNewProductDetail", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> insertNewProductDetail(
			@RequestBody ProductDetails productDetails) {

		LOG.info("starting with request ........." + productDetails);

		LOG.debug("Request Received for insertNewProductDetail {} ",
				productDetails);

		String response = productService.insertNewProductDetail(productDetails);

		LOG.debug("Returning Response for insertNewProductDetail");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/updateProductMarketValue", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> updateProductMarketValue(
			@RequestBody ProductMarket productMarket) {

		LOG.info("starting with request ........." + productMarket);

		LOG.debug("Request Received for updateProductMarketValue {} ",
				productMarket);

		String response = productService
				.updateProductMarketValue(productMarket);

		LOG.debug("Returning Response for updateProductMarketValue");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

	@Lazy(false)
	@RequestMapping(method = RequestMethod.POST, value = "/deleteProductFromCurrent", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<String> deleteProductFromCurrent(
			@RequestBody ProductIdentity proId) {

		LOG.info("starting with request ........." + proId);

		LOG.debug("Request Received for deleteProductFromCurrent {} ", proId);

		String response = productService.deleteProductFromCurrent(proId);

		LOG.debug("Returning Response for deleteProductFromCurrent");

		LOG.info("Ending with response ........." + response);

		return new ResponseEntity<String>(response, HttpStatus.OK);
	}

}
