package com.bieganski.ox;

import java.io.PrintStream;
import java.util.Scanner;

class ConsoleInterface implements UserInterface {
    private Scanner scanner;
    private PrintStream out;

    ConsoleInterface(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.out = printStream;
    }

    @Override
    public void print(Object object) {
        out.println(object);
    }
}
