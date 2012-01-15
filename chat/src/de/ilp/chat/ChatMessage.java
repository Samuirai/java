package de.ilp.chat;

import java.io.Serializable;

public class ChatMessage implements Serializable {

	private static final long serialVersionUID = 7875846953918018798L;
	
	private String command;
	private String message;
	
	public ChatMessage(String command, String message) {
		this.command = command;
		this.message = message;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	public String getCommand() {
		return command;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getMessage() {
		return message;
	}
	
}
