package com.bieganski.ox.win_checkers;

import com.bieganski.ox.Field;

import java.util.TreeSet;

public class HorizontalWinChecker implements WinChecker {
    @Override
    public boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
        int winSize = 3;

        TreeSet<Field> correct = new TreeSet<>();
        correct.add(addedField);
        Field field;
        int counter = 0;

        while (correct.size() < winSize && counter < 2) {
            field = correct.last();
            Field nextField = fieldsWithValue.higher(field);
            counter = counter + appendFieldIfCorrect(field, nextField, correct);

            field = correct.first();
            nextField = fieldsWithValue.lower(field);
            counter = counter + appendFieldIfCorrect(field, nextField, correct);


        }
        return correct.size() >= winSize;
    }

    private int appendFieldIfCorrect(Field currentField, Field nextField, TreeSet<Field> correct) {
        if (checkFieldsAreNotNull(currentField, nextField) && isDistanceCorrectAndSymbolsAreEquals(currentField, nextField)) {
            correct.add(nextField);
            return 0;
        }
        return 1;
    }

    private boolean checkFieldsAreNotNull(Field current, Field next) {
        return current != null && next != null;
    }

    private boolean isDistanceCorrectAndSymbolsAreEquals(Field current, Field next) {
        return current.distanceToField(next) <= 1 && current.areSymbolsEquals(next);
    }
}
