package com.cognizant.controllers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.cognizant.entities.User;

public class SerializableObject {

	public void serializeObject() {
		try {
			FileOutputStream fileOut = new FileOutputStream("user.ser");
			ObjectOutputStream obj = new ObjectOutputStream(fileOut);

			User user = new User();
			user.setName("Rick");
			user.setPassword("2911");
			obj.writeObject(user);
			obj.flush();
			obj.close();
			fileOut.flush();

		} catch (Exception error) {
			error.printStackTrace();
		}
	}

	public void deSerializeObject() throws FileNotFoundException {
		try {
			FileInputStream fileIn = new FileInputStream("user.ser");
			ObjectInputStream obj = new ObjectInputStream(fileIn);

			User user = (User) obj.readObject();
			System.out.println(user.getName());

		} catch (Exception error) {

		}
	}

}
