/**    
 * This entity class is a subclass of the Event entity class, and stores all information relevant to a order such as DateTime, Customer Name, Pax, Table and Staff.
 * In particular, it stores two arrays of items and packages respectively that is managed by the OrderManager class.
 * @author Ian Chan
 * @author Chiam Chuen
 */

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

	
	/** 
	 * To tell user this Event is an Order
	 */
	public String returnType() {
		return "Order";
	}

	
	/** 
	 * Get staff
	 * @return Staff
	 */
	public Staff getStaff() {
		return staff;
	}

	
	/** 
	 * Set staff
	 * @param staff
	 */
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	
	/** 
	 * Get the number of items
	 * @return int
	 */
	public int getItemCount() {
		return itemCount;
	}

	
	/** 
	 * Get the number of packages
	 * @return int
	 */
	public int getPackageCount() {
		return packageCount;
	}

	
	/** 
	 * Get the string of items to print out
	 * @return String[]
	 */
	public String[] getItems() {
		String[] items = new String[this.itemCount];
		int i;
		for (i = 0; i < itemCount; i++) {
			items[i] = "Item: " + orderItems[i].getName() + " " + orderItems[i].getPrice();
		}
		return items;
	}

	
	/** 
	 * Get the string of packages to print out
	 * @return String[]
	 */
	public String[] getPackages() {
		String[] packages = new String[this.packageCount];
		int i;
		for (i = 0; i < packageCount; i++) {
			packages[i] = "Package: " + orderPackages[i].getItem() + " " + orderPackages[i].getPrice();
		}
		return packages;
	}

	
	/** 
	 * Get total price
	 * @return double
	 */
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

	
	/** 
	 * Get ordered time
	 * @return Timing
	 */
	public Timing getOrderedTime() {
		return orderedTime;
	}

	
	/** 
	 * Set ordered time
	 * @param orderedTime
	 */
	public void setOrderedTime(Timing orderedTime) {
		this.orderedTime = orderedTime;
	}

	
	/** 
	 * Remove an item from package
	 * @param s
	 * @param index
	 */
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