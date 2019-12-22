package com.bieganski.ox;

import java.util.Objects;

class Field implements Comparable<Field> {

    private int position;
    private Symbol symbol;

    Field(int position, Symbol symbol) {
        this.position = position;
        this.symbol = symbol;
    }

    boolean isOnPosition(int position) {
        return this.position == position;
    }

    boolean isInBounds(int bounds) {
        return position < bounds && position >= 0;
    }


    @Override
    public int compareTo(Field field) {
        return Integer.compare(position, field.position);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return position == field.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, symbol);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }

}
