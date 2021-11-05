import java.util.*;
import javax.swing.UIDefaults.ProxyLazyValue;

public class Order extends Event {

	private final int maxItemNum = 500;

	protected Item[] orderItems = new Item[maxItemNum];
	protected Package[] orderPackages = new Package[maxItemNum];

	protected int itemCount = 0;
	protected int packageCount = 0;

	private Timing orderedTime;

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

	public int getItemCount() {
		return itemCount;
	}

	public int getPackageCount() {
		return packageCount;
	}

	public String[] getItems() {
		String[] items = new String[this.itemCount];
		int i;
		for (i = 0; i < itemCount; i++) {
			items[i] = "Item: " + orderItems[i].getName() + " " + orderItems[i].getPrice();
		}
		return items;
	}

	public String[] getPackages() {
		String[] packages = new String[this.packageCount];
		int i;
		for (i = 0; i < packageCount; i++) {
			packages[i] = "Package: " + orderPackages[i].getItem() + " " + orderPackages[i].getPrice();
		}
		return packages;
	}

	public double getTotal() {
		double total = 0.00;
		for (int i = 0; i < itemCount; i++) {
			total += orderItems[i].getPrice();
		}
		for (int i = 0; i < packageCount; i++) {
			total += orderPackages[i].getPrice();
		}
		return total;
	}

	public Timing getOrderedTime() {
		return orderedTime;
	}

	public void setOrderedTime(Timing orderedTime) {
		this.orderedTime = orderedTime;
	}

	public void removeItemPackage(String s, int index) {
		if (s.equals("item")) {
			for (int i = index; i < itemCount; i++) {
				orderItems[i] = orderItems[i + 1];
			}
			itemCount -= 1;
		} else if (s.equals("package")) {
			for (int i = index; i < packageCount; i++) {
				orderPackages[i] = orderPackages[i + 1];
			}
			packageCount -= 1;
		}
	}
}