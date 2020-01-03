package com.bieganski.ox;

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
    //TODO Game setup for board size and starting player!
    int boardSize;
    try {
      boardSize = args.length < 1 ? 10 : Integer.parseInt(args[0]);
      if (boardSize < 3 || boardSize > 30) {
        boardSize = 30;
        LOG.warn("Provided number isn't in bounds! Default board size is set");
      }
    } catch (NumberFormatException ex) {
      LOG.warn("Provided text isn't number! Default board size is set");
      boardSize = 30;
    }
    LOG.info("Board size: " + boardSize);

    UserInterface userInterface = new ConsoleInterface(
        new Scanner(System.in), System.out);
    userInterface.println("Tic tac toe!");

    GameFlow gameFlow = new GameFlow(userInterface, boardSize);
    gameFlow.run();
  }
}
