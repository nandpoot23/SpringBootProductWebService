package com.biscuit.product.service.rest.dao;

import java.util.List;

import com.biscuit.product.service.rest.types.BiscuitDetails;
import com.biscuit.product.service.rest.types.BiscuitIdentity;
import com.biscuit.product.service.rest.types.BiscuitName;
import com.biscuit.product.service.rest.types.BiscuitSeason;
import com.biscuit.product.service.rest.types.BiscuitType;
import com.biscuit.product.service.rest.types.BrandName;
import com.biscuit.product.service.rest.types.BrandStock;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public interface BiscuitDao {

	public BiscuitDetails getBiscuitDetailsById(BiscuitIdentity bisId);

	public List<BrandName> getBiscuitByBrandType(BiscuitName bisName);

	public BrandStock getBiscuitByStock(BiscuitIdentity bisId);

	public List<BiscuitType> getAllBrandBiscuitTypeBySeason(BiscuitSeason season);

	public List<BiscuitType> getAllBrandEverGreenBiscuit(BiscuitName bisName);

	public String insertNewBrandBiscuit(BiscuitDetails biscuitDetails);

}
