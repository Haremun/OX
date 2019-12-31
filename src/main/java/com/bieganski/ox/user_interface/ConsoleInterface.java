package com.bieganski.ox.user_interface;

import com.bieganski.ox.Field;
import com.bieganski.ox.painters.ConsoleBoardPainter;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.TreeSet;

public class ConsoleInterface implements UserInterface {
    private Scanner scanner;
    private PrintStream out;

    public ConsoleInterface(Scanner scanner, PrintStream printStream) {
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
        println(new ConsoleBoardPainter()
                .paintBoard(fieldsWithValue, size));
    }
}
