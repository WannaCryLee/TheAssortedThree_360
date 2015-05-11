package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Job;
public class JobTest {
	
	JobList jobList = new JobList();
	
	@Before
	public void setUp() throws Exception {
		//Job myTestJob = new Job();
	}


	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompare() {
		Job myJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30);

		//Compare same job
		assertEquals(myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)), true);

		//test title		
		assertFalse("Testing different titles", myJob.compare(
				new Job("Install benches", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));

		//test park name		
		assertFalse("Testing different park name", myJob.compare(
				new Job("Sweep the park", "Tacoma", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));

		//test address
		assertFalse("Testing different address", myJob.compare(
				new Job("Sweep the park", "Lacey", "Diffaddress", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));

		//test description
		assertFalse("Testing different description", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "Benches", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));

		//test number of light jobs
		assertFalse("Testing different number of light jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 1, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));

		//test number of medium jobs
		assertFalse("Testing different number of medium jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 1, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));

		//test number of heavy jobs
		assertFalse("Testing different number of heavy jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 1, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));

		//test if two jobs
		assertFalse("Test if the job is two days long", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, true, 2015, 1, 5, 2015, 1, 5, 5, 30)));

	}

	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldJobCheck() {
		Job myJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30);
		
		//Checks that all is well
		assertSame("Everything checks out", 8, myJob.jobCheck());

		//Checks for empty title
		assertSame("Everything checks out", 1, 
				new Job("", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty park name
		assertSame("Everything checks out", 2, 
				new Job("Sweep the park", "", "address", "sweep", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty address
		assertSame("Everything checks out", 3, 
				new Job("Sweep the park", "Lacey", "", "sweep", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty description
		assertSame("Everything checks out", 4, 
				new Job("Sweep the park", "Lacey", "address", "", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty light jobs less than 0
		assertSame("Everything checks out", 5, 
				new Job("Sweep the park", "Lacey", "address", "sweep", -100, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty light jobs above 50
		assertSame("Everything checks out", 5, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 100, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty medium jobs less than 0
		assertSame("Everything checks out", 6, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, -100, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty medium jobs above 50
		assertSame("Everything checks out", 6, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 100, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty heavy jobs less than 0
		assertSame("Everything checks out", 7, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, -100, false, 2015, 6, 5,2015, 6, 5, 5, 30).jobCheck());

		//Checks for empty heavy jobs above 50
		assertSame("Everything checks out", 7, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 100, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());

	}

}
