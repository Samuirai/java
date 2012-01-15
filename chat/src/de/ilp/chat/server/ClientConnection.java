package de.ilp.chat.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import de.ilp.chat.ChatConstants;
import de.ilp.chat.ChatMessage;

public class ClientConnection implements Runnable {

	private int id;
	private String name;
	
	private ChatServer server;
	
	private ObjectInputStream clientInputStream;
	private ObjectOutputStream clientOutputStream;
	
	private boolean userLeft = false;
	
	public ClientConnection(Socket client, ChatServer server) {
		this.server = server;
		
		try {
			this.clientInputStream = new ObjectInputStream(client.getInputStream());
			this.clientOutputStream = new ObjectOutputStream(client.getOutputStream());
		} catch (IOException e) {
			System.err.println("Error on opening streams to client socket");
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (!userLeft) {
			
			try {
				ChatMessage message = (ChatMessage) this.clientInputStream.readObject();
				
				if (ChatConstants.COMMAND_ENTER.equals(message.getCommand())) {
					enter(message);
				}
				else if (ChatConstants.COMMAND_MESSAGE.equals(message.getCommand())) {
					message(message.getMessage());
				}
				else if (ChatConstants.COMMAND_LEAVE.equals(message.getCommand())) {
					leave();
					userLeft = true;
				}
			} catch (IOException e) {
				System.err.println("Error on reading object from stream");
				leave();
				userLeft = true;
			} catch (ClassNotFoundException e) {
				System.err.println("Could not resolve ChatMessage class");
				e.printStackTrace();
			}
		}

	}

	public boolean isUserLeft() {
		return userLeft;
	}

	private void enter(ChatMessage message) {
		name = message.getMessage();
		this.id = this.server.registerNewChatter(name);
	}

	private void message(String message) {
		this.server.sendMessageToClients(id + " " + name + ": " + message);
	}

	private void leave() {
		System.out.println(name+" left");
		this.server.sendMessageToClients(id+" "+name+", we will miss you :'(");
	}

	public void sendMessage(String message) {
		try {
			this.clientOutputStream.writeObject(message);
			this.clientOutputStream.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
