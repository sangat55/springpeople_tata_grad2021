package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

public class UpdateProductImageAction {
    private AdminDao adminDao;
    public void updateProductImage(long pid) throws Exception {
        if(pid<0)
        {
            throw new Exception("Product ID Cannot be negative");
        }
        adminDao = new AdminDaoImpl();
        adminDao.updateProductImage(pid);

    }
}
