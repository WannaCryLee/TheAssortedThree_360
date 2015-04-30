package model;

public class Admin {
	
	private String myFirst;
	private String myLast;
	private String myEmail;
	private String myPassword;
	
	public Admin() {
		myFirst = "John";
		myLast = "Doe";
		myEmail = "johndoe@gmail.com";
		myPassword = "password";
	}

	public Admin(String theFirst, String theLast, String theEmail, String thePassword) {
		myFirst = theFirst;
		myLast = theLast;
		myEmail = theEmail;
		myPassword = thePassword;
	}
	
	public String logIn(String email, String password) {
		if (!email.equals(myEmail))
			return "Your email or password does not match our database";
		if (!password.equals(myPassword))
			return "Your email or password does not match our database";
		return "Welcome! " + myFirst + " " + myLast;
	}
	
}
