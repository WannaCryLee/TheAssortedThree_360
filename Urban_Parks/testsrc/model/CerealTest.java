package model;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;

import org.junit.Test;

public class CerealTest {

	private UserList list = new UserList();
	private Cereal testCerealUser = new Cereal(1);
	//private Cereal testCerealJob = new Cereal(0);
	
	@Test
	public void serializeTest() {
		setUpUserList();
		File serialFile = new File("File/user.ser");
		
		testCerealUser.serialize(list);
		
		assertTrue("Serialize File was not created", serialFile.exists());
	}
	
	@Test
	public void deserializeTest() {
		UserList deserialList = (UserList)testCerealUser.deSerialize();
		assertEquals("Deserialize was not kept the same", deserialList, list);
	}
	
	private void setUpUserList() {
		HashMap<Integer, Object> test = new HashMap<Integer, Object>();
		
		Volunteer testVolunteer = new Volunteer("Bob", "Johnson", "bjohnson@gmail.com", "password");
		
		test.put(0, testVolunteer);
		
		testVolunteer = new Volunteer("John", "Rotissary", "jrotissary@gmail.com", "password");
		
		test.put(1, testVolunteer);
		
		testVolunteer = new Volunteer("Duk", "Boki", "dboki@gmail.com", "password");
		
		test.put(2, testVolunteer);
		
		testVolunteer = new Volunteer("Sue", "Shi", "sshi@gmail.com", "password");
		
		test.put(3, testVolunteer);
		
		testVolunteer = new Volunteer("Rue", "Shi", "rshi@gmail.com", "password");
		
		test.put(4, testVolunteer);
		
		list.setMap(test);
	}

}
