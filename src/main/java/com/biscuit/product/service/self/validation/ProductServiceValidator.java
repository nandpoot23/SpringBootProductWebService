package com.biscuit.product.service.self.validation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.error.ProductErrorCode;
import com.biscuit.product.service.rest.error.ProductFrameworkError;
import com.biscuit.product.service.rest.types.ProductDetails;
import com.biscuit.product.service.rest.types.ProductIdentity;
import com.biscuit.product.service.rest.types.ProductMarket;
import com.biscuit.product.service.rest.types.ProductValue;
import com.biscuit.product.service.rest.util.NumericHelper;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class ProductServiceValidator implements ServiceValidator {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory
			.getLogger(ProductServiceValidator.class);

	@Autowired
	private NumericHelper numericHelper;

	@ValidateMethod("getProductDetailByProId")
	public void validateGetProductDetailByProId(ProductIdentity request) {

		/*
		 * Numeric validation, if 0 then exception, if -ve value exception, if
		 * string value then exception, if alphanumeric then exception only pure
		 * int value should go ahead.
		 */
		LOGGER.info("validateGetProductDetailByProId  " + request);

		if (numericHelper.isAlfaNumeric(request.getProductId())
				|| Integer.parseInt(request.getProductId()) < 1) {

			LOGGER.info("validateAddCustomer  validation error " + request);
			LOGGER.debug("please provide the valid product id");

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31554.getValue());

		}

	}

	@ValidateMethod("getAllProductValuation")
	public void validateGetAllProductValuation(ProductValue request) {
		LOGGER.info("validateGetAllProductValuation  " + request);

		if (request.getProValuation().isEmpty()
				|| request.getProValuation().length() == 0
				|| StringUtils.isBlank(request.getProValuation())) {
			LOGGER.debug("please provide the valid product id");

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31557.getValue());
		}

	}

	@ValidateMethod("getProductName")
	public void validateGetProductName(ProductIdentity request) {

		LOGGER.info("validateGetProductName  " + request);

		if (numericHelper.isAlfaNumeric(request.getProductId())
				|| Integer.parseInt(request.getProductId()) < 1) {
			LOGGER.debug("please provide the valid product id");

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31554.getValue());
		}

	}

	@ValidateMethod("getProductType")
	public void validateGetProductType(ProductIdentity request) {
		LOGGER.info("validateGetProductType  " + request);

		if (numericHelper.isAlfaNumeric(request.getProductId())
				|| Integer.parseInt(request.getProductId()) < 1) {
			LOGGER.debug("please provide the valid product id");

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31554.getValue());
		}

	}

	@ValidateMethod("getProductMarketRate")
	public void validateGetProductMarketRate(ProductIdentity request) {
		LOGGER.info("validateGetProductMarketRate  " + request);

		if (numericHelper.isAlfaNumeric(request.getProductId())
				|| Integer.parseInt(request.getProductId()) < 1) {
			LOGGER.debug("please provide the valid product id");

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31554.getValue());
		}

	}

	@ValidateMethod("insertNewProductDetail")
	public void validateInsertNewProductDetail(ProductDetails request) {
		LOGGER.info("validateInsertNewProductDetail  " + request);

		if (request.getId() < 1) {
			throw new ProductFrameworkError(
					ProductErrorCode.PD_31554.getValue());
		}

		if (StringUtils.isBlank(request.getProductName())
				|| request.getProductName().length() == 0) {
			throw new ProductFrameworkError(
					ProductErrorCode.PD_31566.getValue());
		}

		if (StringUtils.isBlank(request.getProductType())) {
			throw new ProductFrameworkError(
					ProductErrorCode.PD_31567.getValue());
		}

		if (StringUtils.isBlank(request.getProductValue())
				|| StringUtils.isBlank(request.getMarketValue())) {
			throw new ProductFrameworkError(
					ProductErrorCode.PD_31568.getValue());
		}

	}

	@ValidateMethod("updateProductMarketValue")
	public void validateUpdateProductMarketValue(ProductMarket request) {
		LOGGER.info("validateUpdateProductMarketValue  " + request);

		if (request.getProductId() < 1) {
			throw new ProductFrameworkError(
					ProductErrorCode.PD_31554.getValue());
		}

		if (StringUtils.isBlank(request.getProductValue())
				|| StringUtils.isBlank(request.getMarketValue())) {
			throw new ProductFrameworkError(
					ProductErrorCode.PD_31568.getValue());
		}

	}

	@ValidateMethod("deleteProductFromCurrent")
	public void validateDeleteProductFromCurrent(ProductIdentity request) {
		LOGGER.info("validateDeleteProductFromCurrent  " + request);

		if (numericHelper.isAlfaNumeric(request.getProductId())
				|| Integer.parseInt(request.getProductId()) < 1) {
			LOGGER.debug("please provide the valid product id");

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31554.getValue());
		}

	}

}
