import java.util.*;
public class Order {

	public Order(boolean isMember, Staff staff) {
		this.isMember = isMember;
		this.staff = staff;
	}

	private final int maxItemNum = 50;
	private final int maxPacNum = 50;

	private Item[] orderItems = new Item[maxItemNum];	// item list
	private Package[] orderPackage = new Package[maxPacNum];	// package list

	private Staff staff = null;	// null means there is no staff
	private boolean isMember = false;
	private Date date;
	private int itemcnt = 0;	// point to the first empty slot in item list
	private int paccnt = 0;		// point to the first package slot in package list

	public void addItem() {
		orderItems[itemcnt++] = ItemMenu.getItem();
	}

	public Item removeItem() {
		Scanner sc = new Scanner(System.in);
		displayOrder();
		System.out.println("Enter the number of item you want to remove: ");
		int itemNum = sc.nextInt(); // itemNum is the index of item you want to remove in the list
		Item rt = orderItems[itemNum];
		for (int i = itemNum; i < itemcnt; ++i)
			orderItems[i] = orderItems[i+1];
		
		itemcnt--;
		sc.close();
		return rt;
	}

	public void addPackage(Package package_add) {
		orderPackage[paccnt++] = PackageMenu.getPackage();
	}

	public Package removePackage() {
		Scanner sc = new Scanner(System.in);
		displayOrder();
		System.out.println("Enter the number of package you want to remove: ");
		int packageNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Package rt = orderPackage[packageNum];
		for (int i = packageNum; i < paccnt; ++i)
			orderPackage[i] = orderPackage[i+1];
		
		paccnt--;
		sc.close();
		return rt;
	}

	public void displayOrder() {
		System.out.println("The items are: ");
		for (int i = 0; i < itemcnt; ++i)
			System.out.println(i + ":\t" + orderItems[i].getName()
				+ "\n\tprince: " + orderItems[i].getPrice()
				+ "\n\ttype: " + orderItems[i].getType());

		System.out.println("The packages are: ");
		for (int i = 0; i < paccnt; ++i)
			System.out.println(i + ":\t" + orderPackage[i].getDescription()
				+ ":\tprince: " + orderPackage[i].getPrice()
				+ ":\titems: " + orderPackage[i].getItem());
	}

	public void displayInvoice() {
		double totalPay = 0;
		System.out.println("\t\tRestaurant Bill");
		System.out.println("****************************************************");
		System.out.println("Staff: " + staff.getName() + "\tDate:" + date.getTime());
		System.out.println("****************************************************");
		for (int i = 0; i < itemcnt; ++i) {
			System.out.println(orderItems[i].getName() + "\t\t" + orderItems[i].getPrice());
			totalPay += orderItems[i].getPrice();
		}
		for (int i = 0; i < paccnt; ++i) {
			System.out.println(orderPackage[i].getDescription() + "\t\t" + orderPackage[i].getPrice());
			totalPay += orderPackage[i].getPrice();
		}
		System.out.println("****************************************************");
		System.out.println("Subtotal\t\t" + totalPay);
		totalPay *= 1.1;
		System.out.println("Tax(10%)\t\t" + totalPay);
		if (isMember) {
			totalPay *= 0.8;
			System.out.println("Member discount(80%)\t" + totalPay);
		}
		System.out.println("****************************************************");
		System.out.println("Total\t\t" + totalPay);

		clean();
	}

	public boolean getIsMember() {
		return this.isMember;
	}

	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	private void clean() {
		itemcnt = 0;
		paccnt = 0;
	}

}

