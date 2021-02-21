package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;

public class UpdateCategoryNameAction {
    private AdminDao adminDao;
    public boolean updateCategoryNameAction(long cid) throws Exception {

        if(cid<0)
        {
            return false;
        }
        adminDao = new AdminDaoImpl();
        adminDao.updateCategoryName(cid);
        return true;
    }
}
