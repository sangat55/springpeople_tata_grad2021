package com.tata.shoppersden.dao;

import com.tata.shoppersden.helper.PostgresConnHelper;
import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import com.tata.shoppersden.models.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ShoppingCartImpl  implements ShoppingCartDao {

    private Connection conn;
    private PreparedStatement preCart;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    private ProductDao productDao;
    private CustomerDao customerDao;
    public ShoppingCartImpl()
    {
        conn = PostgresConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public List<ShoppingCart> displayCart() throws Exception {
        return displayCartItems();
    }



    public List<ShoppingCart> displayCartItems() throws Exception {
        List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
        String query = resourceBundle.getString("displayCart");
        preCart = conn.prepareStatement(query);
        resultSet = preCart.executeQuery();
        ShoppingCart shoppingCart = null;
        Product product = null;
        while(resultSet.next())
        {
            shoppingCart = new ShoppingCart();
            long productId = resultSet.getLong(1);
            long customerId = resultSet.getLong(6);
            productDao = new ProductDaoImpl();
            customerDao = new CustomerDaoImpl();
            Product productById = productDao.getProductById(productId);
            shoppingCart.setCustomer(customerDao.getCustomerById(customerId));
            shoppingCart.setProduct(productById);
            shoppingCart.setQuantity(resultSet.getInt(4));
            shoppingCart.setTempItemId(resultSet.getLong(5));
            shoppingCartList.add(shoppingCart);
        }
        if(shoppingCartList.size()==0)
        {
            throw new Exception("Cart is empty");
        }
        return shoppingCartList;
    }

}
