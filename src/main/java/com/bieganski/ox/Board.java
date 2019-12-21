package com.bieganski.ox;

import java.util.TreeSet;

class Board {
    private int size;
    private TreeSet<Field> occupiedFields;
    private BoardPrinter boardPrinter;

    Board(int size) {
        this(size, null);
    }

    Board(int size, BoardPrinter boardPrinter) {
        this.occupiedFields = new TreeSet<>();
        this.size = size;
        this.boardPrinter = boardPrinter;
        if (boardPrinter != null)
            this.boardPrinter.print(occupiedFields, size);
    }

    boolean addField(Field field) {
        if (occupiedFields.contains(field) || !field.isInBounds(size * size))
            return false;
        occupiedFields.add(field);
        if (boardPrinter != null)
            boardPrinter.print(occupiedFields, size);
        return true;
    }

    @Override
    public String toString() {
        return occupiedFields.toString();
    }
}
