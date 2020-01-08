package com.bieganski.ox.checkers;

import com.bieganski.ox.model.GameSettings;

import java.util.function.Supplier;

class VerticalWinChecker extends WinChecker {
  VerticalWinChecker(GameSettings gameSettings, Supplier<Integer> supplier) {
    super(gameSettings, supplier);
  }
}
