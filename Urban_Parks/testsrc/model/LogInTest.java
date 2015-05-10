package model;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Test;

public class LogInTest {

	LogIn testAdmin = new LogIn();
	LogIn testVolunteer = new LogIn();
	LogIn testParkManager = new LogIn();
	
	@Test
	public void shouldGetInstance() {
		setUpUserList();
		testAdmin.getInstance("bwhale@gmail.com");
		testVolunteer.getInstance("pwhale@gmail.com");
		testParkManager.getInstance("owhale@gmail.com");
		
		assertEquals(testAdmin.getTheAdmin(), null);
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
		
		list.setMap(test);
		
		//Serialize Data
		Cereal testStoreData = new Cereal(0);
		testStoreData.serialize(list);
	}

}
