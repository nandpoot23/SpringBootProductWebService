package com.biscuit.product.service.rest.types;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class BiscuitType {

	private String biscuitName;
	private String biscuitType;

	public String getBiscuitName() {
		return biscuitName;
	}

	public void setBiscuitName(String biscuitName) {
		this.biscuitName = biscuitName;
	}

	public String getBiscuitType() {
		return biscuitType;
	}

	public void setBiscuitType(String biscuitType) {
		this.biscuitType = biscuitType;
	}

	@Override
	public String toString() {
		return "BiscuitType [biscuitName=" + biscuitName + ", biscuitType="
				+ biscuitType + "]";
	}

}
