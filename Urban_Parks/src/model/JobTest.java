package model;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Job;
/**
 * Test the Job Class
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class JobTest {

	JobList jobList = new JobList();
	Job myJob;

	@Before
	public void setUp() throws Exception {
		myJob = new Job("Sweep the park", "Lacey","sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30);
	}


	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void testCompareSameJob() {
		assertEquals(myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)), true);
	}

	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void testCompareDifferentTitle() {	
		assertFalse("Testing different titles", myJob.compare(
				new Job("Install benches", "Lacey", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void testCompareDifferentParks(){		
		assertFalse("Testing different park name", myJob.compare(
				new Job("Sweep the park", "Tacoma", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void testCompareDifferentDescription(){		
		assertFalse("Testing different description", myJob.compare(
				new Job("Sweep the park", "Lacey", "Benches", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void testCompareDifferentLightJobs(){	
		assertFalse("Testing different number of light jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 1, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void testCompareDifferentMediumJobs(){		
		assertFalse("Testing different number of medium jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 5, 1, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void testCompareDifferentHeavyJobs(){		
		assertFalse("Testing different number of heavy jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 5, 5, 1, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void testCompareDifferentNumOfJobs(){		
		assertFalse("Test if the job is two days long", myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 5, 5, 5, true, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}



	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testJobCheck() {
		//Job myJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30);
		assertSame("Everything checks out", 8, myJob.jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareEmptyTitle() {	

		assertSame("Empty title", 1, 
				new Job("", "Lacey","sweep", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareEmptyParks(){		
		assertSame("Empty park name", 2, 
				new Job("Sweep the park", "", "sweep", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}

	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareEmptyDescription(){		
		assertSame("Empty description", 4, 
				new Job("Sweep the park", "Lacey", "", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareLightJobsLessThanLimit(){	
		assertSame("Light jobs less than limit", 5, 
				new Job("Sweep the park", "Lacey", "sweep", -100, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareLightJobsMoreThanLimit(){	
		assertSame("Light jobs above limit", 5, 
				new Job("Sweep the park", "Lacey", "sweep", 100, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareEmptyMediumJobsLessThanLimit(){		

		assertSame("Medium jobs less than limit", 6, 
				new Job("Sweep the park", "Lacey","sweep", 5, -100, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareMediumJobsMoreThanLimit(){	
		assertSame("Medium jobs above limit", 6, 
				new Job("Sweep the park", "Lacey","sweep", 5, 100, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareEmptyHeavyJobsLessThanLimit(){		
		assertSame("Heavy jobs less than limit", 7, 
				new Job("Sweep the park", "Lacey", "sweep", 5, 5, -100, false, 2015, 6, 5,2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void testCompareHeavyJobsMoreThanLimit(){	
		assertSame("Heavy jobs above limit", 7, 
				new Job("Sweep the park", "Lacey","sweep", 5, 5, 100, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}

}
