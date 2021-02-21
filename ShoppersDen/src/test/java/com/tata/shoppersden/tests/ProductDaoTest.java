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

    private Product product,product1,product2;
    private ProductDaoImpl productDao;
    private List<Product> productList;

    @BeforeEach
    public void setUp() throws SQLException {
        productDao = new ProductDaoImpl();
        productList = new ArrayList<Product>();
        productList = productDao.viewProducts();
        product = productDao.createProduct();
        product1 = productDao.createProduct();
        product2 = productDao.createProduct();
        long id = productDao.getRandomProductId();
    }


    @Test
    @DisplayName("Product ID should not be zero")
    public void testGetProductId() throws SQLException {
        assertEquals(productDao.getProductById(0),null);
    }

    @Test
    public void testViewProducts()
    {
        assertFalse(productList.size()==0);
    }


    @Test
    @DisplayName("Product Name should not be empty")
    public void testGetProductName() throws SQLException {
        assertEquals(productDao.getProductByName(""),null);
    }

    @Test
    @DisplayName("Product ID should be unique")
    public void testProductIDUnique()
    {
        assertFalse(product2.getProductId()==product1.getProductId());
    }

    @Test
    @DisplayName("Product Name should not be empty")
    public void testProductNameEmpty()
    {
        assertNotEquals(product.getProductName(),"");
    }

    @Test
    @DisplayName("Product Description should not be empty")
    public void testProductDescEmpty()
    {
        assertNotEquals(product.getDescription(),"");
    }

    @Test
    @DisplayName("Product Price should not be 0")
    public void testProductPriceEmpty()
    {
        assertFalse(product.getPrice()==0);
    }

    @Test
    @DisplayName("Product Quantity should not be 0")
    public void testProductQuantityEmpty()
    {
        assertTrue(product.getQuantity()==0);
    }

    @Test
    @DisplayName("Product Image should not be empty")
    public void testProductImageEmpty()
    {
        assertNotEquals(product.getProductImage(),"");
    }


    @Test
    @DisplayName("Product DOM should not be empty")
    public void testProductDomEmpty()
    {
        assertNotEquals(product.getDom(),null);
    }
}
