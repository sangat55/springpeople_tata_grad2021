package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class AddToCartAction {
    private CustomerDao customerDao;
    public boolean addToCartAction(long pid,long userId) throws SQLException {
        if(pid<0 || userId<0)
        {
            return false;
        }
        customerDao = new CustomerDaoImpl();
        customerDao.addToCart(pid,userId);
        return true;
    }
}
