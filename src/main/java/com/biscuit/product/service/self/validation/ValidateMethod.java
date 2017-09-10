package com.biscuit.product.service.self.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface ValidateMethod {

	/**
	 * The name of the method to validate against.
	 */
	String value();
}
