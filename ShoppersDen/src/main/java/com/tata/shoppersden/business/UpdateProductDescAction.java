package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

public class UpdateProductDescAction {
    private AdminDao adminDao;
    public void updateProductDesc(long pid) throws Exception {
        if(pid<0)
        {
            throw new Exception("Product ID Cannot be negative");
        }
        adminDao = new AdminDaoImpl();
        adminDao.updateProductDescription(pid);

    }
}
