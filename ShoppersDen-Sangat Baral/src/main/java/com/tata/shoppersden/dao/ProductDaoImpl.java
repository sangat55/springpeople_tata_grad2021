package com.tata.shoppersden.dao;

import com.tata.shoppersden.helper.PostgresConnHelper;
import com.tata.shoppersden.models.Product;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ProductDaoImpl implements ProductDao {

    private Connection conn;
    private PreparedStatement pre,getPreById,getPre,preRandom;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    public ProductDaoImpl()
    {
        conn = PostgresConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public Product getProductById(long id) throws SQLException {
        return getProdById(id);
    }

    public Product getProdById(long id) throws SQLException {
        if(id == 0)
        {
            return null;
        }
        String getById = resourceBundle.getString("getProductById");
        getPreById = conn.prepareStatement(getById);
        getPreById.setLong(1,id);
        resultSet = getPreById.executeQuery();
        Product product = null;
        if(resultSet.next())
        {
            product = new Product();
            product.setProductId(resultSet.getLong(1));
            product.setProductName(resultSet.getString(2));
            product.setDescription(resultSet.getString(3));
            product.setPrice(resultSet.getDouble(4));
            product.setProductImage(resultSet.getString(5));
            product.setDom(resultSet.getDate(6));

        }
        return product;

    }

    @Override
    public List<Product> viewProducts() throws SQLException {
        return viewAllProducts();
    }

    @Override
    public Product getProductByName(String name) throws SQLException {
        return getProduct(name);
    }

    @Override
    public long getRandomProductId() throws SQLException {
        return randomProductId();
    }
    private long randomProductId() throws SQLException {
        String randomProduct = resourceBundle.getString("getRandomProductID");
        preRandom = conn.prepareStatement(randomProduct);
        resultSet = preRandom.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getLong(1);
        }
        return 0;

    }


    private List<Product> viewAllProducts() throws SQLException {
        Product product;
        List<Product> productList = new ArrayList<Product>();
        String allProducts = resourceBundle.getString("viewAllProducts");
        pre = conn.prepareStatement(allProducts);
        resultSet = pre.executeQuery();
        while(resultSet.next())
        {
            product = new Product();
            product.setProductId(resultSet.getInt(1));
            product.setProductName(resultSet.getString(2));
            product.setDescription(resultSet.getString(3));
            product.setPrice(resultSet.getDouble(4));
            product.setProductImage(resultSet.getString(5));
            product.setDom(resultSet.getDate(6));
            productList.add(product);

        }
        return productList;
    }
    private Product getProduct(String name) throws SQLException {
        if(name == "")
        {
            return null;
        }
        String getProd = resourceBundle.getString("getProductByName");
        getPre = conn.prepareStatement(getProd);
        getPre.setString(1,name);
        resultSet = getPre.executeQuery();
        Product product = null;
        while(resultSet.next())
        {
            product = new Product();
            product.setProductId(resultSet.getLong(1));
            product.setProductName(resultSet.getString(2));
            product.setDescription(resultSet.getString(3));
            product.setPrice(resultSet.getDouble(4));
            product.setProductImage(resultSet.getString(5));
            product.setDom(resultSet.getDate(6));

        }
        return product;
    }
    public Product createProduct()
    {
        Product product = new Product();
        product.setProductId(new Random().nextInt(10000000));
        product.setProductName(RandomStringUtils.randomAlphabetic(10,20));
        product.setDescription(RandomStringUtils.randomAlphabetic(20,50));
        product.setPrice(new Random().nextInt(10000));
        product.setProductImage(RandomStringUtils.randomAlphabetic(5,10)+"/" + RandomStringUtils.randomAlphabetic(5,10) + "/");
        product.setDom(Date.valueOf(LocalDate.now()));
        return product;
    }
}
