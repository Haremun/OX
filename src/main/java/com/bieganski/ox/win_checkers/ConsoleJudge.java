package com.bieganski.ox.win_checkers;

import com.bieganski.ox.App;
import com.bieganski.ox.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class ConsoleJudge implements Judge {
    private List<WinChecker> checkers = new ArrayList<>();
    private int boardSize;

    public ConsoleJudge(int boardSize) {
        checkers.add(new HorizontalWinChecker());
        this.boardSize = boardSize;
    }

    @Override
    public void onBoardUpdate(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
        boolean win = false;
        for (WinChecker checker :
                checkers) {
            if (checker.checkWin(fieldsWithValue, addedField, boardSize)) {
                win = true;
                break;
            }
        }
        if (win)
            App.LOG.info("Winner is found!");
    }
}
