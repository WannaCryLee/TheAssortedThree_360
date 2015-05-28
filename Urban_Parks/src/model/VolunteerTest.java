/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;


import org.junit.Before;
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
	private Volunteer myVolunteerDefault = new Volunteer();
	private Job myJobData1;
	private Job myJobData2;
	private Job myJobDatePast;
	
	@Before
	public void setUp() throws Exception {
		myJobData1 = new Job("Lessons", "Huntamer Park", "Lacey Dr.", "Swimming in the air.", 5, 5, 5, true, 
				2015, 12, 31, 2016,1,1, 5, 30);
		myJobData2  = new Job("Training", "Long Lake", "Canyon Rd.", "Lifeguard Training", 5, 5, 5, true, 
				2015, 12, 24, 2015,12,25, 5, 30);
		myJobDatePast = new Job("Diving", "Real Lake", "Lacey Dr", "Diving off the deep end", 2, 2, 2, false,
				2015, 2, 2, 2015, 2, 2, 5, 30);
	}

	/**
	 * Test method for {@link model.Volunteer#addJob(model.Job)}.
	 */
	@Test
	public void shouldAddJobWhenNoJobs() {
		assertEquals(myVolunteerDefault.addJob(myJobData1, 0), 2);		
	}
	/**
	 * Test method for {@link model.Volunteer#addJob(model.Job)}.
	 */
	@Test
	public void shouldAddJobWhenVolunteeredAlready() {
		myVolunteerDefault.addJob(myJobData1, 0);
		assertEquals(myVolunteerDefault.addJob(myJobData1, 0), 1);		
		
	}
	/**
	 * Test method for {@link model.Volunteer#addJob(model.Job)}.
	 */
	@Test
	public void shouldAddJobWhenSignedUpForOtherJobs() {
		myVolunteerDefault.addJob(myJobData1, 0);
		assertEquals(myVolunteerDefault.addJob(myJobData2, 0), 2);	
		
	}
	/**
	 * Test method for {@link model.Volunteer#addJob(model.Job)}.
	 */
	@Test
	public void shouldAddJobWhenJobIsInThePast() {
		assertEquals(myVolunteerDefault.addJob(myJobDatePast, 0), 0);
			
	}

}
