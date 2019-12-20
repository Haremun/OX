package com.bieganski.ox;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.TreeSet;

import static org.testng.Assert.assertEquals;

public class BoardPrinterTest {

    @Test
    public void testPrintsCorrectBoard() {
        //Given
        String expectedBoard =
                "\033[2J\033[1;1H" +
                "[ ][ ][ ][ ]\n" +
                "[ ][X][ ][ ]\n" +
                "[ ][ ][O][ ]\n" +
                "[ ][ ][ ][X]\n" +
                        "\n";

        ByteArrayOutputStream actualBoard = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(actualBoard);
        UserInterface userInterface = new ConsoleInterface(null, printStream);
        BoardPrinter boardPrinter = new BoardPrinter(userInterface);

        TreeSet<Field> fields = new TreeSet<>();
        fields.add(new Field(5, Symbol.X));
        fields.add(new Field(10, Symbol.O));
        fields.add(new Field(15, Symbol.X));
        int boardSize = 4;

        //When
        boardPrinter.print(fields, boardSize);
        //Then
        assertEquals(actualBoard.toString(), expectedBoard);
    }

}