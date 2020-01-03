package com.bieganski.ox.ui;

import com.bieganski.ox.BoardListener;

/**
 * Interface for communication with user.
 */
public interface UserInterface extends BoardListener {
  /**
   * Print object to user.
   *
   * @param object - object to print
   */
  void println(Object object);

  /**
   * Ask user for input.
   *
   * @return user input in string
   */
  String askForInput();

  /**
   * Ask user for input that is parsed to position.
   *
   * @param boardSize - board side size is needed to calculate position
   * @return calculated position
   */
  int askForPosition(int boardSize);
}
