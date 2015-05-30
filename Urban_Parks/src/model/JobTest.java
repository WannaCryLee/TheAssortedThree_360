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
	public void shouldCompareSameJob() {
		assertEquals(myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)), true);
	}

	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompareDifferentTitle() {	
		assertFalse("Testing different titles", myJob.compare(
				new Job("Install benches", "Lacey", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompareDifferentParks(){		
		assertFalse("Testing different park name", myJob.compare(
				new Job("Sweep the park", "Tacoma", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompareDifferentDescription(){		
		assertFalse("Testing different description", myJob.compare(
				new Job("Sweep the park", "Lacey", "Benches", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompareDifferentLightJobs(){	
		assertFalse("Testing different number of light jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 1, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompareDifferentMediumJobs(){		
		assertFalse("Testing different number of medium jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 5, 1, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompareDifferentHeavyJobs(){		
		assertFalse("Testing different number of heavy jobs", myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 5, 5, 1, false, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}
	/**
	 * Test method for {@link model.Job#compare(model.Job)}.
	 */
	@Test
	public void shouldCompareDifferentNumOfJobs(){		
		assertFalse("Test if the job is two days long", myJob.compare(
				new Job("Sweep the park", "Lacey", "sweep", 5, 5, 5, true, 2015, 1, 5, 2015, 1, 5, 5, 30)));
	}



	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldJobCheck() {
		//Job myJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5, 5, 30);
		assertSame("Everything checks out", 8, myJob.jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareEmptyTitle() {	

		assertSame("Empty title", 1, 
				new Job("", "Lacey","sweep", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareEmptyParks(){		
		assertSame("Empty park name", 2, 
				new Job("Sweep the park", "", "sweep", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}

	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareEmptyDescription(){		
		assertSame("Empty description", 4, 
				new Job("Sweep the park", "Lacey", "", 5, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareLightJobsLessThanLimit(){	
		assertSame("Light jobs less than limit", 5, 
				new Job("Sweep the park", "Lacey", "sweep", -100, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareLightJobsMoreThanLimit(){	
		assertSame("Light jobs above limit", 5, 
				new Job("Sweep the park", "Lacey", "sweep", 100, 5, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareEmptyMediumJobsLessThanLimit(){		

		assertSame("Medium jobs less than limit", 6, 
				new Job("Sweep the park", "Lacey","sweep", 5, -100, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareMediumJobsMoreThanLimit(){	
		assertSame("Medium jobs above limit", 6, 
				new Job("Sweep the park", "Lacey","sweep", 5, 100, 5, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareEmptyHeavyJobsLessThanLimit(){		
		assertSame("Heavy jobs less than limit", 7, 
				new Job("Sweep the park", "Lacey", "sweep", 5, 5, -100, false, 2015, 6, 5,2015, 6, 5, 5, 30).jobCheck());
	}
	/**
	 * Test method for {@link model.Job#jobCheck()}.
	 */
	@Test
	public void shouldCompareHeavyJobsMoreThanLimit(){	
		assertSame("Heavy jobs above limit", 7, 
				new Job("Sweep the park", "Lacey","sweep", 5, 5, 100, false, 2015, 6, 5, 2015, 6, 5, 5, 30).jobCheck());
	}

}
