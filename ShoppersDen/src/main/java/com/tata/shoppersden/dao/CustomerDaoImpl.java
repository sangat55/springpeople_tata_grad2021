package com.tata.shoppersden.dao;

import com.tata.shoppersden.business.LoginAction;
import com.tata.shoppersden.business.RegistrationAction;
import com.tata.shoppersden.helper.PostgresConnHelper;
import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import com.tata.shoppersden.models.ShoppingCart;
import org.apache.commons.lang3.RandomStringUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CustomerDaoImpl implements CustomerDao{

    private Connection conn;
    private PreparedStatement pre,addPre,getPre,preRandom,preRegister,preCart,preCustomer,prePassword,preName,preEmail,preAddress,prePhone,preSecurity,preRemove;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    private Customer customer = null;
    private ProductDao productDao;
    public CustomerDaoImpl()
    {
        conn = PostgresConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");
    }
    @Override
    public void registerUser(Customer customer) throws Exception {
        registerNewUser(customer);
    }

    @Override
    public void loginUser(long  userId ,String password) throws Exception {
        loginPage(userId,password);
    }

    @Override
    public void addToCart(long pid,long cid) throws SQLException {
        addCart(pid,cid);

    }

    @Override
    public void removeFromCart(long pid, long cid) throws SQLException {
        removeCart(pid,cid);
    }

    private void removeCart(long pid, long cid) throws SQLException {
        String remove = resourceBundle.getString("removeFromCart");
        preRemove = conn.prepareStatement(remove);
        preRemove.setLong(1,pid);
        preRemove.setLong(2,cid);
        preRemove.executeUpdate();

    }

    @Override
    public List<ShoppingCart> viewCart(long userId) throws SQLException {
        return viewCarts(userId);
    }

    private List<ShoppingCart> viewCarts(long userId) throws SQLException {
        List<ShoppingCart> shoppingCartList = new ArrayList<ShoppingCart>();
        ShoppingCart shoppingCart = null;
        String getCart = resourceBundle.getString("viewCart");
        preCart = conn.prepareStatement(getCart);
        preCart.setLong(1,userId);
        resultSet = preCart.executeQuery();
        while(resultSet.next())
        {
            shoppingCart = new ShoppingCart();
            shoppingCart.setCustomer(new CustomerDaoImpl().getCustomerById(resultSet.getLong(6)));
            shoppingCart.setTempItemId(resultSet.getLong(5));
            shoppingCart.setQuantity(resultSet.getInt(4));
            shoppingCart.setProduct(new ProductDaoImpl().getProductById(resultSet.getLong(1)));
            shoppingCartList.add(shoppingCart);
        }
        return shoppingCartList;
    }

    @Override
    public Customer getCustomerById(long id) throws SQLException {
        return getCustomerId(id);
    }

    @Override
    public long getRandomCustomerId() throws SQLException {
        return getRandomCustomer();
    }

    @Override
    public Customer viewProfile(long userId) throws SQLException {
        return viewCustomer(userId);
    }

    @Override
    public void forgetPassword(String pass,long userId) throws SQLException {
        forgetPass(pass,userId);
    }

    @Override
    public void changeName(String name,long userId) throws SQLException {
        changeCusName(name,userId);
    }

    private void changeCusName(String name, long userId) throws SQLException {
        String c_name = resourceBundle.getString("changeName");
        preName = conn.prepareStatement(c_name);
        preName.setString(1,name);
        preName.setLong(2,userId);
        preName.executeUpdate();
    }

    @Override
    public void changeAddress(String address,long userId) throws SQLException {
        changeCustomerAddress(address,userId);
    }

    private void changeCustomerAddress(String address, long userId) throws SQLException {
        String add  = resourceBundle.getString("changeAddress");
        preAddress = conn.prepareStatement(add);
        preAddress.setString(1,address);
        preAddress.setLong(2,userId);
        preAddress.executeUpdate();

    }

    @Override
    public void changeEmail(String email, long userId) throws SQLException {
        changeCustomerEmail(email,userId);
    }

    private void changeCustomerEmail(String email, long userId) throws SQLException {
        String e_mail = resourceBundle.getString("changeEmail");
        preEmail = conn.prepareStatement(e_mail);
        preEmail.setString(1,email);
        preEmail.setLong(2,userId);
        preEmail.executeUpdate();
    }

    @Override
    public void changePhone(long phone, long userId) throws SQLException {
        changeCustomerPhone(phone,userId);
    }

    private void changeCustomerPhone(long phone, long userId) throws SQLException {
        String phone_sql = resourceBundle.getString("changePhone");
        prePhone = conn.prepareStatement(phone_sql);
        prePhone.setLong(1,phone);
        prePhone.setLong(2,userId);
        prePhone.executeUpdate();
    }

    @Override
    public void changeSecurityQuestion(String question, String answer, long userId) throws SQLException {
        changeCustomerSecurity(question,answer,userId);
    }

    private void changeCustomerSecurity(String question, String answer, long userId) throws SQLException {
        String sec = resourceBundle.getString("changeSecurityQuestion");
        preSecurity = conn.prepareStatement(sec);
        preSecurity.setString(1,question);
        preSecurity.setString(2,answer);
        preSecurity.setLong(3,userId);
        preSecurity.executeUpdate();
    }


    private void forgetPass(String password,long userId) throws SQLException {
        String forget = resourceBundle.getString("forgetPassword");
        prePassword = conn.prepareStatement(forget);
        prePassword.setString(1,password);
        prePassword.setLong(2,userId);
        prePassword.executeUpdate();

    }
    private Customer viewCustomer(long userId) throws SQLException {
        Customer customer = new Customer();
        String cus = resourceBundle.getString("viewProfile");
        preCustomer = conn.prepareStatement(cus);
        preCustomer.setLong(1,userId);
        resultSet = preCustomer.executeQuery();
        if(resultSet.next())
        {
            customer.setCustomerId(resultSet.getLong(1));
            customer.setCustomerName(resultSet.getString(2));
            customer.setAddress(resultSet.getString(3));
            customer.setEmailId(resultSet.getString(4));
            customer.setPassword(resultSet.getString(5));
            customer.setPhone(resultSet.getLong(6));
            customer.setSecurityQuestion(resultSet.getString(7));
            customer.setSecurityAnswer(resultSet.getString(8));
        }
        return customer;

    }

    private long getRandomCustomer() throws SQLException {
        String randomCustomer = resourceBundle.getString("getRandomCustomerID");
        preRandom = conn.prepareStatement(randomCustomer);
        resultSet = preRandom.executeQuery();
        if(resultSet.next())
        {
            return resultSet.getLong(1);
        }
        return 0;
    }

    private Customer getCustomerId(long id) throws SQLException {
        String getCustomer = resourceBundle.getString("getCustomerById");
        Customer customer = new Customer();
        getPre = conn.prepareStatement(getCustomer);
        getPre.setLong(1,id);
        resultSet = getPre.executeQuery();
        if(resultSet.next())
        {
            customer.setCustomerId(resultSet.getLong(1));

        }
        return customer;

    }


    public void addCart(long pid, long cid) throws SQLException {
        String addCart = resourceBundle.getString("addToCart");
        Product product = new Product();
        productDao =  new ProductDaoImpl();
        product = productDao.getProductById(pid);
        addPre = conn.prepareStatement(addCart);
        addPre.setLong(1,product.getProductId());
        addPre.setString(2, product.getProductName());
        addPre.setDouble(3,product.getPrice());
        addPre.setInt(4,new Random().nextInt(100));
        addPre.setLong(5,new Random().nextInt(10000));
        addPre.setLong(6,cid);
        addPre.executeUpdate();
    }


    private void loginPage(long userId,String password) throws Exception {
        if(password == "" || userId == 0)
        {
            throw new Exception("Credential Not Valid");
        }
        else {
            if (checkIfValid(userId, password)) {
                System.out.println("Login Successful.  Enjoy your Shopping");
            } else {
                System.out.println("Please Register First");
                new RegistrationAction().registrationAction();

            }
        }
    }

    public boolean checkIfValid(long userId,String password) throws SQLException {
        if(userId ==0 || password == "")
        {
            return false;
        }
        String check = resourceBundle.getString("checkIfValid");
        pre = conn.prepareStatement(check);
        pre.setLong(1,userId);
        pre.setString(2,password);
        resultSet = pre.executeQuery();
        if(resultSet.next())
        {
            System.out.println("Welcome " + resultSet.getString(1));
            return true;
        }
        return false;
    }



    private void registerNewUser(Customer customer) throws Exception {

        if(customer==null)
        {
            throw new NullPointerException("Customer is Null");
        }

        if(checkIfUserExists(customer.getCustomerId()))
        {
            System.out.println("User Already Exists.Please Login!!!");
        }
        else
        {
            addUser(customer);
        }
    }
    public boolean checkIfUserExists(long id) throws SQLException {

        String check = resourceBundle.getString("checkIfUserExists");
        pre = conn.prepareStatement(check);
        pre.setLong(1,id);
        resultSet = pre.executeQuery();
        if(resultSet.next())
        {
            return true;
        }
        return false;
    }
    public void addUser(Customer customer) throws SQLException {
        if(customer == null)
        {
            throw  new NullPointerException("Customer is Null");
        }
        String registerNewUser = resourceBundle.getString("registerNewUser");
        preRegister = conn.prepareStatement(registerNewUser);
        preRegister.setLong(1,customer.getCustomerId());
        preRegister.setString(2,customer.getCustomerName());
        preRegister.setString(3,customer.getAddress());
        preRegister.setString(4, (customer.getEmailId()));
        preRegister.setString(5,customer.getPassword());
        preRegister.setLong(6,customer.getPhone());
        preRegister.setString(7,customer.getSecurityQuestion());
        preRegister.setString(8,customer.getSecurityAnswer());
        preRegister.executeUpdate();

    }




}
