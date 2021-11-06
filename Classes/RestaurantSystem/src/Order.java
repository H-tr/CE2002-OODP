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
	 * @author Ian Chan
	 * @return String
	 */
	public String returnType() {
		return "Order";
	}

	
	/** 
	 * @author Ian Chan
	 * @return Staff
	 */
	public Staff getStaff() {
		return staff;
	}

	
	/** 
	 * @author Ian Chan
	 * @param staff
	 */
	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	
	/** 
	 * @author Chiam Chuen
	 * @return int
	 */
	public int getItemCount() {
		return itemCount;
	}

	
	/** 
	 * @author Chiam Chuen
	 * @return int
	 */
	public int getPackageCount() {
		return packageCount;
	}

	
	/** 
	 * @author Chiam Chuen
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
	 * @author Chiam Chuen
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
	 * @author Chiam Chuen
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
	 * @author Ian Chan
	 * @return Timing
	 */
	public Timing getOrderedTime() {
		return orderedTime;
	}

	
	/** 
	 * @author Ian Chan
	 * @param orderedTime
	 */
	public void setOrderedTime(Timing orderedTime) {
		this.orderedTime = orderedTime;
	}

	
	/** 
	 * @author Chiam Chuen
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