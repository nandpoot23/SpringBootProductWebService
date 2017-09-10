package com.biscuit.product.service.rest.types;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class BiscuitName {

	private String biscuitName;

	public String getBiscuitName() {
		return biscuitName;
	}

	public void setBiscuitName(String biscuitName) {
		this.biscuitName = biscuitName;
	}

	@Override
	public String toString() {
		return "BiscuitName [biscuitName=" + biscuitName + "]";
	}

}
