package com.tata.shoppersden.utility;

import java.util.Scanner;

public class ShoppersDenApp {

    public static void main(String[] args) throws Exception {
        ShoppersDenCustomer shoppersDenCustomer = new ShoppersDenCustomer();
        ShoppersDenAdmin shoppersDenAdmin = new ShoppersDenAdmin();
        Scanner scan = new Scanner(System.in);
        loop: while(true) {
            System.out.println("Welcome to Shopper's Den!!!!!!!");
            System.out.println("ADMIN - 1 ");
            System.out.println("CUSTOMER - 2");
            System.out.println("Exit - 0");
            int choose = scan.nextInt();
            switch (choose) {
                case 0:
                    break loop;
                case 1:
                    shoppersDenAdmin.shoppersDenAdmin();
                    break;
                case 2:
                    shoppersDenCustomer.shopperDenCustomer();
                    break;
                default:
                    break;

            }
        }

    }
}
