package de.ilp.chat.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {


    private List<ClientConnection> connections = new ArrayList<ClientConnection>();
    
    private int chatterCounter = 0;
	
	public ChatServer() {
	}
	
	public static void main(String[] args) {
		new ChatServer().start();
	}

	
	public void start() {
		try {
			ServerSocket serverSocket = new ServerSocket(4444);
			
			System.out.println("Server started");
			
			while (true) {
				//wait for next client to connect
				Socket client = serverSocket.accept();
				
				System.out.println("Client connected");
				//create new client connection runnable that handles the communication to a client in
				//a separate thread
				ClientConnection conn = new ClientConnection(client, this);
				//remember that client connection
				this.connections.add(conn);
				//start the client connection in an own thread
				new Thread(conn).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int registerNewChatter(String name) {
		chatterCounter++;
		
		//TODO inform all clients
		System.out.println(name + " joined");
		sendMessageToClients(name + " entered the chat room");
		
		return chatterCounter;
	}
	
	public void sendMessageToClients(String message) {
		for (ClientConnection conn : this.connections) {
			if(!conn.isUserLeft())
				conn.sendMessage(message);
		}
	}
}
