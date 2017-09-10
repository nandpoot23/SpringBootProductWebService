package com.biscuit.product.service.rest.types;

/**
 * @author mlahariya
 * @version 1.0, March 2017
 */

public class ProductValue {

    private String proValuation;

    public String getProValuation() {
        return proValuation;
    }

    public void setProValuation(String proValuation) {
        this.proValuation = proValuation;
    }

    @Override
    public String toString() {
        return "ProductValue [proValuation=" + proValuation + "]";
    }

}
