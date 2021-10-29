import java.util.Scanner;
public class Package {


	public Package(String description, double price) {
		this.description = description;
		this.price = price;
	}
	
	private double price;
	private Item[] item = new Item[max];
	private static final int max = 10;
	private String description;

	private int itemCnt = 0;
	
	public Package() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the description of this package:");
		description = sc.nextLine();
		System.out.println("Please enter the price: ");
		price = sc.nextDouble();
	}

	public void displayPackage() { // display item inside package
		for (int i = 0; i < itemCnt; ++i) {
			System.out.println(i + ":\t" + item[i].getName() + "\n\tprince: " + item[i].getPrice()
			+ "\n\ttype: " + item[i].getType());
		}
	}

	public void addItem() {
		Item temp = ItemMenu.getItem();
		item[itemCnt++] = temp;
	}

	public void removeItem() {
		displayPackage();
		Scanner sc = new Scanner(System.in);
		System.out.println("\nPlease enter the item you want to remove: ");
		int ch = sc.nextInt();
		for (int i = ch; i < itemCnt - 1; ++i) {
			item[i] = item[i+1];
		}
		itemCnt--;
	}

	public void setDescription() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the new description: \n");
		this.description = sc.nextLine();
		sc.close();
	}

	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter the new price: ");
		this.price = sc.nextDouble();
	}

	public String getItem() {
		String temp = "";
		for (int i = 0; i < itemCnt; ++i) {
			temp += item[i].getName();
			temp += " ";
		}
		return temp;
	}
}
