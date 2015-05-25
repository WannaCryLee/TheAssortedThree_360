package model;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * Checks for that all input is valid, such that fields are filled in correctly and dates are checked before created.
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 */
public class ValidateJob {
	/**
	 * The start number for a month or week
	 */
	private static final int START_DAY_AND_MONTH = 1;
	private static final int FINAL_MONTH = 12;
	private static final int MAX_MONTHS_RANGE = 3;
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
	
	
	////SET THE DAY OF THE MONTH TO WHAT THE MONTH GIVEN BY THE USER WAS!!!

	/**
	 * Make sure the month give is an actual month
	 * 
	 * @return
	 */
	public boolean checkDate(int theMonth, int theDay, int theYear){

		if ((theMonth < START_DAY_AND_MONTH) || (theMonth > FINAL_MONTH)){
			return false;
		} else if ((theDay < START_DAY_AND_MONTH) || (theDay > 31)) {       
			return false;
		} else if (!(theYear == myCurrentYear.getWeekYear() || theYear == myCurrentYear.getWeekYear() + START_DAY_AND_MONTH)) {  
			return false;
		} 
		return true;
	}//end check month

	/**
	 * Checks if a date given is within a certain number of months
	 * 
	 * @param myStartDate		the date given
	 * @return true				if the date is before the time range given and before yesterday, false otherwise
	 */
	public boolean Within3Months(Calendar myStartDate) {
		// The date 90 days after the current date
		Calendar threeMonthsAfterCurrentDate = Calendar.getInstance();
		// The current date
		Calendar today = Calendar.getInstance();

		//Set the date MAX_MONTHS_RANGE months after
		threeMonthsAfterCurrentDate.add(Calendar.MONTH, MAX_MONTHS_RANGE);

		//BR: Date cannot be in the past nor more than MAX_MONTHS_RANGE months in the future from the current date
		if (myStartDate.before(threeMonthsAfterCurrentDate)
				&& myStartDate.after(today)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Validate time in 12 hours format with regular expression
	 * 
	 * @param time time address for validation
	 * @return true valid time format, false invalid time format
	 */
	public boolean checkTime(final String time){		  
		matcher = pattern.matcher(time);
		return matcher.matches();	    	    
	}

}
