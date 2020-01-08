package com.bieganski.ox.model;

import com.bieganski.ox.ui.UserInterface;

import java.util.function.Predicate;

/**
 * Holds main information about game.
 */
public class GameSettings {
  private int winSize;
  private int boardSize;
  private Symbol startSymbol;
  private UserInterface userInterface;

  public GameSettings() {
  }

  /**
   * Initialization of game. Player provides bord size,
   * number of character in win sequence and starting player
   */
  public void init(UserInterface userInterface) {
    this.userInterface = userInterface;
    userInterface.println("Set board side size:");
    boardSize = askForNumber("Wrong board size. Input value between 3 and 30",
        x -> (3 <= x && x <= 30));
    userInterface.println("Set number of characters for win:");
    winSize = askForNumber("Wrong winning condition. Input value between 3 and 30",
        x -> (3 <= x && x <= 30));
    userInterface.println("Choose starting symbol (X - 1 or Y - 2):");
    startSymbol = Symbol.values()[
        askForNumber("Wrong symbol. Choose symbol 1 or 2!", x -> (x == 1 || x == 2)) - 1];
  }

  private int askForNumber(String errorMessage, Predicate<Integer> predicate) {
    int input = userInterface.askForPositiveNumber();
    if (predicate.test(input)) {
      return input;
    }
    userInterface.println(errorMessage);
    return askForNumber(errorMessage, predicate);
  }

  /**
   * Setting game with default values.
   */
  public void setDefault() {
    this.boardSize = 10;
    this.winSize = 3;
    this.startSymbol = Symbol.X;
  }

  public int getBoardSize() {
    return boardSize;
  }

  public int getWinSize() {
    return winSize;
  }

  public Symbol getStartSymbol() {
    return startSymbol;
  }

  @Override
  public String toString() {
    return String.format("Board size: %d ", boardSize)
        + String.format("Winning sequence size: %d ", winSize)
        + String.format("Starting symbol: %s", startSymbol);
  }
}
