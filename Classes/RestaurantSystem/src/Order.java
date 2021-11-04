import java.util.*;
import javax.swing.UIDefaults.ProxyLazyValue;

public class Order extends Event {

	private final int maxItemNum = 500;

	protected Item[] orderItems = new Item[maxItemNum];
	protected Package[] orderPackages = new Package[maxItemNum];

	protected int itemCount = 0;
	protected int packageCount = 0;

	private Staff staff;

	public Order(int pax, String custName, Table table) {
		super.setCustName(custName);
		super.setPax(pax);
		super.setTable(table);
	}

	public String returnType() {
		return "Order";
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String[] getItems() {
		String[] items = new String[this.itemCount];
		int i;
		for (i = 0; i < itemCount; i++) {
			System.out.println(
					items[i] = "Item [" + (i + 1) + "]: " + orderItems[i].getName() + " " + orderItems[i].getPrice());
			items[i] = "Item [" + (i + 1) + "]: " + orderItems[i].getName() + " " + orderItems[i].getPrice();
		}
		return items;
	}

	public String[] getPackages() {
		String[] packages = new String[this.packageCount];
		int i;
		for (i = 0; i < packageCount; i++) {
			System.out.println(
					"Package [" + (i + 1) + "]: " + orderPackages[i].getItem() + " " + orderPackages[i].getPrice());
			packages[i] = "Package [" + (i + 1) + "]: " + orderPackages[i].getItem() + " "
					+ orderPackages[i].getPrice();
		}
		return packages;
	}

}