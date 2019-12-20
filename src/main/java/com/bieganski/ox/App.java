package com.bieganski.ox;

import java.util.Scanner;

class App{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		UserInterface userInterface = new ConsoleInterface(scanner, System.out);
		userInterface.print("Tic tac toe!");
		Board board = new Board(15);
		board.addField(new Field(2, Symbol.X));
		board.addField(new Field(17, Symbol.O));
		board.addField(new Field(20, Symbol.X));
		board.addField(new Field((15 * 14) + 1, Symbol.O));
		userInterface.print(board);

	}
}
