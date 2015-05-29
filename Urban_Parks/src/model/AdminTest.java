/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

/**
 * Test Admin Class
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class AdminTest implements Serializable{

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = -8713016574919857541L;
	private Admin testAdmin;
	private Admin testAdminData;

	private UserList list;
	ArrayList<Volunteer> testVolunteerList;

	@Before
	public void setUp() throws Exception {
		testAdmin = new Admin();
		testAdminData = new Admin("Jordan", "Love", "jlove934@uw.edu", "", "password");
		list = new UserList();
		setUpUserList();
		testVolunteerList = testAdmin.getVolunteer("Boki");		
	}

	/**
	 * Test method for {@link model.Admin#addJob(model.Job)}.
	 */
	@Test
	public void shouldGetListOfVolunteersWithDefaultConstructor() {

		testVolunteerList = testAdmin.getVolunteer("Boki");	
		for (Volunteer person : testVolunteerList) {
			assertEquals(person.getMyLast(), "Boki");
			//			if (!(person.getMyLast().toLowerCase().equals("Boki".toLowerCase()))) {
			//				fail("getVolunteer does not grab the volunteer with the same last name with the parameter");
			//			}
		}

	}
	/**
	 * Test method for {@link model.Volunteer#addJob(model.Job)}.
	 */
	@Test
	public void shouldGetListOfVolunteersWithGivenDataForConstructor() {

		//Testing constructor with parameters to get volunteer
		testVolunteerList = testAdminData.getVolunteer("Shi");
		for (Volunteer person : testVolunteerList) {
			assertEquals(person.getMyLast(), "Shi");
		}

	}

	/**
	 * Test method for {@link model.Admin#getVolunteer(java.lang.String)}.
	 */
	@Test
	public void shouldGetListOfVolunteersWhenNotInSystem() {

		//Testing constructor with parameters to get volunteer
		testVolunteerList = testAdminData.getVolunteer("Mac");

		assertEquals(testVolunteerList.size(), 0);
	}
	/**
	 * Test method for {@link model.Admin#getVolunteer(java.lang.String)}.
	 */
	@Test
	public void shouldGetListOfVolunteersWhenSizeMoreThanOne() {

		ArrayList<Volunteer> testVolunteerList = testAdmin.getVolunteer("Shi");
		assertEquals(testVolunteerList.size(), 2);
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
