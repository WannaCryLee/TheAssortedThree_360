package view;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map.Entry;

import model.Cereal;
import model.Job;
import model.JobList;
import model.UserList;
import model.Volunteer;

/**
 * Displays Volunteer Screen
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class VolunteerGui {
	
	/*
	 * Date format for the jobs
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
	
	// Constructor
	public VolunteerGui () {
		
	}
	
	/**
	 * Main Screen
	 * @param volunteer    Instance of volunteer 
	 */
	public void printScreen(Volunteer volunteer) {
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
	private void saveUser(Volunteer theVolunteer) {
		Cereal saver = new Cereal(0);
		UserList userList = (UserList)saver.deSerialize();
		HashMap<Integer, Object> userMap = userList.getMap();
		int key = -1;
		
		for (Entry<Integer, Object> pair : userMap.entrySet()) {
			if (pair.getValue() instanceof Volunteer) {
				Volunteer aVolunteer = (Volunteer) pair.getValue();
				if (aVolunteer.getMyEmail().equals(theVolunteer.getMyEmail()))
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
	private void myAccountScreen(Volunteer volunteer, UI tools) {
		System.out.println("My Account");
		System.out.println("__________\n");
		System.out.println(volunteer.toString());
		tools.pause();
	}
	
	/**
	 * My Job Screen
	 * @param volunteer		instance of Volunteer
	 * @param tools			instance of UI
	 */
	private void myJobScreen(Volunteer volunteer, UI tools) {
		System.out.println("My Jobs");
		System.out.println("_______");
		HashMap<Job, Integer> jobs = (HashMap<Job, Integer>) volunteer.getMyJobSignedUp();
		for (Entry<Job, Integer> pair : jobs.entrySet()) {
			Job myJob = pair.getKey();
			System.out.println("\n[ " + myJob.getTitle() + " At " + myJob.getStartDate() + " ]");
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
	private void jobAvailableScreen(Volunteer volunteer, Scanner scan, UI tools) {
		Cereal getJobs = new Cereal(1);
		JobList jobs = (JobList)getJobs.deSerialize();
		ArrayList<Job> currentJobs = currentJobList(jobs);
		int index = 0;
		int workload = -1;
		boolean pass = true;
		
		System.out.println("All Jobs Available");
		System.out.println("__________________\n");
		
		for (Job aJob : currentJobs) {
			System.out.println("[ " + index++ + " - " + aJob.getTitle() + ", " + aJob.getParkName() + ", " +
					aJob.getDescription() + ", " + sdf.format(aJob.getStartDate()) + " ]");	
		}
		
		
		//To sign up for a job
		System.out.println("\nWould you like to sign up for a job? (Y/N)");
		String ans = scan.next();
		if (ans.toLowerCase().charAt(0) == 'y') {
			
			int signJob = -1;
			while (signJob > currentJobs.size() || signJob < 0) {
				System.out.print("\nPlease enter the number for the job you would like to sign up for: ");
				if (scan.hasNextInt())
					signJob = scan.nextInt();
				else
					scan.next();
			}
			
			Job selectedJob = currentJobs.get(signJob);
			
			
			
			
			
			if (!selectedJob.isWorkCategoryFull(workload))
				selectedJob.decrementJobCategory(workload);
			else {
				System.out.println("\n Work Category is full!");
				pass = false;
			}
			
			tools.clearScreen();
			int result = volunteer.addJob(selectedJob, workload);
			if (result == 0) {
				System.out.print("\n This job already passed!");
				pass = false;
			} else if (result == 1) {
				System.out.print("\n You are already volunteering for a job on this day!");
				pass = false;
			}
			
			if (pass) {
				while (workload < 0 || workload > 2) {
					System.out.println("Would you like to sign up for Light, Medium, or Heavy work? (0 = light, 1 = medium, 2 = heavy)");
					System.out.println("Available Categories: \nLight: " + selectedJob.getNumLightJobs() + " Medium: " + selectedJob.getNumMedJobs() +
							" Heavy: " + selectedJob.getNumHeavyJobs());
					if (scan.hasNextInt())
						workload = scan.nextInt();
					else 
						scan.next();
				}
				if (!selectedJob.isWorkCategoryFull(workload))
					selectedJob.decrementJobCategory(workload);
				else {
					System.out.println("\n Work Category is full!");
					pass = false;
				}
			}
				
			if (pass) {
				//Sets format for Date Strings
				SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
				System.out.print("\n Success!! You are signed up to volunteer for " + selectedJob.getTitle() + " on " + sdf.format(selectedJob.getStartDate())+ ".");
			}
			tools.pause();
		} else 
			tools.clearScreen();
		
	}
	
	/**
	 * Creates the current job list
	 * @param jobs
	 * @return a list of current jobs
	 */
	private ArrayList<Job> currentJobList(JobList jobs) {
		ArrayList<Job> theJobs = new ArrayList<Job>();
		Date today = new Date();
		
		for (Entry<Integer, Object> job : jobs.getMap().entrySet()) {
			Job ajob = (Job)job.getValue();
			if (ajob.getStartDate().after(today))
				theJobs.add(ajob);
		}
		return theJobs;
	}
}
