package com.bieganski.ox.win_checkers;

import com.bieganski.ox.App;
import com.bieganski.ox.BoardListener;
import com.bieganski.ox.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * Board checker, Judge tries find wins
 */
public class Judge implements BoardListener {
    private List<WinChecker> checkers = new ArrayList<>();
    private int boardSize;

    public Judge(int boardSize) {
        checkers.add(new HorizontalWinChecker());
        this.boardSize = boardSize;
    }

    @Override
    public void onBoardUpdate(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
        if (checkWin(fieldsWithValue, addedField, boardSize))
            App.LOG.info("Winner is found!");
    }

    private boolean checkWin(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
        return checkers.stream().anyMatch(x -> x.checkWin(fieldsWithValue, addedField, boardSize));
    }
}
