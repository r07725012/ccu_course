/** 
 * Assignment #: 3
 * @author ªLÞ³ÂE
 * StudentID : 403530045
 * Description: make car's country, manufacturer, brand
 * Time spent: two days		        	        
 */
public class Makes 
{
	public String country;
	public String manufacturer;
	public String brandName;
	
	public Makes()
	{
		country = "?";
		manufacturer = "?";
		brandName = "?";
	}
	/**
	 * Get the name of country, manufacturer, brand
	 * @return the name of country, manufacturer, brand respectively
	 */
	public String getCountry()
	{
		return this.country;
	}
	public String getManufac()
	{
		return this.manufacturer;
	}
	public String getBrand()
	{
		return this.brandName;
	}
	/**
	 * set the name of country, manufacturer, brand
	 * @param nCountry,nManufac,nBrand specify the name of the car's attribute respectively
	 */
	public void setCountry(String nCountry)
	{
		this.country = nCountry;
	}
	public void setManufac(String nManufac)
	{
		this.manufacturer = nManufac;
	}
	public void setBrand(String nBrand)
	{
		this.brandName = nBrand;
	}
	/**
	 * @return car's country, manufacturer, brand
	 */
	public String toString()
	{
		return "\nCountry:\t" + getCountry() +
			   "\nManufacturer:\t" + getManufac() +
			   "\nBrand:\t" + getBrand() + "\n";
	}
	
	
	
}
