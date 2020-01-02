package com.bieganski.ox;

import java.util.TreeSet;

public interface BoardListener {
    //TODO remove size
    void onBoardUpdate(TreeSet<Field> fieldsWithValue, Field addedField, int size);
}
