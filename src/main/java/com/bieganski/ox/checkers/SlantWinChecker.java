package com.bieganski.ox.checkers;

import com.bieganski.ox.model.Field;

import java.util.TreeSet;

public class SlantWinChecker extends WinChecker {
  SlantWinChecker(int boardSize, int winSize) {
    super(boardSize, winSize);
  }

  @Override
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
        nextField = helper.getHigherField(field, field.hashCode() + boardSize + 1);
        upper = appendFieldIfCorrect(field, nextField, correct);
      }
      if (lower) {
        field = correct.first();
        nextField = helper.getLowerField(field, field.hashCode() - boardSize - 1);
        lower = appendFieldIfCorrect(field, nextField, correct);
      }
    }
    return correct.size() >= winSize;
  }

  protected boolean isDistanceCorrectAndSymbolsAreEqual(Field current, Field next) {
    return current.areSymbolsEqual(next)
        && (current.hashCode() / boardSize) != (next.hashCode() / boardSize);
  }
}
