package com.biscuit.product.service.rest.util;

import org.springframework.stereotype.Component;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Component
public class NumericHelper {

	/**
	 * Returns whether a string consists of all numeric digits.
	 *
	 */
	public boolean isAlfaNumeric(String number) {
		if (number != null && number.matches("\\d+")) {
			return false;
		}
		return true;
	}

}
