package view;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import model.Cereal;
import model.Job;
import model.JobList;
import model.LogIn;
import model.UserList;
import model.Volunteer;

/**
 * Displays Park Manager Screen
 * @author Jordan Love
 *
 */
public class ParkManagerGui {
	//Set the format
	private SimpleDateFormat myDateFormat;
	private SimpleDateFormat myTimeFormat;

	//Constructor
	public ParkManagerGui() {
		myDateFormat = new SimpleDateFormat("MMM dd, yyyy");
		myTimeFormat = new SimpleDateFormat("h:mm a");
	}

	/**
	 * Main Screen
	 * @param parkManager      Instance of Park Manager
	 */
	public void printScreen(LogIn parkManager) {
		Scanner thisScan = new Scanner(System.in);
		UI tools = new UI();

		int choice = 0;
		while (choice != 4) {
			System.out.println("Park Manager");
			System.out.println("____________\n");
			System.out.println("Please Enter a Command");
			System.out.println("______________________\n");
			System.out.println("1) Submit a Jobs");
			System.out.println("2) View My Park Jobs");
			System.out.println("3) My Account");
			System.out.println("4) Exit");
			if (thisScan.hasNextInt()) {
				choice = thisScan.nextInt();
				//helperManager(choice, parkManager, thisScan);
				tools.clearScreen();
				switch (choice) {
				case 1:
					submitJobScreen(parkManager, tools, thisScan);
					break;
				case 2:
					myParkJobScreen(parkManager, tools, thisScan);
					break;
				case 3:
					myAccountScreen(parkManager, tools);
					break;
				}
			} else
				thisScan.next();
		}
		thisScan.close();
	}

	/**
	 * Submit a Job Screen
	 * @param parkManager				instance of Park Manager
	 * @param tools						instance of UI
	 * @param thisScan					instance of Scanner
	 */
	private void submitJobScreen(LogIn parkManager, UI tools, Scanner thisScan) {
		System.out.println("Submit a Job!");
		System.out.println("_____________\n"); 

		System.out.println("\n Under Construction\nPlease check back soon!");

		//		System.out.println("Will the job be 2 days long? (Enter Y for yes or anything else for no): ");
		//		String twoDays = thisScan.next();

		/*
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

		if(twoDays.equals("Y") || twoDays.equals("y")){
			//second date and time entry
			//second constructor with two dates and two times
//			System.out.println("What time does the event start (ie. 5:30): ");
//			String time = thisScan.next();
//			System.out.println("In the morning or evening, (AM or PM): ");
//			time += " " + thisScan.next().toUpperCase();
		} else {
			//first constructor with only one date and time
		}

		System.out.print("\nDate: ");
		String date = thisScan.next();/**
		//Job newJob = new Job(title, parkName, address, description, grade, date);
		//Need to check and notify user if job does not align with business rule before submitting!!
		jobDoubleCheck(thisScan, newJob);
		parkManager.getTheManager().submitJob(newJob);
		System.out.println("Job Submitted");
		 */
		tools.pause();
	}

	/**
	 * My Park Job Screen
	 * @param parkManager				instance of Park Manager
	 * @param tools						instance of UI
	 * @param thisScan					instance of Scanner
	 */
	private void myParkJobScreen(LogIn parkManager, UI tools, Scanner thisScan) {
		Cereal jobData = new Cereal(1);
		JobList jobs = (JobList)jobData.deSerialize();
		Cereal userData = new Cereal(0);
		UserList users = (UserList)userData.deSerialize();
		System.out.println("My Park Jobs");
		System.out.println("____________\n");
		ArrayList<String> myParks = parkManager.getTheManager().getParks();
		for (String park : myParks) {

			java.util.Iterator<Entry<Integer, Object>> itr = jobs.getMap().entrySet().iterator();
			while(itr.hasNext()) {
				Map.Entry<Integer, Object> pair = (Map.Entry<Integer, Object>)itr.next();
				if (((Job)pair.getValue()).getParkName().toLowerCase().equals(park.toLowerCase())) {
					System.out.println("[ " + pair.getKey() + " - " + ((Job)pair.getValue()).getTitle() + " in " + ((Job)pair.getValue()).getStartDate() + " ]");
				}
				itr.remove();
			}	
		}

		System.out.println("\nWould you like to see volunteers for a job? (Y/N)");
		String response = thisScan.next();
		if (response.toLowerCase().charAt(0) == 'y') {
			seeVolunteers(parkManager, thisScan, jobs, users);
			tools.pause();
		} else
			tools.clearScreen();

	}

