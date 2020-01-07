package com.bieganski.ox.checkers;

import com.bieganski.ox.App;
import com.bieganski.ox.BoardListener;
import com.bieganski.ox.GameListener;
import com.bieganski.ox.model.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Initialize and run win checkers to check if added symbol is winning move.
 */
public class Judge implements BoardListener {
  private List<WinChecker> checkers = new ArrayList<>();
  private int boardSize;

  private GameListener gameListener;

  public Judge(GameListener gameListener, int boardSize) {
    this.gameListener = gameListener;
    this.boardSize = boardSize;
    //TODO Think about one class with functional interfaces
    checkers.add(new HorizontalWinChecker(boardSize, 3));
    checkers.add(new VerticalWinChecker(boardSize, 3));
    checkers.add(new SlantWinChecker(boardSize, 3));
    checkers.add(new ReverseSlantWinChecker(boardSize, 3));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onFieldAdded(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
    if (checkWin(fieldsWithValue, addedField, boardSize)) {
      App.LOG.info("Winner is found!");
      gameListener.onWin();
    }
    if (fieldsWithValue.size() == size * size) {
      App.LOG.info("Draw! All fields all occupied");
      gameListener.onDraw();
    }
  }

  private boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
    return checkers.stream().anyMatch(x -> x.checkWin(fieldsWithValue, addedField));
  }
}
