package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.TransactionDao;
import com.tata.shoppersden.dao.TransactionDaoImpl;

public class PlaceOrderAction {
    private TransactionDao transactionDao;
    public void placeOrderAction(long pid,long cid) throws Exception {
        if(pid<0 || cid<0)
        {
            throw new Exception("Customer Id and Product Id Cannot be Negative");
        }
        transactionDao = new TransactionDaoImpl();
        transactionDao.addTransaction(pid,cid);
    }
}
