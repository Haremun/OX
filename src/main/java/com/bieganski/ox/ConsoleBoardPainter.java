package com.bieganski.ox;

import java.util.TreeSet;

class ConsoleBoardPainter implements BoardPainter {

    //TODO: Too long function
    @Override
    public String paintBoard(TreeSet<Field> fieldsWithValues, int boardSide) {
        StringBuilder stringBuilder = new StringBuilder();
        Field fieldWithValue = null;
        if (!fieldsWithValues.isEmpty())
            fieldWithValue = fieldsWithValues.first();

        markColumns(stringBuilder, boardSide);
        int counter = 0;
        markRow(stringBuilder, counter);

        for (int position = 0; position < boardSide * boardSide; position++) {

            if (fieldWithValue != null && fieldWithValue.isOnPosition(position)) {
                stringBuilder.append(String.format("[%s]", fieldWithValue));
                fieldWithValue = fieldsWithValues.higher(fieldWithValue);
            } else {
                stringBuilder.append("[ ]");
            }

            if ((position + 1) % boardSide == 0 && position + 1 != boardSide * boardSide) {
                stringBuilder.append("\n");
                counter++;
                markRow(stringBuilder, counter);
            }
        }

        return stringBuilder.toString();
    }

    private void markRow(StringBuilder stringBuilder, int counter) {
        stringBuilder.append(String.format("%d ", counter));
    }

    private void markColumns(StringBuilder stringBuilder, int boardSide) {
        stringBuilder.append("  ");
        for (int i = 0; i < boardSide; i++) {
            stringBuilder.append(String.format(" %s ", i));
        }
        stringBuilder.append("\n");
    }
}
