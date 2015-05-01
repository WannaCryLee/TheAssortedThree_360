package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

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
	
	/**
	 * Constructor
	 * @param objectNumber, 0 for saving JobList class, 1 for saving UserList class
	 */
	public Cereal(int objectNumber) {
		try {
			if (objectNumber == 0) {
				outFile = new FileOutputStream("Files/job.ser");
				inFile = new FileInputStream("Files/job.ser");
			} else {
				outFile = new FileOutputStream("Files/user.ser");
				inFile = new FileInputStream("Files/user.ser");
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * This saves (serializes) a inputed class object
	 * @param theClass, Object to be written to file
	 */
	protected void serialize(Object theClass) {
		try {
			out = new ObjectOutputStream(outFile);
			out.writeObject(theClass);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	/**
	 * Reads file and returns a Object class
	 * @return Object, from file
	 */
	protected Object deSerialize() {
		Object freshData = null;
		try {
			in = new ObjectInputStream(inFile);
			freshData = in.readObject();
		} catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return freshData;
	}
	
}
