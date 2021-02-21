package com.tata.shoppersden.dao;

import com.tata.shoppersden.models.Category;

import java.sql.SQLException;

public interface CategoryDao {
    public long getRandomCategoryId() throws SQLException;
}
