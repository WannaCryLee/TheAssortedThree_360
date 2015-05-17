package view;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 * 
 */
public class ParkManagerGui {
	/*
	 * Date format for the jobs
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
	
	//Constructor
	public ParkManagerGui() {
	}

	/**
	 * Main Screen
	 * 
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
	 * 
	 * @param parkManager				instance of Park Manager
	 * @param tools						instance of UI
	 * @param thisScan					instance of Scanner
	 */
	private void submitJobScreen(LogIn parkManager, UI tools, Scanner thisScan) {
		Job newJob;
		System.out.println("Submit a Job!");
		System.out.println("_____________\n"); 

		//System.out.println("\n Under Construction\nPlease check back soon!");
		
		System.out.println("Please enter the following information\n");
		System.out.print("Title (One Word): ");
		String title = thisScan.next();
		System.out.print("\nPark Name: ");
		String parkName = thisScan.next();
		while(!parkManager.getTheManager().isMyPark(parkName.toLowerCase())) {
			System.out.print("\nPlease enter one of your park's name: ");
			parkName = thisScan.next();
		}
		
		if (parkManager.getTheManager().maxPendingJobs(parkName) || parkManager.getTheManager().maxPendingJobsWeek(parkName))
			System.out.println("The jobs for this park is at its max!");
		else {
		
			thisScan.nextLine();
			System.out.print("\nAddress: ");
			String address = thisScan.nextLine();
			System.out.print("\nDescription: ");
			String description = thisScan.nextLine();
			System.out.print("\nNumber of light jobs: ");
			int numLightJobs = thisScan.nextInt();
			System.out.print("\nNumber of medium jobs: ");
			int numMedJobs = thisScan.nextInt();
			System.out.print("\nNumber of heavy jobs: ");
			int numHeavyJobs = thisScan.nextInt();
			System.out.print("\nJob Month (ie. 1 - 12: ");
			int startMonth = thisScan.nextInt();
			System.out.print("\nJob Day (ie. 1 - 31: ");
			int startDay = thisScan.nextInt();
			System.out.print("\nJob Year (ie. 2015): ");
			int startYear = thisScan.nextInt();
			System.out.println("Hour: ");
			int hour = thisScan.nextInt();
			System.out.println("Minutes: ");
			int min = thisScan.nextInt();
		
			System.out.println("Will the job be 2 days long? (Y/N): ");
			String twoDays = thisScan.next();

			if(twoDays.toLowerCase().charAt(0) == 'y') {		
			
				//creates the "Two day" job
				boolean isTwoDays = true;
				newJob = new Job(title, parkName, address, description, numLightJobs, numMedJobs, numHeavyJobs, isTwoDays, startYear, startMonth, startDay,
					startYear, startMonth, startDay + 1, hour, min);
			
			} else {
				//creates the "One day" job
				boolean isTwoDays = false;
				newJob = new Job(title, parkName, address, description, numLightJobs, numMedJobs, numHeavyJobs, isTwoDays, startYear, startMonth, startDay,
						startYear, startMonth, startDay, hour, min);
			}
		
			jobDoubleCheck(thisScan, newJob);
			parkManager.getTheManager().submitJob(newJob);
			tools.clearScreen();
			System.out.println("Job Submitted");
		
			
		}
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

			for (Map.Entry<Integer,Object> pair : jobs.getMap().entrySet()) {
				if (((Job)pair.getValue()).getParkName().toLowerCase().equals(park.toLowerCase())) {
					System.out.println("[ " + pair.getKey() + " - " + ((Job)pair.getValue()).getTitle() + " in " + sdf.format(((Job)pair.getValue()).getStartDate()) + " ]");
				}
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

		for (Entry<Integer, Object> pair : users.getMap().entrySet()) {
			if (pair.getValue() instanceof Volunteer) {
				Volunteer itrVolunteer = ((Volunteer)pair.getValue());
				HashMap<Job, Integer> itrJob = (HashMap<Job, Integer>) itrVolunteer.getMyJobSignedUp();

				for (Entry<Job, Integer> jobPair : itrJob.entrySet()) {
					if (jobPair.getKey().compare(selectedJob)) {
						isJobPrinted = true;
						System.out.println("\n[ " + itrVolunteer.getMyFirst() + itrVolunteer.getMyLast() + "( " + itrVolunteer.getMyEmail() + " )"+ " ]");
					}
				}
			}
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
			int intResolve;
			int problem = job.jobCheck();
			System.out.println("\n\nUh Oh! There was a problem. \nPlease Resolve");
			//Title
			switch (problem) {
			case 1:
				System.out.println("\nPlease Re-enter approved title: ");
				resolve = scan.nextLine();
				job.setTitle(resolve);
				break;
				//Park Name
			case 2:
				System.out.println("\nPlease Re-enter approved Park Name: ");
				resolve = scan.nextLine();
				job.setParkName(resolve);
				break;
				//Address
			case 3:
				System.out.println("\nPlease Re-enter approved Address: ");
				resolve = scan.nextLine();
				job.setAddress(resolve);
				break;
				//Description
			case 4:
				System.out.println("\nPlease Re-enter approved Description: ");
				resolve = scan.nextLine();
				job.setDescription(resolve);
				break;
				//Light Job
			case 5:
				System.out.println("\nPlease Re-enter approved Light Job Amount: ");
				intResolve = scan.nextInt();
				job.setNumLightJobs(intResolve);
				break;
				//Medium Job
			case 6:
				System.out.println("\nPlease Re-enter approved Medium Job Amount: ");
				intResolve = scan.nextInt();
				job.setNumMedJobs(intResolve);
				break;
				//Heavy Job
			case 7:
				System.out.println("\nPlease Re-enter approved Heavy Job Amount: ");
				intResolve = scan.nextInt();
				job.setNumHeavyJobs(intResolve);
				break;
				//Date
			case 8:
				System.out.println("\nPlease Re-enter approved Date: \n");
				System.out.print("Year: ");
				int year = scan.nextInt();
				System.out.print("Month: ");
				int month = scan.nextInt();
				System.out.print("Day: ");
				int day = scan.nextInt();
				job.setStartDate(year, month, day);
				break;
			}
		}
	}
}
