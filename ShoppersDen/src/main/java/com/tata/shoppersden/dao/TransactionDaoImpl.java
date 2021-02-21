package com.tata.shoppersden.dao;

import com.tata.shoppersden.helper.PostgresConnHelper;
import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import com.tata.shoppersden.models.Transactions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class TransactionDaoImpl implements TransactionDao {


    private Connection conn;
    private PreparedStatement preGetByCustomer,preGetByProduct,preAdd,preCancel,preRemove;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    private  Transactions transactions;

    public TransactionDaoImpl()
    {
        conn = PostgresConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");
    }
    @Override
    public void addTransaction(long productId,long customerId) throws Exception {
        addTransactionToDb(productId,customerId);
    }

    @Override
    public void cancelOrder(long orderId) throws Exception {
        cancelMyOrder(orderId);
    }

    private void cancelMyOrder(long orderId) throws SQLException {
        String cancel = resourceBundle.getString("cancelOrder");
        preCancel = conn.prepareStatement(cancel);
        preCancel.setLong(1,orderId);
        preCancel.executeUpdate();
    }

    private void addTransactionToDb(long productId,long customerId) throws Exception {
        if(productId==0 || customerId == 0)
        {
            throw new Exception("Invalid Parameters");
        }
        String add = resourceBundle.getString("addTransaction");
        preAdd = conn.prepareStatement(add);
        preAdd.setLong(1,new Random().nextInt(100000000));
        preAdd.setDate(2, Date.valueOf(LocalDate.now()));
        preAdd.setLong(3,productId);
        preAdd.setLong(4,customerId);
        preAdd.executeUpdate();
        String rem = resourceBundle.getString("removeCart");
        preRemove = conn.prepareStatement(rem);
        preRemove.setLong(1,productId);
        preRemove.setLong(2,customerId);
        preRemove.executeUpdate();

    }

    @Override
    public List<Transactions> viewTransactionByCustomerId(long id) throws SQLException {
        return getTransactionsByCustomerId(id);
    }

    @Override
    public List<Transactions> viewTransactionByProductId(long id) throws SQLException {
        return getTransactionsByProductId(id);
    }

    private List<Transactions> getTransactionsByCustomerId(long id) throws SQLException {
        if(id==0)
        {
            return null;
        }
        List<Transactions> transactionsList = new ArrayList<Transactions>();
        String getByCustomer = resourceBundle.getString("getTransactionByCustomerId");
        preGetByCustomer = conn.prepareStatement(getByCustomer);
        preGetByCustomer.setLong(1,id);
        resultSet = preGetByCustomer.executeQuery();
        while(resultSet.next())
        {
            transactions = new Transactions();
            transactions.setTransactionId(resultSet.getLong(1));
            transactions.setTransactionDate(resultSet.getDate(2));
            transactions.setProductId(new ProductDaoImpl().getProductById(resultSet.getLong(3)).getProductId());
            transactions.setCustomerId(new CustomerDaoImpl().getCustomerById(resultSet.getLong(4)).getCustomerId());
            transactionsList.add(transactions);
        }
        return transactionsList;

    }
    private List<Transactions> getTransactionsByProductId(long id) throws SQLException {
        if(id == 0)
        {
            return null;
        }
        List<Transactions> transactionsList = new ArrayList<Transactions>();
        String getByProduct = resourceBundle.getString("getTransactionByProductId");
        preGetByProduct = conn.prepareStatement(getByProduct);
        preGetByProduct.setLong(1,id);
        resultSet = preGetByProduct.executeQuery();
        while(resultSet.next())
        {
            transactions = new Transactions();
            transactions.setTransactionId(resultSet.getLong(1));
            transactions.setTransactionDate(resultSet.getDate(2));
            transactions.setProductId(new ProductDaoImpl().getProductById(resultSet.getLong(3)).getProductId());
            transactions.setCustomerId(new CustomerDaoImpl().getCustomerById(resultSet.getLong(4)).getCustomerId());
            transactionsList.add(transactions);
        }
        return transactionsList;
    }



}
