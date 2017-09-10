package com.biscuit.product.service.rest.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.dao.ProductDao;
import com.biscuit.product.service.rest.types.ProductValuationDetails;
import com.biscuit.product.service.rest.types.ProductValue;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class GetAllProductValuationHandler {

	@Autowired
	private ProductDao ProductDao;

	public ProductDao getProductDao() {
		return ProductDao;
	}

	public void setProductDao(ProductDao productDao) {
		ProductDao = productDao;
	}

	public List<ProductValuationDetails> getAllProductValuation(
			ProductValue proValue) {

		return getProductDao().getAllProductValuation(proValue);
	}

}
