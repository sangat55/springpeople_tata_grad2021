package com.tata.shoppersden.tests;

import com.tata.shoppersden.business.RegistrationAction;
import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;
import com.tata.shoppersden.models.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationTest {
    private Customer customer;
    private RegistrationAction registrationAction;
    private CustomerDao customerDao;

    @BeforeEach
    public void setUp()
    {
        registrationAction = new RegistrationAction();
        customer = registrationAction.createCustomer();
        customerDao = new CustomerDaoImpl();

    }


    @Test
    @DisplayName("Customer Phone should Be 10 digits ")
    public void testPhoneShouldNotBeTen()
    {
        assertTrue((String.valueOf(customer.getPhone())).length()==10);
    }

    @Test
    public void testRegisterNewUser()
    {
        assertThrows(NullPointerException.class,()-> customerDao.registerUser(null));

    }

    @Test
    @DisplayName("Check if User already Exists")
    public void testCheckIfUserExists() throws SQLException {
        assertEquals(new CustomerDaoImpl().checkIfUserExists(new Random().nextInt(100000)),false);
    }

    @Test
    @DisplayName("Test Add Cart")
    public void testAddCart()
    {
        assertThrows(NullPointerException.class,()-> new CustomerDaoImpl().addUser(null));
    }


}
