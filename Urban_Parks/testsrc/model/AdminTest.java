package model;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

/**
 * Test Admin Class
 * @author Jordan Love
 *
 */
public class AdminTest implements Serializable{

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -8713016574919857541L;
	private Admin testAdmin = new Admin();
	private Admin testAdminData = new Admin("Jordan", "Love", "jlove934@uw.edu", "", "password");
	private UserList list = new UserList();
	
	@Test
	public void shouldLogIn() {
		//Testing constructor with no parameters to log in
		assertEquals(testAdmin.logIn("johndoe@gmail.com", "password1"), "Your email or password does not match our database");
		assertEquals(testAdmin.logIn("realtalk", "password"), "Your email or password does not match our database");
		assertEquals(testAdmin.logIn("johndoe@gmail.com", "password"), "Welcome! John Doe");
		
		//Testing constructor with parameters to log in
		assertEquals(testAdminData.logIn("jlove934@uw.edu", "password1"), "Your email or password does not match our database");
		assertEquals(testAdminData.logIn("realtalk", "password"), "Your email or password does not match our database");
		assertEquals(testAdminData.logIn("jlove934@uw.edu", "password"), "Welcome! Jordan Love");
	}
	
	@Test
	public void shouldGetListOfVolunteers() {
		setUpUserList();
		//Testing constructor with no parameters to get volunteer
		ArrayList<Volunteer> testVolunteerList = testAdmin.getVolunteer("Boki");
		for (Volunteer person : testVolunteerList) {
			if (!(person.getMyLast().toLowerCase().equals("Boki".toLowerCase()))) {
				fail("getVolunteer does not grab the volunteer with the same last name with the parameter");
			}
		}
		
		//Testing constructor with parameters to get volunteer
		testVolunteerList = testAdminData.getVolunteer("Shi");
		for (Volunteer person : testVolunteerList) {
			if (!(person.getMyLast().toLowerCase().equals("Shi".toLowerCase()))) {
				fail("getVolunteer does not grab the volunteer with the same last name with the parameter");
			}
		}
		if (testVolunteerList.size() != 2)
			fail("Did not find all the Volunteers with the last name given");
	}
	
	/**
	 * Set up the data for the UserList to test getVolunteer
	 */
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
