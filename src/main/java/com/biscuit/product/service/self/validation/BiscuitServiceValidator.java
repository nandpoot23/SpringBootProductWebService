package com.biscuit.product.service.self.validation;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.error.BiscuitErrorCode;
import com.biscuit.product.service.rest.error.ProductFrameworkError;
import com.biscuit.product.service.rest.types.BiscuitDetails;
import com.biscuit.product.service.rest.types.BiscuitIdentity;
import com.biscuit.product.service.rest.types.BiscuitName;
import com.biscuit.product.service.rest.types.BiscuitSeason;
import com.biscuit.product.service.rest.util.NumericHelper;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class BiscuitServiceValidator implements ServiceValidator {

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory
			.getLogger(BiscuitServiceValidator.class);

	@Autowired
	private NumericHelper numericHelper;

	@ValidateMethod("getBiscuitDetailsById")
	public void validateGetBiscuitDetailsById(BiscuitIdentity request) {

		LOGGER.info("validateGetBiscuitDetailsById  " + request);

		if (numericHelper.isAlfaNumeric(request.getBiscuitId())
				|| Integer.parseInt(request.getBiscuitId()) < 1) {
			LOGGER.debug("please provide the valid biscuit id");

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51554.getValue());

		}

	}

	@ValidateMethod("getBiscuitByBrandType")
	public void validateGetBiscuitByBrandType(BiscuitName request) {
		LOGGER.info("validateGetBiscuitByBrandType  " + request);

		if (StringUtils.isBlank(request.getBiscuitName())) {
			LOGGER.debug("please provide the valid biscuit name");

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51557.getValue());
		}

	}

	@ValidateMethod("getBiscuitByStock")
	public void validateGetBiscuitByStock(BiscuitIdentity request) {
		LOGGER.info("validateGetBiscuitByStock  " + request);

		if (numericHelper.isAlfaNumeric(request.getBiscuitId())
				|| Integer.parseInt(request.getBiscuitId()) < 1) {
			LOGGER.debug("please provide the valid biscuit id");
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51554.getValue());
		}

	}

	@ValidateMethod("getAllBrandBiscuitTypeBySeason")
	public void validateGetAllBrandBiscuitTypeBySeason(BiscuitSeason request) {
		LOGGER.info("validateGetAllBrandBiscuitTypeBySeason  " + request);

		if (StringUtils.isEmpty(request.getSeason())
				|| request.getSeason().length() == 0) {
			LOGGER.debug("please provide the valid season name");
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51562.getValue());
		}

	}

	@ValidateMethod("getAllBrandEverGreenBiscuit")
	public void validateGetAllBrandEverGreenBiscuit(BiscuitName request) {
		LOGGER.info("validateGetAllBrandEverGreenBiscuit  " + request);

		if (StringUtils.isBlank(request.getBiscuitName())
				|| request.getBiscuitName().length() == 0) {
			LOGGER.debug("please provide the valid biscuit name");
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51565.getValue());
		}

	}

	@ValidateMethod("insertNewBrandBiscuit")
	public void validateInsertNewBrandBiscuit(BiscuitDetails request) {
		LOGGER.info("validateInsertNewBrandBiscuit  " + request);

		if (request.getBiscuitId() < 1) {
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51554.getValue());
		}

		if (StringUtils.isBlank(request.getBiscuitName())
				|| request.getBiscuitName().length() == 0) {
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51568.getValue());
		}

		if (StringUtils.isBlank(request.getBiscuitType())) {
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51569.getValue());
		}

		if (StringUtils.isBlank(request.getBiscuitStock())
				|| StringUtils.isBlank(request.getBiscuitBrandName())) {
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51570.getValue());
		}

	}

}
