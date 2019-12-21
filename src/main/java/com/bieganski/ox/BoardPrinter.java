package com.bieganski.ox;

import java.util.TreeSet;

class BoardPrinter {
    private UserInterface userInterface;

    BoardPrinter(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    void print(TreeSet<Field> fieldsWithValues, int boardSide) {
        StringBuilder stringBuilder = new StringBuilder();
        Field fieldWithValue = null;
        if (!fieldsWithValues.isEmpty())
            fieldWithValue = fieldsWithValues.first();

        for (int position = 0; position < boardSide * boardSide; position++) {

            if (fieldWithValue != null && fieldWithValue.isOnPosition(position)) {
                stringBuilder.append(String.format("[%s]", fieldWithValue));
                fieldWithValue = fieldsWithValues.higher(fieldWithValue);
            } else {
                stringBuilder.append("[ ]");
            }

            if ((position + 1) % boardSide == 0)
                stringBuilder.append("\n");
        }

        userInterface.println(stringBuilder.toString());
    }
}
