package model;

import java.util.HashMap;

public class JobList {
	
	//Creates HashMap for a job list
	private HashMap<Integer, Object[]> myMap;
	
	/**
	 * Constructor that declares HashMap to be integer for key
	 * and Object[] for value
	 */
	public JobList() {
		myMap = new HashMap<Integer, Object[]>();
	}
	
	/**
	 * Returns current map
	 * @return HashMap with Integer and Object[]
	 */
	protected HashMap<Integer, Object[]> getMap() {
		HashMap<Integer, Object[]> copyMap = new HashMap<Integer, Object[]>();
		copyMap.putAll(myMap);
		return copyMap;
	}
	
	/**
	 * Updates map with a map that has been modified
	 * @param theMap, HashMap<Integer, Object[]>
	 */
	protected void setMap(HashMap<Integer, Object[]> theMap) {
		myMap.clear();
		myMap.putAll(theMap);
	}
	
	
}
