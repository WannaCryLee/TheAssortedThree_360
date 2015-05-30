package view;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.util.Scanner;

import model.LogIn;

/**
 * Displays log in 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class LogInGui {
	
	//Constructor
	public LogInGui() {
		
	}
	
	/**
	 * Main screen to log in
	 */
	public void logIn() {
		UI tools = new UI();
		tools.clearScreen();
		Scanner in = new Scanner(System.in);
		String givenUsername = "", givenPassword = "";
		do {
			System.out.println("Please Log-In!");
			System.out.println("______________\n");
			System.out.print("Username: ");
			givenUsername = in.next();
			System.out.print("\nPassword: ");
			givenPassword = in.next();
			tools.clearScreen();
		} while (!checkLogIn(givenUsername, givenPassword));
		in.close();
	}
	
	/**
	 * Checks to make sure credentials match
	 * @param givenUsername			User's email
	 * @param givenPassword			User's password
	 * @return
	 */
	private boolean checkLogIn(String givenUsername, String givenPassword) {
		AdminGui admin = new AdminGui();
		VolunteerGui volunteer = new VolunteerGui();
		ParkManagerGui manager = new ParkManagerGui();
		LogIn access = new LogIn();
		access.getInstance(givenUsername);
		//User is a admin
		if((access.getTheAdmin() != null) && access.getWhoAmI() == 2) {
			if (!access.getTheAdmin().getMyPassword().equals(givenPassword))
				return false;
			else
				admin.printScreen(access.getTheAdmin());
		//User is a Park Manager
		} else if (access.getTheManager() != null && access.getWhoAmI() == 1) {
			if (!access.getTheManager().getPassword().equals(givenPassword))
				return false;
			else 
				manager.printScreen(access.getTheManager());
		//User is a volunteer
		} else if (access.getTheVolunteer() != null && access.getWhoAmI() == 0) {
			if (!access.getTheVolunteer().getMyPassword().equals(givenPassword))
				return false;
			else 
				volunteer.printScreen(access.getTheVolunteer());
		} else {
		//Did not find user
			return false;
		}
		return true;
	}

}
