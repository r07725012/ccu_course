import java.io.*; //to use InputStreamReader and BufferedReader
import java.util.*;
/** 
 * Assignment #: 3
 * @author 林瑋鴻
 * StudentID : 403530045
 * Description: displays a menu of choices to a user
		        and performs the chosen task. It will keep asking a user to
		        enter the next choice until the choice of 'Q' (Quit) is entered.
 * Time spent: two days		        	        
 */
public class Assignment3 
{
	public static void main(String[] args) 
	{
		char input = 'Z';//store first char
		String line;//store choice action
		//store ,country, manufacturer, brand, color, price, year
		String country,manufac,brand,color,year;
		double price;
		
		
		// instantiate a Make object
		//Makes make1 = new Makes();
		Car car = new Car();
		printMenu();

		//Create a Scanner object to read user input
		Scanner scan = new Scanner(System.in);

		do  // ask for user input
		{
			System.out.println("What action would you like to perform?");
			line = scan.nextLine(); // get user input as a string before clicking enter
			//System.out.println("count");
			
			if (line.length() == 1)
		    {
		    	input = line.charAt(0);// get first char in a string
		        input = Character.toUpperCase(input); // turn a char into a capital letter (string.toUpperCase: change "string")

		        	  // matches one of the case statement
		        	  switch (input)
		        	  {
		        	  	case 'A':   //Add Car
		        	  		System.out.print("Please enter the car information:\n");
		        	  		System.out.print("What is the car’s manufacturer?\n");
		        	  		manufac = scan.nextLine();
		        	  		System.out.print("What is the car's brand?\n");
		        	  		brand = scan.nextLine();
		        	  		System.out.print("Which country is the car made?\n");
		        	  		country = scan.nextLine();
		        	 
		        	  		car.setMakes(country,manufac,brand);
		        	  		
		        	  		System.out.print("what year was the car made?\n");
		        	  		year = scan.nextLine();
		        	  		car.setYear(year);
		        	  		
		        		  	System.out.print("What color is the car?\n");	
		        		  	color = scan.nextLine();
		        		  	car.setColor(color);
		        	  	
		        		  	System.out.print("How much was the car's price?\n");
		        		  	price = scan.nextDouble(); //it will not eat 換行字元(enter) 
		        		  	car.setPrice(price);
		        		  	
		        		  	line = scan.nextLine();//store the none char(enter,換行字元,\n)
		        		  						   //line's length equal to 0 !!!
		        		  	break;
		        		
		        	  	case 'D':   //Display Car
		        	  		System.out.print(car.toString());
		        	  		break;
		        	  		
		        	  	case 'Q':   //Quit
		        	  		break;
		        	  		
		        	  	case '?':   //Display Menu
		        	  		printMenu();
		        	  		break;
		        	  		
		        	  	default:
		        	  		System.out.print("Unknown action\n");
		        	  		
		        	  }
		        	  
		    }
		    else
		    {
		    	System.out.print("Unknown action\n");
		    }
		          
		 }while (input != 'Q' || line.length() != 1);//input == q and line's length == 1 will break 
		

	}
	/** The method printMenu displays the menu to a user **/
	public static void printMenu()
	{
	     System.out.print("Choice\tAction\n" +
	                        "------\t------\n" +
	                        "A\tAdd Car\n" +
	                        "D\tDisplay Car\n" +
	                        "Q\tQuit\n" +
	                        "?\tDisplay Help\n");
	}

}
