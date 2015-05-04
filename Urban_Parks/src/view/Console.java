package view;

import java.util.Scanner;

public class Console {
	
	public static void main(String[] args) {	
		Scanner scan = new Scanner(System.in);
		printTitle();
		System.out.println("Would you like to log in? (Y for yes or anything else to bypass)");
		System.out.println("          (Volunteers need to log in if they want to sign up for a job)");
		System.out.println("          (Park Managers and Administrators are required to log in)");
		String answer = scan.next();
		if (answer.toLowerCase().charAt(0) == 'y')
			logIn();
		else {
			printJobs();
			System.out.println("Would you like to log in to sign up for a job? (Y/N)");
			answer = scan.next();
			if (answer.toLowerCase().charAt(0) == 'y')
				logIn();
		}
		scan.close();
		closeProgram();
	}
	
	private static void closeProgram() {
		clearScreen();
		System.out.println("Thank you for visiting! \n Good Bye");
	}
	
	private static void printJobs() {
		//TODO: print jobs
	}
	
	private static void printTitle() {
		System.out.println(" ________________________");
		System.out.println("|                        |");
		System.out.println("|       Urban Parks      |");
		System.out.println("|________________________|\n");
	}
	
	private static void logIn() {
		Scanner in = new Scanner(System.in);
		String givenUsername = "", givenPassword = "";
		do {
			System.out.println("Please Log-In!");
			System.out.println("______________\n");
			System.out.print("Username: ");
			givenUsername = in.next();
			System.out.print("\nPassword: ");
			givenPassword = in.next();
			clearScreen();
		} while (!checkLogIn(givenUsername, givenPassword));
		in.close();
	}
	
	private static boolean checkLogIn(String givenUsername, String givenPassword) {
		
		return true;
	}
	
	private static void clearScreen() {
		try {
			String os = System.getProperty("os.name");
			if (os.contains("Windows"))
				Runtime.getRuntime().exec("cls");
			else
				Runtime.getRuntime().exec("clear");
		} catch (Exception e) {
			e.printStackTrace();
		}
		printTitle();
	}
	
}
