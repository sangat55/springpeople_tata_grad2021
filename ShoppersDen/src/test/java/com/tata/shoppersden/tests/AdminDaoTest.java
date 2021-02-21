package com.tata.shoppersden.tests;

import com.tata.shoppersden.dao.AdminDao;
import com.tata.shoppersden.dao.AdminDaoImpl;
import com.tata.shoppersden.models.Admin;
import com.tata.shoppersden.models.Category;
import com.tata.shoppersden.models.Product;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


public class AdminDaoTest {
    private Admin admin;
    private Category category;
    private AdminDao adminDao;
    private Product product;

    @BeforeEach
    public void setUp()
    {
        category = null;
        product = null;
        admin = new Admin();
        admin.setAdminId(new Random().nextInt(100000));
        admin.setAdminName(RandomStringUtils.randomAlphabetic(5,20));
        admin.setAdminPassword(RandomStringUtils.randomAlphabetic(8,20));
        adminDao = new AdminDaoImpl();

    }

    @Test
    @DisplayName("Test Admin Login")
    public void testAdminLogin() throws SQLException {
        assertEquals(adminDao.adminLogin(0, ""),false);
    }

    @Test
    @DisplayName("Test Add Category")
    public void testAddCategory() {
        assertThrows(NullPointerException.class,()->adminDao.addCategory(category));
    }

    @Test
    @DisplayName("Test Add Product")
    public void testAddProduct() {
        assertThrows(NullPointerException.class,()->adminDao.addProduct(product));
    }

    @Test
    @DisplayName("Test Delete Product")
    public void testDeleteProduct() {
        assertThrows(Exception.class,()->adminDao.deleteProduct(0));
    }

    @Test
    @DisplayName("Test Update ProductName")
    public void testUpdateProductName() {
        assertThrows(Exception.class,()->adminDao.updateProductName(0));
    }

    @Test
    @DisplayName("Test Update ProductName")
    public void testUpdateProductDesc() {
        assertThrows(Exception.class,()->adminDao.updateProductDescription(0));
    }

    @Test
    @DisplayName("Test Update Product Price")
    public void testUpdateProductPrice() {
        assertThrows(Exception.class,()->adminDao.updateProductPrice(0));
    }

    @Test
    @DisplayName("Test Update Product Image")
    public void testUpdateProductImage() {
        assertThrows(Exception.class,()->adminDao.updateProductImage(0));
    }


    @Test
    @DisplayName("Test Update Product DOM")
    public void testUpdateProductDom() {
        assertThrows(Exception.class,()->adminDao.updateProductDom(0));
    }

    @Test
    @DisplayName("Test Get Product By Category ID")
    public void testGetProductByCatId() {
        assertThrows(Exception.class,()->adminDao.getProductsByCategoryId(0));
    }

    @Test
    @DisplayName("Test  Get Product By Category Name")
    public void testGetProductByCatName() {
        assertThrows(Exception.class,()->adminDao.getProductsByCategoryName(""));
    }

    @Test
    @DisplayName("Test  Update Category Name")
    public void testUpdateCatName() {
        assertThrows(Exception.class,()->adminDao.updateCategoryName(0));
    }


    @Test
    @DisplayName("Test Get Categories")
    public void testGetCategories() throws SQLException {
        assertTrue(adminDao.getCategories().size()>0);
    }

    @Test
    @DisplayName("Test View all Customer Details ")
    public void testViewAllCustomerDetails() throws SQLException {
        assertTrue(adminDao.viewAllCustomerDetails().size()>0);
    }
}
