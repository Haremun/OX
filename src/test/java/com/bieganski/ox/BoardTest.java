package com.bieganski.ox;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class BoardTest {
    @Test()
    public void testAddingExistingField() {
        //Given
        Field field = new Field(new Coordinates(5, 5), Symbol.X);
        Board board = new Board(10);
        //When
        try {
            board.addFiled(field);
            board.addFiled(field);
        } catch (FieldIsNotEmptyException e) {
            return;
        }
        //Then throws
        Assert.fail("Adding existing element doesn't throw exception");
    }
}
