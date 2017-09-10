package com.biscuit.product.service.rest.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.biscuit.product.service.rest.connector.BiscuitDatabaseConnector;
import com.biscuit.product.service.rest.error.BiscuitErrorCode;
import com.biscuit.product.service.rest.error.ProductFrameworkError;
import com.biscuit.product.service.rest.extractor.BiscuitConfigResultSetExtractor;
import com.biscuit.product.service.rest.extractor.BiscuitSeasonResultSetExtractor;
import com.biscuit.product.service.rest.extractor.BiscuitStockResultSetExtractor;
import com.biscuit.product.service.rest.extractor.BrandNameResultSetExtractor;
import com.biscuit.product.service.rest.types.BiscuitDetails;
import com.biscuit.product.service.rest.types.BiscuitIdentity;
import com.biscuit.product.service.rest.types.BiscuitName;
import com.biscuit.product.service.rest.types.BiscuitSeason;
import com.biscuit.product.service.rest.types.BiscuitType;
import com.biscuit.product.service.rest.types.BrandName;
import com.biscuit.product.service.rest.types.BrandStock;
import com.biscuit.product.service.rest.util.NumericHelper;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Repository("BiscuitDaoImpl")
public class BiscuitDaoImpl implements BiscuitDao {

	private static final Logger LOG = LoggerFactory
			.getLogger(BiscuitDaoImpl.class);

	@Autowired
	private BiscuitDatabaseConnector biscuitDatabaseConnector;

	@Autowired
	private NumericHelper numericValidation;

	public BiscuitDatabaseConnector getBiscuitDatabaseConnector() {
		return biscuitDatabaseConnector;
	}

	public void setBiscuitDatabaseConnector(
			BiscuitDatabaseConnector biscuitDatabaseConnector) {
		this.biscuitDatabaseConnector = biscuitDatabaseConnector;
	}

	@Override
	public BiscuitDetails getBiscuitDetailsById(BiscuitIdentity bisId) {

		List<BiscuitDetails> biscuitDetailsList = new ArrayList<BiscuitDetails>();

		try {

			String query = "select * from biscuit where id = ?";
			biscuitDetailsList = biscuitDatabaseConnector.getJdbcTemplate()
					.query(query, new Object[] { bisId.getBiscuitId() },
							new BiscuitConfigResultSetExtractor());

			LOG.debug(" Query for getBiscuitDetailsById : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit configurations ", e);

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51555.getValue());
		}

		if (CollectionUtils.isEmpty(biscuitDetailsList)) {

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51556.getValue());
		}

		return biscuitDetailsList.get(0);

	}

	@Override
	public List<BrandName> getBiscuitByBrandType(BiscuitName bisName) {

		List<BrandName> brandNameList = new ArrayList<BrandName>();

		try {

			String query = "select BiscuitType, BiscuitBrand from biscuit where BiscuitName = ?";
			brandNameList = biscuitDatabaseConnector.getJdbcTemplate().query(
					query, new Object[] { bisName.getBiscuitName() },
					new BrandNameResultSetExtractor());

			LOG.debug(" Query for getBiscuitByBrandType : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit brand ", e);

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51558.getValue());

		}

		if (CollectionUtils.isEmpty(brandNameList)) {

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51559.getValue());

		}

		return brandNameList;

	}

	@Override
	public BrandStock getBiscuitByStock(BiscuitIdentity bisId) {

		List<BrandStock> brandStockList = new ArrayList<BrandStock>();

		try {

			String query = "select BiscuitStock, BiscuitBrand from biscuit where id = ?";
			brandStockList = biscuitDatabaseConnector.getJdbcTemplate().query(
					query, new Object[] { bisId.getBiscuitId() },
					new BiscuitStockResultSetExtractor());

			LOG.debug(" Query for getBiscuitByStock : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit configurations ", e);

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51560.getValue());
		}

		if (CollectionUtils.isEmpty(brandStockList)) {

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51561.getValue());
		}

		return brandStockList.get(0);

	}

	@Override
	public List<BiscuitType> getAllBrandBiscuitTypeBySeason(BiscuitSeason season) {

		List<BiscuitType> biscuitTypeList = new ArrayList<BiscuitType>();

		try {

			String query = "select BiscuitName, BiscuitType from biscuit where BiscuitBrand = ?";

			biscuitTypeList = biscuitDatabaseConnector.getJdbcTemplate().query(
					query, new Object[] { season.getSeason() },
					new BiscuitSeasonResultSetExtractor());

			LOG.debug(" Query for getAllBrandBiscuitTypeBySeason : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit season ", e);
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51563.getValue());
		}

		if (CollectionUtils.isEmpty(biscuitTypeList)) {

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51564.getValue());
		}

		return biscuitTypeList;

	}

	@Override
	public List<BiscuitType> getAllBrandEverGreenBiscuit(BiscuitName bisName) {

		List<BiscuitType> biscuitTypeList = new ArrayList<BiscuitType>();
		List<String> args = new ArrayList<String>();
		args.add(bisName.getBiscuitName());

		try {

			String query = "select BiscuitName, BiscuitType from biscuit where BiscuitName = ?";
			biscuitTypeList = biscuitDatabaseConnector.getJdbcTemplate().query(
					query, args.toArray(),
					new BiscuitSeasonResultSetExtractor());

			LOG.debug(" Query for getAllBrandEverGreenBiscuit : " + query);

		} catch (Exception e) {
			e.printStackTrace();
			LOG.error("Exception while getting biscuit season ", e);
			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51566.getValue());
		}

		if (biscuitTypeList.isEmpty()) {

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51567.getValue());
		}

		return biscuitTypeList;
	}

	@Override
	public String insertNewBrandBiscuit(BiscuitDetails biscuitDetails) {

		try {

			String query = "insert into biscuit(ID, BiscuitName, BiscuitType, BiscuitStock, BiscuitBrand) "
					+ "values(?, ?, ?, ?, ?)";

			int rowInserted = biscuitDatabaseConnector.getJdbcTemplate()
					.update(query,
							new Object[] { biscuitDetails.getBiscuitId(),
									biscuitDetails.getBiscuitName(),
									biscuitDetails.getBiscuitType(),
									biscuitDetails.getBiscuitStock(),
									biscuitDetails.getBiscuitBrandName() });

			LOG.debug(" Query for insertNewBrandBiscuit : " + query);

			if (rowInserted == 1) {
				return "record inserted.";
			}

		} catch (Exception e) {
			e.printStackTrace();

			throw new ProductFrameworkError(
					BiscuitErrorCode.BD_51571.getValue());
		}

		throw new ProductFrameworkError(BiscuitErrorCode.BD_51572.getValue());

	}

}
