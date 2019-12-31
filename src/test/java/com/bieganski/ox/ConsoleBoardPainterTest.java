package com.bieganski.ox;

import com.bieganski.ox.painters.ConsoleBoardPainter;
import org.testng.annotations.Test;

import java.util.TreeSet;

import static org.testng.Assert.assertEquals;

public class ConsoleBoardPainterTest {

    @Test
    public void testPrintsCorrectBoard() {
        //Given
        String expectedBoard =
                "    0  1  2  3 \n" +
                        " 0 [ ][ ][ ][ ]\n" +
                        " 1 [ ][X][ ][ ]\n" +
                        " 2 [ ][ ][O][ ]\n" +
                        " 3 [ ][ ][ ][X]";

        ConsoleBoardPainter consoleBoardPainter = new ConsoleBoardPainter();

        TreeSet<Field> fields = new TreeSet<>();
        fields.add(new Field(5, Symbol.X));
        fields.add(new Field(10, Symbol.O));
        fields.add(new Field(15, Symbol.X));
        int boardSize = 4;

        //When
        String actualBoard = consoleBoardPainter.paintBoard(fields, boardSize);
        //Then
        assertEquals(actualBoard, expectedBoard);
    }

}