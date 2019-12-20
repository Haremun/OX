package com.bieganski.ox;

import java.util.TreeSet;

class Board {
    private int size;
    private TreeSet<Field> fields;

    Board(int size) {
        fields = new TreeSet<>();
        this.size = size;
    }

    boolean addField(Field field) {
        if (fields.contains(field))
            return false;
        fields.add(field);
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Field field = fields.first();
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                if (checkIsFieldOnGivenPosition(field, (row * size) + column)) {
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

//    private String checkValueOfField(Field field){
//
//    }

    private void appendField(StringBuilder builder, Field field) {
        builder.append("[");
        builder.append(field);
        builder.append("]");
    }

    private boolean checkIsFieldOnGivenPosition(Field field, int position) {
        return field != null && field.isOnGivenPosition(position);
    }
}
