package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Category;

import java.sql.SQLException;

public class AddCategoryAction {
    private AdminDao adminDao;
    public void addCategoryAction(Category category) throws SQLException {
        if(category==null)
        {
            throw new NullPointerException("Category Cannot be Null");
        }
        adminDao = new AdminDaoImpl();
        adminDao.addCategory(category);
    }



}
