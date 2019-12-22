package com.bieganski.ox;

class PositionCalculator {
    private int size;

    PositionCalculator(int size) {
        this.size = size;
    }

    int calculatePosition(String userInput) {
        String[] coordinates = userInput.split(" ");
        String row = coordinates[0];
        String column = coordinates[1];
        return Integer.parseInt(row) * size + Integer.parseInt(column);
    }
}
