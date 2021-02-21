package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

public class UpdateProductNameAction {
    private AdminDao adminDao;
    public boolean updateProductName(long pid) throws Exception {
        if(pid<0)
        {
            return false;
        }
        adminDao = new AdminDaoImpl();
        adminDao.updateProductName(pid);
        return true;
    }
}
