package com.bieganski.ox.checkers;

import com.bieganski.ox.App;
import com.bieganski.ox.BoardListener;
import com.bieganski.ox.GameListener;
import com.bieganski.ox.model.Field;
import com.bieganski.ox.model.GameSettings;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Initialize and run win checkers to check if added symbol is winning move.
 */
public class Judge implements BoardListener {
  private List<WinChecker> checkers = new ArrayList<>();

  private GameListener gameListener;
  private GameSettings gameSettings;

  public Judge(GameListener gameListener, GameSettings gameSettings) {
    this.gameListener = gameListener;
    this.gameSettings = gameSettings;
    //TODO Supplier in constructor or inside class?
    checkers.add(new HorizontalWinChecker(gameSettings, () -> 1));
    checkers.add(new VerticalWinChecker(gameSettings, gameSettings::getBoardSize));
    checkers.add(new SlantWinChecker(gameSettings, () -> gameSettings.getBoardSize() + 1));
    checkers.add(new ReverseSlantWinChecker(gameSettings, () -> gameSettings.getBoardSize() - 1));
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void onFieldAdded(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
    if (checkWin(fieldsWithValue, addedField)) {
      App.LOG.info("Winner is found!");
      gameListener.onWin();
    } else if (fieldsWithValue.size()
        == gameSettings.getBoardSize() * gameSettings.getBoardSize()) {
      App.LOG.info("Draw! All fields all occupied");
      gameListener.onDraw();
    }
  }

  private boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField) {
    if (addedField != null) {
      return checkers.stream().anyMatch(x -> x.checkWin(fieldsWithValue, addedField));
    }
    return false;
  }
}
