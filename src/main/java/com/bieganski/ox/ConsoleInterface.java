package com.bieganski.ox;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInterface implements UserInterface {
    private Scanner scanner;
    private PrintStream out;

    public ConsoleInterface(InputStream inputStream, PrintStream printStream) {
        this.scanner = new Scanner(inputStream);
        this.out = printStream;
    }

    @Override
    public void print(Object object) {
        out.println(object);
    }
}
