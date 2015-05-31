package model;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
/**
 * Creates a Park Manager.
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 * 
 */
public class ParkManager implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1222538082294391688L;
	/**
	 * Default variables.
	 */
	//First Name Variable
	private static final String DEFAULT_FIRST = "Jon";
	//Last Name Variable
	private static final String DEFAULT_LAST = "Snow";
	//Email Variable
	private static final String DEFAULT_EMAIL = "forTheNorth@winterIsComing.com";
	//Password Variable
	private static final String DEFAULT_PASSWORD = "myWatchBegins";
	//Address Variable
	private static final String DEFAULT_ADDRESS = "North";
	
	private static final int MAX_PENDING_JOBS = 30;
	
	private static final int TWO_DAYS = 2;
	
	private static final int THREE_DAYS_BELOW_CURRENT = -3;
	
	private static final int THREE_DAYS_ABOVE_CURRENT = 3;
	
	private static final int MAX_JOBS_IN_WEEK = 5;

	/** First Name */
	private String first;
	/** Last Name */
	private String last;
	/** Email */ 
	private String email;
	/** Password */
	private String password;
	/** Address */
	private String address;
	// Parks
	private ArrayList<String> parks;

	
	/**
	 * Constructor
	 */
	public ParkManager() {
		first = DEFAULT_FIRST;
		last = DEFAULT_LAST;
		email = DEFAULT_EMAIL;
		password = DEFAULT_PASSWORD;
		address = DEFAULT_ADDRESS;
		parks = new ArrayList<String>();
	}
	

	/**
	 * Constructor.
	 * 
	 * @param theFirst First Name
	 * @param theLast Last Name
	 * @param theEmail Email
	 * @param thePassword Password
	 * @param theAddress Address
	 */
	public ParkManager(String theFirst, String theLast, String theEmail, String thePassword, String theAddress, String park) {
		parks = new ArrayList<String>();
		first = theFirst;
		last = theLast;
		email = theEmail;
		password = thePassword;
		address = theAddress;
		parks.add(park.toLowerCase());
	}

	/**
	 * Submitting a Job
	 * 
	 * @param theJob Job class object
	 */
	public void submitJob(Job theJob) {
		Cereal deserial = new Cereal(1);
		JobList jobs;
		HashMap<Integer, Object> jobList;
		
		if (isFileFound()) {
			jobs = (JobList) deserial.deSerialize();
			jobList = jobs.getMap();
		} else {
			jobs = new JobList();
			jobList = new HashMap<Integer, Object>();
		}
		
		jobList.put(jobList.size(), theJob); 
		jobs.setMap(jobList);
		
		deserial.serialize(jobs);
	}
	
	/**
	 * Returns true if pending jobs is MAX_PENDING_JOBS; returns false if its under
	 * 
	 * @param park			String of park name
	 * @return true if jobs are at max or false if its okay
	 */
	public boolean maxPendingJobs(String park) {
		Cereal data = new Cereal(1);
		JobList list = (JobList)data.deSerialize();
		HashMap<Integer, Object> map = list.getMap();
		int pendingJobs = 0;
		Date todayDate = new Date();
		Calendar today = Calendar.getInstance();
		for (Map.Entry<Integer,Object> pair : map.entrySet()) {
			Job aJob = (Job) pair.getValue();
			  if (!aJob.getIsTwoDays()) {
				  if (aJob.getParkName().equals(park) && aJob.getStartDate().after(todayDate)) 
					  pendingJobs++;
			  } else {
				  if (aJob.getParkName().equals(park) && aJob.getStartDate().after(todayDate))
					  pendingJobs += TWO_DAYS;
				  else if (aJob.getParkName().equals(park) && aJob.getEndCalender().after(today))
					  pendingJobs++;
			  }
		}
		if (pendingJobs >= MAX_PENDING_JOBS)
			return true;
		else
			return false;
	}
	/**
	 * Check if the max number off jobs has been reached for the week
	 * 
	 * @param park			the park name
	 * @return true/false	if the park does have more than 5 or less than 5
	 */
