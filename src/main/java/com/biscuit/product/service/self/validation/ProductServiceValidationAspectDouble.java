package com.biscuit.product.service.self.validation;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

//@Aspect
//@Component
public class ProductServiceValidationAspectDouble {

/*    @Autowired
    private CustomerServiceValidator customerServiceValidator;

    @Autowired
    private BisServiceValidator bisServiceValidator;

    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory
            .getLogger(CustomerServiceValidationAspectDouble.class);
*/

/*    @Around("execution(* com.biscuit.product.service.rest.impl.ProductServiceImpl.*(..))")
    public Object aroundCustomerServiceValidation(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        LOGGER.info("CustomerServiceValidationAspect : aroundCustomerServiceValidation Before");
        Method[] methods = customerServiceValidator.getClass().getMethods();
        boolean isValidated = false;

        for (Method method : methods) {
            ValidateMethod annotation = method.getAnnotation(ValidateMethod.class);
            if (null != annotation && annotation.value().equals(proceedingJoinPoint.getSignature().getName())) {
                method.invoke(customerServiceValidator, proceedingJoinPoint.getArgs());
                isValidated = true;
                break;
            }
        }
        if (!isValidated) {
            // for bis
            Method[] methods1 = bisServiceValidator.getClass().getMethods();

            for (Method method : methods1) {
                ValidateMethod annotation = method.getAnnotation(ValidateMethod.class);
                if (null != annotation && annotation.value().equals(proceedingJoinPoint.getSignature().getName())) {
                    method.invoke(bisServiceValidator, proceedingJoinPoint.getArgs());
                    break;
                }
            }
        }

        LOGGER.info("CustomerServiceValidationAspect : aroundCustomerServiceValidation After");
        return proceedingJoinPoint.proceed();

    }
*/
}
