package com.bieganski.ox;

import com.bieganski.ox.model.Field;
import com.bieganski.ox.model.Symbol;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.*;


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
        boolean isOnGivenCoordinates = field.isOnPosition(position + 1);
        //Then
        assertFalse(isOnGivenCoordinates);
    }

    @Test
    public void testCalculateCorrectDistanceToOtherField() {
        //Given
        int distanceExpected = 2;
        Field field = new Field(13, null);
        Field field2 = new Field(15, null);
        //When
        int distanceActual = field.distanceTo(field2);
        //Then
        assertEquals(distanceActual, distanceExpected);
    }

}
