package com.bieganski.ox;

import java.util.ArrayList;
import java.util.List;

class GameFlow implements Runnable {
    private int boardSize;
    private UserInterface userInterface;
    private Board board;
    private List<Symbol> players = new ArrayList<>();
    private boolean win = false;

    GameFlow(UserInterface userInterface, int boardSize) {
        this.boardSize = boardSize;
        this.userInterface = userInterface;

        players.add(Symbol.X);
        players.add(Symbol.O);

        initializeBoard();
    }

    private void initializeBoard() {
        board = new Board(boardSize);
        board.addListener(userInterface);
        board.updateListeners();
    }

    @Override
    public void run() {
        PositionCalculator positionCalculator = new PositionCalculator(new PositionValidator(), boardSize);
        Symbol currentSymbol = players.get(0);
        while (!win) {
            userInterface.println("Input row and column:");
            String input = userInterface.askForInput();
            if (new PositionValidator().checkString(input)) {
                boolean added = board.addField(new Field(positionCalculator.calculatePosition(input), currentSymbol));
                if (added)
                    currentSymbol = changePlayer(currentSymbol);
            }
        }
    }

    private Symbol changePlayer(Symbol currentSymbol) {
        return currentSymbol == Symbol.X ? Symbol.O : Symbol.X;
    }
}