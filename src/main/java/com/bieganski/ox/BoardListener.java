package com.bieganski.ox;

import java.util.TreeSet;

interface BoardListener {
    void onBoardUpdate(TreeSet<Field> fieldsWithValue, Field addedField, int size);
}
