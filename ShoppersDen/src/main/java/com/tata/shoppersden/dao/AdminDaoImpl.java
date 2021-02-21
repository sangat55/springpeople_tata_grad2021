package com.tata.shoppersden.dao;

import com.tata.shoppersden.helper.PostgresConnHelper;
import com.tata.shoppersden.models.*;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class AdminDaoImpl implements AdminDao {

    private Connection conn;
    private PreparedStatement pre,addPre,delPre,preCat,updateNamePre,updateDescPre,updateImagePre,updateDomPre,updatePricePre,CustomerPre,transPre,preById,preByName,preAllCategories,updatePre,adminPre;
    private ResourceBundle resourceBundle;
    private ResultSet resultSet;
    public AdminDaoImpl()
    {
        conn = PostgresConnHelper.getConnection();
        resourceBundle = ResourceBundle.getBundle("db");
    }

    @Override
    public boolean adminLogin(long adminId,String password) throws SQLException {
        return loginAdmin(adminId,password);
    }

    private boolean loginAdmin(long adminId,String password) throws SQLException {
        if(adminId==0 || password == "")
        {
            return false;
        }
        String admin = resourceBundle.getString("adminLogin");
        adminPre = conn.prepareStatement(admin);
        adminPre.setLong(1,adminId);
        adminPre.setString(2,password);
        resultSet = adminPre.executeQuery();
        if(resultSet.next())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public void addCategory(Category category) throws SQLException {
        addCategoryToDB(category);
    }

    private void addCategoryToDB(Category category) throws SQLException {
        if(category==null)
        {
            throw new NullPointerException("Category is null");
        }
        String addCategory = resourceBundle.getString("addCategory");
        preCat = conn.prepareStatement(addCategory);
        preCat.setLong(1,category.getCategoryId());
        preCat.setString(2,category.getCategoryName());
        preCat.executeUpdate();
    }

    @Override
    public void addProduct(Product product) throws SQLException {
        addProductToDB(product);

    }

    @Override
    public void deleteProduct(long productId) throws Exception {
        deleteProd(productId);
    }

    @Override
    public void updateProductName(long pid) throws Exception {
        updateProdName(pid);
    }

    @Override
    public void updateProductDescription(long pid) throws Exception {
        updateProdDescription(pid);
    }

    @Override
    public void updateProductPrice(long pid) throws Exception {
        updateProdPrice(pid);
    }

    @Override
    public void updateProductImage(long pid) throws Exception {
        updateProdImage(pid);
    }

    @Override
    public void updateProductDom(long pid) throws Exception {
        updateProdDom(pid);
    }

    @Override
    public List<Customer> viewAllCustomerDetails() throws SQLException {
        return viewAllCustomers();
    }

    @Override
    public List<Transactions> viewAllTransactionDetails() throws SQLException {
        return viewAllTransactions();
    }

    @Override
    public List<Product> getProductsByCategoryId(long cid) throws Exception {
        return getProductsByCatId(cid);
    }

    @Override
    public List<Product> getProductsByCategoryName(String name) throws Exception {
        return getProductsByCatName(name);
    }

    @Override
    public List<Category> getCategories() throws SQLException {
        return getAllCategories();
    }

    @Override
    public void updateCategoryName(long cid) throws Exception {
        updateCatName(cid);
    }

    private void updateCatName(long cid) throws Exception {
        if(cid==0)
        {
            throw new Exception("Category Id is zero");
        }
        String update = resourceBundle.getString("updateCategoryName");
        updatePre = conn.prepareStatement(update);

        System.out.println("Enter new Category Name");
        String name = new Scanner(System.in).nextLine();
        updatePre.setString(1,name);
        updatePre.setLong(2,cid);
        updatePre.executeUpdate();
    }

    private List<Category> getAllCategories() throws SQLException {
        List<Category> categoryList = new ArrayList<Category>();
        String getAll = resourceBundle.getString("getCategories");
        preAllCategories = conn.prepareCall(getAll);
        resultSet = preAllCategories.executeQuery();
        Category category = null;
        while(resultSet.next())
        {
            category = new Category();
            category.setCategoryId(resultSet.getLong(1));
            category.setCategoryName(resultSet.getString(2));
            categoryList.add(category);
        }
        return categoryList;
    }
    private List<Product> getProductsByCatId(long cid) throws Exception {
        if(cid==0)
        {
            throw new Exception("Category Id is Zero");
        }
        List<Product> productList = new ArrayList<Product>();
        String byCatId = resourceBundle.getString("getProductsByCategoryId");
        preById = conn.prepareStatement(byCatId);

        preById.setLong(1,cid);
        resultSet = preById.executeQuery();
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
            productList.add(product);
        }
        return productList;
    }

    private  List<Product> getProductsByCatName(String cname) throws Exception {
        if(cname=="")
        {
            throw new Exception("Category Name is Empty");
        }
        List<Product> productList = new ArrayList<Product>();
        String byCatName = resourceBundle.getString("getProductsByCategoryName");
        preByName = conn.prepareStatement(byCatName);

        preByName.setString(1,cname);
        resultSet = preByName.executeQuery();
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
            productList.add(product);
        }
        return productList;

    }

    private List<Transactions> viewAllTransactions() throws SQLException {
        String viewTrans = resourceBundle.getString("viewAllTransactions");
        List<Transactions> transactionsList = new ArrayList<Transactions>();
        transPre = conn.prepareStatement(viewTrans);
        resultSet = transPre.executeQuery();
        Transactions transactions = null;
        while(resultSet.next())
        {
            transactions = new Transactions();
            transactions.setTransactionId(resultSet.getLong(1));
            transactions.setTransactionDate(resultSet.getDate(2));
            transactions.setProductId(resultSet.getLong(3));
            transactions.setCustomerId(resultSet.getLong(4));
            transactionsList.add(transactions);

        }
        return transactionsList;

    }

    private List<Customer> viewAllCustomers() throws SQLException {
        List<Customer> customerList = new ArrayList<Customer>();
        String getCustomer = resourceBundle.getString("viewAllCustomers");
        CustomerPre = conn.prepareStatement(getCustomer);
        Customer customer = null;
        resultSet = CustomerPre.executeQuery();
        while(resultSet.next())
        {
            customer = new Customer();
            customer.setCustomerId(resultSet.getLong(1));
            customer.setCustomerName(resultSet.getString(2));
            customer.setAddress(resultSet.getString(3));
            customer.setEmailId(resultSet.getString(4));
            customer.setPassword(resultSet.getString(5));
            customer.setPhone(resultSet.getLong(6));
            customer.setSecurityQuestion(resultSet.getString(7));
            customer.setSecurityAnswer(resultSet.getString(8));
            customerList.add(customer);

        }
        return customerList;
    }

    private void updateProdPrice(long pid) throws Exception {
        if(pid==0)
        {
            throw new Exception("Product Id is zero");
        }
         String updatePrice = resourceBundle.getString("updateProductPrice");
         updatePricePre = conn.prepareStatement(updatePrice);

         System.out.println("Enter your new Product Price");
         double price = new Scanner(System.in).nextDouble();
         updatePricePre.setDouble(1,price);
         updatePricePre.setLong(2,pid);
         updatePricePre.executeUpdate();

     }

     private void updateProdImage(long pid) throws Exception {
         if(pid==0)
         {
             throw new Exception("Product Id is zero");
         }
         String updateImage = resourceBundle.getString("updateProductImage");
         updateImagePre = conn.prepareStatement(updateImage);

         System.out.println("Enter your new Product Image Path");
         String image = new Scanner(System.in).nextLine();
         updateImagePre.setString(1,image);
         updateImagePre.setLong(2,pid);
         updateImagePre.executeUpdate();
     }

     private void updateProdDom(long pid) throws Exception {
         if(pid==0)
         {
             throw new Exception("Product Id is zero");
         }
         String updateDom = resourceBundle.getString("updateProductDom");
         updateDomPre = conn.prepareStatement(updateDom);

         System.out.println("Enter your new Product DOM");
         String date = new Scanner(System.in).nextLine();
         updateDomPre.setDate(1, Date.valueOf(date));
         updateDomPre.setLong(2,pid);
         updateDomPre.executeUpdate();

     }
    private void updateProdDescription(long pid) throws Exception {
        if(pid==0)
        {
            throw new Exception("Product ID is zero");
        }
        String updateDesc = resourceBundle.getString("updateProductDescription");
        updateDescPre = conn.prepareStatement(updateDesc);

        System.out.println("Enter your new Product Description");
        String desc = new Scanner(System.in).nextLine();
        updateDescPre.setString(1,desc);
        updateDescPre.setLong(2,pid);
        updateDescPre.executeUpdate();
    }

    private void updateProdName(long pid) throws Exception {
        if(pid==0)
        {
            throw new Exception("Product Id is zero");
        }
        String updateProd = resourceBundle.getString("updateProductName");
        updateNamePre = conn.prepareStatement(updateProd);
        System.out.println("Enter your new Product Name");
        String name = new Scanner(System.in).nextLine();
        updateNamePre.setString(1,name);
        updateNamePre.setLong(2,pid);
        updateNamePre.executeUpdate();
    }



    private void deleteProd(long pid) throws Exception {
        if(pid==0)
        {
            throw new Exception("Product Id cannot be Zero");
        }
        String delProd = resourceBundle.getString("deleteProduct");
        delPre = conn.prepareStatement(delProd);

        delPre.setLong(1,pid);
        delPre.executeUpdate();
    }
    private void addProductToDB(Product product) throws SQLException {

        if(product == null)
        {
            throw new NullPointerException("Product is null");
        }
        System.out.println("Enter Category Id");
        long cid = new Scanner(System.in).nextLong();
        String addProduct = resourceBundle.getString("addProduct");
        addPre = conn.prepareStatement(addProduct);
        addPre.setLong(1,product.getProductId());
        addPre.setString(2,product.getProductName());
        addPre.setString(3,product.getDescription());
        addPre.setDouble(4,product.getPrice());
        addPre.setString(5,product.getProductImage());
        addPre.setDate(6, (Date) product.getDom());
        addPre.setLong(7,cid);
        addPre.executeUpdate();
    }
}
