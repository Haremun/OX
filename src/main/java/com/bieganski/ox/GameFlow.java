package com.bieganski.ox;

import com.bieganski.ox.checkers.Judge;
import com.bieganski.ox.model.Field;
import com.bieganski.ox.model.GameSettings;
import com.bieganski.ox.model.Symbol;
import com.bieganski.ox.ui.UserInterface;


class GameFlow implements GameListener {
  private UserInterface userInterface;
  private GameSettings gameSettings;
  private Board board;

  private boolean gameStop = false;
  private Symbol currentSymbol;

  GameFlow(UserInterface userInterface, GameSettings gameSettings) {
    this.gameSettings = gameSettings;
    this.userInterface = userInterface;
  }

  private void initializeBoard() {
    board = new Board(gameSettings.getBoardSize());
    board.addListener(userInterface);
    Judge judge = new Judge(this, gameSettings);
    board.addListener(judge);
  }

  void run() {
    initializeBoard();
    currentSymbol = gameSettings.getStartSymbol();
    for (int i = 1; i <= 3; i++) {
      startRound(i);
      nextTurn();
    }
    userInterface.println("Game Over!");
  }

  private void startRound(int index) {
    userInterface.println(String.format("Round %d", index));
    board.cleanBoard();
    board.updateListeners();
    gameStop = false;
  }

  private void nextTurn() {
    askPlayerForInputAndPlaceSymbol(currentSymbol);
    if (!gameStop) {
      currentSymbol = changePlayer(currentSymbol);
      nextTurn();
    }
  }

  private void askPlayerForInputAndPlaceSymbol(Symbol currentSymbol) {
    userInterface.println(String.format("%s moves", currentSymbol));
    userInterface.println("Input row and column:");
    int input = userInterface.askForPosition(gameSettings.getBoardSize());
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
    userInterface.println(String.format("Player %s wins!", currentSymbol));
    userInterface.println("");
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
