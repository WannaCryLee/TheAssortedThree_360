package model;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map.Entry;
/**
*
* Creates a volunteer
* 
* @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
* @version Spring 2015
*/
public class Volunteer implements Serializable {
	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -7862577565514502497L;
	//First Name Variable
	private String myFirst;
	//Last Name Variable
	private String myLast;
	//Email Variable
	private String myEmail;
	//Password Variable
	private String myPassword;
	//List of jobs volunteer has signed up for
	private HashMap<Job, Integer> myJobSignedUp;
//	//Sets format for Date Strings
//	private static SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
	

	/**
	 * Create and set a default volunteer
	 */
	public Volunteer() {
		myFirst = "Jane";
		myLast = "Doe";
		myEmail = "janedoe@gmail.com";
		myPassword = "password";
		myJobSignedUp = new HashMap<Job, Integer>();
	}

	/**
	 * Create a volunteer
	 * 
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
		myJobSignedUp = new HashMap<Job, Integer>();
	}

//	/**
//	 * logIn provides the volunteer with the ability to enter into the system.
//	 * 
//	 * @param theEmail the email of the signing in volunteer
//	 * @param thePassword, the volunteers chosen password
//	 * @return string if they were logged in or not
//	 */
//	public String logIn(String theEmail, String thePassword) {
//		if (!theEmail.equals(myEmail) && !thePassword.equals(myPassword)){
//			return "Your email or password does not match our database";
//		}
//		return "Welcome! " + myFirst + " " + myLast;
//	}
//	
	
	
	/**
	 * addJob places the Job the volunteer signed up for in a list, if they do not already have a job that day
	 * 
	 * and they it's not already in their list.
	 * @param theJob, the position the volunteer wishes to sign up for
	 */
	public int addJob(Job theJob, int workload){
		boolean volunteered = false;
		boolean pastJob = false;
		Calendar today = Calendar.getInstance();

		for (Entry<Job, Integer> pair : myJobSignedUp.entrySet()) {
			if (theJob.getEndCalender().before(today))
				pastJob = true;
			if(theJob.getStartDate().compareTo(pair.getKey().getStartDate()) == 0)
				volunteered = true;
		}

		if (pastJob)
			return 0; // "This job already passed!";
		if(volunteered){
			return 1; //"You are already volunteering for a job on this day!";
		} else {
			myJobSignedUp.put(theJob, workload);
			return 2; //"Success!! You are signed up to volunteer for " + theJob.getTitle() + " on " + sdf.format(theJob.getStartDate())+ ".";
		}
	}

	/**
	 * Getters and Setter for First Name
	 */
	public String getMyFirst() {
		return myFirst;
	}

	public void setMyFirst(String theFirst) {
		myFirst = theFirst;
	}


	/**
	 * Getters and Setter for Last Name
	 */
	public String getMyLast() {
		return myLast;
	}

	public void setMyLast(String theLast) {
		myLast = theLast;
	}


	/**
	 * Getters and Setter for email
	 */
	public String getMyEmail() {
		return myEmail;
	}

	public void setMyEmail(String theEmail) {
		myEmail = theEmail;
	}


	/**
	 * Getters and Setter for password
	 */
	public String getMyPassword() {
		return myPassword;
	}

	public void setMyPassword(String thePassword) {
		myPassword = thePassword;
	}


	/**
	 * Getters and Setter for Job signed up
	 */
	public HashMap<Job, Integer> getMyJobSignedUp() {
		return myJobSignedUp;
	}
	
	public void setMyJobSignedUp(HashMap<Job, Integer> theJobSignedUp) {
		myJobSignedUp = theJobSignedUp;
	}

	/**
	 * Returns all the info of the Volunteer
	 * 
	 * @return a string of the Volunteers information
	 */
	public String toString(){
		return myFirst + " " + myLast + "\n" + myEmail + "\n" + "Status: Volunteer";
	}


}
