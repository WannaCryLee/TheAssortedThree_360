package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import model.Job;
public class JobTest {

	private Job myJobTestCompare;
	private Job myJob;
	private Job otherJob;

	@Before
	public void setUp() throws Exception {
		myJobTestCompare = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
	}

	@Test
	public void testJob() {
		myJob = new Job();
	}

	@Test
	public void testJobStringStringStringStringIntIntIntIntIntIntIntIntInt() {
		myJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
	}

	@Test
	public void testCompareSameJob() {
		myJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
		assertTrue("Testing same job", myJob.compare(myJob));

	}

	@Test
	public void testCompareDifferentTitle() {
		//test title
		otherJob = new Job("Install benches", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
		assertFalse("Testing different titles", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentParkName() {
		//test park name
		otherJob = new Job("Sweep the park", "Tacoma", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
		assertFalse("Testing different park name", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentAddress() {
		//test address
		otherJob = new Job("Sweep the park", "Lacey", "Diffaddress", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
		assertFalse("Testing different address", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentDescription() {
		//test description
		otherJob = new Job("Sweep the park", "Lacey", "address", "Benches", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
		assertFalse("Testing different description", myJobTestCompare.compare(otherJob));
	}
	
	@Test
	public void testCompareDifferentLightJobs() {
		//test number of light jobs
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 1, 5, 5, false, 2015, 1, 5, 2015, 1, 5);
		assertFalse("Testing different number of light jobs", myJobTestCompare.compare(otherJob));
	}

	@Test
	public void testCompareDifferentMediumJobs() {
		//test number of medium jobs
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 1, 5, false, 2015, 1, 5, 2015, 1, 5);
		assertFalse("Testing different number of medium jobs", myJobTestCompare.compare(otherJob));
	}


	@Test
	public void testCompareDifferentHeavyJobs() {
		//test number of heavy jobs
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 1, false, 2015, 1, 5, 2015, 1, 5);
		assertFalse("Testing different number of heavy jobs", myJobTestCompare.compare(otherJob));
	}
	
	@Test
	public void testCompareDifferentIsTwoDay() {
		//test number of heavy jobs
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 5, true, 2015, 1, 5, 2015, 1, 5);
		assertFalse("Testing different is two days boolean", myJobTestCompare.compare(otherJob));
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
	
	
	*/


	@Test
	public void testJobCheckEverythingAligns() {
		assertSame("Everything checks out", 0, myJobTestCompare.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyTitle() {
		otherJob = new Job("", "Lacey", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 1, otherJob.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyParkName() {
		otherJob = new Job("Sweep the park", "", "address", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 2, otherJob.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyAddress() {
		otherJob = new Job("Sweep the park", "Lacey", "", "sweep", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 3, otherJob.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyDescription() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "", 5, 5, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 4, otherJob.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyLightJobsBelow() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", -100, 5, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 5, otherJob.jobCheck());
	}
	@Test
	public void testJobCheckEmptyLightJobsAbove() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 100, 5, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 5, otherJob.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyMediumJobsBelow() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, -100, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 6, otherJob.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyMediumJobsAbove() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 100, 5, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 6, otherJob.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyHeavyJobsBelow() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, -100, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 7, otherJob.jobCheck());
	}
	
	@Test
	public void testJobCheckEmptyHeavyJobsAbove() {
		otherJob = new Job("Sweep the park", "Lacey", "address", "sweep", 5, 5, 100, false, 2015, 1, 5, 2015, 1, 30);
		assertSame("Everything checks out", 7, otherJob.jobCheck());
	}
	
	
	
   /*
    
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
	
	

	@Test
	public void testIsMaxWeek() {
	//	assertTrue();
	//	assertFalse();
	}

}
