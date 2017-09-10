package com.biscuit.product.service.rest.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.product.service.rest.types.ProductMarketRate;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class ProductMarketRateResultSetExtractor implements
		ResultSetExtractor<List<ProductMarketRate>> {

	public List<ProductMarketRate> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<ProductMarketRate> productMarketRateList = new ArrayList<ProductMarketRate>();

		while (rs.next()) {

			ProductMarketRate productMarketRate = new ProductMarketRate();

			productMarketRate.setProdMarketRate(rs.getString("MarketValue"));
			productMarketRateList.add(productMarketRate);
		}

		return productMarketRateList;
	}

}
