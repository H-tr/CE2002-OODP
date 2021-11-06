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
	 * @author HuTianrun
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	
	/** 
	 * set item name
	 * @author HuTianrun
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * get item description
	 * @author HuTianrun
	 * @return String
	 */
	public String getDescription() {
		return this.description;
	}
	
	
	/** 
	 * set item description
	 * @author HuTianrun
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/** 
	 * get item price
	 * @author HuTianrun
	 * @return double
	 */
	public double getPrice() {
		return this.price;
	}

	
	/** 
	 * set item price
	 * @author HuTianrun
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public abstract String getType();
	
}
