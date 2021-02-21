package com.tata.shoppersden.tests;

import com.tata.shoppersden.dao.ProductDaoImpl;
import com.tata.shoppersden.models.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class ProductDaoTest {

    private Product product;
    private ProductDaoImpl productDao;
    private List<Product> productList;

    @BeforeEach
    public void setUp() throws SQLException {
        productDao = new ProductDaoImpl();
        productList = new ArrayList<Product>();
        productList = productDao.viewProducts();
        product = productDao.createProduct();
    }


    @Test
    public void testViewProducts() {
        assertFalse(productList.size() == 0);
    }
}