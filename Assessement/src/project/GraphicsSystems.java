package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import uk.ac.leedsbeckett.oop.LBUGraphics;


public class GraphicsSystems extends LBUGraphics{
	
	// this is the list of the commands which are valid
	String[] menu = {"about","penup","pendown","turnleft","turnright","forward","backward","black","green","red","white","reset","clear","rgbcolor","circle","triangle","load","loadimage"};

	public GraphicsSystems() {
		JFrame MainFrame = new JFrame();  //create a frame to disphay the turtle panel on
		MainFrame.setLayout(new FlowLayout());	// not strictly necessary
		MainFrame.add(this);	// "this" is this object that extends turtle graphics so we are adding a turtle graphics panel to the frame
		MainFrame.pack();	// set the frame to a size we can see
		MainFrame.setVisible(true);		// now display it		
	}
	@Override
	public void about()  // it receive the string parameter 
	{
		super.about(); 
		// saving the old canvas color and customize
		Graphics2D canvas = getGraphics2DContext(); 
		Color old = canvas.getColor(); 
		canvas.setColor(getPenColour());  
		canvas.setFont(new Font("Ink Free",Font.BOLD,50)); // setting the font style and font size
		canvas.drawString("Karan Chaudhary", 550, 150);	// parameter is drawn in x-axis 550 y-axis 150
		canvas.setColor(old);
	}
	
	// it will split the command and store in the array
	public int extractNum(String command) {
		String[] strs = command.split("\\s");
		int n = Integer.parseInt(strs[1]);  // typecasting changing string to integer
		return n; 
	}
	
	//this method moves the turtle to backward
	public void backward() 	{
		forward(-100);
	}
	
	//it is parameterized method which moves the turtle to backward
	public void backward(int distance) 	{
		if(distance > 0) // checking the distance is negative or positive
		{
			forward(-distance); // passing the negative value to the forward moves the turtle backward
		}
		else {
			System.out.println("Negative num is invalid");
		}
	}
	
	// this method check the validity of the commands
	public String validity(String cmd) {
		boolean flag = true;
		for (int i = 0; i<menu.length;i++) //it loops the array of menue
		{
			if(cmd.contains(menu[i])) // it checks the command is in the array of menue if found flag change to false and break the loop
			{
				flag = false;
				break;
			}
		}
		if(flag) {
			return "Invalid";
		}
		else {
			return "Valid";
		}
	}
	// this method loads the image 
	public void loadimage() {
		Graphics canvas = getGraphics2DContext();
		Toolkit t = Toolkit.getDefaultToolkit();
		Image i = t.getImage("E:\\Level 4\\sem 2\\Java OPP\\Assessement\\image.png");  // it support jpg and png image
//		Image i = t.getImage("E:\\Karan\\karan.jpg");
		canvas.drawImage(i,0,0, this);
	}
	
	// this method is draw the circle 	
	public void circle(int r,boolean fill) // receiving the two parameter for radius and fill
	{
		// saving the old canvas color and customize
		Graphics canvas = getGraphics2DContext();
		Color old = canvas.getColor();
		canvas.setColor(getPenColour());
		//Draw a filled if fill is set as true else just outline 
		
		if(fill) // if fill is true it fill the circle
		{
			canvas.fillOval(200, 150, r ,r);
		}
		else {
			canvas.drawOval(300, 150, r ,r);
		}
		canvas.setColor(old);
	}

	public void triangle(int a, boolean fill) // receiving the two parameter for radius and fill
	{	
		//	Calculate the new coordinates
		int x = a;
		int y = x*2;
		int z = (x+y)/2;
		// saving the old canvas color and customize
		Graphics canvas = getGraphics2DContext();
		Color old = canvas.getColor();
		canvas.setColor(getPenColour());
		//creating the rectangle accordoing the coordination
		int[] xPoints = {x,z,y};
		int[] yPoints = {x,y,x};
		
		if(fill) // if fill is true it fill the triangle
		{
			canvas.fillPolygon(xPoints, yPoints, 3);
		}
		else
		{
			canvas.drawPolygon(xPoints, yPoints, 3);
		}
			//Restore the old color
		canvas.setColor(old);
	}
	
	public void triangle(int a, int b, int c,boolean fill) 
	{		
		// saving the old canvas color and customize
		Graphics canvas = getGraphics2DContext();
		Color old = canvas.getColor();
		canvas.setColor(getPenColour());
		//creating the rectangle accordoing the coordination
		int[] xPoints = {a, b,  c}; 
		int[] yPoints = {b,c,a}; 
		
		if(fill)  // if fill is true it fill the triangle
		{
			canvas.fillPolygon(xPoints, yPoints, 3);
		}
		else
		{
			canvas.drawPolygon(xPoints, yPoints, 3);
		}
			//Restore the old color
		canvas.setColor(old);
	}
	
