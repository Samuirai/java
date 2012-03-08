package de.ilp.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		try {
			Socket server = new Socket("localhost", 4444);
			
			ObjectOutputStream serverOutputStream = new ObjectOutputStream(server.getOutputStream());
			serverOutputStream.writeObject(new String("Fabian"));
			serverOutputStream.flush();
			
			ObjectInputStream serverInputStream = new ObjectInputStream(server.getInputStream());
			String message = (String) serverInputStream.readObject();
			System.out.println(message);
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
