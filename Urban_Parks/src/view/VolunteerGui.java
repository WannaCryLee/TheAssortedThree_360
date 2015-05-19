package view;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import model.Cereal;
import model.Job;
import model.JobList;
import model.LogIn;
import model.UserList;
import model.Volunteer;

/**
 * Displays Volunteer Screen
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class VolunteerGui {
	
	// Constructor
	public VolunteerGui () {
		
	}
	
	/**
	 * Main Screen
	 * @param volunteer    Instance of volunteer 
	 */
	public void printScreen(LogIn volunteer) {
		Scanner thisScan = new Scanner(System.in);
		UI tools = new UI();
		int choice = 0;
		do {
			System.out.println("\nVolunteer");
			System.out.println("______________________\n");
			System.out.println("Please Enter a Command");
			System.out.println("______________________\n");
			System.out.println("1) View Upcoming Jobs");
			System.out.println("2) My Jobs");
			System.out.println("3) My Account");
			System.out.println("4) Exit");
			if (thisScan.hasNextInt()) {
				choice = thisScan.nextInt();
				tools.clearScreen();
				switch (choice) {
				case 1:
					jobAvailableScreen(volunteer, thisScan, tools);
					break;
				case 2:
					myJobScreen(volunteer, tools);
					break;
				case 3:
					myAccountScreen(volunteer, tools);
					break;
				}
			} else
				thisScan.next();
			
		} while (choice != 4);
		saveUser(volunteer);
		thisScan.close();
	}
	
	/**
	 * Save the user data
	 * @param volunteer
	 */
	private void saveUser(LogIn volunteer) {
		Cereal saver = new Cereal(0);
		UserList userList = (UserList)saver.deSerialize();
		HashMap<Integer, Object> userMap = userList.getMap();
		Volunteer theVolunteer = volunteer.getTheVolunteer();
		int key = -1;
		
		for (Entry<Integer, Object> pair : userMap.entrySet()) {
			if (pair.getValue() instanceof Volunteer) {
				if (((Volunteer)pair.getValue()).getMyEmail().equals(theVolunteer.getMyEmail()))
					key = pair.getKey();
			}
		}

		if (key == -1) {
			userMap.put(userMap.size(), theVolunteer);
		} else {
			userMap.replace(key, theVolunteer);
		}
		userList.setMap(userMap);
		saver.serialize(userList);
	}
	
	/**
	 * My Account Menu Screen
	 * @param volunteer		instance of Volunteer
	 * @param tools			instance of UI
	 */
	private void myAccountScreen(LogIn volunteer, UI tools) {
		System.out.println("My Account");
		System.out.println("__________\n");
		System.out.println(volunteer.getTheVolunteer().toString());
		//System.out.println(volunteer.getTheVolunteer().getMyFirst() + " " + volunteer.getTheVolunteer().getMyLast());
		//System.out.println(volunteer.getTheVolunteer().getMyEmail());
		//System.out.println("Status: Volunteer");
		tools.pause();
	}
	
	/**
	 * My Job Screen
	 * @param volunteer		instance of Volunteer
	 * @param tools			instance of UI
	 */
	private void myJobScreen(LogIn volunteer, UI tools) {
		System.out.println("My Jobs");
		System.out.println("_______");
		HashMap<Job, Integer> jobs = (HashMap<Job, Integer>) volunteer.getTheVolunteer().getMyJobSignedUp();
		for (Entry<Job, Integer> pair : jobs.entrySet()) {
			System.out.println("\n[ " + pair.getKey().getTitle() + " At " + pair.getKey().getStartDate() + " ]");
		}
		if (jobs.isEmpty())
			System.out.println("\nYou have no jobs :(\nChoose option 1 in the next menu to view and sign up for jobs!");
		tools.pause();
	}
	
	/**
	 * Job Available Menu
	 * @param volunteer		instance of Volunteer
	 * @param scan			instance of Scanner
	 * @param tools			instance of UI
	 */
	private void jobAvailableScreen(LogIn volunteer, Scanner scan, UI tools) {
		Cereal getJobs = new Cereal(1);
		JobList jobs = (JobList)getJobs.deSerialize();
		JobGui jobGui = new JobGui();
		
		System.out.println("All Jobs Available");
		System.out.println("__________________\n");
		
		jobGui.printJobs();
		
		//To sign up for a job
		System.out.println("\nWould you like to sign up for a job? (Y/N)");
		String ans = scan.next();
		if (ans.toLowerCase().charAt(0) == 'y') {
			System.out.print("\n\nPlease enter the number for the job you would like to sign up for: ");
			int signJob = scan.nextInt();
			while (signJob >= jobs.getMap().size() || signJob < 0) {
				System.out.print("\nNumber was out of range\nEnter job number: ");
				signJob = scan.nextInt();
			}
			
			System.out.println("Would you like to sign up for Light, Medium, or Heavy work? (0 = light, 1 = medium, 2 = heavy)");
			int workload = scan.nextInt();
			
			((Job)jobs.getMap().get(signJob)).decrementJobCategory(workload);
			
			tools.clearScreen();
			System.out.println("\n" + ((Volunteer)volunteer.getTheVolunteer()).addJob((Job)(jobs.getMap().get((Integer)signJob)), workload));
			tools.pause();
		} else 
			tools.clearScreen();
		
	}
}
