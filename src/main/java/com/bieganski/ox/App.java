package com.bieganski.ox;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new ConsoleInterface(scanner, System.out);
        userInterface.println("Tic tac toe!");
        //TODO: change const values ,create game setup
        GameFlow gameFlow = new GameFlow(userInterface, 200);
        new Thread(gameFlow).start();

    }
}
