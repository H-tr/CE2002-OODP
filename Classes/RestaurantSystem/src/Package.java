import java.util.Scanner;
/**
 * Each package contains a set of items. It provides a set for customers to choose from.
 * Inside this package class, you can see the methods to control the list.
 * @author Hu Tianrun
 */
public class Package {
	/**
	 * Constructor of package. It takes in description and price.
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
	 */
	public void displayPackage() { // display item inside package
		for (int i = 0; i < itemCnt; ++i) {
			System.out.println(i + ":\t" + item[i].getName() + "\n\tprice: " + item[i].getPrice() + "\n\ttype: "
					+ item[i].getType());
		}
	}

	/**
	 * Add an item into package
	 */
	public void addItem() {
		item[itemCnt++] = ItemMenu.getItem();
	}

	
	/** 
	 * Add an item into package, this method is used for reading from text file
	 * @param i
	 * @param ItemMenu.getItem(i
	 * @param removeItem(
	 */
	public void addItem(int i, int j) { // used when adding items from plain file
		item[itemCnt++] = ItemMenu.getItem(i, j);
	}

	/**
	 * Remove an item from this package
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
	 */
	public void setDescription() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the new description: ");
		// String dummychar = sc.next();
		this.description = sc.nextLine();
	}

	
	/** 
	 * Get description of the package
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	
	/** 
	 * Get price of the package
	 * @return double
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * Reset a new price of the package
	 */
	public void setPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the new price: ");
		this.price = sc.nextDouble();
	}

	
	/** 
	 * Get the total number of items inside the package. This method is used for reading and storing to text file
	 * @return int
	 */
	public int getItemCnt() {
		return itemCnt;
	}

	
	/** 
	 * Get the list of items as a string from package. This method is used for storing to text file
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
	 * @param i
	 * @return Item
	 */
	public Item getItem(int i) {
		return item[i];
	}

	
	/** 
	 * Get the type of items in this package. This method is used for storing the text file
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
