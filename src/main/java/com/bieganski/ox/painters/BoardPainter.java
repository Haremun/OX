package com.bieganski.ox.painters;

import com.bieganski.ox.Field;

import java.util.TreeSet;

public interface BoardPainter {
    String paintBoard(TreeSet<Field> fieldsWithValues, int boardSide);
}
