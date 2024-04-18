import java.io.*;         //to use InputStreamReader and BufferedReader
import java.util.*;       //to use ArrayList
/** 
 * Assignment #:  #5
 * @author ªLÞ³ÂE
 * StudentID : 403530045
 * Description: The Assignment 5 class displays a menu of choices
               (add a product, compute the total cost, search a product, list product,
               quit, display menu) to a user.
               Then it performs the chosen task. It will keep asking a user to
               enter the next choice until the choice of 'Q' (Quit) is
               entered.		        	        
 */
public class Assignment5
{
	
	public static void main (String[] args)
	{
		char input1;// user's action
		String inputInfo = new String();
		String line = new String();
		boolean found = false;

		// ArrayList object is used to store product objects - u
		ArrayList<Product> productList = new ArrayList<Product>();
     
		try
		{
			printMenu();     // print out menu

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader (System.in);
			BufferedReader stdin = new BufferedReader (isr);

			do
			{
				System.out.println("What action would you like to perform?");
				line = stdin.readLine().trim();
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1)
				{
					switch (input1)
					{
						case 'A':   //Add Product
							System.out.print("Please enter a product information to add:\n");
							inputInfo = stdin.readLine().trim();
							productList.add(ProductParser.parseStringToProduct(inputInfo)); //create an object of one of child classes of Product class
							break;
             
						case 'C':   //Compute Total Costs for all products in the productList.
							for(Product p: productList)
							{
								p.computeTotalCost();
							}
               
							System.out.print("total costs computed\n");
							break;
             
						case 'S':   //Search for a product
							System.out.print("Please enter a productId to search:\n");
							inputInfo = stdin.readLine().trim();
							for(Product p: productList)
							{
								if(inputInfo.equals(p.getProductId())) 
								{
									found = true;  //If found, set "found" true, and set "found" false otherwise.
									break;
								}
							}
							 
							if (found)
							{
								System.out.print("product found\n");
								found = false;// return back to the default value
							}
							else
							{
								System.out.print("product not found\n");
							}
							break;
             
						case 'L':   //List Products
							if(productList.size() == 0)  //If there is no product in the list
								System.out.println("No product.\n");
							
							for(Product p: productList)
							{	
								System.out.println(p.toString());
							}
							
							break;
            
						case 'Q':   //Quit
							break;
							
						case '?':   //Display Menu
							printMenu();
							break;
							
						default:
							System.out.print("Unknown action\n");
							break;
					}
				}
				else
				{
					// if input isn't a char
					System.out.print("Unknown action\n");
				}
			} while (input1 != 'Q'); // stop the loop when Q is read
		}
		catch (IOException exception)
		{
			System.out.println("IO Exception");
		}
		
}

  /** The method printMenu displays the menu to a use **/
	public static void printMenu()
	{
		System.out.print("Choice\tAction\n" +
                      "------\t------\n" +
                      "A\tAdd Product\n" +
                      "C\tCompute Total Costs\n" +
                      "S\tSearch for Product\n" +
                      "L\tList Products\n" +
                      "Q\tQuit\n" +
                      "?\tDisplay Help\n\n");
	}
	
}

