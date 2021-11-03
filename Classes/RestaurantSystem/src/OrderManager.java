import java.io.IOException;
import java.util.Scanner;

public class OrderManager {

    private Order order;

    public OrderManager(Order Order){

        this.order = Order;

    }

    public Order getOrder() {
        return order;
    }

    public void addToOrder() throws IOException
    {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
		while (!exit)
		{
			System.out.println("(1) Add Package (2) Add Item (3) Exit");
			int choice = sc.nextInt();
			switch (choice){
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

    public void addItem() throws IOException
    {
        order.orderItems[order.itemCount] = ItemMenu.getItem();
        order.itemCount++;
    }

    public void addPackage() throws IOException
    {
        order.orderPackages[order.packageCount] = PackageMenu.getPackage();
        order.packageCount++;
    }

    public Item removeItem()
    {
        Scanner sc = new Scanner(System.in);
		viewOrder();
		System.out.println("Enter the number of the package you want to remove: ");
		int itemNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Item rt = order.orderItems[itemNum];
		for (int i = itemNum; i < order.orderItems.length; ++i)
			order.orderItems[i] = order.orderItems[i+1];
		sc.close();
        return rt;
    }

    public Package removePackage()
    {
        Scanner sc = new Scanner(System.in);
		viewOrder();
		System.out.println("Enter the number of the package you want to remove: ");
		int packageNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Package rt = order.orderPackages[packageNum];
		for (int i = packageNum; i < order.orderPackages.length; ++i)
			order.orderPackages[i] = order.orderPackages[i+1];
		sc.close();
        return rt;
    }
    
    public void viewOrder()
    {
        System.out.println("The items are: ");
		for (int i = 0; i < order.itemCount; ++i)
			System.out.println(i + ":\t" + order.orderItems[i].getName()
				+ "\n\tprince: " + order.orderItems[i].getPrice()
				+ "\n\ttype: " + order.orderItems[i].getType());

		System.out.println("The packages are: ");
		for (int i = 0; i < order.packageCount; ++i)
			System.out.println(i + ":\t" + order.orderPackages[i].getDescription()
				+ ":\tprince: " + order.orderPackages[i].getPrice()
				+ ":\titems: " + order.orderPackages[i].getItem());
	}


    public void printOrderInvoice()
    {
        return;
	}
}
