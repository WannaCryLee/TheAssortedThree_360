package model;

import java.util.HashMap;

/**
 * Creates a Park Manager.
 * @author Jasmine Pedersen
 *
 */
public class ParkManager {

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
	/** List of all job's created by this Park Manager */
	private JobList jl = new JobList();

	
	/**
	 * Constructor
	 */
	public ParkManager() {
		first = null;
		last = null;
		email = null;
		password = null;
		address = null;
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
		//We need to find a way to pass the Job List between Classes
		HashMap <Integer, Object> jlist = jl.getMap();
		jlist.put(jlist.size(), theJob);
		jl.setMap(jlist); 
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

	
	/**
	 * Getters and Setters for JobList
	 */
	public JobList getJl() {
		JobList returnJl = jl;
		return returnJl;
	}

	public void setJl(JobList jl) {
		this.jl = jl;
	}
	
	
	
}
