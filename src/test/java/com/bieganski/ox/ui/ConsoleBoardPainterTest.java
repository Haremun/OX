package com.bieganski.ox.ui;

import com.bieganski.ox.model.Field;
import com.bieganski.ox.model.Symbol;
import org.testng.annotations.Test;

import java.util.TreeSet;

import static org.testng.Assert.assertEquals;

public class ConsoleBoardPainterTest {

  @Test
  public void testPrintsCorrectBoard() {
    //Given
    int boardSize = 4;
    String expectedBoard =
        "    0  1  2  3 \n" +
            " 0 [ ][ ][ ][ ]\n" +
            " 1 [ ][X][ ][ ]\n" +
            " 2 [ ][ ][O][ ]\n" +
            " 3 [ ][ ][ ][X]";

    ConsoleBoardPainter consoleBoardPainter = new ConsoleBoardPainter(boardSize);

    TreeSet<Field> fields = new TreeSet<>();
    fields.add(new Field(5, Symbol.X));
    fields.add(new Field(10, Symbol.O));
    fields.add(new Field(15, Symbol.X));
    //When
    String actualBoard = consoleBoardPainter.paintBoard(fields);
    //Then
    assertEquals(actualBoard, expectedBoard);
  }

}