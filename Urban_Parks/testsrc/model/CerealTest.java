package model;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;

import org.junit.Test;

/**
 * Test Cereal Class
 * @author Jordan Love
 *
 */
public class CerealTest {

	private UserList userList = new UserList();
	private JobList jobList = new JobList();
	private Cereal testCerealUser = new Cereal(0);
	private Cereal testCerealJob = new Cereal(1);
	
	@Test
	public void shouldSerializeObject() {
		setUpUserList();
		setUpJobList();
		File serialFileUser = new File("Files/user.ser");
		File serialFileJob = new File("Files/job.ser");
		
		testCerealUser.serialize(userList);
		testCerealJob.serialize(jobList);
		
		assertTrue("User Serialize File was not created", serialFileUser.exists());
		assertTrue("Job Serialize File was not created", serialFileJob.exists());
	}
	
	@Test
	public void shouldDeserializeObject() {
		setUpUserList();
		setUpJobList();
		
		UserList deserialUser = (UserList) testCerealUser.deSerialize();
		JobList deserialJob = (JobList) testCerealJob.deSerialize();
		
		assertEquals("Volunteer Deserialize was not kept the same", ((Volunteer)(deserialUser.getMap().get(0))).getMyFirst(), ((Volunteer)(userList.getMap().get(0))).getMyFirst());
		assertEquals("Job Deserialize was not kept the same", ((Job)(deserialJob.getMap().get(0))).getTitle(), ((Job)(jobList.getMap().get(0))).getTitle());
	}
	
	private void setUpJobList() {
		HashMap<Integer, Object> test = new HashMap<Integer, Object>();
		
		Job testJob = new Job("Rock", "Tuscany", "Tacoma, WA", "Clean Rocks", 1 );
		
		test.put(test.size(), testJob);
		
		testJob = new Job("Bark", "Tuscany", "Tacoma, WA", "New Bark", 2 );
		
		test.put(test.size(), testJob);
		
		testJob = new Job("Sweep", "Wright", "Tacoma, WA", "Sweep Sidewalks", 0 );
		
		test.put(test.size(), testJob);
		
		testJob = new Job("Garbage", "Wright", "Tacoma, WA", "Change all the Garbage", 0 );
		
		test.put(test.size(), testJob);
		
		testJob = new Job("New Fountain", "Lighthouse", "Tacoma, WA", "Install new fountain", 2 );
		
		test.put(test.size(), testJob);
		
		testJob = new Job("BBQ", "LightHouse", "Tacoma, WA", "Cook Meat :)", 1 );
		
		test.put(test.size(), testJob);
		
		jobList.setMap(test);
	}
	
	private void setUpUserList() {
		HashMap<Integer, Object> test = new HashMap<Integer, Object>();
		
		Volunteer testVolunteer = new Volunteer("Bob", "Johnson", "bjohnson@gmail.com", "password");
		
		test.put(test.size(), testVolunteer);
		
		testVolunteer = new Volunteer("John", "Rotissary", "jrotissary@gmail.com", "password");
		
		test.put(test.size(), testVolunteer);
		
		testVolunteer = new Volunteer("Duk", "Boki", "dboki@gmail.com", "password");
		
		test.put(test.size(), testVolunteer);
		
		testVolunteer = new Volunteer("Sue", "Shi", "sshi@gmail.com", "password");
		
		test.put(test.size(), testVolunteer);
		
		testVolunteer = new Volunteer("Rue", "Shi", "rshi@gmail.com", "password");
		
		test.put(test.size(), testVolunteer);
		
		userList.setMap(test);
	}

}
