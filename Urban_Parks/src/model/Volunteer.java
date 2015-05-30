package model;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.io.Serializable;
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


	/**
	 * addJob places the Job the volunteer signed up for in a list, if they do not already have a job that day
	 * and they it's not already in their list.
	 * @param theJob, the position the volunteer wishes to sign up for
	 * @return 0 if the job is in the past
	 * @return 1 if the job is conflicting the same day
	 * @return 2 if the job was successful
	 */
	public int addJob(Job theJob, int workload){
		Calendar today = Calendar.getInstance();

		if (theJob.getEndCalender().before(today))
			return 0; // "This job already passed!";
		if (isSameDay(theJob))
			return 1; //it is conflicting dates
		myJobSignedUp.put(theJob, workload);
		return 2; //"Success!!

	}
	
	/**
	 * Checks to see if the job is conflicting with the same day
	 * @param theJob to check 
	 * @return true if it is on the same day else false
	 */
	private boolean isSameDay(Job theJob) {
		for (Entry<Job, Integer> pair : myJobSignedUp.entrySet()) {	
			Job myJob = pair.getKey();
			if(theJob.getStartDate().compareTo(myJob.getStartDate()) == 0)
				return true;
		}
		return false;
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
