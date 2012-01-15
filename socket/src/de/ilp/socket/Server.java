package de.ilp.socket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {


	public static void main(String[] args) {
		System.out.println("Server started");
		while(true) {
			try {
				
				ServerSocket serverSocket = new ServerSocket(4444);
				Socket client = serverSocket.accept();
				
				System.out.println("Client gefunden");
				
				ObjectInputStream clientInputStream = new ObjectInputStream(client.getInputStream());
				String message = (String) clientInputStream.readObject();
				
				System.out.println("Message from Client: "+message);
				
				ObjectOutputStream clientOutputStream = new ObjectOutputStream(client.getOutputStream());
				clientOutputStream.writeObject(new String("Hallo "+message));
				clientOutputStream.flush();
				
				client.close();
				serverSocket.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}
