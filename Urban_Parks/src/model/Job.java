package model;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
	/** Job title */
	private String title; 
	/** Park name the job belongs to */
	private String parkName;
	/** Address of job's location */
	private String address;
	/** Variable for describing the job's details */
	private String description;
	/** Job's difficulty level: 0 = easy, 1 = med, 2 = hard */
	private int grade;
	//Job end date
	private Calendar myEndDate;
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
		grade = 0;
		myStartDate = new GregorianCalendar(2015, 12-1, 24);
		myEndDate = new GregorianCalendar(2015, 12-1, 25);
		//date = null;
	}
	
	/**
	 * Constructor
	 * 
	 * @param theTitle Title of job
	 * @param theParkName Park name job was created for
	 * @param theAddress Address
	 * @param theDescription Description of the job
	 * @param theGrade Job's dificulty level (easy, med, hard)
	 * @param theYear the year of the users job
	 * @param theMonth the month of the users job
	 * @param theDay the day of the users job
	 */
	public Job(String theTitle, String theParkName, String theAddress, 
			String theDescription, int theGrade, int theStartYear, int theStartMonth, int theStartDay,
			int theEndYear, int theEndMonth, int theEndDay) {
		title = theTitle;
		parkName = theParkName;
		address = theAddress;
		description = theDescription;
		grade = theGrade;
		myStartDate = new GregorianCalendar(theStartYear, theStartMonth-1, theStartDay);
		myEndDate = new GregorianCalendar(theEndYear, theEndMonth-1, theEndDay);
		//date = theDate;
	}
	
	public boolean compare(Job other) {
		if (!title.equals(other.getTitle()))
			return false;
		if (!parkName.equals(other.getParkName()))
			return false;
		if (!description.equals(other.getDescription()))
			return false;
		if (grade != other.getGrade())
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
		else if (grade < 0 || grade > 3) 
			return 5;
		//Need to check with conflicting dates?
//		else if (date.equals(""))
//			return 6;
		return 0;
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

	public void setGrade(int theGrade) {
		grade = theGrade;
	}
	
	public void setStartDate(int theYear, int theMonth, int theDay){
		this.myStartDate = new GregorianCalendar(theYear, theMonth-1, theDay);
	}
	
//	public void setDate(String theDate) {
//		date = theDate;
//	}


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

	public int getGrade() {
		return grade;
	}
	
	public Calendar getStartDate(){
		return myStartDate;
	}
	
//	public String getDate() {
//		return date;
//	}

}





