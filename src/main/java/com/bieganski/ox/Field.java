package com.bieganski.ox;

public class Field implements Comparable<Field> {

    private Coordinates coordinates;
    private char symbol;

    public Field(Coordinates coordinates, char symbol) {
        this.coordinates = coordinates;
        this.symbol = symbol;
    }

    boolean isOnGivenCoordinates(Coordinates coordinates){
        return coordinates.equals(this.coordinates);
    }

    @Override
    public int compareTo(Field field) {
        return field.coordinates.compareTo(this.coordinates);
    }

    @Override
    public String toString() {
        return String.valueOf(symbol);
    }
}
