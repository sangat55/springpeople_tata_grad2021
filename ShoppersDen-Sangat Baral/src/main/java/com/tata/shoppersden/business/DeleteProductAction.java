package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

public class DeleteProductAction {
    private AdminDao adminDao;
    public void deleteProductAction(long pid) throws Exception {
        if(pid<0)
        {
            throw new Exception("Product ID is Invalid");
        }
        adminDao = new AdminDaoImpl();
        adminDao.deleteProduct(pid);
    }
}
