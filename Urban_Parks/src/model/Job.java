package model;

import java.io.Serializable;

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
	 * @param theTitle
	 * @param theParkName
	 * @param theAddress
	 * @param theDescription
	 * @param theGrade
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





