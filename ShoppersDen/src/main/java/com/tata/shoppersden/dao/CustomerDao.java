package com.tata.shoppersden.dao;

import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import com.tata.shoppersden.models.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public interface CustomerDao {
    public void loginUser(long userId,String Password) throws Exception;
    public void registerUser(Customer customer) throws Exception;
    public void addToCart(long pid, long cid) throws SQLException;
    public void removeFromCart(long pid,long cid) throws SQLException;
    public List<ShoppingCart> viewCart(long userId) throws SQLException;
    public Customer getCustomerById(long id) throws SQLException;
    public long getRandomCustomerId() throws SQLException;
    public Customer viewProfile(long userId) throws SQLException;
    public void forgetPassword(String pass,long userId) throws SQLException;
    public void changeName(String name,long userId) throws SQLException;
    public void changeAddress(String address,long userId) throws SQLException;
    public void changeEmail(String email,long userId) throws SQLException;
    public void changePhone(long phone,long userId) throws SQLException;
    public void changeSecurityQuestion(String question,String answer,long userId) throws SQLException;

}
