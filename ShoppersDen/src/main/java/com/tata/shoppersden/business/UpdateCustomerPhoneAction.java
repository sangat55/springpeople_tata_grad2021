package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class UpdateCustomerPhoneAction {
    private CustomerDao customerDao;
    public void updateCustomerPhone(long phone,long userId) throws Exception {
        if(String.valueOf(phone).length()<10 || userId<10)
        {
            throw new Exception("Phone nnumber should be 10 digits");
        }
        customerDao = new CustomerDaoImpl();
        customerDao.changePhone(phone,userId);
    }
}
