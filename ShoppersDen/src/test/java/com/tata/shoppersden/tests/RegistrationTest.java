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
    private Customer customer,customer1,customer2;
    private RegistrationAction registrationAction;
    private CustomerDao customerDao;

    @BeforeEach
    public void setUp()
    {
        registrationAction = new RegistrationAction();
        customer = registrationAction.createCustomer();
        customerDao = new CustomerDaoImpl();
        customer1 = registrationAction.createCustomer();
        customer2 = registrationAction.createCustomer();
    }


    @Test
    @DisplayName("Customer ID Should Not Be Negative ")
    public void testCustomerIdTobePositive()
    {

        assertTrue(customer.getCustomerId()>0);
    }

    @Test
    @DisplayName("Customer ID Should  Be Unique ")
    public void testCustomerIdUnique()
    {


        assertNotEquals(customer1.getCustomerId(),customer2.getCustomerId());
    }

    @Test
    @DisplayName("Customer Name should Not be Empty ")
    public void testCustomerNameShouldNotBeEmpty()
    {
        assertNotEquals(customer.getCustomerName(),"");
    }
    @Test
    @DisplayName("Customer Address should Not be Empty ")
    public void testCustomerAddressShouldNotBeEmpty()
    {
        assertNotEquals(customer.getAddress(),"");
    }

    @Test
    @DisplayName("Customer Email Address should Not be Empty ")
    public void testEmailAddressShouldNotBeEmpty()
    {
        assertNotEquals(customer.getEmailId(),"");
    }

    @Test
    @DisplayName("Customer Phone should Be 10 digits ")
    public void testPhoneShouldNotBeTen()
    {
        assertTrue((String.valueOf(customer.getPhone())).length()==10);
    }


    @Test
    @DisplayName("Customer Password should Not Be Empty ")
    public void testPasswordShouldNotBeEmpty()
    {
        assertTrue(customer.getPassword()!="");
    }

    @Test
    @DisplayName("Customer Security Question should Not Be Empty ")
    public void testSecQuestionShouldNotBeEmpty()
    {
        assertTrue(customer.getSecurityQuestion()!="");
    }


    @Test
    @DisplayName("Customer Security Answer should Not Be Empty ")
    public void testSecAnswerShouldNotBeEmpty()
    {
        assertTrue(customer.getSecurityAnswer()!="");
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
