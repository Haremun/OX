package com.bieganski.ox.win_checkers;

import com.bieganski.ox.BoardListener;
import com.bieganski.ox.Field;

import java.util.TreeSet;

/**
 * Interface for judge classes
 * @author Kamil Biegański
 */
interface WinChecker {
    boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField, int size);
}
