package spiderVerse;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;  



//Creating the parent class
class User {
	//The class will be holding variables for the head, body, and leg choice
	protected static String head, body, leg;
	
	//Creating an array with all suit options
	ArrayList<String> options = new ArrayList<>(Arrays.asList(
			"Peter's Suit", 
			"Spider-Verse Suit (Miles)",
			"2099 Suit (Miles)",
			"TRACK Suit",
			"Programmable Matter Suit"));
	
	
	//Creating a print options method
	public void printOptions() {
		
		//This method essentially just cycles through the array list to print all options to the user
		System.out.println("Here are the suit options you can use to mix and match:\n");
		
		for (int x = 0; x < options.size() ; x++) {
			System.out.println("Input " + (x + 1) + " for: " + options.get(x));
		}
		
		System.out.println("\nInput the number which corresponds with your choice:");
		
	}
	
	//This method will be used to draw the personalized spider-man
	public void draw(String name) throws IOException {
		
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		BufferedImage yourcreation;
		
		
		try {
			
			//Loading the images
			//I used string.format to find the correct image file
			BufferedImage head = ImageIO.read(getClass().getClassLoader().getResource(String.format("%sHead.png", Head.head))); 
			BufferedImage body = ImageIO.read(getClass().getClassLoader().getResource(String.format("%sBody.png", Body.body)));
			BufferedImage legs = ImageIO.read(getClass().getClassLoader().getResource(String.format("%sLeg.png", Leg.leg)));
			
			//Scaling the images
			Image scaledLeg = legs.getScaledInstance(260, 360, Image.SCALE_DEFAULT);
			Image scaledHead = head.getScaledInstance(220, 150, Image.SCALE_DEFAULT);
			Image scaledBody = body.getScaledInstance(300, 350, Image.SCALE_DEFAULT);
			
			//Creating a canvas
			yourcreation = new BufferedImage(400, 800, BufferedImage.TYPE_INT_ARGB);
			Graphics2D g = yourcreation.createGraphics();
			
			//Placing the loaded images onto the canvas
			g.drawImage(scaledLeg, 40 , 400, null);
			g.drawImage(scaledBody, 30, 140, null);
			g.drawImage(scaledHead, 55 , 0, null);
			
			g.dispose();
			
			//Creating a window to present the image to the user
			JLabel label = new JLabel();
			window.add(label);
			label.setIcon(new ImageIcon(yourcreation));
			
			//Saving the file as a png
			File file = new File(String.format("%s.png", name));
			ImageIO.write(yourcreation, "png", file);
			
			
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		//Opening the image in a new window
		window.pack();
		window.setVisible(true);
		
	}

}


//Creating a head class
class Head extends User{
	
	public Head(){}
	
	//Draw method that calls the parent draw method
	public void draw(String name) throws IOException {
		super.draw(name);
	}
	
	
	//Method that sets the head to whatever the user chooses
	public void setHead(int option) {
		
		if (option == 1) {
			head = "peter";
		}
		
		if (option == 2) {
			head = "spiderverse";
		}
		
		if (option == 3) {
			head = "2099";
		}
		
		if (option == 4) {
			head = "track";
		}
		
		if (option == 5) {
			head = "matter";
		}
	}
	
	//This method gets the head that was chose by the user
	public String getHead() {
		return head;
	}
	

}


//Creating a body class
class Body extends User{
	
	public Body() {}
	
	//Draw method that calls the parent draw method
	public void draw(String name) throws IOException {
		super.draw(name);
	}
	
	//Method that sets the body to whatever the user chooses
	public void setBody(int option) {
		
		if (option == 1) {
			body = "peter";
		}
		
		if (option == 2) {
			body = "spiderverse";
		}
		
		if (option == 3) {
			body = "2099";
		}
		
		if (option == 4) {
			body = "track";
		}
		
		if (option == 5) {
			body = "matter";
		}
	}
	
	//This method gets the body that was chose by the user
	public String getBody() {
		return body;
	}

}


//Creating a leg class
class Leg extends User{
	
	public Leg() {}
	
	//Draw method that calls the parent draw method
	public void draw(String name) throws IOException {
		super.draw(name);
	}
	
	//Method that sets the leg to whatever the user chooses
	public void setLeg(int option) {
		
		if (option == 1) {
			leg = "peter";
		}
		
		if (option == 2) {
			leg = "spiderverse";
		}
		
		if (option == 3) {
			leg = "2099";
		}
		
		if (option == 4) {
			leg = "track";
		}
		
		if (option == 5) {
			leg = "matter";
		}
	}
	
	//This method gets the leg that was chose by the user
	public String getLeg() {
		return leg;
	}

}


//Main class
class spiderVerse {

