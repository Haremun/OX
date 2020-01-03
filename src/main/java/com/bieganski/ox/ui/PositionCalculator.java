package com.bieganski.ox.ui;

import com.bieganski.ox.App;

class PositionCalculator {
  private int boardSize;
  private PositionValidator positionValidator;

  PositionCalculator(PositionValidator positionValidator, int boardSize) {
    this.boardSize = boardSize;
    this.positionValidator = positionValidator;
  }

  /**
   * Parsing user input to position on board.
   *
   * @param userInput - row and column provided by user
   * @return parsed position,
   * returns -1 when occurs problem with parsing
   * what should be handled in board class
   */
  int parseInt(String userInput) {
    if (!positionValidator.checkString(userInput)) {
      App.LOG.warn("User input isn't correct");
      return -1;
    }
    String[] coordinates = userInput.split(" ");
    String row = coordinates[0];
    String column = coordinates[1];
    try {
      return Integer.parseInt(row) * boardSize + Integer.parseInt(column);
    } catch (NumberFormatException ex) {
      App.LOG.warn("User provided incorrect number");
      return -1;
    }
  }
}
