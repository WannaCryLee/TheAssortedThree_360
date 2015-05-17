/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;
/**
 * Test Log In Class
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class LogInTest {

	private Admin tAdmin;
	private ParkManager tManager;
	private Volunteer tVolunteer;
	
	@Test
	public void shouldGetInstance() {
		LogIn testAdmin = new LogIn();
		LogIn testVolunteer = new LogIn();
		LogIn testManager = new LogIn();
		//Creates the data
		setUpUserList();
		//Tests Administrator
		testAdmin.getInstance("bwhale@gmail.com");
		if (!testAdmin.getTheAdmin().getMyEmail().equals(tAdmin.getMyEmail()))
			fail("Does not grab the right admin");
		assertEquals(testAdmin.getTheManager(), null);
		assertEquals(testAdmin.getTheVolunteer(), null);
		//Tests Volunteer
		testVolunteer.getInstance("pwhale@gmail.com");
		if (!testVolunteer.getTheVolunteer().getMyEmail().equals(tVolunteer.getMyEmail()))
			fail("Does not grab the right volunteer");
		assertEquals(testVolunteer.getTheManager(), null);
		assertEquals(testVolunteer.getTheAdmin(), null);
		//Tests Park Manager
		testManager.getInstance("owhale@gmail.com");	
		if (!testManager.getTheManager().getEmail().equals(tManager.getEmail()))
			fail("Does not grab the right manager");
		assertEquals(testManager.getTheAdmin(), null);
		assertEquals(testManager.getTheVolunteer(), null);
		
	}
	
	private void setUpUserList() {
		UserList list = new UserList();
		
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
		
		tVolunteer = new Volunteer("Pilot", "Whale", "pwhale@gmail.com", "password");
		
		test.put(test.size(), tVolunteer);
		
		tAdmin = new Admin("Blue", "Whale", "bwhale@gmail.com", "Pacific Ocean", "password");
		
		test.put(test.size(), tAdmin);
		
		tManager = new ParkManager("Orca", "Whale", "owhale@gmail.com", "password", "Pacific Ocean", "Wright");
		
		test.put(test.size(), tManager);
		
		list.setMap(test);
		
		//Serialize Data
		Cereal testStoreData = new Cereal(0);
		testStoreData.serialize(list);
	}

}
