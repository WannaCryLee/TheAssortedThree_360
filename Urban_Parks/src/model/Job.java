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
import java.util.Map;
import java.util.Map.Entry;

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
	/** True = Jobs takes Two days, False = Job is only for One day */
	private boolean isTwoDays;
	/** Specifies the number of required volunteers for each category grade. */
	private int numLightJobs;
	private int numMedJobs;
	private int numHeavyJobs;
	/** A list of the volunteers who signed up for the job. */
	private ArrayList<Volunteer> signedUpList;

	//Job duration
	//private int myJobDuration;

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
		isTwoDays = false;
		myStartDate = new GregorianCalendar(2015, 12-1, 24);
		myEndDate = new GregorianCalendar(2015, 12-1, 25);

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
			String theDescription, int theNumLightJobs, int theNumMedJobs,int theNumHeavyJobs, boolean theTwoDays,
			int theStartYear, int theStartMonth, int theStartDay,
			int theEndYear, int theEndMonth, int theEndDay) {
		title = theTitle;
		parkName = theParkName;
		address = theAddress;
		description = theDescription;
		numLightJobs = theNumLightJobs;
		numMedJobs = theNumMedJobs;
		numHeavyJobs = theNumHeavyJobs;
		isTwoDays = theTwoDays;
		myStartDate = new GregorianCalendar(theStartYear, theStartMonth-1, theStartDay);
		//System.out.println(sdf.format(myStartDate.getTime()));
		myEndDate = new GregorianCalendar(theEndYear, theEndMonth-1, theEndDay);
		
		signedUpList = new ArrayList<Volunteer>();
	}
	
	/**
	 * 
	 * @param other The job given by the user
	 * @return true or false 
	 */
	public boolean compare(Job other) {
		if (!title.equals(other.getTitle()))
			return false;
		if (!parkName.equals(other.getParkName()))
			return false;
		if (!address.equals(other.getAddress()))
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
	 * Checks to see if there is already a total number of 5 jobs during that week (3 days on either side of the job days) and if so then
	 * it will return false.
	 * 
	 * @return false if number of jobs in the "week" is 5 or more and true if there is still space to add another
	 */
	public boolean isMaxWeek() {
		int day = myStartDate.get(Calendar.DATE);
		int month = myStartDate.get(Calendar.MONTH);
		int year = myStartDate.get(Calendar.YEAR);
		int numJobWeek = 0;
		Cereal getData = new Cereal(1);
		JobList otherJobs = (JobList) getData.deSerialize();
		
		java.util.Iterator<Entry<Integer, Object>> itr = otherJobs.getMap().entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Object> pair = (Map.Entry<Integer, Object>)itr.next();
			boolean checkTwoDay = false;
			if (!((Job)pair.getValue()).getStartCalender().equals(((Job)pair.getValue()).getEndCalender())) {
				checkTwoDay = true;
			}
			
			//System.out.println("Title: " + ((Job)pair.getValue()).getTitle() + "; Day: " + ((Job)pair.getValue()).getStartCalender().get(Calendar.DATE));
			System.out.println("\nTitle: " + title + "; Day: " + sdf.format(myStartDate.getTime()));
			System.out.println("Title: " + ((Job)pair.getValue()).getTitle() + "; Day: " + sdf.format(((Job)pair.getValue()).getStartDate()));
			
			int otherDay = ((Job)pair.getValue()).getStartCalender().get(Calendar.DATE);	
			int otherMonth = ((Job)pair.getValue()).getStartCalender().get(Calendar.MONTH);
			int otherYear = ((Job)pair.getValue()).getStartCalender().get(Calendar.YEAR);
			if (month == otherMonth && year == otherYear) {
				if (isWithInThree(myStartDate.get(Calendar.DAY_OF_MONTH), day, otherDay)) {
					System.out.println("here");
					numJobWeek++;
				}
				if (checkTwoDay) {
					if (isWithInThree(myStartDate.get(Calendar.DAY_OF_MONTH), day, ((Job)pair.getValue()).getEndCalender().get(Calendar.DATE))){
						System.out.println("here");
						numJobWeek++;
					}
				}
				
			}
			itr.remove();
		}
		System.out.println(numJobWeek);
		if (numJobWeek >= 5)
			return false;
		return true;
	}
	/**
	 * Checks to see if their is a job on any of the days either 3 days before or 3 days after
	 * 
	 * @param dayInMonth the numbers of days total in the current month
	 * @param day the day that is given for the current job
	 * @param otherDay the day that we are comparing too from the list
	 * @return true or false if the day is within 3 days before or after
	 */
	private boolean isWithInThree(int dayInMonth, int day, int otherDay) {
//		System.out.println("day - otherDay <= 3 and >= -3: " + (day - otherDay));
//		System.out.println();
//		System.out.println();
//		System.out.println();
		
		if ((day - otherDay <= 3 && day - otherDay >= -3) || 
				(day - otherDay >= dayInMonth - 3 && day - otherDay <= dayInMonth) || 
				(day - otherDay <= (dayInMonth - 3) * (-1) && day - otherDay >= (dayInMonth) * (-1)))
			return true;
		return false;
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
	
	public void setIsTwoDays(boolean theTwoDays) {
		isTwoDays = theTwoDays;
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

}





