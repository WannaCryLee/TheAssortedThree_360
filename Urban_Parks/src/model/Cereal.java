package model;
/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * The Assorted Three
 * TCSS 360: Software Engineering
 * Spring 2015
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Allows Serialization of Objects
 * 
 * @author Jordan Love, Ariel McNamara, and Jasmine Pedersen
 * @version Spring 2015
 *
 */
public class Cereal implements Serializable{
	
	/**
	 * Generated serial version id
	 */
	private static final long serialVersionUID = -2615628136259107665L;
	
	private static final int USER_LIST = 0;
	
	private FileOutputStream outFile; //outFile creates the stream to serialize an object
		
	private FileInputStream inFile; //inFile creates the stream to deserialize an object
		
	private ObjectOutputStream out; //out is the variable that you can save a object to file
	
	private ObjectInputStream in; //in is the variable that you can read a file to object
	
	private int myType; //type 0 if user or 1 if job
	
	private String path;
	
	private String decodedPath;
	
	/**
	 * Constructor
	 * 
	 * @param objectNumber, 1 for saving JobList class, 0 for saving UserList class
	 */
	public Cereal(int theType) {
		myType = theType;
		findFile();
	}
	/**
	 * Search for the file of the serealized class
	 */
	private void findFile() {
		path = Cereal.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (decodedPath.contains("/Urban_Parks.jar"))
			decodedPath = decodedPath.substring(0, decodedPath.indexOf("/Urban_Parks.jar"));
	}
	
	/**
	 * This saves (serializes) a inputed class object
	 * 
	 * @param theClass, Object to be written to file
	 */
	public void serialize(Object theClass) {		
		try {
			if (myType == USER_LIST)
				outFile = new FileOutputStream( decodedPath + "/user.ser");
			else
				outFile = new FileOutputStream( decodedPath + "/job.ser");
		
			
			out = new ObjectOutputStream(outFile);
			out.writeObject(theClass);
		
			outFile.close();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Reads file and returns a Object class
	 * 
	 * @return Object, from file
	 */
	public Object deSerialize() {
		Object freshData = null;
		
		try {
			if (myType == USER_LIST)
				inFile = new FileInputStream(decodedPath + "/user.ser");
			else
				inFile = new FileInputStream(decodedPath + "/job.ser");
		
			in = new ObjectInputStream(inFile);
			freshData = in.readObject();
		
			inFile.close();
			in.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return freshData;
	}
	
}
