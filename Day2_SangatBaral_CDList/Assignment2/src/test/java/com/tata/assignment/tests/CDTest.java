package com.tata.assignment.tests;

import com.tata.assignment.models.CD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CDTest {
    private CD cd1,cd2;

    @BeforeEach
    @DisplayName("CD id to be Unique")
    public void getInstance()
    {
        cd1 = new CD();
        cd1.setSingerId(new Random().nextInt(10000));
        cd2 = new CD();
        cd2.setSingerId(new Random().nextInt(10000));
    }

    @Test
    public void testCDIdUnique()
    {
        assertNotEquals(cd1.getSingerId(),cd2.getSingerId());
    }

    @ParameterizedTest
    @CsvFileSource(resources = "./resources/CDdata.csv", numLinesToSkip = 1)
    void testWithCsvFileSource(int singerId , String title,String singer)
    {
        assertTrue(singerId>0);
    }
    @Test
    @DisplayName("Test whether generated CDs are sorted")
    public void testCdTitleUnique()
    {
        CDList cdL = new CDListImpl();
        List<CD> cdList = cdL.getCDList();
        List<CD> cdList1,cdList2;
        cdList1 = new ArrayList<>(cdList);
        cdList1.stream().sorted((o1,o2)->o1.getSinger().compareTo(o2.getSinger()));
        cdList2 = new ArrayList<>(cdList);
        CDApp cdApp = new CDApp();
        cdList2 = Collections.sort(cdList,new CDSorter());
        assertEquals(cdList1,cdList2);
    }
}
