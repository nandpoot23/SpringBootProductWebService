package com.biscuit.product.service.rest.types;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class ProductMarketRate {

	private String prodMarketRate;

	public String getProdMarketRate() {
		return prodMarketRate;
	}

	public void setProdMarketRate(String prodMarketRate) {
		this.prodMarketRate = prodMarketRate;
	}

	@Override
	public String toString() {
		return "ProductMarketRate [prodMarketRate=" + prodMarketRate + "]";
	}

}
