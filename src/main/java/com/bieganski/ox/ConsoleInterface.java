package com.bieganski.ox;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeSet;

class ConsoleInterface implements UserInterface {
    private Scanner scanner;
    private PrintStream out;

    ConsoleInterface(Scanner scanner, PrintStream printStream) {
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

    @Override
    public void onBoardUpdate(TreeSet<Field> fieldsWithValue, Field addedField, int size) {
        BoardPainter boardPainter = new BoardPainter();
        println(boardPainter.paintBoard(fieldsWithValue, size));
    }
}
