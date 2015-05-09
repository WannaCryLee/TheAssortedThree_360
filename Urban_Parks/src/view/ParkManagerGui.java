package view;

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

public class ParkManagerGui {

	public ParkManagerGui() {
		
	}
	
	public void printScreen(LogIn parkManager) {
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
	
	private void helperManager(int decision, LogIn parkManager, Scanner thisScan) {
		UI tools = new UI();
		tools.clearScreen();
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
			tools.pause();
			
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
			
			tools.pause();
		} else if (decision == 3) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(parkManager.getTheManager().getFirst() + " " + parkManager.getTheManager().getLast());
			System.out.println(parkManager.getTheManager().getEmail());
			System.out.println("Status: Park Manager");
			tools.pause();
		}
	}
	
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
