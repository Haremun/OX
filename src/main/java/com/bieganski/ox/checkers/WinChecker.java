package com.bieganski.ox.checkers;

import com.bieganski.ox.model.Field;

import java.util.TreeSet;

abstract class WinChecker {
  protected int boardSize;
  protected int winSize;

  WinChecker(int boardSize, int winSize) {
    this.boardSize = boardSize;
    this.winSize = winSize;
  }

  //TODO Win checkers have too long functions, think about functional interfaces!
  abstract boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField);

  protected boolean appendFieldIfCorrect(
      Field currentField, Field nextField, TreeSet<Field> correct) {
    if (checkFieldsAreNotNull(currentField, nextField)
        && isDistanceCorrectAndSymbolsAreEqual(currentField, nextField)) {
      correct.add(nextField);
      return true;
    }
    return false;
  }

  private boolean checkFieldsAreNotNull(Field current, Field next) {
    return current != null && next != null;
  }

  protected abstract boolean isDistanceCorrectAndSymbolsAreEqual(Field current, Field next);
}
