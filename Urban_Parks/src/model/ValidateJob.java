/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * @author Ariel
 *
 * Checks for that all input is valid, such that fields are filled in correctly and dates are checked before created.
 * 
 * 
 * 
 */
public class ValidateJob {

	private Calendar myCurrentYear;

	public ValidateJob(){

		myCurrentYear = Calendar.getInstance();
	}

	/**
	 * Make sure the month give is an actual month
	 * @return
	 */
	public boolean checkDate(int theMonth, int theDay, int theYear){
		if ((theMonth < 1) || (theMonth > 12)){
			return false;
		} else if ((theDay<1) || (theDay>31)) {       
			return false;
		} else if (!(theYear == myCurrentYear.getWeekYear() || theYear == myCurrentYear.getWeekYear() + 1)) {  
			return false;
		} 
		return true;
	}//end check month

//	/**
//	 * Make sure the year given is current
//	 * @return
//	 */
//	public boolean checkYear(int theYear){
//
//		if (!(theYear == myCurrentYear.getWeekYear() || theYear == myCurrentYear.getWeekYear() + 1)) {  
//			return false;
//		} 
//		return true;
//	}//end check year

//	/**
//	 * 
//	 * @return
//	 */
//	public boolean checkDay(int theDay){
//		if ((theDay<1) || (theDay>31)) {       
//			return false;
//		} 		
//		return true;
//	}//end check day

	public boolean Within3Months(int theDay, int theMonth, int theYear) {
		// The date 90 days after the current date
		Calendar threeMonthsAfterCurrentDate = Calendar.getInstance();
		// The current date
		Calendar currentDate = Calendar.getInstance();
		//Set the date given
		Calendar myStartDate = new GregorianCalendar(theYear, theMonth-1, theDay);
		//Set the format
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy");

		//Set the date 3 months after
		threeMonthsAfterCurrentDate.add(Calendar.MONTH, 3);


//		System.out.println("\n\nCurrent Date:  " + sdf.format(currentDate.getTime()));		
//		System.out.println("3 Months After the Current Date:  " + sdf.format(threeMonthsAfterCurrentDate.getTime()));
//		System.out.println("The Date to Validate:  " + sdf.format(myStartDate.getTime()));

		//BR: Date cannot be in the past nor more than 3 months in the future from the current date
		if (myStartDate.getTime().before(threeMonthsAfterCurrentDate.getTime())
				&& myStartDate.getTime().after(currentDate.getTime())) {
			return true;
		} else {
			return false;

		}

	}

}
