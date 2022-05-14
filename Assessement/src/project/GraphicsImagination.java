package project;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class GraphicsImagination  extends Imagination{
	
	// constructor
	GraphicsImagination()
	{	
		JFrame frame = new JFrame(); // creating the frame 
		frame.setLayout(new FlowLayout());  // setting the layout of frame
		frame.add(this);	
		frame.pack();
		frame.setVisible(true);	
		
	}
	public static void main(String[] args) {
		new GraphicsImagination();
	}
	
	public void processCommand(String command) {
		
		// changing the command to the lower case
		String cmd = command.toLowerCase();
		
		// comparing the commands and calling the method according to the string 
		if(cmd.equalsIgnoreCase("name")) {
			name("Karan Chaudhary");
		}
		else if(cmd.equalsIgnoreCase("car")) {
			car();
		}
		else if(cmd.equalsIgnoreCase("house")) {
			house();
		}
		else if(cmd.equalsIgnoreCase("emoji")) {
			emoji();
		}
		else if(cmd.equalsIgnoreCase("garden")) {
			garden();
		}
		else if(cmd.equalsIgnoreCase("mountain")) {
			mountain();
		}
		else if(cmd.equalsIgnoreCase("cloud")) {
			cloud();
		}
		else if(cmd.equalsIgnoreCase("pond")) {
			pond();
		}
		else if(cmd.equalsIgnoreCase("tree")) {
			tree();
		}
		else if(cmd.equalsIgnoreCase("rainbow")) {
			rainbow();
		}
		else if(cmd.equalsIgnoreCase("clear")) {
			clear();
		}
		System.out.println("You typed: " +cmd);
	}
}
