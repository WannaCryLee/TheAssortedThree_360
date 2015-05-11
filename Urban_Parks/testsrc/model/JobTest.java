package model;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

import model.Job;
public class JobTest {
	
	JobList jobList = new JobList();
	
	@Before
	public void setUp() throws Exception {
		Job myTestJob = new Job();
	}


	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompare() {
		Job myJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);

		//Compare same job
		assertEquals(myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5)), true);

		//test title		
		assertFalse("Testing different titles", myJob.compare(
				new Job("Install benches", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5)));

		//test park name		
		assertFalse("Testing different park name", myJob.compare(
				new Job("Sweep the park", "Tacoma", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5)));

		//test address
		assertFalse("Testing different address", myJob.compare(
				new Job("Sweep the park", "Lacey", "Diffaddress", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5)));

		//test description
		assertFalse("Testing different description", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "Benches", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5)));

		//test number of light jobs
		assertFalse("Testing different number of light jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 1, 5, 5, false, 2015, 1, 5, 2015, 1, 5)));

		//test number of medium jobs
		assertFalse("Testing different number of medium jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 1, 5, false, 2015, 1, 5, 2015, 1, 5)));

		//test number of heavy jobs
		assertFalse("Testing different number of heavy jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 1, false, 2015, 1, 5, 2015, 1, 5)));

		//test if two jobs
		assertFalse("Test if the job is two days long", myJob.compare(
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, true, 2015, 1, 5, 2015, 1, 5)));

	}

	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldJobCheck() {
		Job myJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
		
		//Checks that all is well
		assertSame("Everything checks out", 0, myJob.jobCheck());

		//Checks for empty title
		assertSame("Everything checks out", 1, 
				new Job("", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty park name
		assertSame("Everything checks out", 2, 
				new Job("Sweep the park", "", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty address
		assertSame("Everything checks out", 3, 
				new Job("Sweep the park", "Lacey", "", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty description
		assertSame("Everything checks out", 4, 
				new Job("Sweep the park", "Lacey", "address", "", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty light jobs less than 0
		assertSame("Everything checks out", 5, 
				new Job("Sweep the park", "Lacey", "address", "sweep", -100, 5, 5, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty light jobs above 50
		assertSame("Everything checks out", 5, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 100, 5, 5, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty medium jobs less than 0
		assertSame("Everything checks out", 6, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, -100, 5, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty medium jobs above 50
		assertSame("Everything checks out", 6, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 100, 5, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty heavy jobs less than 0
		assertSame("Everything checks out", 7, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, -100, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

		//Checks for empty heavy jobs above 50
		assertSame("Everything checks out", 7, 
				new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 100, false, 2015, 1, 5, 2015, 1, 30).jobCheck());

	}

	/**
	 * Test method for {@link model.Job#isMaxWeek()}.
	 */
	@Test
	public void shouldIsMaxWeek() {
		//	assertTrue();
		Job current  = new Job("Sweep", "Wright", "Tacoma, WA", "Sweep Sidewalks", 3, 5, 3, false, 2015, 5, 17, 2015, 5, 17);

		setUpJobList();
		//Job exJob = (Job) jobList.getMap().get(3);
		//System.out.println(exJob.getTitle() + " " + exJob.getStartDate());
		System.out.println(current.getTitle() + " " + current.isMaxWeek());
		//assertFalse("Too many jobs on the given week", current.isMaxWeek());
		//testJob1.isMaxWeek()
	}
	
	private void setUpJobList() {

		HashMap<Integer, Object> test = new HashMap<Integer, Object>();
		

		Job testJob = new Job("Rock", "Tuscany", "Tacoma, WA", "Clean Rocks", 3, 5, 3, false, 2015, 5, 15, 2015, 5, 15);

		test.put(test.size(), testJob);

		testJob = new Job("Bark", "Tuscany", "Tacoma, WA", "New Bark",3, 5, 3, false, 2015, 5, 16, 2015, 5, 16);

		test.put(test.size(), testJob);

		testJob = new Job("Garbage", "Wright", "Tacoma, WA", "Change all the Garbage", 3, 5, 3, false, 2015, 5, 18, 2015, 5, 18);

		test.put(test.size(), testJob);

		testJob = new Job("New Fountain", "Lighthouse", "Tacoma, WA", "Install new fountain", 3, 5, 3, false, 2015, 5, 19, 2015, 5, 19);

		test.put(test.size(), testJob);

		testJob = new Job("BBQ", "LightHouse", "Tacoma, WA", "Cook Meat :)", 3, 5, 3, false, 2015, 5, 20, 2015, 5, 20);

		test.put(test.size(), testJob);

		jobList.setMap(test);
		//Serialize Data
		Cereal testStoreData = new Cereal(0);
		testStoreData.serialize(jobList);
	}
	/*
	@Test
	public void testCompareDifferentStartYear() {
		//test start year
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2010, 1, 5, 2015, 1, 5);
		assertFalse("Testing different start year", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentStartMonth() {
		//test start month
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 6, 5, 2015, 1, 5);
		assertFalse("Testing different start month", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentStartDay() {
		//test start day
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 10, 2015, 1, 5);
		assertFalse("Testing different start day", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentEndYear() {
		//test end year
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2010, 1, 5);
		assertFalse("Testing different end year", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentEndMonth() {

		//test end month
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 10, 5);
		assertFalse("Testing different end month", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentEndDay() {
		//test end day
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertFalse("Testing different end day", myJobTestCompare.compare(otherJob));
	}


//TESTS IF THE START YEAR AND SUCH.....DON'T KNOW IF WE NEED THIS
 
	@Test
	public void testJobCheckEmptyStartYear() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 0, otherJob.jobCheck());
	}

	@Test
	public void testJobCheckEmptyStartMonth() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 0, otherJob.jobCheck());
	}

	@Test
	public void testJobCheckEmptyStartDay() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 0, otherJob.jobCheck());
	}

	@Test
	public void testJobCheckEmptyEndYear() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 0, otherJob.jobCheck());
	}

	@Test
	public void testJobCheckEmptyEndMonth() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 0, otherJob.jobCheck());
	}

	@Test
	public void testJobCheckEmptyEndDay() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 0, otherJob.jobCheck());
	}

	 */

}
