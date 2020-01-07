package com.bieganski.ox;

import com.bieganski.ox.checkers.Judge;
import com.bieganski.ox.model.Field;
import com.bieganski.ox.model.Symbol;
import com.bieganski.ox.ui.UserInterface;


class GameFlow implements GameListener {
  private int boardSize;
  private UserInterface userInterface;
  private Board board;
  private boolean gameStop = false;
  private Symbol currentSymbol;

  GameFlow(UserInterface userInterface, int boardSize) {
    this.boardSize = boardSize;
    this.userInterface = userInterface;
  }

  private void initializeBoard() {
    board = new Board(boardSize);
    board.addListener(userInterface);
    board.updateListeners();
    Judge judge = new Judge(this, boardSize);
    board.addListener(judge);
  }

  void run() {
    initializeBoard();
    //TODO start player should be from game setup
    currentSymbol = Symbol.values()[0];

    makeTurn();
  }

  private void makeTurn() {
    askPlayerForInputAndPlaceSymbol(currentSymbol);
    if (!gameStop) {
      currentSymbol = changePlayer(currentSymbol);
      makeTurn();
    }
  }

  private void askPlayerForInputAndPlaceSymbol(Symbol currentSymbol) {
    userInterface.println("Input row and column:");
    int input = userInterface.askForPosition(boardSize);
    if (!board.addField(
        new Field(input, currentSymbol))) {
      askPlayerForInputAndPlaceSymbol(currentSymbol);
    }
  }

  private Symbol changePlayer(Symbol currentSymbol) {
    return currentSymbol == Symbol.X ? Symbol.O : Symbol.X;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onWin() {
    gameStop = true;
    userInterface.println(String.format("Player %s wins!:", currentSymbol));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onDraw() {
    gameStop = true;
    userInterface.println("Draw!");
  }
}
