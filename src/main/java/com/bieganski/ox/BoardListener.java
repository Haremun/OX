package com.bieganski.ox;

import com.bieganski.ox.model.Field;

import java.util.TreeSet;

/**
 * Interface for notifying about changes on the board.
 */
public interface BoardListener {
  //TODO remove size and fieldsWithValue, think about adding placed symbol

  /**
   * Notify about new field on the board.
   *
   * @param fieldsWithValue - collection of added fields to board
   * @param addedField      - actually added field
   * @param size            - size of the board
   */
  void onFieldAdded(TreeSet<Field> fieldsWithValue, Field addedField, int size);
}
