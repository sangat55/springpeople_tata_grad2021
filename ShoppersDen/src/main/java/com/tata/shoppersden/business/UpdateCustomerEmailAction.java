package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class UpdateCustomerEmailAction {
    private CustomerDao customerDao;
    public void updateCustomerEmail(String email,long userId) throws Exception {
        if(email == "" || userId<0)
        {
            throw new Exception("Invalid Email Id or User Id");
        }
        customerDao= new CustomerDaoImpl();
        customerDao.changeEmail(email,userId);
    }
}
