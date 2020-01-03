package com.bieganski.ox.ui;

import com.bieganski.ox.ui.PositionCalculator;
import com.bieganski.ox.ui.PositionValidator;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PositionCalculatorTest {
    @DataProvider
    public Object[] badValues() {
        return new Object[]{
                "1",
                "100",
                "k",
                " ",
                "\n",
                "$",
                "12 13 14",
                "1 2 3 4",
                "   ",
                "_",
                "\t"
        };
    }

    @Test
    public void testCalculateProperValue() {
        //Given
        PositionCalculator positionCalculator = new PositionCalculator(new PositionValidator(), 10);
        int expected = 33; //row * size + column
        //When
        int actual = positionCalculator.parseInt("3 3");
        //Then
        Assert.assertEquals(actual, expected);
    }
}