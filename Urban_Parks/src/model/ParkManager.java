package model;

import java.util.HashMap;

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
	
	private JobList jl = new JobList();

	
	public ParkManager() {
		first = null;
		last = null;
		email = null;
		password = null;
		address = null;
	}
	
	/**
	 * 
	 * @param theFirst
	 * @param theLast
	 * @param theEmail
	 * @param thePassword
	 * @param theAddress
	 */
	public ParkManager(String theFirst, String theLast, String theEmail, String thePassword, String theAddress) {
		first = theFirst;
		last = theLast;
		email = theEmail;
		password = thePassword;
		address = theAddress;
	}

	/**
	 * This method logs admin in with given email and password
	 * @param email, string
	 * @param password, string
	 * @return string if they were loged in or not
	 */
	public String logIn(String theEmail, String thePassword) {
		if (!email.equals(theEmail))
			return "Your email or password does not match our database";
		
		if (!password.equals(thePassword))
			return "Your email or password does not match our database";
		return "Welcome! " + first + " " + last;
	}
	
	/**
	 * Submit a job
	 * @param theTitle
	 * @param theParkName
	 * @param theAddress
	 * @param theDescription
	 * @param theGrade
	 */
	public void submitJob(Job theJob) {
		
		HashMap <Integer, Object> jlist = jl.getMap();
		jlist.put(jlist.size(), theJob);
		jl.setMap(jlist); //
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
