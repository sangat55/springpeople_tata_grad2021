package com.tata.shoppersden.tests;

import com.tata.shoppersden.dao.CategoryDao;
import com.tata.shoppersden.dao.CategoryDaoImpl;
import com.tata.shoppersden.models.Category;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLException;
import java.util.Random;

public class CategoryDaoTest {

    private Category category,category1;
    private CategoryDao  categoryDao;

    @BeforeEach
    public void setUp() throws SQLException {
        categoryDao = new CategoryDaoImpl();
        long id = categoryDao.getRandomCategoryId();
        category = new Category();
        category.setCategoryName(RandomStringUtils.randomAlphabetic(10,20));
        category.setCategoryId(new Random().nextInt(100000));
        category1 = new Category();
        category1.setCategoryId(new Random().nextInt(100000));
        category1.setCategoryName(RandomStringUtils.randomAlphabetic(10,20));

    }
    @Test
    @DisplayName("Category ID And Category Name should be unique")
    public void testCategoryIdAndCatName()
    {
        assertFalse(category.getCategoryId()== category1.getCategoryId());
        assertFalse(category.getCategoryName()==category1.getCategoryName());
    }

    @Test
    @DisplayName("Category ID should be non zero")
    public void testCategoryId()
    {
        assertTrue(category.getCategoryId()>0);

    }

    @Test
    @DisplayName("Category Name should not be empty")
    public void testCategoryName()
    {
        assertFalse(category.getCategoryName()== "");

    }
}
