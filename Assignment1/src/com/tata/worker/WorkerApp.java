package com.tata.worker;

import java.util.Scanner;

public class WorkerApp {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        Worker dailyworker = new DailyWorker();
        System.out.println("Enter Daily Worker name: ");
        dailyworker.setName(scan.next());
        System.out.println("Enter Rate Per Day: ");
        dailyworker.setSalaryRate(scan.nextFloat());
        System.out.println("Enter number of hours: ");
        System.out.println("Salary of DailyWorker for a Week: " + dailyworker.Pay(scan.nextInt()));


        Worker salariedWorker = new SalariedWorker();
        System.out.println("Enter Salaried Worker name: ");
        salariedWorker.setName(scan.next());
        System.out.println("Enter Rate Per Hour");
        salariedWorker.setSalaryRate(scan.nextFloat());
        System.out.println("Enter number of Hours: 40 ");
        System.out.println("Salary of Salaried Worker for a Week: " + salariedWorker.Pay(40));





    }
}
