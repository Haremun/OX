package com.bieganski.ox;

import java.util.Objects;

class Coordinates implements Comparable<Coordinates> {
    private int column;
    private int row;

    Coordinates(int column, int row) {
        this.column = column;
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        Coordinates that = (Coordinates) o;
        return column == that.column && row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }

    @Override
    public int compareTo(Coordinates coordinates) {
        int compareY = Integer.compare(coordinates.row, row);
        return compareY == 0 ? Integer.compare(coordinates.column, column) : compareY;
    }

    @Override
    public String toString() {
        return String.format("column: <%s> row: <%s>", column, row);
    }
}
