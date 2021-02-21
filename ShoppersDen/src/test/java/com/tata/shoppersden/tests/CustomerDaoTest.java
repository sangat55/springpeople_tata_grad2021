package com.tata.shoppersden.tests;

import com.tata.shoppersden.business.RegistrationAction;
import com.tata.shoppersden.dao.*;
import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerDaoTest {

    private Customer customer;
    private Product product;
    private CustomerDao customerDao;


    @BeforeEach
    public void setUp() {
        customer = new Customer();
        customer = new RegistrationAction().createCustomer();
        product = null;
        customerDao = new CustomerDaoImpl();

    }



    @Test
    @DisplayName("Customer Id Should not be empty while Performing getCustomerById()")
    public void testGetCustomerById() throws SQLException {
        assertNotEquals(new CustomerDaoImpl().getCustomerById(new Random().nextInt(1000000)),null);
    }

    @Test
    @DisplayName("Customer Id Returned by getRandomCustomerId should not be zero")
    public void testIdReturnedByGetRandomCustomerId() throws SQLException {
        assertTrue(customerDao.getRandomCustomerId()>0);
    }

    @Test
    @DisplayName("Check if cart is empty")
    public void testIdPassedToViewCart() throws SQLException {
        assertEquals(customerDao.viewCart(0).size(),0);
    }
}
