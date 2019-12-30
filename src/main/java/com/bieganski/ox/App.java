package com.bieganski.ox;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

class App {
    public static final Logger LOG = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        LOG.info("Application started");

        Scanner scanner = new Scanner(System.in);
        UserInterface userInterface = new ConsoleInterface(scanner, System.out);
        userInterface.println("Tic tac toe!");
        //TODO: change const values ,create game setup
        GameFlow gameFlow = new GameFlow(userInterface, Integer.parseInt(args[0]));
        new Thread(gameFlow).start();

    }
}
