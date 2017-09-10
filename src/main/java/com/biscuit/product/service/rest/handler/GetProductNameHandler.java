package com.biscuit.product.service.rest.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.dao.ProductDao;
import com.biscuit.product.service.rest.types.ProductIdentity;
import com.biscuit.product.service.rest.types.ProductName;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class GetProductNameHandler {

	@Autowired
	private ProductDao ProductDao;

	public ProductDao getProductDao() {
		return ProductDao;
	}

	public void setProductDao(ProductDao productDao) {
		ProductDao = productDao;
	}

	public ProductName getProductName(ProductIdentity proId) {

		return getProductDao().getProductName(proId);
	}
}
