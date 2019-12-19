package com.bieganski.ox;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

@Test
public class FieldTest {
    @Test
    public void testFieldIsOnGivenCoordinates(){
        //Given
        Field field = new Field(new Coordinates(3, 3), Symbol.X);
        Coordinates coordinates = new Coordinates(3, 3);
        //When
        boolean isOnGivenCoordinates = field.isOnGivenCoordinates(coordinates);
        //Then
        assertTrue(isOnGivenCoordinates);
    }
    @Test
    public void testFieldIsNotOnGivenCoordinates(){
        //Given
        Field field = new Field(new Coordinates(3, 3), Symbol.X);
        Coordinates coordinates = new Coordinates(5, 5);
        //When
        boolean isOnGivenCoordinates = field.isOnGivenCoordinates(coordinates);
        //Then
        assertFalse(isOnGivenCoordinates);
    }

}
