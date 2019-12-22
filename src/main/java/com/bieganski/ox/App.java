package com.bieganski.ox;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new ConsoleInterface(scanner, System.out);
        userInterface.println("Tic tac toe!");
        //Const size, just for checking if works
        Board board = new Board(10);
        board.addListener(userInterface);
        board.updateListeners();

        PositionCalculator positionCalculator = new PositionCalculator(new PositionValidator(),10);

        String input = userInterface.askForInput();
        if (new PositionValidator().checkString(input)) {
            board.addField(new Field(positionCalculator.calculatePosition(input), Symbol.X));
        }
    }
}
