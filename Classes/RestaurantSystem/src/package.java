import java.util.Scanner;
public class Package {
	private double price;
	private Item[] item;
	private static final int max = 10;
	private String description;
	
	public Package() {
		this.item = new Item[max];
	}

	public void addItem(Item item) {
		// TODO
	}

	public void setDescription() {
		Scanner sc = new Scanner(System.in);
		this.description = sc.next();
		sc.close();
	}

	public String getDescription() {
		return description;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Item[] getItem() {
		return this.item;
	}
	public void setItem(Item[] item) {
		this.item = item;
	}
	
	
}