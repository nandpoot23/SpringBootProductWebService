package com.biscuit.product.service.rest.impl;

import java.util.List;

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

public abstract interface ProductService {

	/*
	 * WSDL 1 (service methods : 1)
	 */
	public ProductDetails getProductDetailByProId(ProductIdentity proId);

	/*
	 * WSDL 1 (service methods : 2)
	 */
	public List<ProductValuationDetails> getAllProductValuation(
			ProductValue proValue);

	/*
	 * WSDL 2 (service methods : 1)
	 */
	public ProductName getProductName(ProductIdentity proId);

	/*
	 * WSDL 2 (service methods : 2)
	 */
	public ProductType getProductType(ProductIdentity proId);

	/*
	 * WSDL 2 (service methods : 3)
	 */
	public ProductMarketRate getProductMarketRate(ProductIdentity proId);

	/*
	 * WSDL 3 (service methods : 1)
	 */
	public BiscuitDetails getBiscuitDetailsById(BiscuitIdentity bisId);

	/*
	 * WSDL 3 (service methods : 2)
	 */
	public List<BrandName> getBiscuitByBrandType(BiscuitName bisName);

	/*
	 * WSDL 4 (service methods : 1)
	 */
	public BrandStock getBiscuitByStock(BiscuitIdentity bisId);

	/*
	 * WSDL 4 (service methods : 2)
	 */
	public List<BiscuitType> getAllBrandBiscuitTypeBySeason(BiscuitSeason season);

	/*
	 * WSDL 5 (service methods : 1)
	 */
	public List<BiscuitType> getAllBrandEverGreenBiscuit(BiscuitName bisName);

	/*
	 * WSDL 5 (service methods : 2)
	 */
	public String insertNewBrandBiscuit(BiscuitDetails biscuitDetails);

	/*
	 * WSDL 5 (service methods : 3)
	 */
	public String insertNewProductDetail(ProductDetails productDetails);

	/*
	 * WSDL 5 (service methods : 4)
	 */
	public String updateProductMarketValue(ProductMarket productMarket);

	/*
	 * WSDL 5 (service methods : 5)
	 */
	public String deleteProductFromCurrent(ProductIdentity proId);

}
