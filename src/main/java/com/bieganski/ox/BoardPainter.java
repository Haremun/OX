package com.bieganski.ox;

import java.util.TreeSet;

interface BoardPainter {
    String paintBoard(TreeSet<Field> fieldsWithValues, int boardSide);
}
