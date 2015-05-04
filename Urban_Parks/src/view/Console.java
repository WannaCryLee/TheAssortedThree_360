package view;

import java.util.ArrayList;
import java.util.Scanner;

import model.Job;
import model.LogIn;
import model.Volunteer;

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
		LogIn access = new LogIn();
		access.getInstance(givenUsername);
		//User is a admin
		if((access.getTheAdmin() != null) && access.getWhoAmI() == 2) {
			if (!access.getTheAdmin().getMyPassword().equals(givenPassword))
				return false;
			else
				adminScreen(access);
		//User is a Park Manager
		} else if (access.getTheManager() != null && access.getWhoAmI() == 1) {
			if (!access.getTheManager().getPassword().equals(givenPassword))
				return false;
			else managerScreen(access);
		//User is a volunteer
		} else if (access.getTheVolunteer() != null && access.getWhoAmI() == 0) {
			if (!access.getTheVolunteer().getMyPassword().equals(givenPassword))
				return false;
			else 
				volunteerScreen(access);
		} else {
			//Did not find user
			return false;
		}
		return true;
	}
	
	private static void volunteerScreen(LogIn volunteer) {
		Scanner thisScan = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.println("Volunteer");
			System.out.println("______________________\n");
			System.out.println("Please Enter a Command");
			System.out.println("______________________\n");
			System.out.println("1) View Jobs");
			System.out.println("2) My Jobs");
			System.out.println("3) My Account");
			System.out.println("4) Exit");
			choice = thisScan.nextInt();
			helperVolunteer(choice, volunteer);
		}
		thisScan.close();
	}
	
	private static void helperVolunteer(int decision, LogIn volunteer) {
		if (decision == 1) {
			System.out.println("All Jobs Available");
			System.out.println("__________________\n");
			//TODO: Print all jobs to sign up for
		} else if (decision == 2) {
			System.out.println("My Jobs");
			System.out.println("_______");
			ArrayList<Job> jobs = (ArrayList<Job>) volunteer.getTheVolunteer().getMyJobSignedUp();
			for (Job currentJob : jobs) {
				System.out.println("[ " + currentJob.getTitle() + " At " + currentJob.getDate() + " ]");
			}
		} else if (decision == 3) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(volunteer.getTheVolunteer().getMyFirst() + " " + volunteer.getTheVolunteer().getMyLast());
			System.out.println(volunteer.getTheVolunteer().getMyEmail());
			System.out.println("Status: Admin");
		}
	}
	
	private static void adminScreen(LogIn admin) {
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
			choice = thisScan.nextInt();
			helperAdmin(choice, admin);
		}	
		thisScan.close();
	}
	
	private static void helperAdmin(int decision, LogIn admin) {
		if (decision == 1) {
			Scanner thisScan = new Scanner(System.in);
			System.out.println("Find Volunteers");
			System.out.println("_______________\n");
			System.out.print("Last Name: ");
			String lastName = thisScan.nextLine();
			ArrayList<Volunteer> list = admin.getTheAdmin().getVolunteer(lastName);
			for (Volunteer person :  list) {
				System.out.println("[ " + person.getMyFirst() + " " + person.getMyLast() + " ]");				
			}
			thisScan.close();
		} else if (decision == 2) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(admin.getTheAdmin().getMyFirst() + " " + admin.getTheAdmin().getMyLast());
			System.out.println(admin.getTheAdmin().getMyEmail());
			System.out.println("Status: Admin");
		}
	}
	
	private static void managerScreen(LogIn parkManager) {
		Scanner thisScan = new Scanner(System.in);
		int choice = 0;
		while (choice != 3) {
			System.out.println("Park Manager");
			System.out.println("____________\n");
			System.out.println("Please Enter a Command");
			System.out.println("______________________\n");
			System.out.println("1) Submit a Jobs");
			System.out.println("2) My Account");
			System.out.println("3) Exit");
			choice = thisScan.nextInt();
			helperManager(choice, parkManager);
		}
		thisScan.close();
	}
	
	private static void helperManager(int decision, LogIn parkManager) {
		Scanner thisScan = new Scanner(System.in);
		if (decision == 1) {
			clearScreen();
			System.out.println("Submit a Job!");
			System.out.println("_____________\n");
			System.out.println("Please enter the following information");
			System.out.print("Title: ");
			String title = thisScan.next();
			System.out.print("\nPark Name: ");
			String parkName = thisScan.next();
			System.out.print("\nAddress: ");
			String address = thisScan.next();
			System.out.print("\nDescription: ");
			String description = thisScan.next();
			System.out.print("\nGrade: ");
			int grade = thisScan.nextInt();
			System.out.print("\nDate");
			String date = thisScan.next();
			Job newJob = new Job(title, parkName, address, description, grade, date);
			parkManager.getTheManager().submitJob(newJob);
			System.out.println("Job Submitted");
			
		} else if (decision == 2) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(parkManager.getTheManager().getFirst() + " " + parkManager.getTheManager().getLast());
			System.out.println(parkManager.getTheManager().getEmail());
			System.out.println("Status: Park Manager");
		}
		thisScan.close();
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
