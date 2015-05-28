/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
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
	
	@Before
	public void setUp() throws Exception {
		tAdmin = new Admin("Blue", "Whale", "bwhale@gmail.com", "Pacific Ocean", "password");
		tManager = new ParkManager("Orca", "Whale", "owhale@gmail.com", "password", "Pacific Ocean", "Wright");
		tVolunteer = new Volunteer("Pilot", "Whale", "pwhale@gmail.com", "password");
		setUpUserList();
	}
	
	@Test
	public void shouldGetInstanceOfAdmin() {
		LogIn testAdmin = new LogIn();
		//Tests Administrator
		testAdmin.getInstance("bwhale@gmail.com");
		
		String testEmail = testAdmin.getTheAdmin().getMyEmail();
		String email = tAdmin.getMyEmail();
		
		assertEquals(testEmail.equals(email), true);
//		if (!testAdmin.getTheAdmin().getMyEmail().equals(tAdmin.getMyEmail()))
//			fail("Does not grab the right admin");
		assertEquals(testAdmin.getTheManager(), null);
		assertEquals(testAdmin.getTheVolunteer(), null);
		
	}
	
	@Test
	public void shouldGetInstanceOfVolunteer() {
		LogIn testVolunteer = new LogIn();
		//Tests Volunteer
		testVolunteer.getInstance("pwhale@gmail.com");
		
		String testEmail = testVolunteer.getTheVolunteer().getMyEmail();
		String email = tVolunteer.getMyEmail();
		
		assertEquals(testEmail.equals(email), true);
//		if (!testVolunteer.getTheVolunteer().getMyEmail().equals(tVolunteer.getMyEmail()))
//			fail("Does not grab the right volunteer");
		assertEquals(testVolunteer.getTheManager(), null);
		assertEquals(testVolunteer.getTheAdmin(), null);
	}
	
	@Test
	public void shouldGetInstanceOfManagerWhenManagerExists() {
		LogIn testManager = new LogIn();
		//Tests Park Manager
		testManager.getInstance("owhale@gmail.com");
		
		String testEmail = testManager.getTheManager().getEmail();
		String email = tManager.getEmail();
		
		assertEquals(testEmail.equals(email), true);
//		if (!testManager.getTheManager().getEmail().equals(tManager.getEmail()))
//			fail("Does not grab the right manager");
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
		
		test.put(test.size(), tVolunteer);
			
		test.put(test.size(), tAdmin);
			
		test.put(test.size(), tManager);
		
		list.setMap(test);
		
		//Serialize Data
		Cereal testStoreData = new Cereal(0);
		testStoreData.serialize(list);
	}

}
