package de.ilp.chat.client;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import de.ilp.chat.ChatConstants;
import de.ilp.chat.ChatMessage;

public class ChatClient implements ActionListener {

	class WindowEventHandler extends WindowAdapter {
		public void windowClosing(WindowEvent evt) {
			System.out.println("send leave message");
			leave();
			System.exit(0);
		}
	}
	
	private JScrollPane scrollPane;
	private Socket server;
	private ObjectOutputStream serverOutput;
	private String name;
	private JTextArea messagesText = new JTextArea();
	private JTextField inputText = new JTextField();

	public static void main(String[] args) {
		ChatClient client = new ChatClient(); 
		client.openWindow();
		client.connect();
	}

	private void openWindow() {
		JFrame frame = new JFrame("Chat");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		frame.addWindowListener(new WindowEventHandler());
		frame.setSize( 400, 250 );
		
		JPanel panel = new JPanel();
		panel.setLayout(new GridBagLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.insets = new Insets(5, 5, 5, 5);
		scrollPane = new JScrollPane(messagesText);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		
		panel.add(scrollPane, c);
		
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		c.weighty = 0.1;
		c.gridx = 0;
		c.gridy = 1;
		c.insets = new Insets(5, 5, 5, 5);
		panel.add(inputText, c);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridwidth = 2;
		c.gridy = 3;
		panel.add(buttonPanel, c);

		JButton saveButton = new JButton("Send");
		saveButton.setActionCommand("sendMessage");
		saveButton.addActionListener(this);
		c = new GridBagConstraints();
		c.fill = GridBagConstraints.NONE;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(5, 5, 5, 5);
		
		buttonPanel.add(saveButton, c);
		
		frame.add(panel);
		frame.setVisible( true );	
	}
	
	public void connect() {
		try {
			server = new Socket("localhost", 4444);
			System.out.println("connected to server");
			serverOutput = new ObjectOutputStream(server.getOutputStream());
			name = "Hugo";
			
			enter(name);
			
			ObjectInputStream serverInput = new ObjectInputStream(server.getInputStream());
			
			Object input = null;
			while ((input = serverInput.readObject()) != null) {
				messagesText.setText(messagesText.getText()+input+"\n");
				scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()+1);
				System.out.println("got message from server");
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void enter(String name) {
		sendMessage(new ChatMessage(ChatConstants.COMMAND_ENTER, name));
	}
	
	private void leave() {
		sendMessage(new ChatMessage(ChatConstants.COMMAND_LEAVE, name));
	}
	
	public void sendMessage(ChatMessage message) {
		System.out.println("send chat message");
		try {
			serverOutput.writeObject(message);
			serverOutput.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if ("sendMessage".equals(e.getActionCommand())) {
			sendMessage(new ChatMessage(ChatConstants.COMMAND_MESSAGE, inputText.getText()));
			inputText.setText("");
		}
		
	}
}
