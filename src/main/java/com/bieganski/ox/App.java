package com.bieganski.ox;

import java.util.Scanner;

class App{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		UserInterface userInterface = new ConsoleInterface(scanner, System.out);
		userInterface.print("Tic tac toe!");
		Board board = new Board(15);
		try {
			board.addField(new Field(new Coordinates(2, 2), Symbol.X));
			board.addField(new Field(new Coordinates(6, 7), Symbol.O));
			board.addField(new Field(new Coordinates(2, 1), Symbol.X));
			board.addField(new Field(new Coordinates(3, 5), Symbol.O));
		} catch (FieldIsNotEmptyException e) {
			e.printStackTrace();
		}
		userInterface.print(board);

	}
}
