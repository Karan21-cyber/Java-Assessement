package project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public abstract class Imagination extends JPanel implements ActionListener{
	
	// private ojects  
	private JButton button;
	private JTextField textfield;
	private JLabel label;
	
	// it is an abstract method 
	public abstract void processCommand(String paramString);
	 
	
	//constructor
	public Imagination() {
		
		setPreferredSize(new Dimension(800,600));   // setting size of panel

		label = new JLabel("Commands");	
		textfield = new JTextField(30);
		button = new JButton("Ok");
		
		//adding label,textfield,button in the panel
		add(label);
		add(textfield);
		add(button);

		textfield.addActionListener(this);
		button.addActionListener(this);
		
		setVisible(true);
		}
	
	// get the graphics inside the canvas
	 public Graphics getGraphicsContext()
	  {
	    return getGraphics();
	  }
	// get the graphics2D inside the canvas
	 public Graphics2D getGraphics2DContext()
	  {
	    Graphics2D g2 = (Graphics2D)getGraphicsContext();
	    return g2;
	  }
	 
	 // this method draw the string in the canvas
	 public void name(String name) {
		 
		 Graphics2D dr = getGraphics2DContext();
		 dr.setFont(new Font("Ink Free",Font.BOLD,50));
		 Color colour = new Color(255,20,147);
		 dr.setColor(colour);
		 dr.getColor();
		 dr.drawString(name, 150, 150);
	 }
	 
	 // this method draw the image in the canvas
	 public void garden() {
		 // getting the canvas and creating the garden
		Graphics2D dr = getGraphics2DContext();
		// toolkit is used for drawing image in the canvas
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage("E:\\Level 4\\sem 2\\Java OPP\\Assessement\\garden.jpg");  // it support jpg and png image
		dr.drawImage(i,0,0,800,600,this);
	 }
	 //  this method draw the rainbow
	 public void rainbow() {
		 Graphics2D dr = getGraphics2DContext();
		 dr.setStroke(new BasicStroke(10));	// setting the stroke of the Arc
		 Color colour = new Color(255,20,147);
		 dr.setColor(colour);	// setting the rgb color 
		 dr.getColor();
		 dr.drawArc(310,170,200,200,0,180);
		 
		 Color colour1 = new Color(255,0,255);
		 dr.setColor(colour1);
		 dr.getColor();
		 dr.drawArc(300,160,210,210,0,180);
		 
		 Color colour2 = new Color(148,0,211);
		 dr.setColor(colour2);
		 dr.getColor();
		 dr.drawArc(290,150,220,220,0,180);
		 
		 Color colour3 = new Color(255,240,245);
		 dr.setColor(colour3);
		 dr.getColor();
		 dr.drawArc(280,140,230,230,0,180);
		 
		 Color colour4 = new Color(220,20,60);
		 dr.setColor(colour4);
		 dr.getColor();
		 dr.drawArc(270,130,240,240,0,180);
	 }
	 
	 // this method draw the cloud
	 public void cloud() {
		Graphics2D dr = getGraphics2DContext();
		dr.setPaint(Color.white);{	
		dr.fillOval(400, 50, 100, 50);
		dr.fillOval(400, 80, 150, 50);
		dr.fillOval(450, 50, 180, 50);
		dr.fillOval(450, 90, 200, 50);
		}
	 }
	 
	 // this method draw pond
	 public void pond() {
		Graphics2D dr = getGraphics2DContext();
		dr.setPaint(Color.blue);
		dr.fillOval(400, 500, 150, 50);
		dr.fillOval(300, 500, 150, 50);
		dr.setPaint(Color.red);
		dr.setFont(new Font("Ink Free",Font.BOLD,20));
		dr.drawString("pond", 400, 520);
			
		//importing the turtle
		Toolkit t = Toolkit.getDefaultToolkit();
		Image img = t.getImage("E:\\Level 4\\sem 2\\Java OPP\\Assessement\\turtle90.png");  // it support jpg and png image

		dr.drawImage(img, 470, 500,40,40, this);
			
	 }
	 // this method draw the mountain and many things 
	 public void mountain() {
		Graphics2D dr = getGraphics2DContext();
		Color colour = new Color(128,128,0);
		dr.setColor(colour);
		dr.getColor();
		dr.fillRect(0,0, 800, 600);
		
		dr.setPaint(Color.blue);
		dr.fillRect(0,0, 800, 300);
		dr.setPaint(Color.orange);
		dr.setFont(new Font("Ink Free",Font.BOLD,20));
		dr.drawString("sky", 450, 50);
		dr.fillOval(50, 50, 50, 50);
			
		Toolkit t = Toolkit.getDefaultToolkit();
		Image b = t.getImage("E:\\Level 4\\sem 2\\Java OPP\\Assessement\\bird.jpg");  // it support jpg and png image
		dr.drawImage(b,80,150,50,50,this);
		
		Image b2 = t.getImage("E:\\Level 4\\sem 2\\Java OPP\\Assessement\\bird2.png");  // it support jpg and png image
		dr.drawImage(b2,400,180,50,50,this);
		
		Image b3 = t.getImage("E:\\Level 4\\sem 2\\Java OPP\\Assessement\\bird2.png");  // it support jpg and png image
		dr.drawImage(b3,700,100,50,50,this);
		cloud();
		rainbow();
		//drawing the triangle and make look as the mountain
		int[] x = {0,250,450};
		int[] y = {300,150,300};
		dr.setPaint(Color.green);
		
		dr.fillPolygon(x,y,3);
		
		int[] xPoints = {450,600,800};
		int[] yPoints = {300,150,300};
		dr.setPaint(Color.green);
		dr.fillPolygon(xPoints,yPoints,3);
		house();
		pond();
		tree();
	 }

	 // this method draw car in the canvas
	public void car() {
		Graphics2D dr = getGraphics2DContext();
		//drawing the car 
		dr.setPaint(Color.red);
		dr.fillRect(550, 395,200, 40);
		dr.setPaint(Color.BLACK);
		dr.fillRect(580, 370,150, 25);				
		//drawing the wheels
		dr.setPaint(Color.white);
		dr.fillOval(575, 418, 40,40);
		dr.fillOval(695, 418, 40, 40);				
		//body of car
		dr.setPaint(Color.BLACK);
		dr.fillOval(580, 420, 30, 30);
		dr.fillOval(700, 420, 30, 30);
		// roof of car
		dr.setPaint(Color.red);
		dr.setStroke(new BasicStroke(2));
		dr.drawOval(590, 430, 10, 10);
		dr.drawOval(710, 430, 10, 10);		
	 }
	 
	// this method draw emoji 
	 public void emoji() {
		 Graphics2D dr = getGraphics2DContext();
		 dr.setPaint(Color.yellow);
		dr.fillOval(450,300 , 100, 100);
			
		dr.setPaint(Color.white);
		dr.fillOval(480, 330, 15, 18);
		dr.fillOval(520, 330, 15, 18);
			
		dr.setPaint(Color.black);
		dr.fillOval(480, 330, 10, 10);
		dr.fillOval(520, 330, 10, 10);
			
		dr.fillOval(505, 355, 18, 35);
	 }
	 //this method draw tree
	 public void tree() {
		 Graphics2D dr = getGraphics2DContext();
		 Color colour = new Color(139,69,19);
		 dr.setColor(colour);
		 dr.getColor();
		 dr.fillRect(600, 400, 20, 180);	
		 
		 Color colour1 = new Color(34,139,34);
		 dr.setColor(colour1);
		 dr.getColor();
		 dr.fillOval(550, 350, 100, 100);
		 dr.fillOval(500, 300, 100, 100);
		 dr.fillOval(600, 350, 100, 100);
		 dr.fillOval(580, 300, 100, 100);
	 }
	 // this method draw house 
	 public void house() {
		 Graphics2D dr = getGraphics2DContext();
		//drawing the roof of the house
		int[] xpts = {50, 150,250};
		int[] ypts = {400,320,400};
		dr.setPaint(Color.red);
		dr.fillPolygon(xpts,ypts,3);
		
		 dr.setPaint(Color.black);
		 dr.fillOval(140, 340, 20, 20);
		 dr.setPaint(Color.PINK);
		 dr.fillRect(50, 400, 200, 160);
			
		 dr.setPaint(Color.black);
		 dr.fillRect(70, 420, 50, 50);
		 dr.fillRect(180, 420, 50, 50);
		 dr.fillRect(125, 480, 50, 80);
		 dr.fillRect(40,560, 220, 10);		 
	 }
	 // this method clear the canvas
	 public void clear() {
		 repaint();
	 }
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// it execute try block if error occurs then it execute catch block
		try {
			processCommand(textfield.getText()); // get the text field passing the parameter to the processcommand
			textfield.setText("");
		}
		catch(Exception ex) {
			System.out.println("Action Listener doesnot work");
		}
	}
}
