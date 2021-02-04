package com.tata.shopkeeper;
import java.util.*;
public class ShopApp {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        Shopkeeper shopkeeper = new Shopkeeper();
        while(true)
        {
            System.out.println("If you want to exit: Please mention Product number as 0");
            System.out.println("Enter product number: ");
            int id = scan.nextInt();
            if(id==0)
            {
                break;
            }
            shopkeeper.setProductNo(id);
            System.out.println("Enter Quantity: ");
            shopkeeper.setQuantity(scan.nextInt());
            int no = shopkeeper.getProductNo();
            int num = 0;
            float retail = 0;
            switch (no)
            {

                case 1:
                    num = no;
                    retail = (float) shopkeeper.getQuantity() * 22.5f;
                    break;
                case 2:
                    num = no;
                    retail = (float) shopkeeper.getQuantity() * 44.5f;
                    break;
                case 3:
                    num = no;
                    retail = (float) shopkeeper.getQuantity() * 9.98f;
                    break;

            }
            System.out.println("Total retail price of Product " + num + " is: " + retail);
        }





    }
}
