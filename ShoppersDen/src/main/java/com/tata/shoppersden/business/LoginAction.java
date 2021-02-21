package com.tata.shoppersden.business;


import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.util.Scanner;

public class LoginAction {

    public void loginAction(long userId,String password) throws Exception {

        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.loginUser(userId,password);
    }

}
