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
	 * @auther HuTianrun
	 * @return String
	 */
	public String getName() {
		return this.name;
	}

	
	/** 
	 * @auther HuTianrun
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	
	/** 
	 * @auther HuTianrun
	 * @return String
	 */
	public String getDescription() {
		return this.description;
	}
	
	
	/** 
	 * @auther HuTianrun
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
	/** 
	 * @auther HuTianrun
	 * @return double
	 */
	public double getPrice() {
		return this.price;
	}

	
	/** 
	 * @auther HuTianrun
	 * @param price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	public abstract String getType();
	
}
