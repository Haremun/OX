package com.bieganski.ox.ui;

import com.bieganski.ox.model.Field;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * User interface for communication with player via console.
 */
public class ConsoleInterface implements UserInterface {
  private Scanner scanner;
  private PrintStream out;

  private static final String EXIT = "/q";

  public ConsoleInterface(Scanner scanner, PrintStream printStream) {
    this.scanner = scanner;
    this.out = printStream;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void println(Object object) {
    out.println(object);
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String askForInput() {
    String input = scanner.nextLine();
    if (input.equals(EXIT)) {
      System.exit(0);
    }
    return input;
  }

  //TODO remove boardSize

  /**
   * {@inheritDoc}
   */
  @Override
  public int askForPosition(int boardSize) {
    PositionCalculator positionCalculator =
        new PositionCalculator(new PositionValidator(), boardSize);
    return positionCalculator.parseInt(askForInput());
  }

  @Override
  public int askForPositiveNumber() {
    try {
      return Integer.parseInt(askForInput());
    } catch (NumberFormatException ex) {
      return -1;
    }

  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onFieldAdded(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
    println(new ConsoleBoardPainter(size).paintBoard(fieldsWithValue));
  }
}
