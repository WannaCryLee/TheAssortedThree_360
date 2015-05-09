/*
 * Ariel McNamara, Jasmine Pedersen, and Jordan Love
 * TCSS 360: Software Engineering
 * Spring 2015
 */
package model;

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
 * @author Jordan Love
 *
 */
public class Cereal implements Serializable{
	
	/**
	 * Generated serial version id
	 */
	private static final long serialVersionUID = -2615628136259107665L;

	//outFile creates the stream to serialize an object
	private FileOutputStream outFile;
	
	//inFile creates the stream to deserialize an object
	private FileInputStream inFile;
	
	//out is the variable that you can save a object to file
	private ObjectOutputStream out;
	
	//in is the variable that you can read a file to object
	private ObjectInputStream in;
	
	//type 0 if user or 1 if job
	private int myType;
	
	private String path;
	
	private String decodedPath;
	
	/**
	 * Constructor
	 * @param objectNumber, 1 for saving JobList class, 0 for saving UserList class
	 */
	public Cereal(int theType) {
		myType = theType;
		findFile();
	}
	
	private void findFile() {
		path = Cereal.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		try {
			decodedPath = URLDecoder.decode(path, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		decodedPath = decodedPath.substring(0, decodedPath.indexOf("/Urban_Parks.jar"));
	}
	
	/**
	 * This saves (serializes) a inputed class object
	 * @param theClass, Object to be written to file
	 */
	public void serialize(Object theClass) {
		
		
		try {
			if (myType == 0)
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
	 * @return Object, from file
	 */
	public Object deSerialize() {
		Object freshData = null;
		
		try {
			if (myType == 0)
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
