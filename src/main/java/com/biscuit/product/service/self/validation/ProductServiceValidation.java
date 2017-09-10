package com.biscuit.product.service.self.validation;

/**
 * This is old type of AOP validation, in this we have to write the multiple point cut for separate methods. 
 * 
 * @author mlahariya
 * @version 1.0, March 2017
 */

//@Component
//@Aspect
public class ProductServiceValidation {

   // private static final Logger LOG = LoggerFactory.getLogger(ProductServiceValidation.class);

/*    @Autowired
    private NumericValidation numericValidation;
*/    
    /**
     * Validates the {@link ProductService#getProductDetailByProId(ProductIdentity proId)}
     * operation.
     * 
     * @param errors
     *            A {@link Errors} object containing the errors to return to the
     *            client.
     * @param proId
     *            The <code>proId</code> parameter passed in by the
     *            client.
     */
    
/*    @Pointcut("execution(* com.biscuit.product.service.rest.impl.ProductServiceImpl.getProductDetailByProId(..)) && args(proId,..))")
    public void validateGetProductDetailByProIdentity(ProductIdentity proId) {
        
    }
*/
/*    @Before("validateGetProductDetailByProIdentity(proId)")
    public void validateGetProductDetailByProId(ProductIdentity proId) {

        List<ProductMessage> messageList = new ArrayList<ProductMessage>();

        if (numericValidation.isAlfaNumeric(proId.getProductId())
                || Integer.parseInt(proId.getProductId()) < 1) {
            LOG.debug("please provide the valid product id");
            
           // throw new ProductFrameworkError(ProductErrorCode.PD_31554.getValue());
            messageList.add(new ProductMessage(ProductErrorCode.PD_31554.getValue()));
        }

        checkAndThrowMessage(messageList);
    }
*/

/*    private void checkAndThrowMessage(List<ProductMessage> messageList) {
        if (!messageList.isEmpty()) {
            ProductFrameworkError error = new ProductFrameworkError(messageList.get(0).getCode(), messageList.get(0).getArgs(), null, null);
            error.setProductMessages(messageList);
            throw error;
        }

    }
*/
}
