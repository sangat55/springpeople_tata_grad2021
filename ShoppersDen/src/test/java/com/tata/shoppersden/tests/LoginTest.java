package com.tata.shoppersden.tests;

import com.tata.shoppersden.business.LoginAction;
import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest {

    private CustomerDao customerDao;
    private LoginAction loginAction;


    @BeforeEach
    public void setUp()
    {
        customerDao = new CustomerDaoImpl();
        loginAction = new LoginAction();
    }


    @Test
    @DisplayName("PASSWORD SHOULD NOT BE EMPTY")
    public void testPasswordNotBeNull()
    {
        assertThrows(Exception.class,()-> customerDao.loginUser(new Random().nextInt(1000000),""));
    }


    @Test
    @DisplayName("USER ID SHOULD NOT BE ZERO")
    public void testUserIdNotBeZero()
    {
        assertThrows(Exception.class,()->loginAction.loginAction(0,""));
    }

    @Test
    @DisplayName("Check if UserID and Password Valid")
    public void testCheckIfValid() throws SQLException {
        assertEquals(new CustomerDaoImpl().checkIfValid(0,""),false);
    }



}
