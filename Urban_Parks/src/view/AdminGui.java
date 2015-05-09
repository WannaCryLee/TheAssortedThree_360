package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.LogIn;
import model.Volunteer;

/**
 * Displays Admin Screen
 * @author Jordan Love
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
				helperAdmin(choice, admin, thisScan);
			} else
				thisScan.next();
		}	
		thisScan.close();
	}
	
	/**
	 * Decision Making for main screen
	 * @param decision			Choice from the user
	 * @param admin				Instance of Admin
	 * @param thisScan			Scanner
	 */
	private void helperAdmin(int decision, LogIn admin, Scanner thisScan) {
		UI tools = new UI();
		tools.clearScreen();
		if (decision == 1) {
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
		} else if (decision == 2) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(admin.getTheAdmin().getMyFirst() + " " + admin.getTheAdmin().getMyLast());
			System.out.println(admin.getTheAdmin().getMyEmail());
			System.out.println("Status: Admin");
			tools.pause();
		}
	}
	
}
