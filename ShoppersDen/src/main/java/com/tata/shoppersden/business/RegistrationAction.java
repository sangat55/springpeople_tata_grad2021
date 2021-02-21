package com.tata.shoppersden.business;

import com.tata.shoppersden.dao.CustomerDao;
import com.tata.shoppersden.dao.CustomerDaoImpl;
import com.tata.shoppersden.models.Customer;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;
import java.util.Scanner;


public class RegistrationAction {

    public Customer createCustomer()
    {
        Customer customer = new Customer();
        customer.setCustomerId(new Random().nextInt(100000));
        customer.setCustomerName(RandomStringUtils.randomAlphabetic(10,20));
        customer.setAddress(RandomStringUtils.randomAlphabetic(10,20));
        customer.setEmailId(RandomStringUtils.randomAlphabetic(5,10)+ "@gmail.com");
        customer.setPassword(RandomStringUtils.randomAlphabetic(8,15));
        customer.setPhone(999999999+new Random().nextInt(10000000));
        customer.setSecurityQuestion(RandomStringUtils.randomAlphabetic(30,40));
        customer.setSecurityAnswer(RandomStringUtils.randomAlphabetic(5,20));
        return customer;
    }

    public void registrationAction() throws Exception {
        Scanner scan = new Scanner(System.in);
        Customer customer = new Customer();
        long cid = 2000+ new Random().nextInt(1000);

        customer.setCustomerId(cid);
        System.out.println("Enter Customer Name");
        customer.setCustomerName(scan.nextLine());
        System.out.println("Enter Customer Address");

        customer.setAddress(scan.nextLine());
        System.out.println("Enter customer email");

        customer.setEmailId(scan.nextLine());
        System.out.println("Enter Customer Password");

        customer.setPassword(scan.nextLine());
        System.out.println("Enter Customer Phone");
        customer.setPhone(scan.nextLong());
        System.out.println("Enter Security Question");
        scan.nextLine();
        customer.setSecurityQuestion(scan.nextLine());
        System.out.println("Enter Security Answer");
        customer.setSecurityAnswer(scan.nextLine());
        System.out.println("Your Customer ID is " + cid);
        CustomerDao customerDao = new CustomerDaoImpl();
        customerDao.registerUser(customer);
    }

}
