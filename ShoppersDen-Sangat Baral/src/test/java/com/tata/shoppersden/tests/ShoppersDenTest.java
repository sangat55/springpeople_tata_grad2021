package com.tata.shoppersden.tests;

import com.tata.shoppersden.utility.ShoppersDenCustomer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ShoppersDenTest {
    ShoppersDenCustomer shoppersDenCustomer;


    @BeforeEach
    public void setUp()
    {
        shoppersDenCustomer = new ShoppersDenCustomer();
    }

    @Test
    @DisplayName("Customer Id should not be zero")
    public void testCustomerIdGreaterThanZero()
    {
        assertThrows(Exception.class,()->shoppersDenCustomer.customerFunctionality(0));
    }
}
