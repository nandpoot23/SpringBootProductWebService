package com.biscuit.product.service.rest.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.dao.BiscuitDao;
import com.biscuit.product.service.rest.types.BiscuitIdentity;
import com.biscuit.product.service.rest.types.BrandStock;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class GetBiscuitByStockHandler {

	@Autowired
	private BiscuitDao biscuitDao;

	public BiscuitDao getBiscuitDao() {
		return biscuitDao;
	}

	public void setBiscuitDao(BiscuitDao biscuitDao) {
		this.biscuitDao = biscuitDao;
	}

	public BrandStock getBiscuitByStock(BiscuitIdentity bisId) {

		return getBiscuitDao().getBiscuitByStock(bisId);
	}

}
