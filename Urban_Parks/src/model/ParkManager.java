package model;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Creates a Park Manager.
 * @author Jasmine Pedersen
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

	
	/**
	 * Constructor
	 */
	public ParkManager() {
		first = DEFAULT_FIRST;
		last = DEFAULT_LAST;
		email = DEFAULT_EMAIL;
		password = DEFAULT_PASSWORD;
		address = DEFAULT_ADDRESS;
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
	public ParkManager(String theFirst, String theLast, String theEmail, String thePassword, String theAddress) {
		first = theFirst;
		last = theLast;
		email = theEmail;
		password = thePassword;
		address = theAddress;
	}

	/**
	 * This method logs Park Managers in with given email and password
	 * @param email Email string
	 * @param password Password string
	 * @return string if they were logged in or not
	 */
	public String logIn(String theEmail, String thePassword) {
		if (!email.equals(theEmail))
			return "Your email or password does not match our database";
		
		if (!password.equals(thePassword))
			return "Your email or password does not match our database";
		return "Welcome! " + first + " " + last;
	}
	
	/**
	 * Submitting a Job
	 * @param theJob Job class object
	 */
	public void submitJob(Job theJob) {
		Cereal deserial = new Cereal(1);
		JobList jobs;
		HashMap<Integer, Object> jobList;
		
		File fileFound = new File("Files/job.ser");
		
		if (fileFound.exists()) {
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
	
}
