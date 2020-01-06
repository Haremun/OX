package com.bieganski.ox.checkers;

import com.bieganski.ox.model.Field;

import java.util.TreeSet;

/**
 * Checks board for winning combination.
 *
 * @author Kamil Biegański
 */
interface WinChecker {
  boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField, int size);
}
