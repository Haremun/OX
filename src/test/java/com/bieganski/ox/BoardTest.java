package com.bieganski.ox;

import com.bieganski.ox.model.Field;
import com.bieganski.ox.model.Symbol;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;


public class BoardTest {

    @DataProvider
    public Object[] positiveInteger() {
        return IntStream.rangeClosed(0, 5000).boxed().toArray();
    }

    @DataProvider
    public Object[] negativeInteger() {
        return IntStream.range(-5000, 0).boxed().toArray();
    }

    @DataProvider
    public Object[] symbols() {
        return new Object[]{Symbol.O, Symbol.X};
    }

    @Test
    public void testAddedSymbolsAreSorted(){
        //Given
        Board board = new Board(5);
        //When
        board.addField(new Field(15, Symbol.O));
        board.addField(new Field(5, Symbol.X));
        board.addField(new Field(2, Symbol.O));
        board.addField(new Field(3, Symbol.X));
        //Then
        assertEquals(board.toString(), "[O, X, X, O]");
    }

    @Test(dataProvider = "positiveInteger")
    public void testAddingValueOnOccupiedField(int position) {
        //Given
        Field field = new Field(position, Symbol.X);
        Board board = new Board(position * 2);
        //When
        board.addField(field);
        boolean added = board.addField(new Field(position, Symbol.X));
        //Then
        Assert.assertFalse(added);
    }

    @Test(dataProvider = "symbols")
    public void testAddingValueOnOccupiedFieldWithDifferentSymbol(Symbol symbol) {
        //Given
        Field field = new Field(15, symbol);
        Board board = new Board(30);
        Symbol secondSymbol = symbol == Symbol.O ? Symbol.X : Symbol.O;
        //When
        board.addField(field);
        boolean added = board.addField(new Field(15, secondSymbol));
        //Then
        Assert.assertFalse(added);
    }

    @Test(dataProvider = "positiveInteger")
    public void testAddingValueOutOfBoardBounds(int size) {
        //Given
        Field field = new Field(size * size + 1, Symbol.X);
        Board board = new Board(size);
        //When
        boolean added = board.addField(field);
        //Then
        Assert.assertFalse(added);
    }

    @Test(dataProvider = "negativeInteger")
    public void testAddingValueOnNegativePosition(int position) {
        //Given
        Field field = new Field(position, Symbol.X);
        Board board = new Board(30);
        //When
        boolean added = board.addField(field);
        //Then
        Assert.assertFalse(added);
    }
}
