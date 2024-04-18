/** 
 * Assignment #: 3
 * @author ªLÞ³ÂE
 * StudentID : 403530045
 * Description: set and get car's year,color,price,country, manufacturer, brand
 * Time spent: two days		        	        
 */
public class Car
{
	public String year;
	public String color;
	public double price;
	public Makes makes;
	
	public Car()
	{
		year = "?";
		color = "?";
		price = 0.0;
		makes = new Makes();
	}
	/**
	 * get car's year,color,price
	 * @return car's year,color,price
	 */
	public String getYear()
	{
		return this.year;
	}
	public String getColor()
	{
		return this.color;
	}
	public double getPrice()
	{
		return this.price;
	}
	/**
	 * get a new makes object
	 * @return a new makes object
	 */
	public Makes getMakes()
	{
		return this.makes;
	}
	/**
	 * set car's year,color,price
	 * @param nYear,nColor,nPrice specify the car's year,color,price
	 */
	public void setYear(String nYear)
	{
		this.year = nYear;
	}
	public void setColor(String nColor)
	{
		this.color = nColor;
	}
	public void setPrice(double nPrice)
	{
		this.price = nPrice;
	}
	/**
	 * set the name of country, manufacturer, brand
	 * @param nCountry specify car's country
	 * @param nManufac specify car's manufacturer
	 * @param nBrand specify car's brand
	 */
	public void setMakes(String nCountry, String nManufac, String nBrand)
	{
		this.makes.setCountry(nCountry);
		this.makes.setManufac(nManufac);
		this.makes.setBrand(nBrand);
	}
	/**
	 * @return car's country, manufacturer, brand, year, color, price
	 */
	public String toString()
	{
		return "\nCountry:\t" + getMakes().getCountry() +
			   "\nManufacturer:\t" + getMakes().getManufac() + 
			   "\nBrand:\t" + getMakes().getBrand() + 
			   "\nYear:\t" + getYear() + 
			   "\nColor:\t" + getColor() +
			   "\nPrice:\t" + getPrice()+ "\n\n";
	}
	
	
}
