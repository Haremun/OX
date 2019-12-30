package com.bieganski.ox;

import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

class Board {
    private int size;
    private TreeSet<Field> occupiedFields;
    private List<BoardListener> listeners;


    Board(int size) {
        this.occupiedFields = new TreeSet<>();
        this.listeners = new LinkedList<>();
        this.size = size;
    }

    boolean addField(Field field) {
        if (occupiedFields.contains(field) || !field.isInBounds(size * size))
            return false;
        occupiedFields.add(field);
        listeners.forEach(x -> x.onBoardUpdate(occupiedFields, field, size));
        App.LOG.info("Player made move: " + field);
        return true;
    }

    void addListener(BoardListener listener) {
        listeners.add(listener);
    }

    void updateListeners() {
        listeners.forEach(x -> x.onBoardUpdate(occupiedFields, null, size));
    }

    @Override
    public String toString() {
        return occupiedFields.toString();
    }

}
