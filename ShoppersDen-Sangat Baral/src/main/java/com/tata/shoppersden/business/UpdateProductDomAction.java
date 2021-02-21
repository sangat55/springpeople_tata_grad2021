package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

public class UpdateProductDomAction {
    private AdminDao adminDao;
    public void updateProductDom(long pid) throws Exception {
        if(pid<0)
        {
            throw new Exception("Product ID Cannot be negative");
        }
        adminDao = new AdminDaoImpl();
        adminDao.updateProductDom(pid);
    }
}
