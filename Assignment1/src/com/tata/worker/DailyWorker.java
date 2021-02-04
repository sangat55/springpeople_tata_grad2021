package com.tata.worker;

public class DailyWorker extends  Worker{

    public float Pay(int hours)
    {
        return getSalaryRate()*hours/24;
    }
}
