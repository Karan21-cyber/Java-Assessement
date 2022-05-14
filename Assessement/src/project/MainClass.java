package project;

import java.awt.FlowLayout;

import javax.swing.JFrame;

import uk.ac.leedsbeckett.oop.LBUGraphics;

public class MainClass extends LBUGraphics{
	
	public MainClass() {
		JFrame MainFrame = new JFrame();  //create a frame to disphay the turtle panel on
		MainFrame.setLayout(new FlowLayout());	// not strictly necessary
		MainFrame.add(this);	// "this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
		MainFrame.pack();	// set the frame to a size we can see
		MainFrame.setVisible(true);		// now display it
		about();	// call the LBUGraphics about method to display version information
	}
	
	@Override
	public void processCommand(String command) {
		// String paramenter is the text typed into the LBUGraphics JTextField
		// Lands here if return was pressed or "OK" JButton clicked
			
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainClass();
	}
	

}
