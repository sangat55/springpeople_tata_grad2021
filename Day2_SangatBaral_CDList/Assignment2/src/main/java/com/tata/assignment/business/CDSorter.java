package com.tata.assignment.business;

import com.tata.assignment.models.CD;

import java.util.Comparator;

public class CDSorter implements Comparator<CD> {

    @Override
    public int compare(CD o1, CD o2) {
        return o1.getSinger().compareTo(o2.getSinger());
    }
}
