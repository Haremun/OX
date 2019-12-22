package com.bieganski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class FieldTest {

    @DataProvider
    public Object[] positionProvider() {
        return IntStream.rangeClosed(0, 1000).boxed().toArray();
    }

    @Test(dataProvider = "positionProvider")
    public void testFieldIsOnGivenCoordinates(int position) {
        //Given
        Field field = new Field(position, Symbol.X);
        //When
        boolean isOnGivenCoordinates = field.isOnPosition(position);
        //Then
        assertTrue(isOnGivenCoordinates);
    }

    @Test(dataProvider = "positionProvider")
    public void testFieldIsNotOnGivenCoordinates(int position) {
        //Given
        Field field = new Field(position, Symbol.X);
        //When
        boolean isOnGivenCoordinates = field.isOnPosition(position+1);
        //Then
        assertFalse(isOnGivenCoordinates);
    }

}
