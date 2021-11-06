import java.util.Scanner;

public class Package {
	/**
	 * @author HuTianrun
	 * @param description
	 * @param price
	 */
	public Package(String description, double price) {
		this.description = description;
		this.price = price;
	}

	private double price;
	private Item[] item = new Item[max];
	private static final int max = 20;
	private String description;

	private int itemCnt = 0;

	/**
	 * Build a package by asking user the description of package and price
	 * @author HuTianrun
	 */
	public Package() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the description of this package:");
		description = sc.nextLine();
		System.out.println("Please enter the price: ");
		price = sc.nextDouble();
	}

	
	/** 
	 * Display the item inside package
	 * @author HuTianrun
	 * @param ++i
	 */
	public void displayPackage() { // display item inside package
		for (int i = 0; i < itemCnt; ++i) {
			System.out.println(i + ":\t" + item[i].getName() + "\n\tprice: " + item[i].getPrice() + "\n\ttype: "
					+ item[i].getType());
		}
	}

	/**
	 * Add an item into package
	 * @author HuTianrun
	 */
	public void addItem() {
		item[itemCnt++] = ItemMenu.getItem();
	}

	
	/** 
	 * Add an item into package, this method is used for reading from text file
	 * @author HuTianrun
	 * @param i
	 * @param ItemMenu.getItem(i
	 * @param removeItem(
	 */
	public void addItem(int i, int j) { // used when adding items from plain file
		item[itemCnt++] = ItemMenu.getItem(i, j);
	}

	/**
	 * Remove an item from this package
	 * @author HuTianrun
	 */
	public void removeItem() {
		displayPackage();
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter the item you want to remove: ");
		int ch = sc.nextInt();
		if (ch < 0 || ch >= itemCnt) {
			System.out.println("Invalid input");
			return;
		}
		for (int i = ch; i < itemCnt - 1; ++i) {
			item[i] = item[i + 1];
		}
		itemCnt--;
	}

	/**
	 * Reset the description of the package
	 * @author HuTianrun
	 */
	public void setDescription() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the new description: ");
		// String dummychar = sc.next();
		this.description = sc.nextLine();
	}

	
	/** 
	 * Get description of the package
	 * @author HuTianrun
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	
	/** 
	 * Get price of the package
	 * @author HuTianrun
	 * @return double
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Reset a new price of the package
	 * @author HuTianrun
	 */
	public void setPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the new price: ");
		this.price = sc.nextDouble();
	}

	
	/** 
	 * Get the total number of items inside the package. This method is used for reading and storing to text file
	 * @author HuTianrun
	 * @return int
	 */
	public int getItemCnt() {
		return itemCnt;
	}

	
	/** 
	 * Get the list of items as a string from package. This method is used for storing to text file
	 * @author HuTianrun
	 * @return String
	 */
	public String getItem() {
		String temp = "";
		for (int i = 0; i < itemCnt; ++i) {
			temp += item[i].getName();
			temp += ", ";
		}
		return temp;
	}

	
	/** 
	 * Get an item from this package. This method is used for reading from text file
	 * @author HuTianrun
	 * @param i
	 * @return Item
	 */
	public Item getItem(int i) {
		return item[i];
	}

	
	/** 
	 * Get the type of items in this package. This method is used for storing the text file
	 * @author HuTianrun
	 * @param j
	 * @return int
	 */
	public int getInfo(int j) {
		int info = 0;
		switch (item[j].getType()) {
		case "Main Course":
			info = 0;
			break;
		case "Drinks":
			info = 1;
			break;
		case "Dessert":
			info = 2;
			break;
		}
		return info;
	}
}
