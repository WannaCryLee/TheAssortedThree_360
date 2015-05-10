/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Creates a job.
 * @author Jasmine Pedersen
 *
 */
public class Job implements Serializable {

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -7742067979482263151L;
	/*
	 * Date format for the jobs
	 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
	/*
	 * Start Date for the job 
	 */
	private Calendar myStartDate;
	//Job end date
	private Calendar myEndDate;
	
	/** Job title */
	private String title; 
	/** Park name the job belongs to */
	private String parkName;
	/** Address of job's location */
	private String address;
	/** Variable for describing the job's details */
	private String description;

	/** Work Category integer variable: 0 = light, 1 = Medium, 2 = Heavy. */
	//private int workCat;

	/** Specifies the number of required volunteers for each category grade. */
	private int numLightJobs;
	private int numMedJobs;
	private int numHeavyJobs;
	/** A list of the volunteers who signed up for the job. */
	private ArrayList<Volunteer> signedUpList;

	//Job duration
	//private int myJobDuration;
	/** Date of job */
	//private String date;

	/**
	 * Constructor
	 */
	public Job() {
		title = null;
		parkName = null;
		address = null;
		description = null;
		numLightJobs = 0;
		numMedJobs = 0;
		numHeavyJobs = 0;
		myStartDate = new GregorianCalendar(2015, 12-1, 24);
		myEndDate = new GregorianCalendar(2015, 12-1, 25);
		//date = null;

		signedUpList = new ArrayList<Volunteer>();
	}

	
	
	/**
	 * Constructor for two days
	 * 
	 * @param theTitle Title of job
	 * @param theParkName Park name job was created for
	 * @param theAddress Address
	 * @param theDescription Description of the job
	 * @param theGrade Job's difficulty level (easy, med, hard)
	 * @param theYear the year of the users job
	 * @param theMonth the month of the users job
	 * @param theDay the day of the users job
	 */
	public Job(String theTitle, String theParkName, String theAddress, 
			String theDescription, int theNumLightJobs, int theNumMedJobs,int theNumHeavyJobs, 
			int theStartYear, int theStartMonth, int theStartDay,
			int theEndYear, int theEndMonth, int theEndDay) {
		title = theTitle;
		parkName = theParkName;
		address = theAddress;
		description = theDescription;
		numLightJobs = theNumLightJobs;
		numMedJobs = theNumMedJobs;
		numHeavyJobs = theNumHeavyJobs;
		myStartDate = new GregorianCalendar(theStartYear, theStartMonth-1, theStartDay);
		myEndDate = new GregorianCalendar(theEndYear, theEndMonth-1, theEndDay);
		//date = theDate;

		signedUpList = new ArrayList<Volunteer>();
	}
	
	/**
	 * 
	 * @param other
	 * @return
	 */
	public boolean compare(Job other) {
		if (!title.equals(other.getTitle()))
			return false;
		if (!parkName.equals(other.getParkName()))
			return false;
		if (!description.equals(other.getDescription()))
			return false;
		if (numLightJobs != other.getNumLightJobs())
			return false;
		if (numMedJobs != other.getNumMedJobs())
			return false;
		if (numHeavyJobs != other.getNumHeavyJobs())
			return false;
		//		if (date.equals(other.getDate()))
		//			return false;

		return true;
	}

	/**
	 * Checks if job is aligned with Business Rules
	 * @return int of which part of the job is conflicting
	 */
	public int jobCheck() {
		if (title.equals(""))
			return 1;
		else if (parkName.equals("")) 
			return 2;
		else if (address.equals("")) 
			return 3;
		else if (description.equals(""))
			return 4;
		else if (numLightJobs < 0 || numLightJobs > 50) 
			return 5;
		else if (numMedJobs < 0 || numMedJobs > 50) 
			return 6;
		else if (numHeavyJobs < 0 || numHeavyJobs > 50) 
			return 7;
		//Need to check with conflicting dates?
		//		else if (date.equals(""))
		//			return 8;
		return 0;
	}

	/**
	 * Sign up volunteers for the job.
	 *  
	 * @param theVolunteer Volunteer signing up
	 * @param theWorkCategory 0=Light, 1=Medium, 2=Hard
	 */
	private void signUp(Volunteer theVolunteer, int theWorkCategory) {
		if (isVolunteerAlreadySignedUp(theVolunteer) == true) {
			signedUpList.add(theVolunteer);	
			decrementJobCategory(theWorkCategory);
		}
	}

	/**
	 * Business rule:
	 * Prevents volunteer from signing up for the same job.
	 * 
	 * @param theVolunteer Volunteer signing up
	 * @return true if volunteer exists, false if not
	 */
	private boolean isVolunteerAlreadySignedUp(Volunteer theVolunteer) {
		//Loops through the list of volunteers already signed up for this job
		for (int i = 0; i < signedUpList.size() - 1; i++) {
			if (signedUpList.get(i).equals(theVolunteer) == true) {
				return true;
			}
		}
		return false; //if the volunteer is not already signed up
	}

	/**
	 * Decrements the specific job category for the job.
	 * 
	 * @param theWorkCategory 0=Light, 1=Medium, 2=Hard
	 */
	private void decrementJobCategory(int theWorkCategory) {
		if (theWorkCategory == 0) { // light 
			if (numLightJobs > 0) 
				numLightJobs -= 1;	
		} else if (theWorkCategory == 1) { // medium 
			if (numMedJobs > 0) 
				numMedJobs -= 1;
		} else if (theWorkCategory == 2) { // hard 
			if (numHeavyJobs > 0) 
				numHeavyJobs -= 1;
		}
	}


	/** Setters */
	public void setTitle(String theTitle) {
		title = theTitle;
	}

	public void setParkName(String theParkName) {
		parkName = theParkName;
	}

	public void setAddress(String theAddress) {
		address = theAddress;
	}

	public void setDescription(String theD) {
		description = theD;
	}

	public void setNumLightJobs(int theL) {
		numLightJobs = theL;
	}

	public void setNumMedJobs(int theM) {
		numMedJobs = theM;
	}
	public void setNumHeavyJobs(int theH) {
		numHeavyJobs = theH;
	}

	public void setStartDate(int theYear, int theMonth, int theDay){
		this.myStartDate = new GregorianCalendar(theYear, theMonth-1, theDay);
	}

	/** Getters */
	public String getTitle() {
		return title;
	}

	public String getParkName() {
		return parkName;
	}

	public String getAddress() {
		return address;
	}

	public String getDescription() {
		return description;
	}

	public int getNumLightJobs() {
		return numLightJobs;
	}

	public int getNumMedJobs() {
		return numMedJobs;
	}

	public int getNumHeavyJobs() {
		return numHeavyJobs;
	}

	public Date getStartDate(){
		return myStartDate.getTime();
	}

}





