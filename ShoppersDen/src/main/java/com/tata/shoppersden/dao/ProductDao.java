package com.tata.shoppersden.dao;

import com.tata.shoppersden.models.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    public Product getProductById(long id) throws SQLException;
    public List<Product> viewProducts() throws SQLException;
    public Product getProductByName(String name) throws SQLException;
    public long getRandomProductId() throws SQLException;

}
