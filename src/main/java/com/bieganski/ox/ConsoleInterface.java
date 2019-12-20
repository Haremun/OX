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

    @Override
    public void refreshAndPrint(Object object) {
        out.print("\033[2J\033[1;1H");
        out.println(object);
    }
}
