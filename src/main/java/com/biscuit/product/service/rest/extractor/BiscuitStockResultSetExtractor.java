package com.biscuit.product.service.rest.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.product.service.rest.types.BrandStock;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class BiscuitStockResultSetExtractor implements
		ResultSetExtractor<List<BrandStock>> {

	public List<BrandStock> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<BrandStock> brandStockList = new ArrayList<BrandStock>();

		while (rs.next()) {

			BrandStock brandStockObj = new BrandStock();

			brandStockObj.setBiscuitStock(rs.getString("BiscuitStock"));
			brandStockObj.setBiscuitBrand(rs.getString("BiscuitBrand"));
			brandStockList.add(brandStockObj);
		}

		return brandStockList;
	}

}
