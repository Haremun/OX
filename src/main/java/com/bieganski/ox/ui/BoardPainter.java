package com.bieganski.ox.ui;

import com.bieganski.ox.model.Field;

import java.util.TreeSet;

interface BoardPainter {
  String paintBoard(TreeSet<Field> fieldsWithValues, int boardSide);
}
