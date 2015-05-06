package model;

import java.io.Serializable;

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
	/** Date of job */
	private String date;

	/**
	 * Constructor
	 */
	public Job() {
		title = null;
		parkName = null;
		address = null;
		description = null;
		grade = 0;
		date = null;
	}
	
	/**
	 * Constructor
	 * 
	 * @param theTitle Title of job
	 * @param theParkName Park name job was created for
	 * @param theAddress Address
	 * @param theDescription Description of the job
	 * @param theGrade Job's dificulty level (easy, med, hard)
	 * @param theDate Date of the job
	 */
	public Job(String theTitle, String theParkName, String theAddress, 
			String theDescription, int theGrade, String theDate) {
		title = theTitle;
		parkName = theParkName;
		address = theAddress;
		description = theDescription;
		grade = theGrade;
		date = theDate;
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
		if (date.equals(other.getDate()))
			return false;
		
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
		else if (date.equals(""))
			return 6;
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
	
	public void setDate(String theDate) {
		date = theDate;
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

	public int getGrade() {
		return grade;
	}
	
	public String getDate() {
		return date;
	}

}





