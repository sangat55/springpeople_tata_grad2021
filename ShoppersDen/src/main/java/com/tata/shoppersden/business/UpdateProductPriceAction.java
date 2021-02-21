package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

public class UpdateProductPriceAction {
    private AdminDao adminDao;
    public boolean updateProductPrice(long pid) throws Exception {
        if(pid<0)
        {
            return false;
        }
        adminDao = new AdminDaoImpl();
        adminDao.updateProductPrice(pid);
        return true;
    }
}
