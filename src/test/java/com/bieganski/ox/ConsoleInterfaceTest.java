package com.bieganski.ox;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

@Test
public class ConsoleInterfaceTest {
    @Test
    public void testPrintCharacterWhenGetCharacter() {
        //Given
        ByteArrayOutputStream actualOutput = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(actualOutput);
        UserInterface userInterface = new ConsoleInterface(null, printStream);
        String expected = "e";
        //When
        userInterface.println(expected);
        //Then
        Assert.assertEquals(actualOutput.toString(), expected + "\n");
    }
}