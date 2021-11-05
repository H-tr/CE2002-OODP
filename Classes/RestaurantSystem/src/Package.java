import java.util.Scanner;

public class Package {

	public Package(String description, double price) {
		this.description = description;
		this.price = price;
	}

	private double price;
	private Item[] item = new Item[max];
	private static final int max = 20;
	private String description;

	private int itemCnt = 0;

	public Package() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the description of this package:");
		description = sc.nextLine();
		System.out.println("Please enter the price: ");
		price = sc.nextDouble();
	}

	
	/** 
	 * @auther HuTianrun
	 * @param ++i
	 */
	public void displayPackage() { // display item inside package
		for (int i = 0; i < itemCnt; ++i) {
			System.out.println(i + ":\t" + item[i].getName() + "\n\tprice: " + item[i].getPrice() + "\n\ttype: "
					+ item[i].getType());
		}
	}

	public void addItem() {
		item[itemCnt++] = ItemMenu.getItem();
	}

	
	/** 
	 * @auther HuTianrun
	 * @param i
	 * @param ItemMenu.getItem(i
	 * @param removeItem(
	 */
	public void addItem(int i, int j) { // used when adding items from plain file
		item[itemCnt++] = ItemMenu.getItem(i, j);
	}

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

	public void setDescription() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the new description: ");
		// String dummychar = sc.next();
		this.description = sc.nextLine();
	}

	
	/** 
	 * @auther HuTianrun
	 * @return String
	 */
	public String getDescription() {
		return description;
	}

	
	/** 
	 * @auther HuTianrun
	 * @return double
	 */
	public double getPrice() {
		return this.price;
	}

	public void setPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the new price: ");
		this.price = sc.nextDouble();
	}

	
	/** 
	 * @auther HuTianrun
	 * @return int
	 */
	public int getItemCnt() {
		return itemCnt;
	}

	
	/** 
	 * @auther HuTianrun
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
	 * @auther HuTianrun
	 * @param i
	 * @return Item
	 */
	public Item getItem(int i) {
		return item[i];
	}

	
	/** 
	 * @auther HuTianrun
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
