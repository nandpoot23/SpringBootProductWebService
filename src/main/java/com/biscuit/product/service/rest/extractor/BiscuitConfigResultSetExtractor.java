package com.biscuit.product.service.rest.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.biscuit.product.service.rest.types.BiscuitDetails;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class BiscuitConfigResultSetExtractor implements
		ResultSetExtractor<List<BiscuitDetails>> {

	public List<BiscuitDetails> extractData(ResultSet rs) throws SQLException,
			DataAccessException {

		List<BiscuitDetails> biscuitDetailList = new ArrayList<BiscuitDetails>();

		while (rs.next()) {

			BiscuitDetails biscuitDetails = new BiscuitDetails();
			biscuitDetails.setBiscuitId(rs.getInt("ID"));
			biscuitDetails.setBiscuitName(rs.getString("BiscuitName"));
			biscuitDetails.setBiscuitType(rs.getString("BiscuitType"));
			biscuitDetails.setBiscuitStock(rs.getString("BiscuitStock"));
			biscuitDetails.setBiscuitBrandName(rs.getString("BiscuitBrand"));
			biscuitDetailList.add(biscuitDetails);
		}

		return biscuitDetailList;
	}

}
