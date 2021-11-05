import java.io.IOException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class OrderManager {

	private Order order;

	public OrderManager(Order Order) {

		this.order = Order;

	}

	public Order getOrder() {
		return order;
	}

	public void addToOrder() throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean exit = false;
		while (!exit) {
			System.out.println("(1) Add Package (2) Add Item (3) Exit");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				addPackage();
				System.out.println("Package Added");
				break;
			case 2:
				addItem();
				System.out.println("Item Added");
				break;
			case 3:
				exit = true;
				break;
			default:
				System.out.println("Invalid input!");
			}
		}
	}

	public void addItem() throws IOException {
		ItemMenu.getItemList();
		order.orderItems[order.itemCount] = ItemMenu.getItem();
		order.itemCount++;
	}

	public void addPackage() throws IOException {
		ItemMenu.getItemList();
		PackageMenu.getPacList();
		order.orderPackages[order.packageCount] = PackageMenu.getPackage();
		order.packageCount++;
	}

	public Item removeItem() {
		Scanner sc = new Scanner(System.in);
		viewOrder();
		System.out.println("Enter the number of the items you want to remove: ");
		int itemNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Item rt = order.orderItems[itemNum];
		for (int i = itemNum; i < order.orderItems.length; ++i)
			order.orderItems[i] = order.orderItems[i + 1];
		sc.close();
		return rt;
	}

	public Package removePackage() {
		Scanner sc = new Scanner(System.in);
		viewOrder();
		System.out.println("Enter the number of the package you want to remove: ");
		int packageNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Package rt = order.orderPackages[packageNum];
		for (int i = packageNum; i < order.orderPackages.length; ++i)
			order.orderPackages[i] = order.orderPackages[i + 1];
		sc.close();
		return rt;
	}

	public void viewOrder() {

		System.out.printf("Order taken by: ");
		System.out.println(order.getStaff().getJobTitle() + " " + order.getStaff().getName());

		System.out.println("The items are: ");
		for (int i = 0; i < order.itemCount; ++i) {
			if (order.orderItems[i] != null) {
				System.out.println(i + ":\t" + order.orderItems[i].getName() + "\n\tprice: "
						+ order.orderItems[i].getPrice() + "\n\ttype: " + order.orderItems[i].getType());
			} else {
				order.removeItemPackage("item", i);
			}
		}
		System.out.println("The packages are: ");
		for (int i = 0; i < order.packageCount; ++i) {
			if (order.orderPackages[i] != null) {
				System.out.println(i + ":\t" + order.orderPackages[i].getDescription() + ":\tprice: "
						+ order.orderPackages[i].getPrice() + ":\titems: " + order.orderPackages[i].getItem());
			} else {
				order.removeItemPackage("package", i);
			}
		}
	}

	public String printOrderInvoice(boolean isMember, Staff staff) {
		double totalPay = 0;
		DecimalFormat f = new DecimalFormat("##.00");
		Calendar cal = Calendar.getInstance();
		Date date = cal.getTime();

		System.out.println("\t\tRestaurant Bill");
		System.out.println("****************************************************");
		System.out.println("Staff: " + staff.getName() + "\tDate:" + date);
		System.out.println("****************************************************");
		for (int i = 0; i < order.itemCount; ++i) {
			System.out.println(order.orderItems[i].getName() + "\t\t" + f.format(order.orderItems[i].getPrice()));
			totalPay += order.orderItems[i].getPrice();
		}
		for (int i = 0; i < order.packageCount; ++i) {
			System.out.println(
					order.orderPackages[i].getDescription() + "\t\t" + f.format(order.orderPackages[i].getPrice()));
			totalPay += order.orderPackages[i].getPrice();
		}
		System.out.println("****************************************************");
		System.out.println("Subtotal\t\t" + f.format(totalPay));
		totalPay *= 1.1;
		System.out.println("Tax(10%)\t\t" + f.format(totalPay));
		if (isMember) {
			totalPay *= 0.8;
			System.out.println("Member discount(80%)\t" + f.format(totalPay));
		}
		System.out.println("****************************************************");
		System.out.println("Total\t\t" + f.format(totalPay));
		return f.format(totalPay);
	}

	public void saveOrder(String total) throws IOException {
		String[] itemList = order.getItems();
		String[] packageList = order.getPackages();

		Calendar cal1 = Calendar.getInstance();
		Date date = cal1.getTime();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDate = dateFormat.format(date);

		FileWriter writer = new FileWriter("Orders.txt", true);
		writer.write(strDate + "\n");
		writer.write("Staff: " + order.getStaff().getName() + " " + order.getStaff().getEmployeeId() + "\n");
		writer.write("Customer: " + order.getCustName() + "\n");
		writer.write("Pax: " + order.getPax() + "\n");
		writer.write(order.getItemCount() + order.getPackageCount() + "\n");
		if (itemList.length != 0) {
			for (int i = 0; i < order.itemCount; i++) {
				writer.write(itemList[i] + "\n");
			}
		}
		if (packageList.length != 0) {
			for (int i = 0; i < order.packageCount; i++) {
				writer.write(packageList[i] + "\n");
			}
		}
		writer.write(total + "\n");
		writer.close();
	}
}
