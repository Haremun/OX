package com.bieganski.ox.checkers;

import com.bieganski.ox.model.Field;
import com.bieganski.ox.model.GameSettings;

import java.util.function.Supplier;

class HorizontalWinChecker extends WinChecker {
  HorizontalWinChecker(GameSettings gameSettings, Supplier<Integer> supplier) {
    super(gameSettings, supplier);
  }

  @Override
  protected boolean isRowCorrect(Field current, Field next) {
    return current.hashCode() / boardSize == next.hashCode() / boardSize;
  }
}
