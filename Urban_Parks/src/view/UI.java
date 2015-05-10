package view;

import java.util.Scanner;

/**
 * UI tools 
 * @author Jordan Love
 *
 */
public class UI {
	
	//Constructor
	public UI() {
		
	}
	
	/**
	 * Clears the screen by printing new lines
	 */
	protected void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n\n");
		}
		printTitle();
	}
	
	/**
	 * Pauses program so the user can read
	 */
	@SuppressWarnings("resource")
	protected void pause() {
		 System.out.println("\n\nPress Enter To Continue...");
         new Scanner(System.in).nextLine();
		clearScreen();
	}
	
	/**
	 * Prints the Company Title
	 */
	protected void printTitle() {
		System.out.println(" ________________________");
		System.out.println("|                        |");
		System.out.println("|       Urban Parks      |");
		System.out.println("|________________________|  Created by: TheAssortedThree\n");
	}
	
	/**
	 * Closes the program by clearing the screen and saying good bye
	 */
	protected void closeProgram() {
		clearScreen();
		System.out.println("Thank you for visiting! \nGood Bye");
	}
}
