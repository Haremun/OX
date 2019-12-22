package com.bieganski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class PositionValidatorTest {

    @DataProvider
    public Object[] properValues() {
        return new Object[]{
                "12 13",
                "100 1",
                "1 0",
                "0 1",
                "0 0",
                "1 1",
                "10 10"
        };
    }

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

    @Test(dataProvider = "properValues")
    public void testValidationShouldPass(String properValue) {
        //Given
        PositionValidator positionValidator = new PositionValidator();
        //When
        boolean isValidated = positionValidator.checkString(properValue);
        //Then
        assertTrue(isValidated, String.format("Text: %s should pass!", properValue));
    }

    @Test(dataProvider = "badValues")
    public void testValidationShouldNotPass(String badValue) {
        //Given
        PositionValidator positionValidator = new PositionValidator();
        //When
        boolean isValidated = positionValidator.checkString(badValue);
        //Then
        assertFalse(isValidated, String.format("Text: %s shouldn't pass!", badValue));
    }
}