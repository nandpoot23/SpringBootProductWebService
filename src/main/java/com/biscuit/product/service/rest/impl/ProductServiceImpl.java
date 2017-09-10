package com.biscuit.product.service.rest.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.handler.DeleteProductFromCurrentHandler;
import com.biscuit.product.service.rest.handler.GetAllBrandBiscuitTypeBySeasonHandler;
import com.biscuit.product.service.rest.handler.GetAllBrandEverGreenBiscuitHandler;
import com.biscuit.product.service.rest.handler.GetAllProductValuationHandler;
import com.biscuit.product.service.rest.handler.GetBiscuitByBrandTypeHandler;
import com.biscuit.product.service.rest.handler.GetBiscuitByStockHandler;
import com.biscuit.product.service.rest.handler.GetBiscuitDetailsByIdHandler;
import com.biscuit.product.service.rest.handler.GetProductDetailByProIdHandler;
import com.biscuit.product.service.rest.handler.GetProductMarketRateHandler;
import com.biscuit.product.service.rest.handler.GetProductNameHandler;
import com.biscuit.product.service.rest.handler.GetProductTypeHandler;
import com.biscuit.product.service.rest.handler.InsertNewBrandBiscuitHandler;
import com.biscuit.product.service.rest.handler.InsertNewProductDetailHandler;
import com.biscuit.product.service.rest.handler.UpdateProductMarketValueHandler;
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

@Component("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

	private static Logger LOG = LoggerFactory
			.getLogger(ProductServiceImpl.class);

	@Autowired
	private GetProductDetailByProIdHandler getProductDetailByProIdHandler;

	@Autowired
	private GetAllProductValuationHandler getAllProductValuationHandler;

	@Autowired
	private GetProductNameHandler getProductNameHandler;

	@Autowired
	private GetProductTypeHandler getProductTypeHandler;

	@Autowired
	private GetProductMarketRateHandler getProductMarketRateHandler;

	@Autowired
	private GetBiscuitDetailsByIdHandler getBiscuitDetailsByIdHandler;

	@Autowired
	private GetBiscuitByBrandTypeHandler getBiscuitByBrandTypeHandler;

	@Autowired
	private GetBiscuitByStockHandler getBiscuitByStockHandler;

	@Autowired
	private GetAllBrandBiscuitTypeBySeasonHandler getAllBrandBiscuitTypeBySeasonHandler;

	@Autowired
	private GetAllBrandEverGreenBiscuitHandler getAllBrandEverGreenBiscuitHandler;

	@Autowired
	private InsertNewBrandBiscuitHandler insertNewBrandBiscuitHandler;

	@Autowired
	private InsertNewProductDetailHandler insertNewProductDetailHandler;

	@Autowired
	private UpdateProductMarketValueHandler updateProductMarketValueHandler;

	@Autowired
	private DeleteProductFromCurrentHandler deleteProductFromCurrentHandler;

	@Override
	public ProductDetails getProductDetailByProId(ProductIdentity proId) {

		if (proId.getProductId() != null) {
			LOG.info("ProductServiceImpl::GetProductDetailByProId  ProId : "
					+ proId.getProductId());
			LOG.debug("ProductServiceImpl::GetProductDetailByProId  ProId : "
					+ proId.getProductId());
		}

		LOG.info("Going to handler .........");
		return getProductDetailByProIdHandler.getProductDetailByProId(proId);
	}

	@Override
	public List<ProductValuationDetails> getAllProductValuation(
			ProductValue proValue) {

		return getAllProductValuationHandler.getAllProductValuation(proValue);
	}

	@Override
	public ProductName getProductName(ProductIdentity proId) {

		return getProductNameHandler.getProductName(proId);
	}

	@Override
	public ProductType getProductType(ProductIdentity proId) {

		return getProductTypeHandler.getProductType(proId);
	}

	@Override
	public ProductMarketRate getProductMarketRate(ProductIdentity proId) {

		return getProductMarketRateHandler.getProductMarketRate(proId);
	}

	@Override
	public BiscuitDetails getBiscuitDetailsById(BiscuitIdentity bisId) {

		return getBiscuitDetailsByIdHandler.getBiscuitDetailsById(bisId);
	}

	@Override
	public List<BrandName> getBiscuitByBrandType(BiscuitName bisName) {

		return getBiscuitByBrandTypeHandler.getBiscuitByBrandType(bisName);
	}

	@Override
	public BrandStock getBiscuitByStock(BiscuitIdentity bisId) {

		return getBiscuitByStockHandler.getBiscuitByStock(bisId);
	}

	@Override
	public List<BiscuitType> getAllBrandBiscuitTypeBySeason(BiscuitSeason season) {

		return getAllBrandBiscuitTypeBySeasonHandler
				.getAllBrandBiscuitTypeBySeason(season);
	}

	@Override
	public List<BiscuitType> getAllBrandEverGreenBiscuit(BiscuitName bisName) {

		return getAllBrandEverGreenBiscuitHandler
				.getAllBrandEverGreenBiscuit(bisName);
	}

	@Override
	public String insertNewBrandBiscuit(BiscuitDetails biscuitDetails) {

		return insertNewBrandBiscuitHandler
				.insertNewBrandBiscuit(biscuitDetails);
	}

	@Override
	public String insertNewProductDetail(ProductDetails productDetails) {

		return insertNewProductDetailHandler
				.insertNewProductDetail(productDetails);
	}

	@Override
	public String updateProductMarketValue(ProductMarket productMarket) {

		return updateProductMarketValueHandler
				.updateProductMarketValue(productMarket);
	}

	@Override
	public String deleteProductFromCurrent(ProductIdentity proId) {

		return deleteProductFromCurrentHandler.deleteProductFromCurrent(proId);
	}

}
