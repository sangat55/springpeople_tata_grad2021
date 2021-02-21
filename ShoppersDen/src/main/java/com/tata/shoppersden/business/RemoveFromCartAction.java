package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class RemoveFromCartAction {
    private CustomerDao customerDao;
    public void removeFromCart(long pid,long cid) throws Exception {
        if(pid<0 || cid<0)
        {
            throw new Exception("Product ID and Customer ID cannot be negative");
        }
        customerDao = new CustomerDaoImpl();
        customerDao.removeFromCart(pid,cid);
    }
}
