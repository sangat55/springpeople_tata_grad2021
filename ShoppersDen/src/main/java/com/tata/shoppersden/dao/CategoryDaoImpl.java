package com.tata.shoppersden.dao;

import com.tata.shoppersden.helper.PostgresConnHelper;
import com.tata.shoppersden.models.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CategoryDaoImpl implements CategoryDao  {
    private Connection conn;
    private PreparedStatement preRandom;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    public CategoryDaoImpl()
    {
        conn = PostgresConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");
    }
    @Override
    public long getRandomCategoryId() throws SQLException {
        return getRandomId();
    }
    private long getRandomId() throws SQLException {
        String getRandom = resourceBundle.getString("getRandomCategoryId");
        preRandom = conn.prepareStatement(getRandom);
        resultSet = preRandom.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getLong(1);
        }
        return 0;
    }
}
