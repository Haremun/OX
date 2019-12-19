package com.bieganski.ox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class BoardTest {
    @Test(expectedExceptions = FieldIsNotEmptyException.class)
    public void testAddingExistingField() throws FieldIsNotEmptyException {
        //Given
        Field field = new Field(new Coordinates(5, 5), Symbol.X);
        Board board = new Board(10);
        //When
//        try {
        board.addField(field);
        board.addField(new Field(new Coordinates(5, 5), Symbol.X));
//        } catch (FieldIsNotEmptyException e) {
//            return;
//        }
        //Then throws
        Assert.fail("Adding existing element doesn't throw exception");
    }
}
