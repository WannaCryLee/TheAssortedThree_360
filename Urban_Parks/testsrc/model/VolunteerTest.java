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
			
	private Volunteer myVolunteerDefault = new Volunteer();
	private Volunteer myVolunteerGivenData = new Volunteer("Lysia", "Valu", "jedimaster@gmail.com", "sparkle");
	private Job myJobData1 = new Job("Lessons", "Huntamer Park", "Lacey Dr.", "Swimming in the air.", 5, "August 1");
	private Job myJobData2 = new Job("Training", "Long Lake", "Canyon Rd.", "Lifeguard Training", 5, "June 2");
	
	/**
	 * Test method for {@link model.Volunteer#Volunteer(int, java.lang.String, java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void shouldLogIn() {
		//Testing constructor with no parameters to log in
		assertEquals(myVolunteerDefault.logIn("doe@gmail.com", "password"), 
				"Your email or password does not match our database");
		assertEquals(myVolunteerDefault.logIn("janedoe@gmail.com", "pass"), 
				"Your email or password does not match our database");
		assertEquals(myVolunteerDefault.logIn("janedoe@gmail.com", "password"), "Welcome! Jane Doe");
		
		//Testing constructor with parameters to log in
		assertEquals(myVolunteerGivenData.logIn("jedi@gmail.com", "sparkle"), 
				"Your email or password does not match our database");
		assertEquals(myVolunteerGivenData.logIn("jedimaster@gmail.com", "spark"), 
				"Your email or password does not match our database");
		assertEquals(myVolunteerGivenData.logIn("jedimaster@gmail.com", "sparkle"), "Welcome! Lysia Valu");
	}

	/**
	 * Test method for {@link model.Volunteer#addJob(model.Job)}.
	 */
	@Test
	public void shouldAddJob() {
		//Checks if a job was added or not
		assertEquals(myVolunteerDefault.addJob(myJobData1), "Success!! You are signed up to volunteer for " + myJobData1.getTitle() 
				+ " on " + myJobData1.getDate() + ".");
		assertEquals(myVolunteerDefault.addJob(myJobData1), "You are already volunteering for a job on this day!");
		assertEquals(myVolunteerDefault.addJob(myJobData2), "Success!! You are signed up to volunteer for " + myJobData2.getTitle() 
				+ " on " + myJobData2.getDate() + ".");
	}

}
