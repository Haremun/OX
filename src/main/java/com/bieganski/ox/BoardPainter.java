package com.bieganski.ox;

import java.util.TreeSet;

public interface BoardPainter {
    String paintBoard(TreeSet<Field> fieldsWithValues, int boardSide);
}
