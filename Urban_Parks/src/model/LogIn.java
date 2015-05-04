package model;

import java.util.Map;
import java.util.Map.Entry;

public class LogIn {
	
	Volunteer theVolunteer;
	ParkManager theManager;
	Admin theAdmin;
	int whoAmI;
	
	public LogIn() {
		theVolunteer = null;
		theManager = null;
		theAdmin = null;
	}
	
	public void getInstance(String username) {
		Cereal read = new Cereal(0);
		UserList list = (UserList) read.deSerialize();
		
		java.util.Iterator<Entry<Integer, Object>> itr = list.getMap().entrySet().iterator();
		while(itr.hasNext()) {
			Map.Entry<Integer, Object> pair = (Map.Entry<Integer, Object>)itr.next();
			if (pair.getValue() instanceof Volunteer) {
				Volunteer currentVolunteer = (Volunteer) pair.getValue();
				if (currentVolunteer.getMyEmail().equals(username)) {
					theVolunteer = currentVolunteer;
					whoAmI = 0;
					break;
				}
			} else if (pair.getValue() instanceof ParkManager) {
				ParkManager currentParkManager = (ParkManager) pair.getValue();
				if (currentParkManager.getEmail().equals(username)) {
					theManager = currentParkManager;
					whoAmI = 1;
					break;
				}
			} else {
				Admin currentAdmin = (Admin) pair.getValue();
				if (currentAdmin.getMyEmail().equals(username)) {
					theAdmin = currentAdmin;
					whoAmI = 2;
					break;
				}
			}			
			itr.remove();
		}		
	}

	public Volunteer getTheVolunteer() {
		Volunteer returnVolunteer = theVolunteer;
		return returnVolunteer;
	}

	public void setTheVolunteer(Volunteer theVolunteer) {
		this.theVolunteer = theVolunteer;
	}

	public ParkManager getTheManager() {
		ParkManager returnManager = theManager;
		return returnManager;
	}

	public void setTheManager(ParkManager theManager) {
		this.theManager = theManager;
	}

	public Admin getTheAdmin() {
		Admin returnAdmin = theAdmin;
		return returnAdmin;
	}

	public void setTheAdmin(Admin theAdmin) {
		this.theAdmin = theAdmin;
	}

	public int getWhoAmI() {
		int returnWhoAmI = whoAmI;
		return returnWhoAmI;
	}

	public void setWhoAmI(int whoAmI) {
		this.whoAmI = whoAmI;
	}
	
	
	
	
}
