package com.bieganski.ox;

public class App{
	public static void main(String[] args){
		UserInterface userInterface = new ConsoleInterface(System.in, System.out);
		userInterface.print("Tic tac toe!");
		Board board = new Board(15);
		try {
			board.addFiled(new Field(new Coordinates(2, 2), Symbol.X));
			board.addFiled(new Field(new Coordinates(6, 7), Symbol.O));
			board.addFiled(new Field(new Coordinates(2, 1), Symbol.X));
			board.addFiled(new Field(new Coordinates(3, 5), Symbol.O));
		} catch (FieldIsNotEmptyException e) {
			e.printStackTrace();
		}
		userInterface.print(board);

	}
}
