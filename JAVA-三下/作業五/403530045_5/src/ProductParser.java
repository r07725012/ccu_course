/** 
 * Assignment #: #5
 * @author ªLÞ³ÂE
 * StudentID : 403530045
 * Description: Create a Product object (either a Clothing object or a Food object) from a parsable string.      	        
 */

public class ProductParser {
	/**
	 * parse user's input to the individual attribute
	 * @param lineToParse product info from user's input  
	 * @return the object of a new food or clothing
	 */
	public static Product parseStringToProduct(String lineToParse)
	{
		String[] productInfo = lineToParse.split("/"); // Get every attribute from user's input
		String kind = productInfo[0].toLowerCase(); // the first element is either food or clothing
		int quantity;
		double unitPrice,damageRate;
		
		if(kind.equals("clothing"))
		{
			quantity = Integer.parseInt(productInfo[2]); // parse string to a integer
			unitPrice = Double.parseDouble(productInfo[3]);
			Product p = new Clothing(productInfo[1],quantity,unitPrice,productInfo[4],productInfo[5]);
			return p;
			
		}	
		else    //kind is "food"
		{
			quantity = Integer.parseInt(productInfo[2]);
			unitPrice = Double.parseDouble(productInfo[3]);
			damageRate = Double.parseDouble(productInfo[5]);
			
			Product p = new Food(productInfo[1],quantity,unitPrice,productInfo[4],damageRate,productInfo[6]);
			return p;
	
		}
			
	}
	
	
}
