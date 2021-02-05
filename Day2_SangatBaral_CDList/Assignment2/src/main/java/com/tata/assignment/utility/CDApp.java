package com.tata.assignment.utility;

import com.tata.assignment.business.CDSorter;
import com.tata.assignment.collections.CDList;
import com.tata.assignment.collections.CDListImpl;
import com.tata.assignment.models.CD;

import java.util.Collections;
import java.util.List;

public class CDApp {
    public static void main(String args[])
    {
        CDList cdL = new CDListImpl();
        List<CD> cdList  = cdL.getCDList();
        for(CD cd : cdList)
        {
            System.out.println(cd);
        }
        System.out.println();
        Collections.sort(cdList,new CDSorter());
        for(CD cd: cdList)
        {
            System.out.println(cd);
        }
    }
}
