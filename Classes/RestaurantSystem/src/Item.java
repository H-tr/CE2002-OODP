/**
 * Item has three types: Main course, Drinks and Dessert. These three type are inherited from Item class. 
 * In the Item class, there are some basic information about every item including name, description and price.
 * Customers could choose those item.
 * @author Hu Tianrun
 */

public abstract class Item {
	private String name;
	private String description;
	private double price;
	
	public Item(String name, String description,double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	
	/** 
	 * get item name
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	
	/** 
	 * set item name
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * get item description
	 * @return String
	 */
	public String getDescription() {
		return this.description;
	}
	
	
	/** 
	 * set item description
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/** 
	 * get item price
	 * @return double
	 */
	public double getPrice() {
		return this.price;
	}

	
	/** 
	 * set item price
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Abstract method. It can get the type from every subclass. 
	 * @return
	 */
	public abstract String getType();
	
}
