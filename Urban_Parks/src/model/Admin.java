package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Admin {
	
	//First Name Variable
	private String myFirst;
	//Last Name Variable
	private String myLast;
	//Email Variable
	private String myEmail;
	//Password Variable
	private String myPassword;
	
	/**
	 * Constructor
	 */
	public Admin() {
		myFirst = "John";
		myLast = "Doe";
		myEmail = "johndoe@gmail.com";
		myPassword = "password";
	}

	/**
	 * Constructor
	 * @param theFirst, String
	 * @param theLast, String
	 * @param theEmail, String
	 * @param thePassword, String
	 */
	public Admin(String theFirst, String theLast, String theEmail, String thePassword) {
		myFirst = theFirst;
		myLast = theLast;
		myEmail = theEmail;
		myPassword = thePassword;
	}
	
	/**
	 * This method logs admin in with given email and password
	 * @param email, string
	 * @param password, string
	 * @return string if they were loged in or not
	 */
	public String logIn(String email, String password) {
		if (!email.equals(myEmail))
			return "Your email or password does not match our database";
		if (!password.equals(myPassword))
			return "Your email or password does not match our database";
		return "Welcome! " + myFirst + " " + myLast;
	}
	
	/**
	 * Searches through the database for the input lastname and return
	 * a arraylist of userid if found or return null if nothing was found
	 * @param theLastName, the last name of the Volunteer
	 * @return ArrayList<Integer>, List of user id with the given last name
	 */
	public ArrayList<Integer> getVolunteer(String theLastName) {
		ArrayList<Integer> foundVolunteer = new ArrayList<Integer>();
		
		UserList list = new UserList();
		HashMap<Integer, Object[]> map = list.getMap();
		
		java.util.Iterator<Entry<Integer, Object[]>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Object[]> pair = (Map.Entry<Integer, Object[]>)itr.next();
			//This checks value[1] to equal the given last name and checks to see if its a volunteer
			if (pair.getValue()[1].equals(theLastName) && pair.getValue()[2] == (Integer)0) {
				foundVolunteer.add(pair.getKey());
			}
			itr.remove();
		}
		
		return foundVolunteer;
	}
}
