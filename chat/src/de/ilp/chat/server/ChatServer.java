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
				Socket client = serverSocket.accept();	
				System.out.println("Client connected");
				ClientConnection conn = new ClientConnection(client, this);
				this.connections.add(conn);
				new Thread(conn).start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public int registerNewChatter(String name) {
		chatterCounter++;
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
