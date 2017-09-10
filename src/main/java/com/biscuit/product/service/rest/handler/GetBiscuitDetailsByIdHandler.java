package com.biscuit.product.service.rest.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.biscuit.product.service.rest.dao.BiscuitDao;
import com.biscuit.product.service.rest.types.BiscuitDetails;
import com.biscuit.product.service.rest.types.BiscuitIdentity;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class GetBiscuitDetailsByIdHandler {

	@Autowired
	private BiscuitDao biscuitDao;

	public BiscuitDao getBiscuitDao() {
		return biscuitDao;
	}

	public void setBiscuitDao(BiscuitDao biscuitDao) {
		this.biscuitDao = biscuitDao;
	}

	public BiscuitDetails getBiscuitDetailsById(BiscuitIdentity bisId) {

		return getBiscuitDao().getBiscuitDetailsById(bisId);
	}

}
