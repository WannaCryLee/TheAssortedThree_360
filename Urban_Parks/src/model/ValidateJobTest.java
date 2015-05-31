/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

/**
 * Class used to test the validate job class.
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class ValidateJobTest {

	ValidateJob myVJ;
	Calendar start;
	
	@Before
	public void setUp() throws Exception {
		myVJ = new ValidateJob();
		start = Calendar.getInstance();
	}


	/**
	 * Test method for {@link model.ValidateJob#checkDate(int, int)}.
	 */
	@Test
	public void testCheckDateWithMonthBeforeJan() {
		//Months wrong, days right, years right
		assertEquals(myVJ.checkDate(0, 16, 2015), false);
	}
	
	/**
	 * Test method for {@link model.ValidateJob#checkDate(int, int)}.
	 */
	@Test
	public void testCheckDateWithMonthAfterDec() {
		//Months wrong, days right, years right
		assertEquals(myVJ.checkDate(13, 16, 2015), false);
	}
	/**
	 * Test method for {@link model.ValidateJob#checkDate(int, int)}.
	 */
	@Test
	public void testCheckDateWithDayPastHighestDayInAMonth() {
		//Months right, days wrong, and years right
		assertEquals(myVJ.checkDate(1, 32, 2015), false);
	}
	
	/**
	 * Test method for {@link model.ValidateJob#checkDate(int, int)}.
	 */
	@Test
	public void testCheckDateWithDayBeforeFirstOfAMonth() {
		assertEquals(myVJ.checkDate(12, -1, 2015), false);
	}	
	
	
	/**
	 * Test method for {@link model.ValidateJob#checkDate(int, int)}.
	 */
	@Test
	public void testCheckDateWithAllWithCorrectTimeFrame() {
		//Months, days, and years correct
		assertEquals(myVJ.checkDate(1, 16, 2016), true);
		assertEquals(myVJ.checkDate(12, 15, 2015), true);
	}
	
	/**
	 * Test method for {@link model.ValidateJob#checkDate(int, int)}.
	 */
	@Test
	public void testCheckDateWhenYearAYearBehindCurrentYear() {
		assertEquals(myVJ.checkDate(12, 15, 2014), false);
	}
	
	/**
	 * Test method for {@link model.ValidateJob#checkDate(int, int)}.
	 */
	@Test
	public void testCheckDateWhenYearToFarInAdvance() {
		assertEquals(myVJ.checkDate(12, 15, 2017), false);
	}

	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testBeWithinMaxRangeMonthsWhenMoreThanMaxRange() {
		start = new GregorianCalendar(2015, 10, 5);
		assertFalse(myVJ.WithinMaxRangeMonths(start));
	}
	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testBeWithinMaxRangeMonthsWhenWithinMax() {
		start = new GregorianCalendar(2015, 6, 2);
		assertTrue(myVJ.WithinMaxRangeMonths(start));
	}
	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testBeWithinMaxRangeMonthsWhenInPast() {

		start = new GregorianCalendar(2015, 3, 2);
		assertFalse(myVJ.WithinMaxRangeMonths(start));
	}

	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testcheckTimeWhenCorrectFormatAtOne() {
				
		assertEquals(myVJ.checkTime("1:00 AM"), true);
	
	}
	
	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testcheckTimeWhenCorrectFormatAtTwelve() {
		assertEquals(myVJ.checkTime("12:00 AM"), true);
		
	}
	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testcheckTimeWhenIncorrectTimeBeforeOne() {
		assertEquals(myVJ.checkTime("0:00 AM"), false);
		
	}	
	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testcheckTimeWhenIncorrectFormatInProperClockRange() {
		assertEquals(myVJ.checkTime("10:00AM"), false);
		
	}	
	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testcheckTimeWhenTimeAfterTwelve() {
		assertEquals(myVJ.checkTime("13:00 AM"), false);
		
	}	
	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void testcheckTimeWhenIncorrectFormat() {
		assertEquals(myVJ.checkTime("12:00 am"), false);		
	}

}
