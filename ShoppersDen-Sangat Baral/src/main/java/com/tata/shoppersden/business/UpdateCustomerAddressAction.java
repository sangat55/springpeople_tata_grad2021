package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class UpdateCustomerAddressAction {
    private CustomerDao customerDao;
    public void updateCustomerAddress(String address,long userId) throws Exception {
        if(address=="" || userId<0)
        {
            throw new Exception("Invlaid Address or User Id");
        }
        customerDao = new CustomerDaoImpl();
        customerDao.changeAddress(address,userId);
    }
}
