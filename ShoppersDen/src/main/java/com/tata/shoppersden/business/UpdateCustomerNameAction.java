package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class UpdateCustomerNameAction {
    private CustomerDao customerDao;
    public void updateCustomerName(String name,long userId) throws Exception {
        if(name == "" || userId<0)
        {
            throw new Exception("Invalid Username or User iD");
        }
        customerDao = new CustomerDaoImpl();
        customerDao.changeName(name,userId);
    }
}
