package com.biscuit.product.service.rest.error;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public enum ProductErrorCode implements java.io.Serializable {

	PD_31554("PRODUCT-31554"), PD_31555("PRODUCT-31555"), PD_31556(
			"PRODUCT-31556"), PD_31557("PRODUCT-31557"), PD_31558(
			"PRODUCT-31558"), PD_31559("PRODUCT-31559"), PD_31560(
			"PRODUCT-31560"), PD_31561("PRODUCT-31561"), PD_31562(
			"PRODUCT-31562"), PD_31563("PRODUCT-31563"), PD_31564(
			"PRODUCT-31564"), PD_31565("PRODUCT-31565"), PD_31566(
			"PRODUCT-31566"), PD_31567("PRODUCT-31567"), PD_31568(
			"PRODUCT-31568"), PD_31569("PRODUCT-31569"), PD_31570(
			"PRODUCT-31570"), PD_31571("PRODUCT-31571"), PD_31572(
			"PRODUCT-31572"), PD_31573("PRODUCT-31573"), PD_31574(
			"PRODUCT-31574");

	/**
	 * String that represents a property
	 */
	private String property = null;

	/**
	 * Enum constructor
	 */
	private ProductErrorCode(String property) {
		this.property = property;
	}

	/**
	 * Return the enumeration from the String
	 *
	 * @link ErrorCode
	 */
	public static ProductErrorCode fromValue(String value) {
		return valueOf(value);

	}

	/**
	 * Return the value of enumeration
	 * 
	 * @return enumerationValue {@link String}
	 */
	public String getValue() {
		return property;
	}

}
