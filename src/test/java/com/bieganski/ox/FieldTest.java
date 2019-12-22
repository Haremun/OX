package com.bieganski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class FieldTest {

    @Test
    public void testFieldIsOnGivenCoordinates() {
        //Given
        Field field = new Field(3, Symbol.X);
        //When
        boolean isOnGivenCoordinates = field.isOnPosition(3);
        //Then
        assertTrue(isOnGivenCoordinates);
    }

    @Test
    public void testFieldIsNotOnGivenCoordinates() {
        //Given
        Field field = new Field(3, Symbol.X);
        //When
        boolean isOnGivenCoordinates = field.isOnPosition(5);
        //Then
        assertFalse(isOnGivenCoordinates);
    }

}
