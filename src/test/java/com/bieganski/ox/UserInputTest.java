package com.bieganski.ox;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Scanner;
import java.util.stream.Stream;

import static org.testng.Assert.assertEquals;

public class UserInputTest {
    @DataProvider
    public Object[] inputProviderFromAscii() {
        int maxAsciiValue = 126;
        int minAsciiValue = 32;
        return Stream.iterate(minAsciiValue, x -> x += 1)
                .map(Character::toString)
                .limit(maxAsciiValue - minAsciiValue + 1)
                .toArray();
    }

    @Test(dataProvider = "inputProviderFromAscii")
    public void testUserInputsCoordinatesShouldReturnTheSameCoordinates(String expected) {
        //Given
        Scanner scanner = new Scanner(expected);
        UserInterface userInterface = new ConsoleInterface(scanner, null);
        //When
        String actual = userInterface.askForInput();
        //Then
        assertEquals(actual, expected, String.format("Returned value '%s' isn't equal '%s'", actual, expected));
    }
}
