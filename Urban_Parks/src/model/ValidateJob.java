/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Ariel
 *
 * Checks for that all input is valid, such that fields are filled in correctly and dates are checked before created.
 * 
 * 
 * 
 */
public class ValidateJob {
	//The current year to date
	private Calendar myCurrentYear;
	//The pattern desired to check time
	private Pattern pattern;
	//The ability to match all the times
	private Matcher matcher;
	//The wanted pattern to identify appropriate time constraints; non-military time
	private  String patternForTimes;
	/**
	 * Constructor for initializing variables
	 */
	public ValidateJob(){
		myCurrentYear = Calendar.getInstance();
		patternForTimes = "(1[012]|[1-9]):[0-5][0-9](\\s)(AM|PM)";
		pattern = Pattern.compile(patternForTimes);
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


	public boolean Within3Months(int theDay, int theMonth, int theYear) {
		// The date 90 days after the current date
		Calendar threeMonthsAfterCurrentDate = Calendar.getInstance();
		// The current date
		Calendar currentDate = Calendar.getInstance();
		// Set the date given
		Calendar myStartDate = new GregorianCalendar(theYear, theMonth-1, theDay);

		//Set the date 3 months after
		threeMonthsAfterCurrentDate.add(Calendar.MONTH, 3);

		//BR: Date cannot be in the past nor more than 3 months in the future from the current date
		if (myStartDate.getTime().before(threeMonthsAfterCurrentDate.getTime())
				&& myStartDate.getTime().after(currentDate.getTime())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validate time in 12 hours format with regular expression
	 * @param time time address for validation
	 * @return true valid time format, false invalid time format
	 */
	public boolean checkTime(final String time){		  
		matcher = pattern.matcher(time);
		return matcher.matches();	    	    
	}

}
