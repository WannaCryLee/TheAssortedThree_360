package model;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.io.Serializable;
import java.util.HashMap;

/**
 * Creates a list of Jobs
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 * 
 */
public class JobList implements Serializable{

	/**
	 * Generated Serial Version ID
	 */
	private static final long serialVersionUID = 1239457467190085015L;
	//Creates HashMap for a job list
	private HashMap<Integer, Object> myMap;

	/**
	 * Constructor that declares HashMap to be integer for key
	 * 
	 * and Object[] for value
	 */
	public JobList() {
		myMap = new HashMap<Integer, Object>();
	}

	/**
	 * Returns current map
	 * 
	 * @return HashMap with Integer and Object[]
	 */
	public HashMap<Integer, Object> getMap() {
		HashMap<Integer, Object> copyMap = new HashMap<Integer, Object>();
		copyMap.putAll(myMap);
		return copyMap;
	}

	/**
	 * Updates map with a map that has been modified
	 * 
	 * @param theMap, HashMap<Integer, Object[]>
	 */
	public void setMap(HashMap<Integer, Object> theMap) {
		myMap.clear();
		myMap.putAll(theMap);
	}

	/**
	 * Returns the contents within the HashMap as a string
	 * 
	 * @return the contents as a string
	 */
	public String toString(){
		String result = "[";

		if(!(myMap.isEmpty())){

		}

		return result + "]";
	}	
}
