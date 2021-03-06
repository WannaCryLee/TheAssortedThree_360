package view;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import model.Cereal;
import model.Job;
import model.JobList;

/**
 * Displays jobs 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class JobGui {
	/*
	 * Date format for the jobs
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
	//Constructor
	public JobGui() {
		
	}
	
	/**
	 * Prints the job
	 */
	public void printJobs() {
		Cereal getJobs = new Cereal(1);
		JobList jobs = (JobList)getJobs.deSerialize();
		HashMap<Integer, Object> map = jobs.getMap();
		Date today = new Date();
		int index = 0;
		
		System.out.println("Today's Date: " + sdf.format(today) + "\n");
		
		for (Map.Entry<Integer,Object> pair : map.entrySet()) {
			Job aJob = (Job) pair.getValue();
			if (aJob.getStartDate().after(today)) {
				System.out.println("[ " + index++ + " - " + aJob.getTitle() + ", " + aJob.getParkName() + ", " +
						aJob.getDescription() + ", " + sdf.format(aJob.getStartDate()) + " ]");		
			}
		}	
	}
}
