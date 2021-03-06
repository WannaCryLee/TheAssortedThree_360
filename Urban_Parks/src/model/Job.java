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
import java.util.Date;
import java.util.GregorianCalendar;


/**
 * Creates a job.
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
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
	
	
	private static final int MIN_NUM_VOLUNTEERS = 0;

	private static final int MAX_NUM_VOLUNTEERS = 50;
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
	/** Variable for describing the job's details */
	private String description;
	/** True = Jobs takes Two days, False = Job is only for One day */
	private boolean isTwoDays;
	/** Specifies the number of required volunteers for each category grade. */
	private int numLightJobs;
	private int numMedJobs;
	private int numHeavyJobs;

	//Job duration
	//private int myJobDuration;

	/**
	 * Constructor
	 */
	public Job() {
		title = null;
		parkName = null;
		description = null;
		numLightJobs = 0;
		numMedJobs = 0;
		numHeavyJobs = 0;
		isTwoDays = false;
		myStartDate = new GregorianCalendar(2015, 12-1, 24);
		myEndDate = new GregorianCalendar(2015, 12-1, 25);
	}

	/**
	 * Constructor for two days
	 * 
	 * @param theTitle Title of job
	 * @param theParkName Park name job was created for
	 * @param theDescription Description of the job
	 * @param theYear the year of the users job
	 * @param theMonth the month of the users job
	 * @param theDay the day of the users job
	 */
	public Job(String theTitle, String theParkName,  
			String theDescription, int theNumLightJobs, int theNumMedJobs,int theNumHeavyJobs, boolean theTwoDays,
			int theStartYear, int theStartMonth, int theStartDay,
			int theEndYear, int theEndMonth, int theEndDay, int hour, int min) {
		title = theTitle;
		parkName = theParkName.toLowerCase();
		description = theDescription;
		numLightJobs = theNumLightJobs;
		numMedJobs = theNumMedJobs;
		numHeavyJobs = theNumHeavyJobs;
		isTwoDays = theTwoDays;
		myStartDate = new GregorianCalendar(theStartYear, theStartMonth-1, theStartDay, hour, min);
		myEndDate = new GregorianCalendar(theEndYear, theEndMonth-1, theEndDay);
	}

	/**
	 * 
	 * @param other The job given by the user
	 * 
	 * @return true or false 
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
		if (isTwoDays != other.getIsTwoDays()) {
			return false;
		}
		return true;
	}

	/**
	 * Checks if job is aligned with Business Rules
	 * 
	 * @return int of which part of the job is conflicting
	 */
	public int jobCheck() {
		ValidateJob valiDate = new ValidateJob();
		if (title.equals(""))
			return 1;
		else if (parkName.equals("")) 
			return 2;
		else if (description.equals(""))
			return 4;
		else if (numLightJobs < MIN_NUM_VOLUNTEERS || numLightJobs > MAX_NUM_VOLUNTEERS) 
			return 5;
		else if (numMedJobs < MIN_NUM_VOLUNTEERS || numMedJobs > MAX_NUM_VOLUNTEERS) 
			return 6;
		else if (numHeavyJobs < MIN_NUM_VOLUNTEERS || numHeavyJobs > MAX_NUM_VOLUNTEERS) 
			return 7;
		else if (!valiDate.WithinMaxRangeMonths(myStartDate)) {
			return 8;
		}
		return 0;
	}

	/**
	 * Checks if volunteers can sign up for a work category for a job
	 * 
	 * @param category			has to be 0,1,2 (Light, Medium, Heavy)
	 * @return 					true if its full or false if there is room
	 */
	public boolean isWorkCategoryFull(int category) {
		switch (category) {
		case 0:
			if (numLightJobs > MIN_NUM_VOLUNTEERS)
				return false;
			break;
		case 1:
			if (numMedJobs > MIN_NUM_VOLUNTEERS)
				return false;
			break;
		case 2:
			if (numHeavyJobs > MIN_NUM_VOLUNTEERS)
				return false;
			break;
		} 
		return true;
	}

	/**
	 * Decrements the specific job category for the job.
	 * 
	 * @param theWorkCategory 	0 = Light, 1 = Medium, 2 = Hard
	 */
	public void decrementJobCategory(int theWorkCategory) {
		if (theWorkCategory == 0) { // light 
			if (numLightJobs > MIN_NUM_VOLUNTEERS) 
				numLightJobs -= 1;	
		} else if (theWorkCategory == 1) { // medium 
			if (numMedJobs > MIN_NUM_VOLUNTEERS) 
				numMedJobs -= 1;
		} else if (theWorkCategory == 2) { // hard 
			if (numHeavyJobs > MIN_NUM_VOLUNTEERS) 
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

	public void setIsTwoDays(boolean theTwoDays) {
		isTwoDays = theTwoDays;
	}

	public void setStartDate(int theYear, int theMonth, int theDay){
		myStartDate = new GregorianCalendar(theYear, theMonth-1, theDay);
	}

	/** Getters */
	public String getTitle() {
		return title;
	}

	public String getParkName() {
		return parkName;
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

	public boolean getIsTwoDays() {
		return isTwoDays;
	}

	public Date getStartDate(){
		return myStartDate.getTime();
	}

	public Calendar getStartCalender() {
		return myStartDate;
	}
	public Calendar getEndCalender() {
		return myEndDate;
	}
	public Date getEndDate() {
		return myEndDate.getTime();
	}
	
	/**
	 * Returns all the info of the Job
	 * 
	 * @return a string of the Job's information
	 */
	public String toString(){
		return "Title: " + title + " \nParkName: " + parkName 
				+ "\nDescription: " + description + "\nStart Date: " + sdf.format(getStartDate()) 
				+ "\nEnd Date: " + sdf.format(getEndDate());
	}
}