	public void loadcmd() {
		// it execute the block of code indide the try if error occurs it execute code inside catch
		try {
			BufferedReader br = new BufferedReader(new FileReader("command.txt"));  // opening the file to read
			String cmd; // creating string variable
			while ((cmd = br.readLine()) != null)  // checking readline is not a null
			{
				loadCommand(cmd);			
			}
			br.close();  // closing the file
		}catch(IOException e) {
            System.err.println("Oops! Unable to read the file.");
            e.printStackTrace();
         }
	}
	
	public void cmdWrite(String cmd) // it receive the command
	{
		// it execute the block of code indide the try if error occurs it execute code inside catch
			try {
					BufferedWriter bw = new BufferedWriter(new FileWriter("command.txt", true));  // creating the file and opening the file to write
					bw.write(cmd+"\n");  // write command and go to next line
					bw.close();		// closing the file
	    	}catch(Exception ex)
	    		{
	    			System.out.println("file not found");
	    		}
	}
	// this method is used to detect the numeric data 
	public boolean numeric(String cmd) {
		boolean numeric = false;
		String[] cmds = cmd.split("\\s");
		String x;
		for(int i = 1; i < cmds.length; i++) {
			x = cmds[i];
			if( x.matches("-?\\d+(\\.\\d+)?")) {			
				numeric = true;
				break;
			}
		}
		return numeric;
	}
	
