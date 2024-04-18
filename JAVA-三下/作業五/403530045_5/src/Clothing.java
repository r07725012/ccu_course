/** 
 * Assignment #:  #5
 * @author ªLÞ³ÂE
 * StudentID : 403530045
 * Description: Clothing is a subclass of Product class. 
 * 				It has the attributes of size and color in addition to the inherited ones:			
 */

public class Clothing extends Product{
	public String size;
	public String color;
	/**
	 * set the value of the attributes
	 * @param productIdValue
	 * @param quantityValue
	 * @param unitPriceValue
	 * @param sizeValue the size of clothing
	 * @param colorValue the color of clothing
	 */
	public Clothing(String productIdValue, int quantityValue, double unitPriceValue, String sizeValue, String colorValue)
	{
		super(productIdValue,quantityValue,unitPriceValue);
		size = sizeValue;
		color = colorValue;
		
	}
	/**
	 * compute the total cost of the clothing
	 */
	@Override
	public void computeTotalCost()
	{
		totalCost = unitPrice * quantity;
		totalCost = Math.round(totalCost * 100) / 100.0; // round off to the 2nd decimal place
	}
	/**
	 * @return info of clothing
	 */
	public String toString()
	{
		String info = 	"\nClothing:" 
						+ "\nProduct ID:\t" + productId
						+ "\nQuantity:\t" + quantity
						+ "\nUnit Price:\t$" + unitPrice
						+ "\nTotal Cost:\t$" + totalCost 
						+ "\nSize:\t" + size
						+ "\nColor:\t" + color
						+ "\n";
		
		return info;
		
	}
	
}
