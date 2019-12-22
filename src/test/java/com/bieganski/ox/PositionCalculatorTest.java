package com.bieganski.ox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PositionCalculatorTest {
    @Test
    public void testCalculateProperValue() {
        //Given
        PositionCalculator positionCalculator = new PositionCalculator(10);
        int expected = 33; //row * size + column
        //When
        int actual = positionCalculator.calculatePosition("3 3");
        //Then
        Assert.assertEquals(actual, expected,
                String.format("Actual value: %s isn't equals expected value: %s", actual, expected));
    }
}