	public void loadCommand(String cmd) throws IOException {
		
		System.out.println("Command you entered is "+validity(cmd)+": "+ cmd); // it will print the validity of command
		
		boolean fill = false;
		if(cmd.contains("fill")) // checking if command contains fill. it change fill into the true
		{
			fill = true;
		}
		
		
		if(cmd.equals(menu[0]))
		{
			about();  // it calls about method where turtle dance and pass the string paramerter 
		}
		
		else if(cmd.equals(menu[1])) {
			penUp();	// it calls penUp method where line will not drawn
		}
		
		else if(cmd.equals(menu[2])) {
			penDown();	// it calls pendown method where line will draw
		}
		
		else if(cmd.contains(menu[3])) {
			if(cmd.equals(menu[3])== true) {
				turnLeft();
			}
			else {
				if(numeric(cmd)== true) {
					if(extractNum(cmd)>0) 	// checking the number greater than zero call the turnleft else pring negative number
					{
						turnLeft(extractNum(cmd));
					}
					else {
						System.out.println("Negative number is invalid.");
					}
				}
				else {
					System.out.println("Please pass the numeric parameter.");
				}
				
			}
		}
		
		else if(cmd.contains(menu[4])) {
			if(cmd.equals(menu[4])== true) {
				turnRight();
			}
			else {
				if(numeric(cmd)== true) {
					if(extractNum(cmd)>0)  // checking the number greater than zero call the turnright else pring negative number
					{
						turnRight(extractNum(cmd));
					}
					else {
						System.out.println("Negative number is invalid.");
					}
				}
				else {
					System.out.println("Please pass the numeric parameter.");
				}
			}
		}
		
		else if(cmd.contains(menu[5])) {
			if(cmd.equals(menu[5])== true) {
				forward(100);
			}
			else {
				if(numeric(cmd)== true) {
					if(extractNum(cmd)>0)  // checking the number greater than zero call the turnright else pring negative number
					{
						forward(extractNum(cmd));
					}
					else {
						System.out.println("Negative number is invalid.");
					}
				}
				else {
					System.out.println("Please pass the numeric parameter.");
				}
			}
		}
		
		else if(cmd.contains(menu[6])) {
			if(cmd.equals(menu[6])== true) {
				backward(100);
			}
			else {
				if(numeric(cmd)== true) {
					if(extractNum(cmd)>0)  // checking the number greater than zero call the turnright else pring negative number
					{
						backward(extractNum(cmd));
					}
					else {
						System.out.println("Negative number is invalid.");
					}
				}
				else {
					System.out.println("Please pass the numeric parameter.");
				}
			}
		}
		
		else if(cmd.equals(menu[7])) {
			setPenColour(Color.black);
		}
		else if(cmd.equals(menu[8])) {
			setPenColour(Color.green);
		}
		else if(cmd.equals(menu[9])) {
			setPenColour(Color.red);
		}
		else if(cmd.equals(menu[10])) {
			setPenColour(Color.white);	
		}
		else if(cmd.equals(menu[11])) {
			reset();
		}
		else if(cmd.equals(menu[12]))   
		{
			clear();
		}
		
		else if(cmd.equals("loadimage")) // checking if command equals loadimage
		{
			loadimage();  // calling the loadimage method
		}
		
		else if(cmd.contains("rgbcolor")) // checking if command contains rgbcolor
		{
			if(cmd.equals("rgbcolor")==true) // checking if command equlas rgb color without parameter
			{
				System.out.println("Parameter is not passed");
			}
			else {
				String[] cmds = cmd.split("\\s");
				if(cmds.length > 5) {
					System.out.println("Please pass the 3 pararmeter");
				}
				else if(cmds.length < 4) {
					System.out.println("Please pass the 3 parameter");
				}
				else {
					// checking the numberic and not numebric data
					boolean numeric = true;
					numeric =  cmds[1].matches("-?\\d+(\\.\\d+)?");
					numeric =  cmds[2].matches("-?\\d+(\\.\\d+)?");
					numeric =  cmds[3].matches("-?\\d+(\\.\\d+)?");
					
					if(numeric == true) {
						String[] arr = cmd.split("\\s");  // it split the command ans store in the array formate in pen
						// typecasting changing the string to integer by indexing the element
						int a = Integer.parseInt(arr[1]);
						int b = Integer.parseInt(arr[2]);
						int c = Integer.parseInt(arr[3]);
						if(a >= 0 && b >= 0 && c >= 0) {
							if(a <= 255 && b <= 255 && c <= 255) {
								Color col = new Color(a,b,c);  // creating the object for the color
								PenColour = col;
							}
							else {
								System.out.println("Out of range. Range is (0 - 255)");
							}
						}
						else {
							System.out.println("Negative number is invalid");
						}
					}
					else {
						System.out.println("Please pass the numeric parameter.");
					}
				}
			}
		}	
		
		else if(cmd.contains("circle"))  // checking if command contains circle
		{
			if(cmd.equals("circle")==true)  // checking if command equals circle withou parameter
			{
				System.out.println("Parameter is not passed");
			}
			else {
				if(numeric(cmd)== true) {
					if(extractNum(cmd) > 0) {
						circle(extractNum(cmd),fill);  // passing the parameter
					}
					else {
						System.out.println("Negative number is invalid");
					}
				}
				else {
					System.out.println("Please pass the numeric parameter.");
				}
				
			}
					
		}
		else if(cmd.contains("triangle")) // checking if command contains triangle 
		{
			if(cmd.equals("triangle")==true) // checking if command equals to triangle without parameter
			{
				System.out.println("Parameter is not passed");
			}
			else {	
				// it split the command and stored in the array formate
				String[] arr = cmd.split("\\s");
				// typecasting changing string to integer
				if(arr.length > 2) 
				{	
					String[] cmds = cmd.split("\\s");
					if(cmds.length > 5) {
						System.out.println("Please pass the 3 pararmeter");
					}
					else if(cmds.length < 4) {
						System.out.println("Please pass the 3 parameter");
					}	
					else {
					// checking the numberic and not numebric data
						boolean numeric = true;
						numeric =  cmds[1].matches("-?\\d+(\\.\\d+)?");
						numeric =  cmds[2].matches("-?\\d+(\\.\\d+)?");
						numeric =  cmds[3].matches("-?\\d+(\\.\\d+)?");
						
						if(numeric == true) {
							int a = Integer.parseInt(arr[1]);
							int b = Integer.parseInt(arr[2]);
							int c = Integer.parseInt(arr[3]);
							if( a > 0 && b > 0 && c > 0) {
								triangle(a,b, c,fill); // passing the 3 int parameter and one boolean parameter to the triangle 
							}
							else {
								System.out.println("Negative number is invalid");
							}
						}
						else {
							System.out.println("Please pass the numeric parameter.");
						}
					}
				}		
				else {
					// checking the numeric data 
					if(numeric(cmd)== true) {
						int a = Integer.parseInt(arr[1]);
						if(a > 0) {
							triangle(a,fill);	// passing two parameter 
						}
						else {
							System.out.println("Negative number is invalid");
						}
					}
					else {
						System.out.println("Please pass the numeric parameter.");
					}
				}
			}
		}
		// we are saving the canvas image
		// try defines the block of code and execute if code error then it shows the massage in the catch
		try {
			BufferedImage image = getBufferedImage();
			File imagefile = new File("image.png");
			ImageIO.write(image, "png", imagefile);
		}
		catch (IOException e) 
		{
			JOptionPane.showMessageDialog(null,"Image is Not saved","Warning!!",2);
		}
	}
	
	@Override
	public void processCommand(String command)  {
		// this changs the command to the lowercase
		
		String cmd = command.toLowerCase();  //it changes the command to the lower case
		
		// passing the paramenter to the loadCommand
		try {
			loadCommand(cmd);
		} 
		catch (IOException e) {
			System.out.println("");		
		}
		
		// checking command if command is load it loads the command stored in command.txt else it write the command 
		if(cmd.equals("load")) {
			System.out.println("We load the commads againa!!\n");
			loadcmd();  // calling the load command
		}
		else {
			cmdWrite(cmd);	// passing the one paramenter
		}
		System.out.println("");
	}	
	
	public static void main(String[] args) {
		new GraphicsSystems();	// calling the GraphicsSystems
	}
}
