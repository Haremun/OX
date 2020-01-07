package com.bieganski.ox.checkers;

import com.bieganski.ox.App;
import com.bieganski.ox.model.Field;

import java.util.TreeSet;

public class ReverseSlantWinChecker implements WinChecker {
  @Override
  public boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
    int winSize = 3;
    TreeSetHelper helper = new TreeSetHelper(fieldsWithValue);
    TreeSet<Field> correct = new TreeSet<>();
    correct.add(addedField);
    boolean upper = true;
    boolean lower = true;

    Field nextField;
    Field field;
    //TODO DRY and too long
    //TODO Bug with win in different rows
    while (correct.size() < winSize && !(!upper && !lower)) {

      if (upper) {
        field = correct.last();
        nextField = helper.getHigherField(field, field.hashCode() + size - 1);
        upper = appendFieldIfCorrect(field, nextField, correct);
      }
      if (lower) {
        field = correct.first();
        nextField = helper.getLowerField(field, field.hashCode() - size + 1);
        lower = appendFieldIfCorrect(field, nextField, correct);
      }
    }
    if (correct.size() >= winSize) {
      correct.forEach(x -> App.LOG.info(String.valueOf(x.hashCode())));
      return true;
    } else
      return false;
  }

  private boolean appendFieldIfCorrect(Field currentField, Field nextField, TreeSet<Field> correct) {
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

  private boolean isDistanceCorrectAndSymbolsAreEqual(Field current, Field next) {
    return current.areSymbolsEqual(next) && (current.hashCode() / 3) != (next.hashCode() / 3);
  }
}
