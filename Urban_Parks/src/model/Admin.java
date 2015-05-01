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
	//Address Variable
	private String myAddress;
	
	/**
	 * Constructor
	 */
	public Admin() {
		myFirst = "John";
		myLast = "Doe";
		myEmail = "johndoe@gmail.com";
		myAddress = "";
		myPassword = "password";
	}

	/**
	 * Constructor
	 * @param theFirst, String
	 * @param theLast, String
	 * @param theEmail, String
	 * @param thePassword, String
	 */
	public Admin(String theFirst, String theLast, String theEmail, String theAddress, String thePassword) {
		myFirst = theFirst;
		myLast = theLast;
		myEmail = theEmail;
		myAddress = theAddress;
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
	public ArrayList<Volunteer> getVolunteer(String theLastName, UserList list) {
		ArrayList<Volunteer> foundVolunteer = new ArrayList<Volunteer>();
		
		//UserList list = new UserList();
		HashMap<Integer, Object> map = list.getMap();
		
		java.util.Iterator<Entry<Integer, Object>> itr = map.entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Object> pair = (Map.Entry<Integer, Object>)itr.next();
			//This checks value[1] to equal the given last name and checks to see if its a volunteer
			if (((Volunteer)(pair.getValue())).getMyLast().toLowerCase().equals(theLastName.toLowerCase())) {
				foundVolunteer.add((Volunteer)(pair.getValue()));
			}
			itr.remove();
		}
		
		return foundVolunteer;
	}
	
	/**
	 * Getters and Setters for First Name
	 */
	public String getMyFirst() {
		String returnFirstName = myFirst;
		return returnFirstName;
	}

	public void setMyFirst(String theFirstName) {
		myFirst = theFirstName;
	}

	
	/**
	 * Getters and Setters for Last Name
	 */
	public String getMyLast() {
		String returnLastName = myLast;
		return returnLastName;
	}

	public void setMyLast(String theLastName) {
		myLast = theLastName;
	}

	
	/**
	 * Getters and Setters for Email
	 */
	public String getMyEmail() {
		String returnEmail = myEmail;
		return returnEmail;
	}

	public void setMyEmail(String theEmail) {
		myEmail = theEmail;
	}

	
	/**
	 * Getters and Setters for Password
	 */
	public String getMyPassword() {
		String returnPassword = myPassword;
		return returnPassword;
	}

	public void setMyPassword(String thePassword) {
		myPassword = thePassword;
	}

	
	/**
	 * Getters and Setters for Address
	 */
	public String getMyAddress() {
		String returnAddress = myAddress;
		return returnAddress;
	}

	public void setMyAddress(String theAddress) {
		myAddress = theAddress;
	}
}
