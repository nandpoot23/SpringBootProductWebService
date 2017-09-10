package com.biscuit.product.service.rest.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.product.service.rest.types.ProductValuationDetails;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class ProductValuationResultSetExtractor implements
		ResultSetExtractor<List<ProductValuationDetails>> {

	public List<ProductValuationDetails> extractData(ResultSet rs)
			throws SQLException, DataAccessException {

		List<ProductValuationDetails> productValuationList = new ArrayList<ProductValuationDetails>();

		while (rs.next()) {

			ProductValuationDetails productValuationDetails = new ProductValuationDetails();

			productValuationDetails.setProductName(rs.getString("ProductName"));
			productValuationDetails.setProductValue(rs
					.getString("ProductValue"));
			productValuationDetails.setMarketValue(rs.getString("MarketValue"));
			productValuationList.add(productValuationDetails);
		}

		return productValuationList;
	}

}
