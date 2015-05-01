package model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

public class AdminTest {

	private Admin testAdmin = new Admin();
	private Admin testAdminData = new Admin("Jordan", "Love", "jlove934@uw.edu", "", "password");
	private UserList list = new UserList();
	
	@Test
	public void LogInTest() {
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
	public void getVolunteerTest() {
		setUpUserList();
		//Testing constructor with no parameters to get volunteer
		ArrayList<Volunteer> testVolunteerList = testAdmin.getVolunteer("Boki", list);
		for (Volunteer person : testVolunteerList) {
			if (!(person.getMyLast().toLowerCase().equals("Boki".toLowerCase()))) {
				fail("getVolunteer does not grab the volunteer with the same last name with the parameter");
			}
		}
		
		//Testing constructor with parameters to get volunteer
		testVolunteerList = testAdminData.getVolunteer("Boki", list);
		for (Volunteer person : testVolunteerList) {
			if (!(person.getMyLast().toLowerCase().equals("Boki".toLowerCase()))) {
				fail("getVolunteer does not grab the volunteer with the same last name with the parameter");
			}
		}
	}
	
	private void setUpUserList() {
		HashMap<Integer, Object> test = new HashMap<Integer, Object>();
		
		Volunteer testVolunteer = new Volunteer("Bob", "Johnson", "bjohnson@gmail.com", "password");
		
		test.put(0, testVolunteer);
		
		testVolunteer = new Volunteer("John", "Rotissary", "jrotissary@gmail.com", "password");
		
		test.put(1, testVolunteer);
		
		testVolunteer = new Volunteer("Duk", "Boki", "dboki@gmail.com", "password");
		
		test.put(2, testVolunteer);
		
		testVolunteer = new Volunteer("Sue", "Shi", "sshi@gmail.com", "password");
		
		test.put(3, testVolunteer);
		
		testVolunteer = new Volunteer("Rue", "Shi", "rshi@gmail.com", "password");
		
		test.put(4, testVolunteer);
		
		list.setMap(test);
	}

}
