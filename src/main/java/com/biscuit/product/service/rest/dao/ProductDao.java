package com.biscuit.product.service.rest.dao;

import java.util.List;

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

public interface ProductDao {

	public ProductDetails getProductDetailByProId(ProductIdentity proId);

	public List<ProductValuationDetails> getAllProductValuation(
			ProductValue proValue);

	public ProductName getProductName(ProductIdentity proId);

	public ProductType getProductType(ProductIdentity proId);

	public ProductMarketRate getProductMarketRate(ProductIdentity proId);

	public String insertNewProductDetail(ProductDetails productDetails);

	public String updateProductMarketValue(ProductMarket productMarket);

	public String deleteProductFromCurrent(ProductIdentity proId);

}
