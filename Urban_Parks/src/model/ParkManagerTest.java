/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;

import model.JobList;
import model.ParkManager;
/**
 * Test Park Manager Class
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class ParkManagerTest implements Serializable{

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -8713016574919857541L;
	private ParkManager testParkManager;
	private Job newJob;
	private static final int MAX_PENDING_JOBS = 30;


	@Before
	public void setUp() throws Exception {
		testParkManager = new ParkManager("Jasmine", "Pedersen", "jtp@uw.edu", "password", "", "");
		setUpJobList();
		newJob = new Job();		
	}

	@Test 
	public void testSubmitAJob() {
		Job originalJob = new Job("Rock", "Tuscany", "Clean Rocks", 3, 5, 3, false, 2015, 5, 15, 2015, 5, 15, 5, 30);
		testParkManager.submitJob(originalJob);

		Cereal checkJob = new Cereal(1);
		JobList jList = (JobList)checkJob.deSerialize();
		HashMap<Integer, Object> jobs = jList.getMap();
		Job modifiedJob = (Job)jobs.get(jobs.size() - 1);

		assertTrue(modifiedJob.getTitle().equals(originalJob.getTitle()));

	}
	
	//TESTING MAX PENDING JOBS...................................................................................

	@Test
	public void testPassMaxWhenJobCapacityNotMax() {

		newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, 1, 2015, 9, 1, 5, 30);
		testParkManager.submitJob(newJob);
		assertFalse(testParkManager.maxPendingJobs("lighthouse"));

	}
	
	@Test
	public void testPassMaxWhenJobCapacityNotMaxAndInPast() {

		newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 3, 1, 2015, 3, 1, 5, 30);
		testParkManager.submitJob(newJob);
		assertFalse(testParkManager.maxPendingJobs("lighthouse"));

	}
	
	
	@Test
	public void testPassMaxWhenJobCapacityNotAtMaxCapacityButWithTwoJobs() {

		newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, true, 2015, 9, 1, 2015, 9, 2, 5, 30);
		testParkManager.submitJob(newJob);
		assertFalse(testParkManager.maxPendingJobs("lighthouse"));

	}
	
	@Test
	public void testPassMaxWhenJobCapacityNotAtMaxCapacityButWithTwoJobsInThePast() {

		newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, true, 2015, 5, 1, 2015, 5, 2, 5, 30);
		testParkManager.submitJob(newJob);
		assertFalse(testParkManager.maxPendingJobs("lighthouse"));

	}
	@Test
	public void testPassMaxWhenJobCapacityNotAtMaxCapacityButWhenParkNameWrong() {

		newJob = new Job("BBQ", "Light", "Cook Meat :)", 3, 5, 3, true, 2015, 9, 1, 2015, 9, 2, 5, 30);
		testParkManager.submitJob(newJob);
		assertFalse(testParkManager.maxPendingJobs("lighthouse"));

	}
	
	@Test
	public void testPassMaxWhenJobCapacityNotAtMaxCapacityButWithTwoJobsWhenOnlySecondDayIsAfterCurrentDay() {
		newJob = new Job("Dragon Scale", "lighthouse", "Cook Meat :)", 3, 5, 3, true, 2015, 9, 1, 2015, 9, 2, 5, 30);
		testParkManager.submitJob(newJob);
		//The first day is today, and the second day is tomorrow
		//Don't have time to getInstance from Calendar at this moment
		newJob = new Job("Red Shell", "lighthouse", "Death on Swift Wings :)", 3, 5, 3, true, 2015, 5, 1, 2015, 7, 2, 12, 00);		
		testParkManager.submitJob(newJob);
			
		assertFalse(testParkManager.maxPendingJobs("lighthouse"));
	}
	
	@Test
	public void testPassMaxWhenJobCapacityNotAtMaxCapacityButWithTwoJobsWhenSecondDayIsInThePast() {

		newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, true, 2015, 4, 29, 2015, 4, 30, 5, 30);		
		testParkManager.submitJob(newJob);
			
		assertFalse(testParkManager.maxPendingJobs("lighthouse"));
	}
	
	@Test
	public void testPassMaxWhenJobCapacityNotAtMaxCapacityButWithTwoJobsWhenParkNameWrong() {

		newJob = new Job("BBQ", "Light", "Cook Meat :)", 3, 5, 3, true, 2015, 9, 29, 2015, 9, 30, 5, 30);		
		testParkManager.submitJob(newJob);
			
		assertFalse(testParkManager.maxPendingJobs("lighthouse"));
	}
	
	
	
	@Test
	public void testPassMaxWhenJobCapacityOneBeforeMax() {

		for (int i = 1; i < MAX_PENDING_JOBS - 1; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
		}

		assertFalse(testParkManager.maxPendingJobs("lighthouse"));

	}

	@Test
	public void testPassMaxWhenJobCapacityAtMax() {

		for (int i = 1; i <= MAX_PENDING_JOBS; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
		}
		assertTrue(testParkManager.maxPendingJobs("lighthouse"));

	}
	
	
	//Testing Max Week...................................................................................................
	
	@Test
	public void testPassMaxWeekWhenNewJobIsOneDayLongAndNotAtMax() {
		
		for (int i = 1; i <= 3; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);

		}
		
		for (int i = 5; i <= 7; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);				
		}

		newJob = new Job("BBQ", "LightHouse","Cook Meat :)", 3, 5, 3, false, 2015, 9, 4, 2015, 9, 4, 5, 30);
		//testParkManager.submitJob(newJob);
		assertFalse(testParkManager.maxPendingJobsWeek("lighthouse", newJob.getStartDate(), false));

	}
	
	@Test
	public void testPassMaxWeekWhenNewJobIsOneDayLongAndAtMax() {
		
		for (int i = 1; i <= 3; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
		}
		
		for (int i = 4; i <= 7; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);		
		}

		newJob = new Job("BBQ", "LightHouse","Cook Meat :)", 3, 5, 3, false, 2015, 9, 4, 2015, 9, 4, 5, 30);
		assertTrue(testParkManager.maxPendingJobsWeek("lighthouse", newJob.getStartDate(), false));

	}
	
	@Test
	public void testPassMaxWeekWhenNewJobIsTwoDaysLongAndAtMaxCapacity() {
		
		for (int i = 1; i <= 3; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
		}
		newJob = new Job("Blood Bath", "LightHouse", "Cook Meat :)", 3, 5, 3, true, 2015, 9, 6, 2015, 9, 7, 5, 30);
		testParkManager.submitJob(newJob);


		newJob = new Job("BBQ", "LightHouse","Cook Meat :)", 3, 5, 3, true, 2015, 9, 4, 2015, 9, 5, 5, 30);
		//testParkManager.submitJob(newJob);
		assertTrue(testParkManager.maxPendingJobsWeek("lighthouse", newJob.getStartDate(), true));

	}
	
	@Test
	public void testPassMaxWeekWhenNewJobIsTwoDaysLongAndNotAtMaxCapacity() {
		
		for (int i = 1; i <= 3; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
		}

		newJob = new Job("BBQ", "LightHouse","Cook Meat :)", 3, 5, 3, true, 2015, 9, 4, 2015, 9, 5, 5, 30);
		assertFalse(testParkManager.maxPendingJobsWeek("lighthouse", newJob.getStartDate(), true));

	}
	
	@Test
	public void testPassMaxWeekWhenNewJobIsTwoDaysLongAndOneJobStartDateIsTheLastDayOfWeek() {
		
		for (int i = 1; i <= 3; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
		}
		newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, true, 2015, 9, 7, 2015, 9, 8, 5, 30);
		testParkManager.submitJob(newJob);

		newJob = new Job("BBQ", "LightHouse","Cook Meat :)", 3, 5, 3, true, 2015, 9, 4, 2015, 9, 5, 5, 30);
		assertFalse(testParkManager.maxPendingJobsWeek("lighthouse", newJob.getStartDate(), true));

	}
	
	@Test
	public void testPassMaxWeekWhenNewJobIsTwoDaysLongAndOneJobEndDateIsTheFirstDayOfWeek() {
		
		for (int i = 7; i <= 9; i++) {
			newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
		}
		newJob = new Job("BBQ", "LightHouse", "Cook Meat :)", 3, 5, 3, true, 2015, 9, 1, 2015, 9, 2, 5, 30);
		testParkManager.submitJob(newJob);

		newJob = new Job("BBQ", "LightHouse","Cook Meat :)", 3, 5, 3, true, 2015, 9, 5, 2015, 9, 6, 5, 30);
		assertFalse(testParkManager.maxPendingJobsWeek("lighthouse", newJob.getStartDate(), true));

	}
	
	@Test
	public void testPassMaxWeekWhenNewJobIsTwoDaysLongAndParkNameIsDifferent() {
		
		for (int i = 8; i <= 9; i++) {
			newJob = new Job("Egg", "Dragon", "Cook Meat :)", 3, 5, 3, false, 2015, 9, i, 2015, 9, i, 5, 30);
			testParkManager.submitJob(newJob);
		}
		newJob = new Job("Rawr", "Dinosaur", "Cook Meat :)", 3, 5, 3, true, 2015, 9, 1, 2015, 9, 2, 5, 30);
		testParkManager.submitJob(newJob);

		newJob = new Job("BBQ", "Light","Cook Meat :)", 3, 5, 3, true, 2015, 9, 5, 2015, 9, 6, 5, 30);
		assertFalse(testParkManager.maxPendingJobsWeek("Eidon", newJob.getStartDate(), true));

	}
	

	private void setUpJobList() {

		HashMap<Integer, Object> test = new HashMap<Integer, Object>();
		JobList list = new JobList();


		Job testJob = new Job("Rock", "Tuscany","Clean Rocks", 3, 5, 3, false, 2015, 5, 15, 2015, 5, 15, 5, 30);

		test.put(test.size(), testJob);

		testJob = new Job("Bark", "Tuscany", "New Bark",3, 5, 3, false, 2015, 5, 16, 2015, 5, 16, 5, 30);

		test.put(test.size(), testJob);

		testJob = new Job("Garbage", "Wright", "Change all the Garbage", 3, 5, 3, false, 2015, 5, 18, 2015, 5, 18, 5, 30);

		test.put(test.size(), testJob);


		list.setMap(test);

		//Serialize Data
		Cereal testStoreData = new Cereal(1);
		testStoreData.serialize(list);
	}

}

