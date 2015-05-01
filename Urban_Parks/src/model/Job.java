package model;

import java.util.HashMap;

public class Job {

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
	/** A list of all the volunteers who signed up for the job */
	private HashMap <Integer, Object> volunteerList;

	public Job() {
		title = null;
		parkName = null;
		address = null;
		description = null;
		grade = 0;
		volunteerList = null;
	}
	
	public Job(String theTitle, String theParkName, String theAddress, 
			String theDescription, int theGrade, HashMap <Integer, Object> theVolunteerList) {
		title = theTitle;
		parkName = theParkName;
		address = theAddress;
		description = theDescription;
		grade = theGrade;
		volunteerList = theVolunteerList;
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

	public void addVolunteerToList(int theID) { //or volunteer object???

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

	public HashMap <Integer, Object> getVolunteerList() {
		return volunteerList;
	}



}





