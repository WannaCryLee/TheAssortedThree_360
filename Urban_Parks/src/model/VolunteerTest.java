/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;

import org.junit.Test;

/**
 * 
 * Test the Volunteer Class
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class VolunteerTest {
	//Sets format for Date Strings
	private static SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");
	private Volunteer myVolunteerDefault = new Volunteer();
//	theTitle,theParkName, theAddress, 
//			theDescription,theNumLightJobs, theNumMedJobs, theNumHeavyJobs,
	
//			int theStartYear, int theStartMonth, int theStartDay,
//			int theEndYear, int theEndMonth, int theEndDay)
	private Volunteer myVolunteerGivenData = new Volunteer("Lysia", "Valu", "jedimaster@gmail.com", "sparkle");
	private Job myJobData1 = new Job("Lessons", "Huntamer Park", "Lacey Dr.", "Swimming in the air.", 5, 5, 5, true, 
			2015, 12, 31, 2016,1,1, 5, 30);
	private Job myJobData2 = new Job("Training", "Long Lake", "Canyon Rd.", "Lifeguard Training", 5, 5, 5, true, 
			2015, 12, 24, 2015,12,25, 5, 30);
	private Job myJobDatePast = new Job("Diving", "Real Lake", "Lacey Dr", "Diving off the deep end", 2,2,2,false,2015,2,2,2015,2,2,5,30);
	
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
		//System.out.println("Here!! " + myJobData1.getTitle() + " " + myJobData1.getStartDate() );
//		System.out.println("Success!! You are signed up to volunteer for " + myJobData1.getTitle() 
//				+ " on " +  sdf.format(myJobData1.getStartDate())+ ".");
//		System.out.println("You are already volunteering for a job on this day!");
//		System.out.println("Success!! You are signed up to volunteer for " + myJobData2.getTitle() 
//				+ " on " +  sdf.format(myJobData2.getStartDate())+ ".");
		//Checks if a job was added or not
		assertEquals(myVolunteerDefault.addJob(myJobData1, 0), "Success!! You are signed up to volunteer for " + myJobData1.getTitle() 
				+ " on " +  sdf.format(myJobData1.getStartDate())+ ".");
		assertEquals(myVolunteerDefault.addJob(myJobData1, 0), "You are already volunteering for a job on this day!");
		assertEquals(myVolunteerDefault.addJob(myJobData2, 0), "Success!! You are signed up to volunteer for " + myJobData2.getTitle() 
				+ " on " +  sdf.format(myJobData2.getStartDate())+ ".");
		assertEquals("This job already passed!",myVolunteerDefault.addJob(myJobDatePast, 0));
		
//		System.out.println("Success!! You are signed up to volunteer for " + myJobData1.getTitle() 
//				+ " on " +  sdf.format(myJobData1.getStartDate())+ ".");
//		System.out.println("You are already volunteering for a job on this day!");
//		System.out.println("Success!! You are signed up to volunteer for " + myJobData2.getTitle() 
//				+ " on " +  sdf.format(myJobData2.getStartDate())+ ".");
		
	}

}
