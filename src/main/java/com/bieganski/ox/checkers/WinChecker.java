package com.bieganski.ox.checkers;

import com.bieganski.ox.model.Field;
import com.bieganski.ox.model.GameSettings;

import java.util.TreeSet;
import java.util.function.Supplier;

abstract class WinChecker {
  protected int boardSize;
  protected int winSize;
  protected Supplier<Integer> supplier;

  WinChecker(GameSettings gameSettings, Supplier<Integer> supplier) {
    this.boardSize = gameSettings.getBoardSize();
    this.winSize = gameSettings.getWinSize();
    this.supplier = supplier;
  }

  boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField) {
    TreeSetHelper helper = new TreeSetHelper(fieldsWithValue);
    TreeSet<Field> correct = new TreeSet<>();
    correct.add(addedField);
    boolean upper = true;
    boolean lower = true;

    Field nextField;
    Field field;
    while (correct.size() < winSize && !(!upper && !lower)) {

      if (upper) {
        field = correct.last();
        nextField = helper.getHigherField(field, field.hashCode() + supplier.get());
        upper = appendFieldIfCorrect(field, nextField, correct);
      }
      if (lower) {
        field = correct.first();
        nextField = helper.getLowerField(field, field.hashCode() - supplier.get());
        lower = appendFieldIfCorrect(field, nextField, correct);
      }
    }
    return correct.size() >= winSize;
  }

  private boolean appendFieldIfCorrect(
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
   *
   * @param current - actually checked field
   * @param next    - next filed to check
   * @return <code>true</code> if row of next field is correct or
   * <code>false</code> when rows aren't in correct rows
   */
  protected boolean isRowCorrect(Field current, Field next) {
    return true;
  }
}
