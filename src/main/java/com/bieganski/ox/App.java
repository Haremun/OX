package com.bieganski.ox;

import com.bieganski.ox.model.GameSettings;
import com.bieganski.ox.ui.ConsoleInterface;
import com.bieganski.ox.ui.UserInterface;

import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Main class for OX application.
 *
 * @author Kamil Biegański
 * @version 0.5
 */
public final class App {
  public static final Logger LOG = LoggerFactory.getLogger(App.class);

  /**
   * Loading args, initializes user interface
   * and starts game flow.
   *
   * @param args - provides board size
   */
  public static void main(String[] args) {

    LOG.info("Application started");

    UserInterface userInterface = new ConsoleInterface(
        new Scanner(System.in), System.out);
    userInterface.println("Tic tac toe!");
    userInterface.println("Use '/q' command to leave");


    GameSettings gameSettings = new GameSettings();
    gameSettings.init(userInterface);


    LOG.info(gameSettings.toString());

    new GameFlow(userInterface, gameSettings).run();
  }
}
