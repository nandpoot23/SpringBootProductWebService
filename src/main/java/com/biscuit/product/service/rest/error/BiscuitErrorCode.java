package com.biscuit.product.service.rest.error;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public enum BiscuitErrorCode implements java.io.Serializable {

	BD_51554("BISCUIT-51554"), BD_51555("BISCUIT-51555"), BD_51556(
			"BISCUIT-51556"), BD_51557("BISCUIT-51557"), BD_51558(
			"BISCUIT-51558"), BD_51559("BISCUIT-51559"), BD_51560(
			"BISCUIT-51560"), BD_51561("BISCUIT-51561"), BD_51562(
			"BISCUIT-51562"), BD_51563("BISCUIT-51563"), BD_51564(
			"BISCUIT-51564"), BD_51565("BISCUIT-51565"), BD_51566(
			"BISCUIT-51566"), BD_51567("BISCUIT-51567"), BD_51568(
			"BISCUIT-51568"), BD_51569("BISCUIT-51569"), BD_51570(
			"BISCUIT-51570"), BD_51571("BISCUIT-51571"), BD_51572(
			"BISCUIT-51572");

	/**
	 * String that represents a property
	 */
	private String property = null;

	/**
	 * Enum constructor
	 */
	private BiscuitErrorCode(String property) {
		this.property = property;
	}

	/**
	 * Return the enumeration from the String
	 *
	 * @link ErrorCode
	 */
	public static BiscuitErrorCode fromValue(String value) {
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
