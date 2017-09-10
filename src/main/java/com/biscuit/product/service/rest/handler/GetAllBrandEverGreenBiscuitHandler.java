package com.biscuit.product.service.rest.handler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.dao.BiscuitDao;
import com.biscuit.product.service.rest.types.BiscuitName;
import com.biscuit.product.service.rest.types.BiscuitType;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class GetAllBrandEverGreenBiscuitHandler {

	@Autowired
	private BiscuitDao biscuitDao;

	public BiscuitDao getBiscuitDao() {
		return biscuitDao;
	}

	public void setBiscuitDao(BiscuitDao biscuitDao) {
		this.biscuitDao = biscuitDao;
	}

	public List<BiscuitType> getAllBrandEverGreenBiscuit(BiscuitName bisName) {

		return getBiscuitDao().getAllBrandEverGreenBiscuit(bisName);
	}

}
