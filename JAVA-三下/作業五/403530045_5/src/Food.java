/** 
 * Assignment #:  #5
 * @author ªLÞ³ÂE
 * StudentID : 403530045
 * Description: Food is a subclass of Product class. 
 * 				It has the attributes of name, damageRate and expirationDate in addition to the inherited ones.      	        
 */

public class Food extends Product{
	public String name;
	public String expirationDate;
	public double damageRate;
	/**
	 * set the value of the attributes 
	 * @param productIdValue
	 * @param quantityValue
	 * @param unitPriceValue
	 * @param nameValue the name of food
	 * @param damageRateValue the damageRate of food
	 * @param expirationDateValue the expirationDate of food
	 */
	public Food(String productIdValue, int quantityValue, double unitPriceValue, String nameValue,double damageRateValue, String expirationDateValue)
	{
		super(productIdValue,quantityValue,unitPriceValue);
		name = nameValue;
		damageRate = damageRateValue; 
		expirationDate = expirationDateValue;
	}
	/**
	 * compute the total cost of the food
	 */
	@Override
	public void computeTotalCost()
	{
		totalCost = unitPrice * quantity * (1 + damageRate);
		totalCost = Math.round(totalCost * 100) / 100.0; // round off to the 2nd decimal place
	}

	// damageRate is transfered to percentage
	/**
	 * @return info of food
	 */
	public String toString()
	{
		String info = 	"\nFood:" 
						+ "\nProduct ID:\t" + productId
						+ "\nQuantity:\t" + quantity
						+ "\nUnit Price:\t$" + unitPrice
						+ "\nTotal Cost:\t$" + totalCost 
						+ "\nFood Name:\t" + name
						+ "\nDamage Rate:\t" +   Math.round(damageRate * 100 * 100) / 100.0    + "%"
						+ "\nExpiratino Date:\t" + expirationDate
						+ "\n";
		
		return info;
		
	}
	
	
	
	
	
	
	
}
