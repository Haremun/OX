package com.bieganski.ox;

import java.util.Scanner;

class App{
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		UserInterface userInterface = new ConsoleInterface(scanner, System.out);
		userInterface.println("Tic tac toe!");
		//Const size, just for checking if works
		Board board = new Board(10);
		board.addListener(userInterface);
		board.updateListeners();
		board.addField(new Field(15, Symbol.X));
	}
}
