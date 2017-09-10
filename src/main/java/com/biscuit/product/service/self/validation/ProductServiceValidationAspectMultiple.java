package com.biscuit.product.service.self.validation;

import java.lang.reflect.Method;
import java.util.List;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

@Aspect
@Component
public class ProductServiceValidationAspectMultiple {

	@Autowired
	private List<ServiceValidator> serviceValidators;

	private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory
			.getLogger(ProductServiceValidationAspectMultiple.class);

	/*
	 * @Around executes two times, first when in coming request comes second
	 * times after completing the successful method execution.
	 */

	@Around("execution(* com.biscuit.product.service.rest.impl.ProductServiceImpl.*(..))")
	public Object aroundCustomerServiceValidation(
			ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		LOGGER.info("ProductServiceValidationAspect : aroundProductServiceValidation Before");
		for (ServiceValidator serviceValidator : serviceValidators) {
			Method[] methods = serviceValidator.getClass().getMethods();
			for (Method method : methods) {
				ValidateMethod annotation = method
						.getAnnotation(ValidateMethod.class);
				if (null != annotation
						&& annotation.value().equals(
								proceedingJoinPoint.getSignature().getName())) {
					method.invoke(serviceValidator,
							proceedingJoinPoint.getArgs());
					return proceedingJoinPoint.proceed();
				}
			}
		}

		LOGGER.info("CustomerServiceValidationAspect : aroundCustomerServiceValidation After");
		return proceedingJoinPoint.proceed();

	}

}
