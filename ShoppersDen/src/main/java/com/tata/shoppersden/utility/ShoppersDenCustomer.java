package com.tata.shoppersden.utility;

import com.tata.shoppersden.business.*;
import com.tata.shoppersden.dao.*;
import com.tata.shoppersden.models.Customer;
import com.tata.shoppersden.models.Product;
import com.tata.shoppersden.models.Transactions;

import java.sql.SQLException;
import java.util.Scanner;

public class ShoppersDenCustomer {
    Scanner scan = new Scanner(System.in);
    private CustomerDao customerDao;
    private TransactionDao transactionDao;
    private ProductDao productDao;
    private Product product;
    private Customer customer;
    private AddToCartAction addToCartAction;
    private PlaceOrderAction placeOrderAction;
    private ForgetPasswordAction forgetPasswordAction;
    private UpdateCustomerNameAction updateCustomerNameAction;
    private UpdateCustomerAddressAction updateCustomerAddressAction;
    private UpdateCustomerEmailAction updateCustomerEmailAction;
    private UpdateCustomerPhoneAction updateCustomerPhoneAction;
    private RemoveFromCartAction removeFromCartAction;
    private CancelOrderAction cancelOrderAction;

    public void shopperDenCustomer() throws Exception {

        customerDao = new CustomerDaoImpl();
        transactionDao = new TransactionDaoImpl();
        productDao = new ProductDaoImpl();
        addToCartAction = new AddToCartAction();
        placeOrderAction = new PlaceOrderAction();
        forgetPasswordAction= new ForgetPasswordAction();
        updateCustomerNameAction = new UpdateCustomerNameAction();
        updateCustomerAddressAction =  new UpdateCustomerAddressAction();
        updateCustomerEmailAction = new UpdateCustomerEmailAction();
        updateCustomerPhoneAction = new UpdateCustomerPhoneAction();
        removeFromCartAction = new RemoveFromCartAction();
        cancelOrderAction = new CancelOrderAction();
        customer = new Customer();
        loop: while(true) {
            System.out.println("Welcome to Shopper's Den!!!!!!!");
            System.out.println("Returning User - 1 ");
            System.out.println("New User - 2");
            System.out.println("Exit - 0");
            int choose = scan.nextInt();

            switch (choose) {
                case 0:

                    break loop;
                case 1:
                    System.out.println("Enter your UserID");
                    long userId = scan.nextLong();
                    System.out.println("Enter your Password");
                    String password = scan.next();
                    new LoginAction().loginAction(userId, password);
                    customerFunctionality(userId);
                    break;
                case 2:
                    new RegistrationAction().registrationAction();
                    break;
                default:
                    break;

            }
        }

    }
    public void customerFunctionality(long userId) throws Exception {
        if(userId == 0)
        {
            throw new Exception("Customer ID Cannot Be Zero");
        }

        loop: while (true) {
            System.out.println("****************Menu**************");
            System.out.println("Add to Cart-1 \t Place Order-2 \t Search Products By Id-3");
            System.out.println("Search Product By Name-4 \t View Profile-5");
            System.out.println("Search Products By Category Name-6");
            System.out.println("Forget Password-7 \t Change Name-8 ");
            System.out.println("Change Address-9 \t Change Phone-10 ");
            System.out.println("Change Email-11 \t Change Security-12");
            System.out.println("View Orders - 13 \t Remove From Cart-14");
            System.out.println("Cancel Order-15 \t Log out - 0");
            int choose = scan.nextInt();

            switch (choose) {
                case 0:
                    System.out.println("Logout Successful");
                    break loop;
                case 1:
                    System.out.println("Enter Product Id");
                    long pid = scan.nextLong();
                    //customerDao.addToCart(pid, userId);
                    addToCartAction.addToCartAction(pid,userId);
                    break;

                case 2:
                    System.out.println("Enter Product Id");
                    long pid1 = scan.nextLong();
                    //transactionDao.addTransaction(pid1, userId);
                    placeOrderAction.placeOrderAction(pid1,userId);
                    break;
                case 3:
                    System.out.println("Enter Product Id");
                    long pid2 = scan.nextLong();
                    product = productDao.getProductById(pid2);
                    System.out.println(product);
                    break;
                case 4:
                    System.out.println("Enter Product Name");
                    String pname = new Scanner(System.in).nextLine();
                    product = productDao.getProductByName(pname);
                    System.out.println(product);
                    break;

                case 5:
                    customer = customerDao.viewProfile(userId);
                    System.out.println(customer);
                    break;
                case 6:
                    System.out.println("Enter Category Name");
                    String cname1 = new Scanner(System.in).nextLine();
                    for(Product product : new AdminDaoImpl().getProductsByCategoryName(cname1))
                    {
                        System.out.println(product);
                    }
                    break;
                case 7:
                    System.out.println("Enter new Password");

                    String pass1 = scan.next();
                    System.out.println("Confirm Password");

                    String pass2 = scan.next();
                    if(pass1==pass2)
                    {
                        //customerDao.forgetPassword(pass1,userId);
                        forgetPasswordAction.forgetPasswordAction(pass1,userId);
                    }
                    break;
                case 8:
                    System.out.println("Enter new Username");
                    scan.nextLine();
                    String user_name = scan.nextLine();
                    //customerDao.changeName(user_name,userId);
                    updateCustomerNameAction.updateCustomerName(user_name,userId);
                    break;
                case 9:
                    System.out.println("Enter new Address");
                    scan.nextLine();
                    String address = scan.nextLine();
                    //customerDao.changeAddress(address,userId);
                    updateCustomerAddressAction.updateCustomerAddress(address,userId);
                    break;
                case 10:
                    System.out.println("Enter new phone");
                    long phone = scan.nextLong();
                    //customerDao.changePhone(phone,userId);
                    updateCustomerPhoneAction.updateCustomerPhone(phone,userId);
                    break;
                case 11:
                    System.out.println("Enter new Email");
                    scan.nextLine();
                    String email = scan.nextLine();
                    //customerDao.changeEmail(email,userId);
                    updateCustomerEmailAction.updateCustomerEmail(email,userId);
                    break;
                case 12:
                    System.out.println("Enter New Security question");
                    scan.nextLine();
                    String question = scan.nextLine();
                    System.out.println("Enter new Security Answer");
                    String answer = scan.nextLine();
                    customerDao.changeSecurityQuestion(question,answer,userId);
                    break;
                case 13:
                    for(Transactions transactions:transactionDao.viewTransactionByCustomerId(userId)) {
                        System.out.println(transactions);
                    }
                    break;
                case 14:
                    System.out.println("Enter Product Id");
                    long pid3 = scan.nextLong();
                    removeFromCartAction.removeFromCart(pid3,userId);
                    break;
                case 15:
                    System.out.println("Enter Order Id");
                    long orderID = scan.nextLong();
                    cancelOrderAction.cancelOrder(orderID);
                    break;
            }
        }
    }
}
