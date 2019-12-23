package com.bieganski.ox;

import java.util.Scanner;

class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new ConsoleInterface(scanner, System.out);
        userInterface.println("Tic tac toe!");
        //Const size, just for checking if works
        GameFlow gameFlow = new GameFlow(userInterface, 10);
        new Thread(gameFlow).start();

    }
}
