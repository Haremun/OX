package com.bieganski.ox;

import com.bieganski.ox.user_interface.UserInterface;
import com.bieganski.ox.win_checkers.Judge;

import java.util.ArrayList;
import java.util.List;

class GameFlow implements Runnable, GameListener {
    private int boardSize;
    private UserInterface userInterface;
    private Board board;
    private List<Symbol> players = new ArrayList<>();
    private Symbol currentSymbol;
    private boolean win = false;

    GameFlow(UserInterface userInterface, int boardSize) {
        this.boardSize = boardSize;
        this.userInterface = userInterface;

        players.add(Symbol.X);
        players.add(Symbol.O);
// TODO factory method
        initializeBoard();
    }

    private void initializeBoard() {
        board = new Board(boardSize);
        board.addListener(userInterface);
        board.updateListeners();
        Judge judge = new Judge(this, boardSize);
        board.addListener(judge);
    }

    @Override
    public void run() {
        PositionCalculator positionCalculator = new PositionCalculator(new PositionValidator(), boardSize);
        currentSymbol = players.get(0);
        makeTurn(positionCalculator);
    }

    private void makeTurn(PositionCalculator positionCalculator) {
        askPlayerForInputAndPlaceSymbol(positionCalculator, currentSymbol);
        if (!win) {
            currentSymbol = changePlayer(currentSymbol);
            makeTurn(positionCalculator);
        }
    }

    private void askPlayerForInputAndPlaceSymbol(PositionCalculator positionCalculator, Symbol currentSymbol) {
        userInterface.println("Input row and column:");
        String input = userInterface.askForInput();
        boolean added = board.addField(new Field(positionCalculator.calculatePosition(input), currentSymbol));
        if (!added) {
            askPlayerForInputAndPlaceSymbol(positionCalculator, currentSymbol);
            //userInterface.println("There is no such position!");
        }
    }

    private Symbol changePlayer(Symbol currentSymbol) {
        return currentSymbol == Symbol.X ? Symbol.O : Symbol.X;
    }

    @Override
    public void onWin() {
        win = true;
    }
}
