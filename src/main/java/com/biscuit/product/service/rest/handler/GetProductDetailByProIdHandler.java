package com.biscuit.product.service.rest.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.dao.ProductDao;
import com.biscuit.product.service.rest.types.ProductDetails;
import com.biscuit.product.service.rest.types.ProductIdentity;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class GetProductDetailByProIdHandler {

	private static Logger LOG = LoggerFactory
			.getLogger(GetProductDetailByProIdHandler.class);

	@Autowired
	private ProductDao ProductDao;

	public ProductDao getProductDao() {
		return ProductDao;
	}

	public void setProductDao(ProductDao productDao) {
		ProductDao = productDao;
	}

	public ProductDetails getProductDetailByProId(ProductIdentity proId) {

		LOG.info("Going to dao layer .........");
		return getProductDao().getProductDetailByProId(proId);

	}

}
