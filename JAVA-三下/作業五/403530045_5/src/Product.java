/** 
 * Assignment #:  #5
 * @author ªLÞ³ÂE
 * StudentID : 403530045
 * Description: Represents the basic attributes of a product in a grocery store.        
 */

public abstract class Product {
	protected String productId = "?";
	protected int quantity = 0;
	protected double unitPrice = 0.0;
	protected double totalCost = 0.0;
	/**
	 * Set the initial value of the product
	 * @param productIdValue The unique id of the product
	 * @param quantityValue  The quantity of the product in the store
	 * @param unitPriceValue The price of the product
	 */
	public Product(String productIdValue, int quantityValue, double unitPriceValue)
	{
		productId = productIdValue;
		quantity = quantityValue;
		unitPrice = unitPriceValue;
	}
	/**
	 * Get the product's unique id
	 * @return product's unique id
	 */
	public String getProductId()
	{
		return productId;
	}
	/**
	 * computes and updates the attribute of totalCost
	 */
	public abstract void computeTotalCost(); // the subclass have to override it
	/**
	 * @return basic info of products
	 */
	public String toString()
	{
		String info = "\nProduct ID:\t" + productId
						+ "\nQuantity:\t" + quantity
						+ "\nUnit Price:\t$" + unitPrice
						+ "\nTotal Cost:\t$" + totalCost 
						+ "\n";
		
		return info;
		
	}
	
}
