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
        && currentField.areSymbolsEqual(nextField)
        && isRowCorrect(currentField, nextField)) {
      correct.add(nextField);
      return true;
    }
    return false;
  }

  private boolean checkFieldsAreNotNull(Field current, Field next) {
    return current != null && next != null;
  }

  /**
   * You can override this function when checker
   * have spacial requirements about rows.
   * @param current - actually checked field
   * @param next    - next filed to check
   * @return <code>true</code> if row of next field is correct or
   * <code>false</code> when rows aren't in correct rows
   */
  protected boolean isRowCorrect(Field current, Field next) {
    return true;
  }
}
