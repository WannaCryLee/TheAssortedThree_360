package view;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.util.ArrayList;
import java.util.Scanner;

import model.LogIn;
import model.Volunteer;

/**
 * Displays Admin Screen
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 * 
 */
public class AdminGui {

	//Constructor
	public AdminGui() {
		
	}
	
	/**
	 * Main Screen
	 * @param admin		Instance of Administrator
	 */
	public void printScreen(LogIn admin) {
		Scanner thisScan = new Scanner(System.in);
		UI tools = new UI();
		int choice = 0;
		
		while (choice != 3) {	
			System.out.println("Administrator");
			System.out.println("____________\n");
			System.out.println("Please Enter a Command");
			System.out.println("______________________\n");
			System.out.println("1) Find Volunteers");
			System.out.println("2) My Account");
			System.out.println("3) Exit");
			if (thisScan.hasNextInt()) {
				choice = thisScan.nextInt();
				//helperAdmin(choice, admin, thisScan);
				tools.clearScreen();
				switch (choice) {
				case 1:
					searchVolunteerScreen(admin, tools, thisScan);
					break;
				case 2:
					myAccountScreen(admin, tools);
					break;
				}
			} else
				thisScan.next();
		}	
		thisScan.close();
	}
	
	/**
	 * My Account Screen
	 * @param admin			instance of Admin
	 * @param tools			instacne of UI
	 */
	private void myAccountScreen(LogIn admin, UI tools) {
		System.out.println("My Account");
		System.out.println("__________\n");
		System.out.println(admin.getTheAdmin().toString());
		//System.out.println(admin.getTheAdmin().getMyFirst() + " " + admin.getTheAdmin().getMyLast());
		//System.out.println(admin.getTheAdmin().getMyEmail());
		//System.out.println("Status: Admin");
		tools.pause();
	}
	
	/**
	 * Search Volunteer Screen
	 * @param admin			instance of Admin
	 * @param tools			instance of UI
	 * @param thisScan		instance of Scanner
	 */
	private void searchVolunteerScreen(LogIn admin, UI tools, Scanner thisScan) {
		System.out.println("Find Volunteers");
		System.out.println("_______________\n");
		System.out.print("Last Name: ");
		String lastName = thisScan.next();
		ArrayList<Volunteer> list = admin.getTheAdmin().getVolunteer(lastName);
		tools.clearScreen();
		if (list.size() == 0) {
			System.out.println("No Match Found");
		}
		for (Volunteer person :  list) {
			System.out.println("[ " + person.getMyFirst() + " " + person.getMyLast() + " (Email: " + person.getMyEmail() + ") ]");				
		}
		tools.pause();
	}
	
}
