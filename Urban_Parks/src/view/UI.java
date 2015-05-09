package view;

import java.util.Scanner;

public class UI {
	public UI() {
		
	}
	protected void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n\n");
		}
		printTitle();
	}
	
	@SuppressWarnings("resource")
	protected void pause() {
		 System.out.println("\n\nPress Enter To Continue...");
         new Scanner(System.in).nextLine();
		clearScreen();
	}
	
	protected void printTitle() {
		System.out.println(" ________________________");
		System.out.println("|                        |");
		System.out.println("|       Urban Parks      |");
		System.out.println("|________________________|  Created by: TheAssortedThree\n");
	}
	
	protected void closeProgram() {
		clearScreen();
		System.out.println("Thank you for visiting! \nGood Bye");
	}
}
