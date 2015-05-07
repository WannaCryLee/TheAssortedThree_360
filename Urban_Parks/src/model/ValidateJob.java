/**
 * 
 */
package model;

import java.util.Calendar;

/**
 * @author Ariel
 *
 * Checks for that all input is valid, such that fields are filled in correctly and dates are checked before created.
 * 
 * 
 * 
 */
public class ValidateJob {

	private boolean myValidSuccess;

	private Calendar myCurrentYear;

	public ValidateJob(){

		myValidSuccess = false;

	}

	/**
	 * 
	 * @return
	 */
	public boolean checkMonth(int theMonth){
		boolean valid = false;
		int number = 0;

		if ((number<1) || (number>12))    {

		} else{
			valid = true;
		}//ends if
		return valid;
	}//end check month

	/**
	 * 
	 * @return
	 */
	public boolean checkYear(int theYear){
		boolean valid = false;

		if (theYear <= 2015) {  
		
		} else{
			valid = true;
		}//ends if

		return valid;
	}//end check year

	/**
	 * 
	 * @return
	 */
	public boolean checkDay(int theDay){
		boolean valid = false;

		if ((theDay<1) || (theDay>31)) {       

		} else{
			valid = true;
		}//ends if

		return valid;

	}//end check day

}
