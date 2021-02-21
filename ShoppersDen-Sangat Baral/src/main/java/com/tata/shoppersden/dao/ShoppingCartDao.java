package com.tata.shoppersden.dao;

import com.tata.shoppersden.models.ShoppingCart;

import java.sql.SQLException;
import java.util.List;

public interface ShoppingCartDao {
    public List<ShoppingCart> displayCart() throws Exception;
}
