/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Test;

/**
 * Class used to test the validate job class.
 * 
 * @author Ariel McNamara, Jasmine Pedersen, and Jordan Love
 *
 */
public class ValidateJobTest {

	ValidateJob myVJ = new ValidateJob();

	/**
	 * Test method for {@link model.ValidateJob#checkDate(int, int)}.
	 */
	@Test
	public void shouldCheckDate() {
		//Months wrong, days right, years right
		assertEquals(myVJ.checkDate(13, 16, 2015), false);
		assertEquals(myVJ.checkDate(0, 16, 2015), false);

		//Months right, days wrong, and years right
		assertEquals(myVJ.checkDate(1, 32, 2015), false);
		assertEquals(myVJ.checkDate(12, -1, 2015), false);

		//Months, days, and years correct
		assertEquals(myVJ.checkDate(1, 16, 2016), true);
		assertEquals(myVJ.checkDate(12, 15, 2014), false);

		//Months, days, and years correct
		assertEquals(myVJ.checkDate(1, 16, 2015), true);
		assertEquals(myVJ.checkDate(12, 15, 2015), true);
	}

	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void shouldBeWithin3Months() {
		Calendar start = new GregorianCalendar(2015, 10, 5);
		assertFalse(myVJ.Within3Months(start));
		start = new GregorianCalendar(2015, 6, 2);
		assertTrue(myVJ.Within3Months(start));
		start = new GregorianCalendar(2015, 3, 2);
		assertFalse(myVJ.Within3Months(start));
	}

	/**
	 * Test method for {@link model.ValidateJob#validate(java.lang.String)}.
	 */
	@Test
	public void shouldcheckTime() {
				
		assertEquals(myVJ.checkTime("1:00 AM"), true);
		assertEquals(myVJ.checkTime("12:00 AM"), true);

		assertEquals(myVJ.checkTime("0:00 AM"), false);
		assertEquals(myVJ.checkTime("10:00AM"), false);
		assertEquals(myVJ.checkTime("13:00 AM"), false);
		assertEquals(myVJ.checkTime("12:00 am"), false);
		
	}


}
