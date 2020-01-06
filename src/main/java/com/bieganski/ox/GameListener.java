package com.bieganski.ox;

/**
 * Interface to notify about game status changes.
 */
public interface GameListener {
  /**
   * Notify about pass win conditions.
   */
  void onWin();

  /**
   * Notify about draw.
   */
  void onDraw();
}
