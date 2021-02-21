package com.tata.shoppersden.tests;


import com.tata.shoppersden.dao.TransactionDao;
import com.tata.shoppersden.dao.TransactionDaoImpl;
import com.tata.shoppersden.models.Transactions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TransactionDaoTest {

    private TransactionDao transactionDao;
    private Transactions transaction;
    private Transactions transaction1;
    private Transactions transaction2;


    @BeforeEach
    public void setUp() {
        transactionDao = new TransactionDaoImpl();
        transaction = new Transactions();
        transaction.setTransactionId(new Random().nextInt(1000000));
        transaction.setProductId(new Random().nextInt(1000000));
        transaction.setCustomerId(new Random().nextInt(1000000));
        transaction.setTransactionDate(Date.valueOf(LocalDate.now()));
        transaction1 = new Transactions();
        transaction1.setTransactionId(new Random().nextInt(1000000));
        transaction2 = new Transactions();
        transaction2.setTransactionId(new Random().nextInt(1000000));

    }


    @Test
    @DisplayName("Product Id and Customer Id should not be zero")
    public void testIdToBePositive()
    {
        assertThrows(Exception.class,()-> transactionDao.addTransaction(0,0));
        assertTrue(transaction.getCustomerId()>0);
        assertTrue(transaction.getProductId()>0);
    }


    @Test
    @DisplayName("Transaction Id should be Unique")
    public void testTransactionIdUnique()
    {
        assertNotEquals(transaction1.getTransactionId(),transaction2.getTransactionId());
    }

    @Test
    @DisplayName("Transaction ID Should be Positive")
    public void testTransactionIdPositive()
    {
        assertTrue(transaction.getTransactionId()>0);
    }

    @Test
    @DisplayName("Transaction Date Should be not be empty")
    public void testTransactionDate()
    {
        assertEquals(transaction.getTransactionDate(),Date.valueOf(LocalDate.now()));
    }



    @Test
    public void testViewTransactionsByCustomerId() throws SQLException {
        assertEquals(transactionDao.viewTransactionByCustomerId(0),null);
    }

    @Test
    public void testViewTransactionsByProductId() throws SQLException {
        assertEquals(transactionDao.viewTransactionByProductId(0),null);
    }

    @Test
    public void mockTestViewTransactionsByCustomerId() throws SQLException {
        TransactionDao transactionDao = mock(TransactionDaoImpl.class);
        when(transactionDao.viewTransactionByCustomerId(0)).thenReturn(mockViewTransactionsByCustomerId(0));
        assertFalse(transactionDao.viewTransactionByCustomerId(0).size()==0);
    }

    private List<Transactions> mockViewTransactionsByCustomerId(long id)
    {
        Transactions transactions = null;
        List<Transactions> transactionsList = new ArrayList<Transactions>();
        for(int i=0;i<10;i++)
        {
            transactions = new Transactions();
            transactionsList.add(transactions);
        }
        return transactionsList;

    }

    @Test
    public void mockTestViewTransactionsByProductId() throws SQLException {
        TransactionDao transactionDao = mock(TransactionDaoImpl.class);
        when(transactionDao.viewTransactionByProductId(0)).thenReturn(mockViewTransactionsByProductId(0));
        assertFalse(transactionDao.viewTransactionByProductId(0).size()==0);
    }

    private List<Transactions> mockViewTransactionsByProductId(long id)
    {
        Transactions transactions = null;
        List<Transactions> transactionsList = new ArrayList<Transactions>();
        for(int i=0;i<10;i++)
        {
            transactions = new Transactions();
            transactionsList.add(transactions);
        }
        return transactionsList;

    }


}
