package com.tata.worker;

public class SalariedWorker extends Worker {

    public float Pay(int hours)
    {
        return getSalaryRate()*hours;
    }


}
