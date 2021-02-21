package com.tata.shoppersden.dao;

import com.tata.shoppersden.models.*;

import java.sql.SQLException;
import java.util.List;

public interface AdminDao {
    public boolean adminLogin(long adminId,String password) throws  SQLException;
    public void addCategory(Category category) throws SQLException;
    public void addProduct(Product product) throws SQLException;
    public void deleteProduct(long productId) throws Exception;
    public void updateProductName(long pid) throws Exception;
    public void updateProductDescription(long pid) throws Exception;
    public void updateProductPrice(long pid) throws Exception;
    public void updateProductImage(long pid) throws Exception;
    public void updateProductDom(long pid) throws Exception;
    public List<Customer> viewAllCustomerDetails() throws SQLException;
    public List<Transactions> viewAllTransactionDetails() throws SQLException;
    public List<Product> getProductsByCategoryId(long cid) throws Exception;
    public List<Product> getProductsByCategoryName(String cname) throws Exception;
    public List<Category> getCategories() throws SQLException;
    public void updateCategoryName(long cid) throws Exception;
}
