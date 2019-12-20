package com.bieganski.ox;

import java.util.Scanner;

class App{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		UserInterface userInterface = new ConsoleInterface(scanner, System.out);
		userInterface.print("Tic tac toe!");
		BoardPrinter boardPrinter = new BoardPrinter(userInterface);
		//Const size, just for checking if works
		Board board = new Board(10, boardPrinter);
	}
}
