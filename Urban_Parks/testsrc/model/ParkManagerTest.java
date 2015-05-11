/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import org.junit.Test;

import java.io.Serializable;
import java.util.HashMap;

import model.JobList;
import model.ParkManager;

public class ParkManagerTest implements Serializable{

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -8713016574919857541L;
	private ParkManager testEmptyPM = new ParkManager();
	private ParkManager testParkManager = new ParkManager("Jasmine", "Pedersen", "jtp@uw.edu", "password", "", "");
	
	@Test
	public void shouldLogIn() {
		//Testing constructor with no parameters to log in
		assertEquals(testEmptyPM.logIn("forTheNorth@winterIsComing.com", "myWatchBeginsTomorrow"), "Your email or password does not match our database");
		assertEquals(testEmptyPM.logIn("realtalk", "password"), "Your email or password does not match our database");
		assertEquals(testEmptyPM.logIn("forTheNorth@winterIsComing.com", "myWatchBegins"), "Welcome! Jon Snow");
		
		//Testing constructor with parameters to log in
		assertEquals(testParkManager.logIn("jtp@uw.edu", "password1234"), "Your email or password does not match our database");
		assertEquals(testParkManager.logIn("something", "password"), "Your email or password does not match our database");
		assertEquals(testParkManager.logIn("jtp@uw.edu", "password"), "Welcome! Jasmine Pedersen");
	}
	
	@Test 
	public void shouldSubmitAJob() {
		Job originalJob = new Job("Rock", "Tuscany", "Tacoma, WA", "Clean Rocks", 3, 5, 3, false, 2015, 5, 15, 2015, 5, 15, 5, 30);
		testParkManager.submitJob(originalJob);
		
		Cereal checkJob = new Cereal(1);
		JobList jList = (JobList)checkJob.deSerialize();
		HashMap<Integer, Object> jobs = jList.getMap();
		Job modifiedJob = (Job)jobs.get(jobs.size() - 1);
		
		if (!modifiedJob.getTitle().equals(originalJob.getTitle())) {
			fail("Your Job has been changed");
		}
	}
	
	@Test
	public void shouldPassMax() {
		setUpJobList();
		Job newJob;
		for (int i = 1; i < 30; i++) {
			newJob = new Job("BBQ", "LightHouse", "Tacoma, WA", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
			assertFalse(testParkManager.maxPendingJobs("lighthouse"));
		}
		newJob = new Job("BBQ", "LightHouse", "Tacoma, WA", "Cook Meat :)", 3, 5, 3, false, 2015, 9, 30, 2015, 9, 30, 5, 30);
		testParkManager.submitJob(newJob);
		assertTrue(testParkManager.maxPendingJobs("lighthouse"));

	}
	
	@Test
	public void shouldPassMaxWeek() {
		setUpJobList();
		Job newJob;
		for (int i = 1; i < 5; i++) {
			newJob = new Job("BBQ", "LightHouse", "Tacoma, WA", "Cook Meat :)", 3, 5, 3, false, 2015, 5, i+7, 2015, 9, i+7, 5, 30);
			testParkManager.submitJob(newJob);
			assertFalse(testParkManager.maxPendingJobsWeek("lighthouse"));			
		}
		newJob = new Job("BBQ", "LightHouse", "Tacoma, WA", "Cook Meat :)", 3, 5, 3, false, 2015, 5, 14, 2015, 5, 14, 5, 30);
		testParkManager.submitJob(newJob);
		assertTrue(testParkManager.maxPendingJobsWeek("lighthouse"));

	}
	
	private void setUpJobList() {

		HashMap<Integer, Object> test = new HashMap<Integer, Object>();
		JobList list = new JobList();
		

		Job testJob = new Job("Rock", "Tuscany", "Tacoma, WA", "Clean Rocks", 3, 5, 3, false, 2015, 5, 15, 2015, 5, 15, 5, 30);

		test.put(test.size(), testJob);

		testJob = new Job("Bark", "Tuscany", "Tacoma, WA", "New Bark",3, 5, 3, false, 2015, 5, 16, 2015, 5, 16, 5, 30);

		test.put(test.size(), testJob);

		testJob = new Job("Garbage", "Wright", "Tacoma, WA", "Change all the Garbage", 3, 5, 3, false, 2015, 5, 18, 2015, 5, 18, 5, 30);

		test.put(test.size(), testJob);


		list.setMap(test);
		
		//Serialize Data
		Cereal testStoreData = new Cereal(1);
		testStoreData.serialize(list);
	}
	
}

