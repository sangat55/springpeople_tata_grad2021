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
}
