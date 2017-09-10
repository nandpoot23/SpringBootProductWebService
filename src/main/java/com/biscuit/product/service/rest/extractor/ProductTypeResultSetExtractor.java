package com.biscuit.product.service.rest.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.product.service.rest.types.ProductType;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class ProductTypeResultSetExtractor implements
		ResultSetExtractor<List<ProductType>> {

	public List<ProductType> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<ProductType> productTypeList = new ArrayList<ProductType>();

		while (rs.next()) {

			ProductType productType = new ProductType();

			productType.setProductType(rs.getString("ProductType"));
			productTypeList.add(productType);
		}

		return productTypeList;
	}

}
