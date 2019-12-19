package com.bieganski.ox;

import java.util.TreeSet;

class Board {
    private int size;
    private TreeSet<Field> fields;

    Board(int size) {
        fields = new TreeSet<>();
        this.size = size;
    }

    void addFiled() {
        fields.add(new Field(new Coordinates(3, 3), 'X'));
        fields.add(new Field(new Coordinates(1, 1), 'O'));
        fields.add(new Field(new Coordinates(1, 8), 'X'));
        fields.add(new Field(new Coordinates(4, 5), 'O'));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Field field = fields.pollFirst();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (checkIsFiledOnGivenCoordinates(field, new Coordinates(x + 1, y + 1))) {
                    appendField(stringBuilder, field);
                    field = fields.pollFirst();
                } else {
                    stringBuilder.append("[ ]");
                }
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private void appendField(StringBuilder builder, Field field) {
        builder.append("[");
        builder.append(field);
        builder.append("]");
    }

    private boolean checkIsFiledOnGivenCoordinates(Field field, Coordinates coordinates) {
        if (field == null)
            return false;
        return field.isOnGivenCoordinates(coordinates);
    }
}
