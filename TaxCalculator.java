package com.tata.ecommerce.business;

public interface TaxCalculator {

    float computeIGST(double totalPrice,String categoryName);
    float[] computeCGSTSGST(double totalPrice,String categoryName);
}
