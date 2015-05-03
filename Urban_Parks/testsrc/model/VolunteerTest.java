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
	private Job jobData1 = new Job("Lessons", "Huntamer Park", "Lacey Dr.", "Swimming in the air.", 5, "August 1");
	private Job jobData2 = new Job("Training", "Long Lake", "Canyon Rd.", "Lifeguard Training", 5, "June 2");
	/**
	 * Test method for {@link model.Volunteer#Volunteer(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testLogIn() {
		//Testing constructor with no parameters to log in
		assertEquals(volunteerDefault.logIn("doe@gmail.com", "password"), "Your email or password does not match our database");
		assertEquals(volunteerDefault.logIn("janedoe@gmail.com", "pass"), "Your email or password does not match our database");
		assertEquals(volunteerDefault.logIn("janedoe@gmail.com", "password"), "Welcome! Jane Doe");
		
		//Testing constructor with parameters to log in
		assertEquals(volunteerGivenData.logIn("jedi@gmail.com", "sparkle"), "Your email or password does not match our database");
		assertEquals(volunteerGivenData.logIn("jedimaster@gmail.com", "spark"), "Your email or password does not match our database");
		assertEquals(volunteerGivenData.logIn("jedimaster@gmail.com", "sparkle"), "Welcome! Lysia Valu");
	}

	/**
	 * Test method for {@link model.Volunteer#addJob(model.Job)}.
	 */
	@Test
	public void testAddJob() {
		assertEquals(volunteerDefault.addJob(jobData1), "Success!! You are signed up to volunteer for " + jobData1.getTitle() + " on ");
		//assertEquals(volunteerDefault.addJob(jobData1), "You are already volunteering for a job on this day!");
		//assertEquals(volunteerDefault.addJob(jobData2), "Success!! You are signed up to volunteer for " + jobData2.getTitle() + " on ");
	}

}
