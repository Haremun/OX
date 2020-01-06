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

  public ConsoleInterface(Scanner scanner, PrintStream printStream) {
    this.scanner = scanner;
    this.out = printStream;
  }

  @Override
  public void println(Object object) {
    out.println(object);
  }

  @Override
  public String askForInput() {
    return scanner.nextLine();
  }

  //TODO remove boardSize
  @Override
  public int askForPosition(int boardSize) {
    PositionCalculator positionCalculator =
        new PositionCalculator(new PositionValidator(), boardSize);
    return positionCalculator.parseInt(askForInput());
  }

  @Override
  public void onFieldAdded(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
    println(new ConsoleBoardPainter()
        .paintBoard(fieldsWithValue, size));
  }
}
