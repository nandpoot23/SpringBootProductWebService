package com.biscuit.product.service.rest.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.stereotype.Repository;

import com.biscuit.product.service.rest.config.CacheConfiguration;
import com.biscuit.product.service.rest.connector.ProductDatabaseConnector;
import com.biscuit.product.service.rest.error.ProductErrorCode;
import com.biscuit.product.service.rest.error.ProductFrameworkError;
import com.biscuit.product.service.rest.extractor.ProductConfigResultSetExtractor;
import com.biscuit.product.service.rest.extractor.ProductMarketRateResultSetExtractor;
import com.biscuit.product.service.rest.extractor.ProductNameResultSetExtractor;
import com.biscuit.product.service.rest.extractor.ProductTypeResultSetExtractor;
import com.biscuit.product.service.rest.extractor.ProductValuationResultSetExtractor;
import com.biscuit.product.service.rest.types.ProductDetails;
import com.biscuit.product.service.rest.types.ProductIdentity;
import com.biscuit.product.service.rest.types.ProductMarket;
import com.biscuit.product.service.rest.types.ProductMarketRate;
import com.biscuit.product.service.rest.types.ProductName;
import com.biscuit.product.service.rest.types.ProductType;
import com.biscuit.product.service.rest.types.ProductValuationDetails;
import com.biscuit.product.service.rest.types.ProductValue;
import com.biscuit.product.service.rest.util.NumericHelper;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Repository("ProductDaoImpl")
public class ProductDaoImpl implements ProductDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(ProductDaoImpl.class);

	@Autowired
	private ProductDatabaseConnector productDatabaseConnector;

	public ProductDatabaseConnector getProductDatabaseConnector() {
		return productDatabaseConnector;
	}

	public void setProductDatabaseConnector(
			ProductDatabaseConnector productDatabaseConnector) {
		this.productDatabaseConnector = productDatabaseConnector;
	}

	@Autowired
	private NumericHelper numericValidation;

	@Autowired
	@Qualifier("cacheManager")
	protected CacheManager cacheManager;

	public CacheManager getCacheManager() {
		return cacheManager;
	}

	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

	private static final String CACHE_NAME = CacheConfiguration.CACHE_HEAD_END_VENDOR;

	@SuppressWarnings("unchecked")
	@Override
	public ProductDetails getProductDetailByProId(ProductIdentity proId) {

		List<ProductDetails> productList = new ArrayList<ProductDetails>();

		Map<String, ProductDetails> productDetailMap = new HashMap<>();

		Cache cache = getCache(CACHE_NAME);
		if (cache != null) {
			Object cacheResp = cache.get(CACHE_NAME);
			if (cacheResp != null) {
				if (cacheResp instanceof SimpleValueWrapper) {
					SimpleValueWrapper svw = (SimpleValueWrapper) cacheResp;
					productDetailMap = (Map<String, ProductDetails>) svw.get();
				} else {
					productDetailMap = (Map<String, ProductDetails>) cacheResp;
				}
			}
		}

		try {

			String query = "select * from product where id = ?";

			if (productDetailMap.isEmpty()) {
				productList = productDatabaseConnector.getJdbcTemplate().query(
						query, new Object[] { proId.getProductId() },
						new ProductConfigResultSetExtractor());
				if (!productDetailMap.isEmpty() && cache != null) {
					cache.put(CACHE_NAME, productDetailMap);
				}

			}
			LOG.info(" Query for getProductDetailByProId : " + query);
			LOG.debug(" Query for getProductDetailByProId : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.info("Exception while getting product configuration ", e);
			LOG.error("Exception while getting product configuration ", e);

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31555.getValue());

		}

		if (CollectionUtils.isEmpty(productList)) {

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31556.getValue());

		}

		LOG.info("Returing response from database ........."
				+ productList.get(0));
		return productList.get(0);

	}

	@Override
	public List<ProductValuationDetails> getAllProductValuation(
			ProductValue proValue) {

		List<ProductValuationDetails> productValuationList = new ArrayList<ProductValuationDetails>();
		String query = "select ProductName, ProductValue, MarketValue from product";

		try {

			productValuationList = productDatabaseConnector.getJdbcTemplate()
					.query(query, new ProductValuationResultSetExtractor());

			LOG.debug(" Query for getAllProductValuation : " + query);
		} catch (Exception e) {
			LOG.error("Exception while getting product valuations ", e);

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31558.getValue());
		}

		if (CollectionUtils.isEmpty(productValuationList)) {

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31559.getValue());
		}

		return productValuationList;

	}

	@Override
	public ProductName getProductName(ProductIdentity proId) {

		List<ProductName> productList = new ArrayList<ProductName>();

		try {

			String query = "select ProductName from product where id = ?";

			productList = productDatabaseConnector.getJdbcTemplate().query(
					query, new Object[] { proId.getProductId() },
					new ProductNameResultSetExtractor());
			LOG.debug(" Query for getProductName : " + query);

		} catch (Exception e) {
			e.printStackTrace();

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31560.getValue());
		}
		if (!productList.isEmpty()) {

			return productList.get(0);
		} else {

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31561.getValue());
		}
	}

	@Override
	public ProductType getProductType(ProductIdentity proId) {

		List<ProductType> productTypeList = new ArrayList<ProductType>();

		try {

			String query = "select ProductType from product where id = ?";

			productTypeList = productDatabaseConnector.getJdbcTemplate().query(
					query, new Object[] { proId.getProductId() },
					new ProductTypeResultSetExtractor());
			LOG.debug(" Query for getProductType : " + query);

		} catch (Exception e) {
			e.printStackTrace();

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31562.getValue());

		}
		if (!productTypeList.isEmpty()) {

			return productTypeList.get(0);
		}

		else {

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31563.getValue());
		}

	}

	@Override
	public ProductMarketRate getProductMarketRate(ProductIdentity proId) {

		List<ProductMarketRate> productMarketRateList = new ArrayList<ProductMarketRate>();

		try {

			String query = "select MarketValue from product where id = ?";

			productMarketRateList = productDatabaseConnector.getJdbcTemplate()
					.query(query, new Object[] { proId.getProductId() },
							new ProductMarketRateResultSetExtractor());
			LOG.debug(" Query for getProductMarketRate : " + query);

		} catch (Exception e) {
			e.printStackTrace();

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31564.getValue());
		}

		if (CollectionUtils.isEmpty(productMarketRateList)) {

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31565.getValue());
		}

		return productMarketRateList.get(0);

	}

	@Override
	public String insertNewProductDetail(ProductDetails productDetails) {

		try {

			String query = "insert into product(ID, ProductName, ProductType, ProductValue, MarketValue) "
					+ "values(?, ?, ?, ?, ?)";

			int rowInserted = productDatabaseConnector.getJdbcTemplate()
					.update(query,
							new Object[] { productDetails.getId(),
									productDetails.getProductName(),
									productDetails.getProductType(),
									productDetails.getProductValue(),
									productDetails.getMarketValue() });

			LOG.debug(" Query for insertNewProductDetail : " + query);

			if (rowInserted == 1) {
				return "record inserted.";
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new ProductFrameworkError(
					ProductErrorCode.PD_31569.getValue());

		}

		throw new ProductFrameworkError(ProductErrorCode.PD_31570.getValue());

	}

	@Override
	public String updateProductMarketValue(ProductMarket productMarket) {

		try {

			String query = "update product set ProductValue = ?, MarketValue = ? where ID = ?";

			int rowUpdated = productDatabaseConnector.getJdbcTemplate().update(
					query,
					new Object[] { productMarket.getProductValue(),
							productMarket.getMarketValue(),
							productMarket.getProductId() });

			LOG.debug(" Query for updateProductMarketValue : " + query);

			if (rowUpdated == 1) {
				return "Product value along with market value updated.";
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31571.getValue());
		}

		throw new ProductFrameworkError(ProductErrorCode.PD_31572.getValue());
	}

	@Override
	public String deleteProductFromCurrent(ProductIdentity proId) {

		int rowDeleted = 0;

		try {

			String query = "delete from product where ID = ?";

			rowDeleted = productDatabaseConnector.getJdbcTemplate().update(
					query, new Object[] { proId.getProductId() });
			LOG.debug(" Query for deleteProductFromCurrent : " + query);

		} catch (Exception e) {
			e.printStackTrace();

			throw new ProductFrameworkError(
					ProductErrorCode.PD_31573.getValue());
		}

		if (rowDeleted == 1) {
			return "Product Not Exist Any More.";
		}

		throw new ProductFrameworkError(ProductErrorCode.PD_31574.getValue());
	}

	protected Cache getCache(String cacheName) {

		Cache cache = null;
		if (getCacheManager() != null
				&& getInteger("caches." + cacheName + ".maxsize", 0) > 0) {
			cache = getCacheManager().getCache(cacheName);
		}
		return cache;
	}

	public Integer getInteger(String name) {
		return this.getInteger(name, null);
	}

	public boolean contains(String name) {
		return true;
	}

	@ConfigurationProperties(prefix = "CACHE_HEAD_END_VENDOR")
	public String getPropertyValue(String name) {
		return "2";
	}

	<T> T resolve(T value, T defaultValue) {
		return (value == null ? defaultValue : value);
	}

	public Integer getInteger(String name, Integer defaultValue) {
		if (this.contains(name)) {
			try {
				return this.resolve(
						Integer.valueOf(this.getPropertyValue(name)),
						defaultValue);
			} catch (NumberFormatException nfEx) {
				LOG.warn(
						"Property value could not be converted to an integer. name={}",
						name);
				return defaultValue;
			}
		} else {
			return defaultValue;
		}
	}

}
