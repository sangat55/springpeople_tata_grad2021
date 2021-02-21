package com.tata.shoppersden.tests;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.ShoppingCartDao;
import com.tata.shoppersden.dao.ShoppingCartImpl;
import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import com.tata.shoppersden.models.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLException;
import java.util.List;
import java.util.Random;

public class ShoppingCartDaoTest {


    private ShoppingCartDao shoppingCartDao;
    private ShoppingCart shoppingCart;
    List<ShoppingCart> shoppingCartList;

    @BeforeEach
    public void setUp() throws Exception {
        shoppingCart = new ShoppingCart();
        shoppingCart.setProduct(new Product());
        shoppingCart.setCustomer(new Customer());
        shoppingCart.setQuantity(new Random().nextInt(10000));
        shoppingCart.setTempItemId(new Random().nextInt(100000));
        shoppingCartDao = new ShoppingCartImpl();

    }




    @Test
    @DisplayName("Quantity Cannot be Zero")
    public void testShoppingCartQuantity()
    {
        assertFalse(shoppingCart.getQuantity()==0);
    }

    @Test
    @DisplayName("Temp ID Cannot be Zero")
    public void testShoppingCartTempId()
    {
        assertTrue(shoppingCart.getTempItemId()>0);
    }
}