//	public boolean maxPendingJobsWeek(String park, Date jobStartDate, boolean isTwoDays) {
	public boolean maxPendingJobsWeek(String park, Date jobStartDate, boolean isTwoDays) {
		
		Cereal data = new Cereal(1);
		JobList list = (JobList)data.deSerialize();
		HashMap<Integer, Object> map = list.getMap();
		int pendingJobs = 0;
		
		Calendar threeDaysBefore  = Calendar.getInstance();
		threeDaysBefore.setTime(jobStartDate);
		threeDaysBefore.add(Calendar.DATE, THREE_DAYS_BELOW_CURRENT);
		Calendar threeDaysAfter  = Calendar.getInstance();
		threeDaysAfter.setTime(jobStartDate);
		threeDaysAfter.add(Calendar.DATE, THREE_DAYS_ABOVE_CURRENT);

		for (Map.Entry<Integer,Object> pair : map.entrySet()) {
			Job aJob = (Job) pair.getValue();
			
			  if (!aJob.getIsTwoDays()) {
				  if (aJob.getParkName().equals(park) && (aJob.getStartCalender().after(threeDaysBefore)) && 
						  (aJob.getStartCalender().before(threeDaysAfter))) 
					  pendingJobs++;
			  } else {
				  if (aJob.getParkName().equals(park) && 
						  (aJob.getStartCalender().after(threeDaysBefore)) && 
						  (aJob.getStartCalender().before(threeDaysAfter))) 
					  pendingJobs++;
				  if (aJob.getParkName().equals(park) && 
						  (aJob.getEndCalender().after(threeDaysBefore)) && 
						  (aJob.getEndCalender().before(threeDaysAfter))) 
					  pendingJobs++;
			  }
		}
		
		if (!isTwoDays && pendingJobs >= MAX_JOBS_IN_WEEK) {
			return true;
		} else if(isTwoDays && pendingJobs >= (MAX_JOBS_IN_WEEK - 1)){
			return true;
		}
		return false;	
		
	}
	
	/**
	 * Checks to see if job database exist
	 * @return True if there is a current database else false
	 */
	private boolean isFileFound() {
		String path = Cereal.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		String decodedPath = "";
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (decodedPath.contains("/Urban_Parks.jar"))
			decodedPath = decodedPath.substring(0, decodedPath.indexOf("/Urban_Parks.jar"));
		
		File fileFound = new File( decodedPath + "/job.ser");
		
		return fileFound.exists();
	}
	
	/**
	 * Returns true if its instance's park else false if not
	 * 
	 * @param theJob			instance of the new job
	 * @return true 			if its part of park; false if not
	 */
	public boolean isMyPark(String thePark) {
		return parks.contains(thePark);
	}

	
	/**
	 * Getters and Setters for First Name
	 */
	public String getFirst() {
		String returnFirst = first;
		return returnFirst;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	
	/**
	 * Getters and Setters for Last Name
	 */
	public String getLast() {
		String returnLast = last;
		return returnLast;
	}

	public void setLast(String last) {
		this.last = last;
	}

	
	/**
	 * Getters and Setters for email
	 */
	public String getEmail() {
		String returnEmail = email;
		return returnEmail;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * Getters and Setters for password
	 */
	public String getPassword() {
		String returnPassword = password;
		return returnPassword;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * Getters and Setters for address
	 */
	public String getAddress() {
		String returnAddress = address;
		return returnAddress;
	}

	public void setAddress(String address) {
		this.address = address;
	}	
	
	//Getters and Setters for parks
	public ArrayList<String> getParks() {
		ArrayList<String> returnPark = parks;
		return returnPark;
	}

	public void setParks(ArrayList<String> parks) {
		this.parks = parks;
	}
	
	/**
	 * Returns all the info of the Park Manager
	 * 
	 * @return a string of the PM's information
	 */
	public String toString(){
		return first + " " + last + "\n" + email + "\n" + "Status: Park Manager";
	}
}
