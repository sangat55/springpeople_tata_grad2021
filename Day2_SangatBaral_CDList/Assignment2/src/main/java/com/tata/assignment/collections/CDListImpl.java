package com.tata.assignment.collections;

import com.tata.assignment.models.CD;

import java.util.*;

public class CDListImpl implements  CDList{
    @Override
    public List<CD> getCDList() {
        return getData();
    }
    public List<CD> getData()
    {
        Scanner scan = new Scanner(System.in);
        List<CD> cdList = new ArrayList<CD>();
        Set<Long> cdIdSet = new HashSet<Long>();
        CD cd = null;
        System.out.println("Enter the number of entries");
        int n = scan.nextInt();
        for(int i=0;i<n*2;i++)
        {
            cdIdSet.add((long) new Random().nextInt(10000));
        }
        Object[] objects = cdIdSet.toArray();
        for(int i=0;i<n;i++)
        {
            cd = new CD();
            long id = (Long) objects[i];
            System.out.println("Singer Id is: "+ id);
            cd.setSingerId(id);
            System.out.println("Enter Song name: ");
            cd.setTitle(scan.next());
            System.out.println("Enter Singer's name:");
            cd.setSinger(scan.next());
            cdList.add(cd);
        }
        return cdList;
    }
}
