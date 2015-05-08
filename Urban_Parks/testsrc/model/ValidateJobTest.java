/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Class used to test the validate job class.
 * 
 * @author Ariel McNamara, Jasmine Pedersen, and Jordan Love
 *
 */
public class ValidateJobTest {

	ValidateJob myVJ = new ValidateJob();

	//	/**
	//	 * Test method for {@link model.ValidateJob#checkMonth(int)}.
	//	 */
	//	@Test
	//	public void shouldCheckMonth() {
	//		assertEquals(myVJ.checkMonth(13), false);
	//		assertEquals(myVJ.checkMonth(0), false);
	//		assertEquals(myVJ.checkMonth(1), true);
	//		assertEquals(myVJ.checkMonth(12), true);
	//		
	//	}

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

	//	/**
	//	 * Test method for {@link model.ValidateJob#checkYear(int)}.
	//	 */
	//	@Test
	//	public void shouldCheckYear() {
	//		assertEquals(myVJ.checkYear(2015), true);
	//		assertEquals(myVJ.checkYear(2016), true);
	//		assertEquals(myVJ.checkYear(2013), false);
	//	}

	//	/**
	//	 * Test method for {@link model.ValidateJob#checkDay(int)}.
	//	 */
	//	@Test
	//	public void shouldCheckDay() {
	//		assertEquals(myVJ.checkDay(16), true);
	//		assertEquals(myVJ.checkDay(-1), false);
	//		assertEquals(myVJ.checkDay(32), false);
	//	}

	/**
	 * Test method for {@link model.ValidateJob#Within3Months(java.lang.String, java.lang.String)}.
	 */
	@Test
	public void shouldBeWithin3Months() {
		assertEquals(myVJ.Within3Months(9, 9, 2015), false);
		assertEquals(myVJ.Within3Months(7, 8, 2015), true);
		assertEquals(myVJ.Within3Months(5, 5, 2015), false);
	}

}
