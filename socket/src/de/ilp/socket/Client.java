package de.ilp.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {
		System.out.println("Client started");
		try {
		
			Socket server = new Socket("localhost", 4444);
			
			System.out.println("write message");

			ObjectOutputStream clientOutputStream = new ObjectOutputStream(server.getOutputStream());
			clientOutputStream.writeObject(new String("Fabian"));
			clientOutputStream.flush();
			
			System.out.println("warte auf Server Antwort");
			
			ObjectInputStream clientInputStream = new ObjectInputStream(server.getInputStream());
			String message = (String) clientInputStream.readObject();		
			
			System.out.println("Message from Client: "+message);

			server.close();
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
