package com.tata.shoppersden.dao;

import com.tata.shoppersden.models.Transactions;

import java.sql.SQLException;
import java.util.List;

public interface TransactionDao {
    public void addTransaction(long productId,long customerId) throws Exception;
    public void cancelOrder(long orderId) throws Exception;
    public List<Transactions> viewTransactionByCustomerId(long id) throws SQLException;
    public List<Transactions> viewTransactionByProductId(long id) throws SQLException;
}
