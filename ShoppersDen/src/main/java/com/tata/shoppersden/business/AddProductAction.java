package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Product;

import java.sql.SQLException;

public class AddProductAction {
    private AdminDao adminDao;
    public void addProductAction(Product product) throws SQLException {
        if(product == null)
        {
            throw new NullPointerException("Product Cannot Be Null");
        }
        else {
            adminDao = new AdminDaoImpl();
            adminDao.addProduct(product);
        }
    }
}