	/**
	 * My Account Screen
	 * @param parkManager			instance of Park Manager
	 * @param tools					instance of UI
	 */
	private void myAccountScreen(LogIn parkManager, UI tools) {
		System.out.println("My Account");
		System.out.println("__________\n");
		System.out.println(parkManager.getTheManager().getFirst() + " " + parkManager.getTheManager().getLast());
		System.out.println(parkManager.getTheManager().getEmail());
		System.out.println("Status: Park Manager");
		tools.pause();
	}

	private void seeVolunteers(LogIn parkManager, Scanner thisScan, JobList jobs, UserList users) {
		System.out.print("\nJob number: ");
		int jobNum = thisScan.nextInt();
		Job selectedJob = (Job)jobs.getMap().get(jobNum);
		while (!parkManager.getTheManager().getParks().contains(selectedJob.getParkName())) {
			System.out.print("\nYou do not have this job number for your park\nPlease enter the correct Job Number: ");
			jobNum = thisScan.nextInt();
			selectedJob = (Job)jobs.getMap().get(jobNum);
		}
		boolean isJobPrinted = false;

		java.util.Iterator<Entry<Integer, Object>> itr = users.getMap().entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Object> pair = (Map.Entry<Integer, Object>)itr.next();
			if (pair.getValue() instanceof Volunteer) {
				Volunteer itrVolunteer = ((Volunteer)pair.getValue());
				ArrayList<Job> itrJob = (ArrayList<Job>) itrVolunteer.getMyJobSignedUp();

				for (Job each : itrJob) {
					if (each.compare(selectedJob)) {
						isJobPrinted = true;
						System.out.println("\n[ " + itrVolunteer.getMyFirst() + itrVolunteer.getMyLast() + "( " + itrVolunteer.getMyEmail() + " )"+ " ]");
					}
				}
			}
			itr.remove();
		}
		if (!isJobPrinted)
			System.out.println("\nNo Volunteers has signed up yet");
	}

	/**
	 * Check to see if the job aligns with business rules
	 * @param scan				instance of Scanner
	 * @param job				instance of Job
	 */
	private void jobDoubleCheck(Scanner scan, Job job) {
		while (job.jobCheck() != 0) {
			String resolve;
			int gradeResolve;
			int problem = job.jobCheck();
			System.out.println("\n\nUh Oh! There was a problem. \nPlease Resolve");
			//Title
			if (problem == 1) {
				System.out.println("\nPlease Re-enter approved title: ");
				resolve = scan.nextLine();
				job.setTitle(resolve);
				//Park Name
			} else if (problem == 2) {
				System.out.println("\nPlease Re-enter approved Park Name: ");
				resolve = scan.nextLine();
				job.setParkName(resolve);
				//Address
			} else if (problem == 3) {
				System.out.println("\nPlease Re-enter approved Address: ");
				resolve = scan.nextLine();
				job.setAddress(resolve);
				//Description
			} else if (problem == 4) {
				System.out.println("\nPlease Re-enter approved Description: ");
				resolve = scan.nextLine();
				job.setDescription(resolve);
				//Grade
			} else if (problem == 5) {
				System.out.println("\nPlease Re-enter approved Grade: ");
				gradeResolve = scan.nextInt();
				//job.setGrade(gradeResolve);
				//Date
			} else if (problem == 6) {
				System.out.println("\nPlease Re-enter approved Date: ");
				resolve = scan.nextLine();
				//job.setDate(resolve);
			}
		}
	}
}
