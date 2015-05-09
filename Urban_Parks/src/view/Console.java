package view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import model.Admin;
import model.Cereal;
import model.Job;
import model.JobList;
import model.LogIn;
import model.ParkManager;
import model.UserList;
import model.Volunteer;

/**
 * Console Driver for Urban Parks
 * @author Jordan Love
 *
 */
public class Console {
	
	public static void main(String[] args) {
		startProgram();
		Scanner scan = new Scanner(System.in);
		clearScreen();
		System.out.println("Would you like to log in? (Y for yes or anything else to bypass)");
		System.out.println("          (Volunteers need to log in if they want to sign up for a job)");
		System.out.println("          (Park Managers and Administrators are required to log in)");
		String answer = scan.next();
		if (answer.toLowerCase().charAt(0) == 'y')
			logIn();
		else {
			clearScreen();
			printJobs();
			System.out.println("\n\nWould you like to log in to sign up for a job? (Y/N)");
			answer = scan.next();
			if (answer.toLowerCase().charAt(0) == 'y')
				logIn();
		}
		scan.close();
		closeProgram();
	}
	
	
	
	
	
	//****************************************************************************************************
	//									        Volunteer Screen
	//****************************************************************************************************

	
	
	
	
	/**
	 * Main volunteer Screen
	 * If modifying print statements make sure to modify the helperVolunteer method as well
	 */
	private static void volunteerScreen(LogIn volunteer) {
		Scanner thisScan = new Scanner(System.in);
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
				helperVolunteer(choice, volunteer, thisScan);
			} else
				thisScan.next();
			
		} while (choice != 4);
		thisScan.close();
	}
	
	private static void helperVolunteer(int decision, LogIn volunteer, Scanner scan) {
		clearScreen();
		if (decision == 1) {
			System.out.println("All Jobs Available");
			System.out.println("__________________\n");
			Cereal getJobs = new Cereal(1);
			JobList jobs = (JobList)getJobs.deSerialize();
			

			java.util.Iterator<Entry<Integer, Object>> itr = jobs.getMap().entrySet().iterator();
			while(itr.hasNext()) {
				Map.Entry<Integer, Object> pair = (Map.Entry<Integer, Object>)itr.next();
				System.out.println("[ " + pair.getKey() + " - " + ((Job)pair.getValue()).getTitle() + ", " + ((Job)pair.getValue()).getParkName() + ", " +
						((Job)pair.getValue()).getDescription() + ", " + 
						((Job)pair.getValue()).getStartDate() + " ]");				
				itr.remove();
			}	
			//To sign up for a job
			System.out.println("\n Would you like to sign up for a job? (Y/N)");
			String ans = scan.next();
			if (ans.toLowerCase().charAt(0) == 'y') {
				System.out.print("\n\n Please enter the number for the job you would like to sign up for: ");
				int signJob = scan.nextInt();
				System.out.println("\n" + ((Volunteer)volunteer.getTheVolunteer()).addJob((Job)(jobs.getMap().get((Integer)signJob))));
			}
			
			pause(scan);
			
		} else if (decision == 2) {
			System.out.println("My Jobs");
			System.out.println("_______");
			ArrayList<Job> jobs = (ArrayList<Job>) volunteer.getTheVolunteer().getMyJobSignedUp();
			for (Job currentJob : jobs) {
				System.out.println("\n[ " + currentJob.getTitle() + " At " + currentJob.getStartDate() + " ]");
			}
			pause(scan);
		} else if (decision == 3) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(volunteer.getTheVolunteer().getMyFirst() + " " + volunteer.getTheVolunteer().getMyLast());
			System.out.println(volunteer.getTheVolunteer().getMyEmail());
			System.out.println("Status: Volunteer");
			pause(scan);
		}
	}
	
	
	
	
	
	//****************************************************************************************************
	//									      Administrator Screen
	//****************************************************************************************************

	
	
	
	/**
	 * Main Administrator Screen
	 * If modifying print statements make sure to modify the helperAdmin method as well
	 */
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
			if (thisScan.hasNextInt()) {
				choice = thisScan.nextInt();
				helperAdmin(choice, admin, thisScan);
			} else
				thisScan.next();
		}	
		thisScan.close();
	}
	
	private static void helperAdmin(int decision, LogIn admin, Scanner thisScan) {
		clearScreen();
		if (decision == 1) {
			System.out.println("Find Volunteers");
			System.out.println("_______________\n");
			System.out.print("Last Name: ");
			String lastName = thisScan.next();
			ArrayList<Volunteer> list = admin.getTheAdmin().getVolunteer(lastName);
			clearScreen();
			if (list.size() == 0) {
				System.out.println("No Match Found");
			}
			for (Volunteer person :  list) {
				System.out.println("[ " + person.getMyFirst() + " " + person.getMyLast() + " (Email: " + person.getMyEmail() + ") ]");				
			}
			pause(thisScan);
		} else if (decision == 2) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(admin.getTheAdmin().getMyFirst() + " " + admin.getTheAdmin().getMyLast());
			System.out.println(admin.getTheAdmin().getMyEmail());
			System.out.println("Status: Admin");
			pause(thisScan);
		}
	}
	
	
	
	
	
	
	
	//****************************************************************************************************
	//									        Park Manager Screen
	//****************************************************************************************************

	
	
	
	
	
	/**
	 * Main Park Manager Screen
	 * If modifying print statements make sure to modify the helperManager method as well
	 */
	private static void managerScreen(LogIn parkManager) {
		Scanner thisScan = new Scanner(System.in);
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
				helperManager(choice, parkManager, thisScan);
			} else
				thisScan.next();
		}
		thisScan.close();
	}
	
	private static void helperManager(int decision, LogIn parkManager, Scanner thisScan) {
		clearScreen();
		if (decision == 1) {
			//clearScreen();
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
			System.out.print("\nDate: ");
			String date = thisScan.next();/**
			//Job newJob = new Job(title, parkName, address, description, grade, date);
			//Need to check and notify user if job does not align with business rule before submitting!!
			jobDoubleCheck(thisScan, newJob);
			parkManager.getTheManager().submitJob(newJob);
			System.out.println("Job Submitted");
			*/
			pause(thisScan);
			
			//View Park jobs
		} else if (decision == 2) {
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
				System.out.println("What job number?");
				int jobNum = thisScan.nextInt();
				Job selectedJob = (Job)jobs.getMap().get(jobNum);
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
					System.out.println("No Volunteers has signed up yet\n");
			}
			
			pause(thisScan);
		} else if (decision == 3) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(parkManager.getTheManager().getFirst() + " " + parkManager.getTheManager().getLast());
			System.out.println(parkManager.getTheManager().getEmail());
			System.out.println("Status: Park Manager");
			pause(thisScan);
		}
	}
	
	private static void jobDoubleCheck(Scanner scan, Job job) {
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
	
	
	
	
	
	
	//****************************************************************************************************
	//									        Console UI 
	//****************************************************************************************************

	
	
	
	
	
	
	
	private static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println("\n\n");
		}
		printTitle();
	}
	
	private static void pause(Scanner scan) {
		String getOut = "";
		do {
			System.out.println("\n Input anything to continue");
			getOut = scan.next();
		} while (getOut == "");
		clearScreen();
	}
	
	private static void printTitle() {
		System.out.println(" ________________________");
		System.out.println("|                        |");
		System.out.println("|       Urban Parks      |");
		System.out.println("|________________________|  Created by: TheAssortedThree\n");
	}
	
	private static void closeProgram() {
		clearScreen();
		System.out.println("Thank you for visiting! \nGood Bye");
	}
	
	
	
	
	
	
	
	
	
	//****************************************************************************************************
	//									        Jobs toString
	//****************************************************************************************************

	
	
	
	
	
	
	private static void printJobs() {
		Cereal getJobs = new Cereal(1);
		JobList jobs = (JobList)getJobs.deSerialize();
		

		java.util.Iterator<Entry<Integer, Object>> itr = jobs.getMap().entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Object> pair = (Map.Entry<Integer, Object>)itr.next();
			System.out.println("[ " + ((Job)pair.getValue()).getTitle() + ", " + ((Job)pair.getValue()).getParkName() + ", " +
					((Job)pair.getValue()).getDescription() + ", " +
					((Job)pair.getValue()).getStartDate() + " ]");			
			itr.remove();
		}		
	}
	
	
	
	
	
	
	//****************************************************************************************************
	//									        Log In
	//****************************************************************************************************

	
	
	
	
	
	
	private static void logIn() {
		clearScreen();
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

	
	
	
	
	
	//****************************************************************************************************
	//							           		Set Up Data
	//****************************************************************************************************
	
	

	
	
	
	private static void startProgram() {
		UserList userList = new UserList();
		JobList jobList = new JobList();
		HashMap<Integer, Object> startingMap = new HashMap<Integer, Object>();
		
		Volunteer newVolunteer = new Volunteer("Bob", "Johnson", "bjohnson@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("John", "Rotissary", "jrotissary@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("Duk", "Boki", "dboki@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("Sue", "Shi", "sshi@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("Rue", "Shi", "rshi@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("Pilot", "Whale", "pwhale@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		Admin newAdmin = new Admin("Blue", "Whale", "bwhale@gmail.com", "Pacific Ocean", "password");
		
		startingMap.put(startingMap.size(), newAdmin);
		
		ParkManager newManager = new ParkManager("Orca", "Whale", "owhale@gmail.com", "password", "Pacific Ocean", "Wright");
		
		startingMap.put(startingMap.size(), newManager);
		
		userList.setMap(startingMap);
		
		startingMap = new HashMap<Integer, Object>();
		
		Job startingJob = new Job("Rock", "Tuscany", "Tacoma, WA", "Clean Rocks", 3, 5, 3, 2015, 5, 15, 2015, 5, 15);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("Bark", "Tuscany", "Tacoma, WA", "New Bark",3, 5, 3, 2015, 5, 30, 2015, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("Sweep", "Wright", "Tacoma, WA", "Sweep Sidewalks", 3, 5, 3, 2015, 6, 15, 2015, 6, 15);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("Garbage", "Wright", "Tacoma, WA", "Change all the Garbage", 3, 5, 3, 2015, 7, 15, 2015, 7, 15);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("New Fountain", "Lighthouse", "Tacoma, WA", "Install new fountain", 3, 5, 3, 2015, 8, 15, 2015, 8, 15);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("BBQ", "LightHouse", "Tacoma, WA", "Cook Meat :)", 3, 5, 3, 2015, 9, 15, 2015, 9, 15);
		
		startingMap.put(startingMap.size(), startingJob);
		
		jobList.setMap(startingMap);
		
		//Serialize Data
		Cereal storeUserData = new Cereal(0);
		Cereal storeJobData = new Cereal(1);
		storeUserData.serialize(userList);
		storeJobData.serialize(jobList);
	}
	
}
