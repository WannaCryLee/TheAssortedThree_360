package view;

import java.util.Map;
import java.util.Map.Entry;

import model.Cereal;
import model.Job;
import model.JobList;

/**
 * Displays jobs 
 * @author Jordan Love
 *
 */
public class JobGui {

	//Constructor
	public JobGui() {
		
	}
	
	/**
	 * Prints the job
	 */
	public void printJobs() {
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
}
