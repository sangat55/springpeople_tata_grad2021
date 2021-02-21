package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.TransactionDao;
import com.tata.shoppersden.dao.TransactionDaoImpl;

public class CancelOrderAction {
    private TransactionDao transactionDao;
    public void cancelOrder(long orderId) throws Exception {
        if(orderId<0)
        {
            throw new Exception("Transaction id cannot be null");
        }
        transactionDao = new TransactionDaoImpl();
        transactionDao.cancelOrder(orderId);
    }
}