	public static void main(String[] args) throws IOException {
		
		//Instantiating my classes
		Scanner scan = new Scanner (System.in);
		User user = new User();
		Head head = new Head();
		Body body = new Body();
		Leg leg = new Leg();
		
		System.out.println("Come and create your very own personalized Spider-Man!");
		
		
		//Using a while true loop so that the user can load as many spider-men as they like
		while (true) {
			
			System.out.println("\n\n\nDo you want to load one of your Spider-Men or create a new one? (Input 0 to load, 1 to create, or anything else to exit)");
			
			String input = scan.nextLine();
			
			//Checking if the user wants to create a spider-man
			if (input.equals("1")) {
				
				//Using a while true loop in case the user inputs something invalid.
				while (true) {
					
					System.out.println("\nLets get started with the head of your Spider-Man!");
					
					//Using try/catch in case the user inputs something that is not an integer
					try {

						user.printOptions();
						
						//Getting the user's input
						int choice = scan.nextInt();
						
						//Setting the head
						if (choice <= 5 && choice >= 1) {
							head.setHead(choice);
						}
						
						//If the number is invalid, the program goes to the beginning of the loop
						else {
							System.out.println("Invalid input. Please try again.");
							continue;
						}

						
						System.out.println("\nOk, now its time for the body!");
						
						user.printOptions();
						
						//Getting the user's input
						choice = scan.nextInt();
						
						//Setting the body
						if (choice <= 5 && choice >= 1) {
							body.setBody(choice);
						}
						//If the number is invalid, the program goes to the beginning of the loop
						else {
							System.out.println("Invalid input. Please try again.");
							continue;
						}
						
						
						System.out.println("\nFinally, choose your legs!");
						
						user.printOptions();
						
						//Getting the user's input
						choice = scan.nextInt();
						
						//Setting the leg
						if (choice <= 5 && choice >= 1) {
							leg.setLeg(choice);
						}
						//If the number is invalid, the program goes to the beginning of the loop
						else {
							System.out.println("\n\nInvalid input. Please try again.");
							continue;
						}
						
						//Making the user to name their spider-man
						System.out.println("\n\nWhat do you want to name your Spider-Man?");
						String name = scan.next();
						
						//Using try/catch to get the IOException when drawing
						try {
							
							//Adding the Spider-Man name to saved.txt
						    Files.write(Paths.get("saved.txt"), String.format("\n%s", name).getBytes(), StandardOpenOption.APPEND);
						    
						    //Drawing and saving the spider-man as what they named it
						    user.draw(name);
						    
						    //Final output. Tells the user what components their spider-man has
						    System.out.println("\n\n\nYour Spider-Man was saved successfully");
						    System.out.println("Head: " + head.getHead());
						    System.out.println("Body: " + body.getBody());
						    System.out.println("Leg: " + leg.getLeg());
						    
						    scan.next();
						    
						    break;
						    
						
						}catch (IOException e) {
						    
						}

						
						//If the user inputs something other than an integer, the program loops back to the beginning
					} catch (InputMismatchException e) {
						
						System.out.println("\n\nInvalid input. Please try again.");
						scan.next();
						
					}
					
					
				}
			}
			
			//Checking if the user wants to load a saved spider-man
			if (input.equals("0")) {
				
				Scanner scanner = new Scanner(new File("saved.txt"));//Resetting the scanner
				boolean discovered = false;
				int lineNum = 0;
				
				System.out.println("\n");
				
				//Checking how many lines there are in saved.txt
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					lineNum += 1;
				}
				
				//If there are more than 1 line, there are files saved
				if (lineNum > 1) {
					Scanner scan1 = new Scanner(new File("saved.txt")); //Resetting the scanner
					
					//Outputting all the saved spider-men
					while (scan1.hasNextLine()) {
						   String line = scan1.nextLine();
						   
						   System.out.println(line);
						}
				}
				
				
				else {
					//If there is only 1 line, the program displays this message and goes to the beginning of the program to make them create a spider-man
					System.out.println("There are no saved Spider-Men in your PC");
					continue;
					
				}
				
				
				//Using a while true loop in case of an invalid input
				while (true) {
					
					//Getting the user's input on which spider-man they want to load
					System.out.println("\nType the name of the Spider-Man you want to load: ");
					String choice = scan.nextLine(); //saving the user's choice
					
					
					Scanner scan2 = new Scanner(new File("saved.txt"));//Creating new instance of the scanner class so that it wont mess up the choice variable
					
					//Going through all the lines in the saved.txt file
					while (scan2.hasNextLine()) {
						
						   String line = scan2.nextLine();
						   String lowLine = line;
						   
						   //If the current line is equal to the user's input, we set the discovered variable to true
						   if (lowLine.toLowerCase().equals(choice.toLowerCase())) {
							   
							   discovered = true;
							   
							   
							   //Using try/catch to open the png file of the spider-man that the user chose
							   try{
								   
								   File file = new File(String.format("%s.png", line));
								   Desktop d = Desktop.getDesktop();
								   d.open(file);
							       
							   }
							   catch (IOException e)
							   {
								   
							   }
						   }
						}
					
					//If the discovered variable is still false, the program outputs a message saying that the spider-man the user inputed does not exist
					if (discovered == false) {
						
						System.out.println("\nThe Spider-Man name you entered doesn't exist. Please try again.");
						
						//Going to the beginning of the loop
						continue;
						
					}
					
					//Breaks from the loop
					else {
						break;
					}
					
				}
			}
			
			else { //If the user inputs anything else, the program closes
				
				System.out.println("\nGoodbye");
				System.exit(0);
			}
			
		}
		
	}
}
