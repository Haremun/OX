package com.bieganski.ox;

class PositionCalculator {
    private int boardSize;
    private PositionValidator positionValidator;

    PositionCalculator(PositionValidator positionValidator, int boardSize) {
        this.boardSize = boardSize;
        this.positionValidator = positionValidator;
    }

    int calculatePosition(String userInput) {
        if (!positionValidator.checkString(userInput))
            throw new IllegalArgumentException("There is no such position!");
        String[] coordinates = userInput.split(" ");
        String row = coordinates[0];
        String column = coordinates[1];
        try {
            return Integer.parseInt(row) * boardSize + Integer.parseInt(column);
        } catch (NumberFormatException ex){
            App.LOG.warn("User provided incorrect number");
            return -1;
        }
    }
}
