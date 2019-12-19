package com.bieganski.ox;

import java.util.TreeSet;

class Board {
    private int size;
    private TreeSet<Field> fields;

    Board(int size) {
        fields = new TreeSet<>();
        this.size = size;
    }

    void addFiled(Field field) throws FieldIsNotEmptyException {
        if (fields.contains(field))
            throw new FieldIsNotEmptyException("You can't add existing field");
        fields.add(field);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Field field = fields.first();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (checkIsFiledOnGivenCoordinates(field, new Coordinates(x + 1, y + 1))) {
                    appendField(stringBuilder, field);
                    field = fields.higher(field);
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
