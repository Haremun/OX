package com.bieganski.ox;

public class App{
	public static void main(String[] args){
		UserInterface userInterface = new ConsoleInterface(System.in, System.out);
		userInterface.print("Tic tac toe!");
		Board board = new Board(15);
		board.addFiled();
		userInterface.print(board);

	}
}
