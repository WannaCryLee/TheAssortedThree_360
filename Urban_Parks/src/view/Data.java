package view;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

import model.Admin;
import model.Cereal;
import model.Job;
import model.JobList;
import model.ParkManager;
import model.UserList;
import model.Volunteer;

/**
 * Original Data
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class Data {

	//Constructor
	public Data() {
		
	}
	
	/**
	 * Serializes new objects for data
	 */
	public void freshData() {
		UserList userList = new UserList();
		JobList jobList = new JobList();
		HashMap<Integer, Object> startingMap = new HashMap<Integer, Object>();
		
		Volunteer newVolunteer = new Volunteer("Bob", "Johnson", "bjohnson@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("John", "Rotissary", "jrotissary@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("Duk", "Boki", "dboki@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("Sue", "Shi", "sshi@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("Rue", "Shi", "rshi@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		newVolunteer = new Volunteer("Pilot", "Whale", "pwhale@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		Admin newAdmin = new Admin("Blue", "Whale", "bwhale@gmail.com", "Pacific Ocean", "password");
		
		startingMap.put(startingMap.size(), newAdmin);
		
		ParkManager newManager = new ParkManager("Orca", "Whale", "owhale@gmail.com", "password", "Pacific Ocean", "Wright");
		
		startingMap.put(startingMap.size(), newManager);
		
		userList.setMap(startingMap);
		
		startingMap = new HashMap<Integer, Object>();
		
		Job startingJob = new Job("Rock", "Tuscany", "Clean Rocks", 3, 5, 3, false, 2015, 5, 15, 2015, 5, 15, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("Bark", "Tuscany", "New Bark",3, 5, 3, false, 2015, 5, 30, 2015, 5, 30, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("Sweep", "Wright", "Sweep Sidewalks", 3, 5, 3, false, 2015, 6, 15, 2015, 6, 15, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("Garbage", "Wright", "Change all the Garbage", 3, 5, 3, false, 2015, 8, 15, 2015, 8, 15, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("New Fountain", "Lighthouse", "Install new fountain", 3, 5, 3, false, 2015, 8, 15, 2015, 8, 15, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, 15, 2015, 9, 15, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		jobList.setMap(startingMap);
		
		//Serialize Data
		Cereal storeUserData = new Cereal(0);
		Cereal storeJobData = new Cereal(1);
		storeUserData.serialize(userList);
		storeJobData.serialize(jobList);
	}
	
	/**
	 * Sets up 30 jobs within 90 days
	 */
	public void ruleMax30() {
		UserList userList = new UserList();
		JobList jobList = new JobList();
		HashMap<Integer, Object> startingMap = new HashMap<Integer, Object>();
		
		Volunteer newVolunteer = new Volunteer("Sue", "Shi", "sshi@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		
		newVolunteer = new Volunteer("Pilot", "Whale", "pwhale@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		Admin newAdmin = new Admin("Blue", "Whale", "bwhale@gmail.com", "Pacific Ocean", "password");
		
		startingMap.put(startingMap.size(), newAdmin);
		
		ParkManager newManager = new ParkManager("Orca", "Whale", "owhale@gmail.com", "password", "Pacific Ocean", "Tuscany");
		
		startingMap.put(startingMap.size(), newManager);
		
		userList.setMap(startingMap);
		
		startingMap = new HashMap<Integer, Object>();
		
		Job startingJob = new Job("Rock", "Tuscany", "Clean Rocks", 3, 5, 3, false, 2015, 8, 15, 2015, 8, 15, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		for (int i = 2; i < 22; i += 2) {
		
		startingJob = new Job("Bark", "Tuscany", "New Bark",3, 5, 3, false, 2015, 7, i, 2015, 7, i, 5, 30);
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("Bark", "Tuscany", "New Bark",3, 5, 3, false, 2015, 6, i, 2015, 6, i, 5, 30);
		startingMap.put(startingMap.size(), startingJob);
		
		startingJob = new Job("Bark", "Tuscany", "New Bark",3, 5, 3, false, 2015, 8, i, 2015, 8, i, 5, 30);
		startingMap.put(startingMap.size(), startingJob);
		
		}
		
		jobList.setMap(startingMap);
		
		//Serialize Data
		Cereal storeUserData = new Cereal(0);
		Cereal storeJobData = new Cereal(1);
		storeUserData.serialize(userList);
		storeJobData.serialize(jobList);
	}
	
	/**
	 * Set up 5 jobs within a week
	 */
	public void ruleMax5() {
		UserList userList = new UserList();
		JobList jobList = new JobList();
		HashMap<Integer, Object> startingMap = new HashMap<Integer, Object>();
		
		Volunteer newVolunteer = new Volunteer("Sue", "Shi", "sshi@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		
		newVolunteer = new Volunteer("Pilot", "Whale", "pwhale@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		Admin newAdmin = new Admin("Blue", "Whale", "bwhale@gmail.com", "Pacific Ocean", "password");
		
		startingMap.put(startingMap.size(), newAdmin);
		
		ParkManager newManager = new ParkManager("Orca", "Whale", "owhale@gmail.com", "password", "Pacific Ocean", "Tuscany");
		
		startingMap.put(startingMap.size(), newManager);
		
		userList.setMap(startingMap);
		
		startingMap = new HashMap<Integer, Object>();
		
		Job startingJob = new Job("Rock", "Tuscany", "Clean Rocks", 3, 5, 3, false, 2015, 5, 15, 2015, 5, 15, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		for (int i = 7; i < 14; i++) {
			if (i != 10) {
				startingJob = new Job("Bark", "Tuscany", "New Bark",3, 5, 3, false, 2015, 7, i, 2015, 7, i, 5, 30);
				startingMap.put(startingMap.size(), startingJob);
			}
		}
		
		jobList.setMap(startingMap);
		
		//Serialize Data
		Cereal storeUserData = new Cereal(0);
		Cereal storeJobData = new Cereal(1);
		storeUserData.serialize(userList);
		storeJobData.serialize(jobList);
	}
	
	/**
	 * Sets up max work category for a job
	 */
	public void ruleMaxWorkCategory() {
		UserList userList = new UserList();
		JobList jobList = new JobList();
		HashMap<Integer, Object> startingMap = new HashMap<Integer, Object>();
		
		Volunteer newVolunteer = new Volunteer("Sue", "Shi", "sshi@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		
		newVolunteer = new Volunteer("Pilot", "Whale", "pwhale@gmail.com", "password");
		
		startingMap.put(startingMap.size(), newVolunteer);
		
		Admin newAdmin = new Admin("Blue", "Whale", "bwhale@gmail.com", "Pacific Ocean", "password");
		
		startingMap.put(startingMap.size(), newAdmin);
		
		ParkManager newManager = new ParkManager("Orca", "Whale", "owhale@gmail.com", "password", "Pacific Ocean", "Tuscany");
		
		startingMap.put(startingMap.size(), newManager);
		
		userList.setMap(startingMap);
		
		startingMap = new HashMap<Integer, Object>();
		
		Job startingJob = new Job("Rock", "Tuscany", "Clean Rocks", 0, 0, 0, false, 2015, 7, 15, 2015, 7, 15, 5, 30);
		
		startingMap.put(startingMap.size(), startingJob);
		
		jobList.setMap(startingMap);
		
		//Serialize Data
		Cereal storeUserData = new Cereal(0);
		Cereal storeJobData = new Cereal(1);
		storeUserData.serialize(userList);
		storeJobData.serialize(jobList);
	}
	
	/**
	 * Search for the file of the serealized Job class
	 */
	private String findJobFile() {
		String decodedPath = "";
		String path = Cereal.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (decodedPath.contains("/Urban_Parks.jar"))
			decodedPath = decodedPath.substring(0, decodedPath.indexOf("/Urban_Parks.jar"));
		
		return decodedPath + "/job.ser";
	}
	
	public boolean hasJobFile() {
		File job = new File(findJobFile());
		if (job.exists()) 
			return true;
		return false;
	}
	
	/**
	 * Search for the file of the serealized User class
	 */
	private String findUserFile() {
		String decodedPath = "";
		String path = Cereal.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (decodedPath.contains("/Urban_Parks.jar"))
			decodedPath = decodedPath.substring(0, decodedPath.indexOf("/Urban_Parks.jar"));
		
		return decodedPath + "/user.ser";
	}
	
	public boolean hasUserFile() {
		File user = new File(findUserFile());
		if (user.exists())
			return true;
		return false;
	}
}
