package com.tata.shoppersden.utility;


import com.tata.shoppersden.business.*;
import com.tata.shoppersden.dao.*;
import com.tata.shoppersden.models.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class ShoppersDenAdmin {
    private AdminDao adminDao;
    private Category category;
    private Product product;
    private ShoppingCartDao shoppingCartDao;
    private CustomerDao customerDao;
    private ProductDao productDao;
    private TransactionDao transactionDao;
    private AddCategoryAction addCategoryAction;
    private AddProductAction addProductAction;
    private DeleteProductAction deleteProductAction;
    private UpdateCategoryNameAction updateCategoryNameAction;
    private UpdateProductNameAction updateProductNameAction;
    private UpdateProductPriceAction updateProductPriceAction;
    private UpdateProductDescAction updateProductDescAction;
    private UpdateProductImageAction updateProductImageAction;
    private UpdateProductDomAction updateProductDomAction;
    Scanner scan = new Scanner(System.in);
    public void shoppersDenAdmin() throws Exception {

        adminDao = new AdminDaoImpl();
        productDao = new ProductDaoImpl();
        transactionDao = new TransactionDaoImpl();
        addCategoryAction = new AddCategoryAction();
        addProductAction = new AddProductAction();
        deleteProductAction = new DeleteProductAction();
        updateCategoryNameAction = new UpdateCategoryNameAction();
        updateProductNameAction = new UpdateProductNameAction();
        updateProductPriceAction = new UpdateProductPriceAction();
        updateProductDomAction = new UpdateProductDomAction();
        updateProductImageAction = new UpdateProductImageAction();
        updateProductDescAction = new UpdateProductDescAction();
        System.out.println("Enter AdminId");
        long adminId = scan.nextLong();
        System.out.println("Enter your password");

        String password = scan.next();
        if(adminDao.adminLogin(adminId,password))
        {
            System.out.println("Welcome to Admin Page");
            adminFunctions();

        }
        else
        {
            System.out.println("Invalid Credentials");
        }

    }

    public void adminFunctions() throws Exception {

        loop: while(true) {
            System.out.println("*************************Menu*********************");
            System.out.println("Select any one Functionality");
            System.out.println("Add Category-1 \t Add Product-2 \t Delete Product-3");
            System.out.println("Display Cart-4 \t Display Cart By CustomerId-5");
            System.out.println("Update Category Name-6 \t Update Product Name-7");
            System.out.println("Update Product Image-8 \t Update Product Desc-9");
            System.out.println("Update Product DOM-10 \t Update Product Price-11");
            System.out.println("View All Categories-12 \t View All Customer-13");
            System.out.println("View All Transactions-14 \t View Products By Id-15");
            System.out.println("View Products By CategoryId-16 \t View Products By CategoryName-17");
            System.out.println("View Products By Name-18 \t View Transactions by Customer Id-19");
            System.out.println("View Transactions by Product ID -20 \t View All Products-21");
            System.out.println("Logout -0");
            int choice = scan.nextInt();
            switch (choice) {
                case 0:
                    break loop;
                case 1:
                    category = new Category();
                    System.out.println("Enter category Id");
                    long cid = scan.nextLong();
                    System.out.println("Enter category Name");
                    scan.nextLine();
                    String cname = scan.nextLine();
                    category.setCategoryId(cid);
                    category.setCategoryName(cname);
                    //adminDao.addCategory(category);
                    addCategoryAction.addCategoryAction(category);
                    break;
                case 2:
                    product = new Product();
                    System.out.println("Enter Product ID");
                    product.setProductId(scan.nextLong());
                    System.out.println("Enter Product Name");
                    scan.nextLine();
                    product.setProductName(scan.nextLine());
                    System.out.println("Enter Product Desc");
                    product.setDescription(scan.nextLine());
                    System.out.println("Enter Product Price");
                    product.setPrice(scan.nextDouble());
                    System.out.println("Enter Product Image");
                    scan.nextLine();
                    product.setProductImage(scan.nextLine());
                    System.out.println("Enter Product DOM");

                    product.setDom(Date.valueOf(scan.nextLine()));
                    //adminDao.addProduct(product);
                    addProductAction.addProductAction(product);
                    break;

                case 3:
                    System.out.println("Enter Product Id");
                    long pid = scan.nextLong();
                    //adminDao.deleteProduct(pid);
                    deleteProductAction.deleteProductAction(pid);
                    break;

                case 4:
                    shoppingCartDao = new ShoppingCartImpl();
                    List<ShoppingCart> shoppingCartList;
                    shoppingCartList = shoppingCartDao.displayCart();
                    for (ShoppingCart shoppingCart : shoppingCartList) {
                        System.out.println("Product ID: " + shoppingCart.getProduct().getProductId());
                        System.out.println("Product Name: " + shoppingCart.getProduct().getProductName());
                        System.out.println("Product Price: " + shoppingCart.getProduct().getPrice());
                        System.out.println("Product Quantity: " + shoppingCart.getQuantity());
                        System.out.println("Product Temp ID: " + shoppingCart.getTempItemId());
                        System.out.println("________________________________________");
                    }
                    break;

                case 5:
                    customerDao = new CustomerDaoImpl();
                    List<ShoppingCart> shoppingCartList1;
                    System.out.println("Enter Customer Id");
                    long cid1 = scan.nextLong();
                    shoppingCartList1 = customerDao.viewCart(cid1);
                    for (ShoppingCart shoppingCart : shoppingCartList1) {
                        System.out.println("Product ID: " + shoppingCart.getProduct().getProductId());
                        System.out.println("Product Name: " + shoppingCart.getProduct().getProductName());
                        System.out.println("Product Price: " + shoppingCart.getProduct().getPrice());
                        System.out.println("Product Quantity: " + shoppingCart.getQuantity());
                        System.out.println("Product Temp ID: " + shoppingCart.getTempItemId());
                        System.out.println("__________________________________________");
                    }
                    break;
                case 6:
                    System.out.println("Enter Category Id");
                    long cid2 = new Scanner(System.in).nextLong();
                    //adminDao.updateCategoryName(cid2);
                    updateCategoryNameAction.updateCategoryNameAction(cid2);
                    break;
                case 7:
                    System.out.println("Enter the product Id");
                    long pid1 = new Scanner(System.in).nextLong();
                    //adminDao.updateProductName(pid1);
                    updateProductNameAction.updateProductName(pid1);
                    break;
                case 8:
                    System.out.println("Enter the product id");
                    long pid2 = new Scanner(System.in).nextLong();
                    updateProductImageAction.updateProductImage(pid2);
                    //adminDao.updateProductImage(pid2);
                    break;
                case 9:
                    System.out.println("Enter the product id");
                    long pid3 = new Scanner(System.in).nextLong();
                    //adminDao.updateProductDescription(pid3);
                    updateProductDescAction.updateProductDesc(pid3);
                    break;
                case 10:
                    System.out.println("Enter the product id");
                    long pid4 = new Scanner(System.in).nextLong();
                    //adminDao.updateProductDom(pid4);
                    updateProductDomAction.updateProductDom(pid4);
                    break;
                case 11:
                    System.out.println("Enter the product id");
                    long pid5 = new Scanner(System.in).nextLong();
                    updateProductPriceAction.updateProductPrice(pid5);
                    //adminDao.updateProductPrice(pid5);
                    break;
                case 12:
                    for (Category category : adminDao.getCategories()) {
                        System.out.println(category);
                    }
                    break;
                case 13:
                    List<Customer> customerList = adminDao.viewAllCustomerDetails();
                    for (Customer customer : customerList) {
                        System.out.println(customer);
                    }
                    break;
                case 14:
                    List<Transactions> transactionsList = adminDao.viewAllTransactionDetails();
                    for (Transactions transactions : transactionsList) {
                        System.out.println(transactions);
                    }
                    break;
                case 15:
                    System.out.println("Enter Product Id");

                    long pid6 = scan.nextLong();
                    product = productDao.getProductById(pid6);
                    System.out.println(product);
                    break;
                case 16:
                    System.out.println("Enter Category Id");
                    long cid10 = new Scanner(System.in).nextLong();

                    for (Product product : adminDao.getProductsByCategoryId(cid10)) {
                        System.out.println(product);
                    }
                    break;
                case 17:
                    System.out.println("Enter Category Name");

                    String cname1 = new Scanner(System.in).nextLine();
                    for (Product product : adminDao.getProductsByCategoryName(cname1)) {
                        System.out.println(product);
                    }
                    break;
                case 18:
                    System.out.println("Enter Product Name");
                    scan.nextLine();
                    String pname = scan.nextLine();
                    product = productDao.getProductByName(pname);
                    System.out.println(product);
                    break;
                case 19:
                    System.out.println("Enter Customer id");
                    long cid20 = scan.nextLong();
                    for (Transactions transactions : transactionDao.viewTransactionByCustomerId(cid20)) {
                        System.out.println(transactions);
                    }
                    break;
                case 20:
                    System.out.println("Enter Product id");
                    long pid20 = scan.nextLong();
                    for (Transactions transactions : transactionDao.viewTransactionByProductId(pid20)) {
                        System.out.println(transactions);
                    }
                    break;
                case 21:

                    for (Product product : productDao.viewProducts()) {
                        System.out.println(product);
                    }
            }

        }
    }


}
