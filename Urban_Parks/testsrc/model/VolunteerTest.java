/**
 * 
 */
package model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ariel
 *
 */
public class VolunteerTest {

	private Volunteer volunteerDefault = new Volunteer();
	private Volunteer volunteerGivenData = new Volunteer("Lysia", "Valu", "jedimaster@gmail.com", "sparkle");
	/**
	 * Test method for {@link model.Volunteer#Volunteer(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testVolunteerGivenData() {
		//Testing constructor with no parameters to log in
		assertEquals(volunteerDefault.logIn("doe@gmail.com", "password"), "Your email or password does not match our database");
		assertEquals(volunteerDefault.logIn("janedoe@gmail.com", "pass"), "Your email or password does not match our database");
		assertEquals(volunteerDefault.logIn("janedoe@gmail.com", "password"), "Welcome! Jane Doe");
		
		//Testing constructor with parameters to log in
		assertEquals(volunteerGivenData.logIn("jedimaster@gmail.com", "sparkle"), "Welcome! Lysia Valu");
	}

	/**
	 * Test method for {@link model.Volunteer#logIn(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogIn() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link model.Volunteer#addJob(model.Job)}.
	 */
	@Test
	public void testAddJob() {
		fail("Not yet implemented");
	}

}
