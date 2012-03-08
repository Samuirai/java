package de.ilp.chat.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class ChatClient implements ActionListener{

	private String name="default";
	private JFrame nameWindow;
	private JTextArea verlauf = new JTextArea("Verlauf:\n");
    private JTextField nachricht = new JTextField("");
    private JTextField changeName = new JTextField(20);
    private JScrollPane scrollPane;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChatClient chat = new ChatClient();
		chat.openWindow();
	   

	}
	
	private void openWindow(){
	       JFrame frame = new JFrame("Button");
	       JPanel mainPanel= new JPanel();
	       
	       mainPanel.setLayout(new MigLayout("wrap 1","","[grow 100][]"));

	       frame.setContentPane(mainPanel);
	       
	       JButton button1 = new JButton("Click me!");
	       button1.addActionListener(this);
	       button1.setActionCommand("button1");
	       JButton button2 = new JButton("Change Name");
	       
	       button2.addActionListener(this);
	       button2.setActionCommand("button2");	
	       
	       verlauf.setEditable(false);
	       
//	       button2.setEnabled(false);
	       scrollPane = new JScrollPane(verlauf);
	       mainPanel.add(scrollPane, "h 200,growy, w 100%");
//	       mainPanel.add(verlauf, "h 200,growy, w 100%");
	       mainPanel.add(new JLabel("Der Button:"),"split 4");	       
	       mainPanel.add(nachricht, "w 200, grow");
	       mainPanel.add(button1);
	       mainPanel.add(button2);
	       
	       
	       
	       
	       frame.pack();
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if("button1".equals(e.getActionCommand())){
			verlauf.setText(verlauf.getText()+nachricht.getText()+"\n");
			scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum());
		}
		if("button2".equals(e.getActionCommand())){
			   nameWindow = new JFrame("Change Name");
		       JPanel mainPanel= new JPanel(new MigLayout());

		       nameWindow.setContentPane(mainPanel);
		       

		       JButton enter = new JButton("Change Name");
		       enter.setActionCommand("nameChange");
		       enter.addActionListener(this);
		       
		       changeName.setText(name);


		       mainPanel.add(new JLabel("Bitte neuen Namen eingeben:"));
		       mainPanel.add(changeName,"wrap");
		       mainPanel.add(enter);
		       
		       
		       nameWindow.pack();
		       nameWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		       nameWindow.setVisible(true);
		}
		if("nameChange".equals(e.getActionCommand())){
			name=changeName.getText();
			verlauf.setText(verlauf.getText()+"Dein neuer Name ist: "+name+"\n");			
			nameWindow.dispose();
		}
		
		
	}

}