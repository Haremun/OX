package com.bieganski.ox;

import com.bieganski.ox.win_checkers.HorizontalWinChecker;
import org.testng.annotations.Test;

import java.util.TreeSet;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HorizontalWinCheckerTest {
    //TODO data provider
    @Test
    public void testCleanWin() {
        //Given
        TreeSet<Field> fields = new TreeSet<>();
        fields.add(new Field(0, Symbol.X));
        fields.add(new Field(2, Symbol.X));
        HorizontalWinChecker checker = new HorizontalWinChecker();
        //When
        boolean isWin = checker.checkWin(fields, new Field(1, Symbol.X), 10);
        //Then
        assertTrue(isWin);
    }
    @Test
    public void testWinWithOtherSymbolBySide(){
        //Given
        TreeSet<Field> fields = new TreeSet<>();
        fields.add(new Field(0, Symbol.X));
        fields.add(new Field(2, Symbol.X));
        fields.add(new Field(3, Symbol.O));
        HorizontalWinChecker checker = new HorizontalWinChecker();
        //When
        boolean isWin = checker.checkWin(fields, new Field(1, Symbol.X), 10);
        //Then
        assertTrue(isWin);
    }
    @Test
    public void testWinWithOtherSymbol(){
        //Given
        TreeSet<Field> fields = new TreeSet<>();
        fields.add(new Field(0, Symbol.X));
        fields.add(new Field(1, Symbol.O));
        fields.add(new Field(2, Symbol.X));
        fields.add(new Field(3, Symbol.O));
        fields.add(new Field(4, Symbol.X));
        fields.add(new Field(5, Symbol.X));
        HorizontalWinChecker checker = new HorizontalWinChecker();
        //When
        boolean isWin = checker.checkWin(fields, new Field(6, Symbol.X), 10);
        //Then
        assertTrue(isWin);
    }
    @Test
    public void testAddedSymbolInRowAndNoWin(){
        //Given
        TreeSet<Field> fields = new TreeSet<>();
        fields.add(new Field(0, Symbol.X));
        fields.add(new Field(1, Symbol.O));
        HorizontalWinChecker checker = new HorizontalWinChecker();
        //When
        boolean isWin = checker.checkWin(fields, new Field(3, Symbol.X), 10);
        //Then
        assertFalse(isWin);
    }
}