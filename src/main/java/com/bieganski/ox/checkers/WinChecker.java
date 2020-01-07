package com.bieganski.ox.checkers;

import com.bieganski.ox.model.Field;

import java.util.TreeSet;

/**
 * Checks board for winning combination.
 *
 * @author Kamil Biegański
 */
interface WinChecker {
  /**
   * Find winning combination on board.
   * @param fieldsWithValue - all added fields on board
   * @param addedField      - new field added on board
   * @param size            - board side size
   * @return <code>true</code> if found winning combination,
   <code>false</code> if there is no win with this combination
   */
  boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField, int size);
}
