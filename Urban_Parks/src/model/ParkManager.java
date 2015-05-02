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
	
	/**
	 * 
	 * @param theEmail
	 * @param thePassword
	 * @return
	 */
	public String logIn(String theEmail, String thePassword) {
		if (!email.equals(theEmail))
			return "Your email or password does not match our database";
		
		if (!password.equals(thePassword))
			return "Your email or password does not match our database";
		return "Welcome! " + first + " " + last;
	}
	
	public void submitJob(String theTitle, String theParkName, String theAddress, 
			String theDescription, int theGrade, HashMap <Integer, Object> theVolunteerList) {
		
		Job newJob = new Job(theTitle, theParkName, theAddress, theDescription, theGrade, theVolunteerList);
		HashMap <Integer, Object> jlist = jl.getMap();
		jlist.put(jlist.size(), newJob);
		jl.setMap(jlist); //
	}
	
	
	
}
