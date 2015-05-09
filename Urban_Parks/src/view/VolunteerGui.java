package view;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import model.Cereal;
import model.Job;
import model.JobList;
import model.LogIn;
import model.Volunteer;

/**
 * Displays Volunteer Screen
 * @author Jordan Love
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
	
	/**
	 * Decision making method for Volunteer
	 * @param decision  	The int of the choice from the user
	 * @param volunteer		The instance of Volunteer
	 * @param scan			Scanner
	 */
	private void helperVolunteer(int decision, LogIn volunteer, Scanner scan) {
		UI tools = new UI();
		tools.clearScreen();
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
			
			tools.pause();
			
		} else if (decision == 2) {
			System.out.println("My Jobs");
			System.out.println("_______");
			ArrayList<Job> jobs = (ArrayList<Job>) volunteer.getTheVolunteer().getMyJobSignedUp();
			for (Job currentJob : jobs) {
				System.out.println("\n[ " + currentJob.getTitle() + " At " + currentJob.getStartDate() + " ]");
			}
			tools.pause();
		} else if (decision == 3) {
			System.out.println("My Account");
			System.out.println("__________\n");
			System.out.println(volunteer.getTheVolunteer().getMyFirst() + " " + volunteer.getTheVolunteer().getMyLast());
			System.out.println(volunteer.getTheVolunteer().getMyEmail());
			System.out.println("Status: Volunteer");
			tools.pause();
		}
	}
}
