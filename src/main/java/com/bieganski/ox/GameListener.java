package com.bieganski.ox;

/**
 * Notifies about game status changes.
 */
public interface GameListener {
  /**
   * Notifies about pass win conditions.
   */
  void onWin();

  /**
   * Notifies about draw.
   */
  void onDraw();
}
