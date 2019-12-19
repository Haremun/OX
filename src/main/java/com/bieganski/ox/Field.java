package com.bieganski.ox;

import java.util.Objects;

class Field implements Comparable<Field> {

    private Coordinates coordinates;
    private Symbol symbol;

    Field(Coordinates coordinates, Symbol symbol) {
        this.coordinates = coordinates;
        this.symbol = symbol;
    }


    boolean isOnGivenCoordinates(Coordinates coordinates) {
        return coordinates.equals(this.coordinates);
    }

    @Override
    public int compareTo(Field field) {
        return field.coordinates.compareTo(this.coordinates);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return coordinates.equals(field.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordinates, symbol);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
