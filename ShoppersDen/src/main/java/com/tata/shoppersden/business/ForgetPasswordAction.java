package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;

import java.sql.SQLException;

public class ForgetPasswordAction {
    private CustomerDao customerDao;
    public void forgetPasswordAction(String password,long userid) throws Exception {
        if(password == "")
        {
            throw new Exception("Password Cannot be Empty");
        }
        customerDao = new CustomerDaoImpl();
        customerDao.forgetPassword(password,userid);
    }

}
