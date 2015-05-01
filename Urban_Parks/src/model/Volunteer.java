package model;

import java.util.ArrayList;
import java.util.List;

public class Volunteer {
	//First Name Variable
	private String myFirst;
	//Last Name Variable
	private String myLast;
	//Email Variable
	private String myEmail;
	//Password Variable
	private String myPassword;
	//List of jobs volunteer has signed up for
	private List<Job> myJobSignedUp;

	/**
	 * Create and set a default volunteer
	 */
	public Volunteer() {
		myFirst = "Jane";
		myLast = "Doe";
		myEmail = "janedoe@gmail.com";
		myPassword = "password";
		myJobSignedUp = new ArrayList<Job>();
	}

	/**
	 * Create a volunteer
	 * @param theFirst, first name of the volunteer
	 * @param theLast, last name of the volunteer
	 * @param theEmail, email of the volunteer
	 * @param thePassword, password of the volunteer
	 */
	public Volunteer(String theFirst, String theLast, String theEmail, String thePassword) {
		myFirst = theFirst;
		myLast = theLast;
		myEmail = theEmail;
		myPassword = thePassword;
		myJobSignedUp = new ArrayList<Job>();
	}
	
	/**
	 * logIn provides the volunteer with the ability to enter into the system.
	 * @param theEmail the email of the signing in volunteer
	 * @param thePassword, the volunteers chosen password
	 * @return string if they were logged in or not
	 */
	public String logIn(String theEmail, String thePassword) {
		if (!theEmail.equals(myEmail)) {
			return "Your email or password does not match our database";
		}
		if (!thePassword.equals(myPassword)){
			return "Your email or password does not match our database";
		}
		return "Welcome! " + myFirst + " " + myLast;
	}
	/**
	 * addJob places the Job the volunteer signed up for in a list.
	 * @param theJob, the position the volunteer wishes to sign up for
	 */
	public String addJob(Job theJob){
		//if date in theJob != date in any job in list then
		myJobSignedUp.add(theJob);
		//return "Success!! You are signed up to volunteer for " + theJob.title + " on " + theJob.date + "."
		//else 
		return "You are already volunteering for a job on this day.";
		
	}

	public String getMyFirst() {
		return myFirst;
	}

	public void setMyFirst(String theFirst) {
		myFirst = theFirst;
	}

	public String getMyLast() {
		return myLast;
	}

	public void setMyLast(String theLast) {
		myLast = theLast;
	}

	public String getMyEmail() {
		return myEmail;
	}

	public void setMyEmail(String theEmail) {
		myEmail = theEmail;
	}

	public String getMyPassword() {
		return myPassword;
	}

	public void setMyPassword(String thePassword) {
		myPassword = thePassword;
	}

	public List<Job> getMyJobSignedUp() {
		return myJobSignedUp;
	}

	public void setMyJobSignedUp(List<Job> theJobSignedUp) {
		myJobSignedUp = theJobSignedUp;
	}
	
	
	
}
