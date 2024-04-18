// input.java
import java.util.Scanner;

/** This is a i/o program for assignment 1
 * 
 * 
 * @author ªLÞ³ÂE
 * @version 1.0
 */
public class IntegerTester {
	/** main class
	 * 
	 * @param args array of string arguments
	 */
	public static void main(String args[]){
		
		int num1, num2=0;
		Scanner in = new Scanner(System.in);
		
		do
		{
			System.out.println("Please enter two integer and not greater than 100 (-1 for finish):");		
			num1 = in.nextInt(); // user input first number
			
			if(num1 != -1 && num1 <= 100) //number cannot be -1 or greater than 100
			{
				num2 = in.nextInt();// user input second number	
				
				if(num2 != -1 && num2 <= 100)  
				{
					//two numbers are correct and do arithmetic operations
					System.out.println("Sum:          "+ (num1+num2));
					System.out.println("Difference:   "+ (num1-num2));
					System.out.println("Product:      "+ (num1*num2));
					System.out.printf("Average:      %.2f\n",(double)(num1+num2)/2); 
					System.out.println("Distance:     "+ Math.abs(num1-num2));
					System.out.println("Maximum:      "+ Math.max(num1,num2));
					System.out.println("Minimum:      "+ Math.min(num1,num2));
					
					
				}
				else if(num2 > 100) // detect number greater than 100
				{
					System.out.println("Can not enter interger greater than 100");
				}
				
			}
			else if(num1 > 100)
			{
				System.out.println("Can not enter interger greater than 100");
			}
			
		}	
		while(num1 != -1 && num2 != -1); /**program finished if number equal to -1
											*/
		
	
		System.out.println("Program has finished.");
		
	}
}
