/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import java.util.HashMap;

import org.junit.Test;

public class LogInTest {

	@Test
	public void shouldGetInstance() {
		LogIn testUser = new LogIn();
		//Goes through when there is no data
		testUser.getInstance("ChecksIfEmpty@gmail.com");
		//Creates the data
		setUpUserList();
		//Tests Administrator
		testUser.getInstance("bwhale@gmail.com");
		//Tests Volunteer
		testUser.getInstance("pwhale@gmail.com");
		//Tests Park Manager
		testUser.getInstance("owhale@gmail.com");		
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
		
		testVolunteer = new Volunteer("Pilot", "Whale", "pwhale@gmail.com", "password");
		
		test.put(test.size(), testVolunteer);
		
		Admin testAdmin = new Admin("Blue", "Whale", "bwhale@gmail.com", "Pacific Ocean", "password");
		
		test.put(test.size(), testAdmin);
		
		ParkManager testManager = new ParkManager("Orca", "Whale", "owhale@gmail.com", "password", "Pacific Ocean", "Wright");
		
		test.put(test.size(), testManager);
		
		testManager = new ParkManager("Twin", "kies", "hostess@gmail.com", "password", "Ocean", "Mermaid");
		
		test.put(test.size(), testManager);
		
		list.setMap(test);
		
		//Serialize Data
		Cereal testStoreData = new Cereal(0);
		testStoreData.serialize(list);
	}

}
