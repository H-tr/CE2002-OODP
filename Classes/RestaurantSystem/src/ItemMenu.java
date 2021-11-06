import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ItemMenu {
	private static final int maxItemNum = 500; // max item menu size

	private static Item[] mainCourseMenu = new Item[maxItemNum]; // main course menu
	private static Item[] drinksMenu = new Item[maxItemNum]; // drinks menu
	private static Item[] dessertMenu = new Item[maxItemNum]; // dessert menu

	private static int mainCourseCnt = 0; // used to point the first empty slot of item menu
	private static int drinksCnt = 0; // used to point the first empty slot of item menu
	private static int dessertCnt = 0; // used to point the first empty slot of item menu

	/**
	 * Item list is storage list that will store all the item information. This function is to add an item into item list, used to manage the item
	 * @author HuTianrun
	 */
	public static void addItem() {
		String dummychar; // make sure scan works well
		String type;
		String name;
		String description;
		double price;
		Scanner sc = new Scanner(System.in);
		System.out.printf(
				"The item types you can choose: maincourse, drinks and dessert.\n Please enter the type you want to choose: ");
		do {
			type = sc.next();
			switch (type) { // ** requires initialization of the item class **
			case "maincourse":
				System.out.println("Please enter name of the main course:");
				dummychar = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Please enter description of this item:");
				description = sc.nextLine();
				System.out.println("Please enter the price:");
				price = sc.nextDouble();
				mainCourseMenu[mainCourseCnt++] = new MainCourse(name, description, price);
				break;
			case "drinks":
				System.out.println("Please enter name of the drinks:");
				dummychar = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Please enter description of this item:");
				description = sc.nextLine();
				System.out.println("Please enter the price:");
				price = sc.nextDouble();
				drinksMenu[drinksCnt++] = new Drinks(name, description, price);
				break;
			case "dessert":
				System.out.println("Please enter name of the dessert:");
				dummychar = sc.nextLine();
				name = sc.nextLine();
				System.out.println("Please enter description of this item:");
				description = sc.nextLine();
				System.out.println("Please enter the price:");
				price = sc.nextDouble();
				dessertMenu[dessertCnt++] = new Dessert(name, description, price);
				break;
			default:
				System.out.println("No such type, please enter again.");
			}
		} while (!type.equals("maincourse") && !type.equals("drinks") && !type.equals("dessert"));
	}

	/**
	 * Remove the item from list
	 * @author HuTianrun
	 * @return Item
	 */
	public static Item removeItem() {
		Scanner sc = new Scanner(System.in);
		int itemNum;
		Item rt = null;
		System.out.println("Enter the type of item you want to remove(maincourse, drinks or dessert): ");
		String type;
		do {
			type = sc.next();
			switch (type) { // ** requires initialization of the item class **
			case "maincourse":
				showMainCourse();
				System.out.println("Enter the id of main course you want to remove: ");
				itemNum = sc.nextInt();
				rt = mainCourseMenu[itemNum];
				for (int i = itemNum; i < mainCourseCnt; ++i)
					mainCourseMenu[i] = mainCourseMenu[i + 1];
				mainCourseCnt--;
				break;
			case "drinks":
				showDrinks();
				System.out.println("Enter the id of drinks you want to remove: ");
				itemNum = sc.nextInt();
				rt = drinksMenu[itemNum];
				for (int i = itemNum; i < drinksCnt; ++i)
					drinksMenu[i] = drinksMenu[i + 1];
				drinksCnt--;
				break;
			case "dessert":
				showDessert();
				System.out.println("Enter the id of dessert you want to remove: ");
				itemNum = sc.nextInt();
				rt = dessertMenu[itemNum];
				for (int i = itemNum; i < dessertCnt; ++i)
					dessertMenu[i] = dessertMenu[i + 1];
				dessertCnt--;
				break;
			default:
				System.out.println("No such type, please enter again.");
			}
		} while (!type.equals("maincourse") && !type.equals("drinks") && !type.equals("dessert"));

		return rt;
	}

	/**
	 * Display the item list
	 * @author HuTianrun
	 */
	public static void showItems() {
		System.out.println("\n\t\tThe main course list:");
		showMainCourse();
		System.out.println("\n\t\tThe drink list:");
		showDrinks();
		System.out.println("\n\t\tThe dessert list:");
		showDessert();
	}

	/**
	 * Display the main course list
	 * @author HuTianrun
	 */
	private static void showMainCourse() {
		for (int i = 0; i < mainCourseCnt; ++i)
			System.out.println(i + ":\t" + mainCourseMenu[i].getName() + "\n\tprice: " + mainCourseMenu[i].getPrice()
					+ "\n\ttype: " + mainCourseMenu[i].getDescription() + "\n");
	}

	/**
	 * Display the drinks list
	 * @author HuTianrun
	 */
	private static void showDrinks() {
		for (int i = 0; i < drinksCnt; ++i)
			System.out.println(i + ":\t" + drinksMenu[i].getName() + "\n\tprice: " + drinksMenu[i].getPrice()
					+ "\n\ttype: " + drinksMenu[i].getDescription() + "\n");
	}

	/**
	 * Display the dessert list
	 * @author HuTianrun
	 */
	private static void showDessert() {
		for (int i = 0; i < dessertCnt; ++i)
			System.out.println(i + ":\t" + dessertMenu[i].getName() + "\n\tprice: " + dessertMenu[i].getPrice()
					+ "\n\ttype: " + dessertMenu[i].getDescription() + "\n");
	}

	/**
	 * Get an item from menu
	 * @author HuTianrun
	 * @return Item
	 */
	public static Item getItem() {
		Scanner sc = new Scanner(System.in);
		int itemNum;
		Item rt = null;
		System.out.println("Enter the type of item you want to get(maincourse, drinks or dessert): ");
		String type;
		do {
			type = sc.next();
			switch (type) { // ** requires initialization of the item class **
			case "maincourse":
				showMainCourse();
				System.out.println("Enter the id of main course you want to get: ");
				itemNum = sc.nextInt();
				rt = mainCourseMenu[itemNum];
				break;
			case "drinks":
				showDrinks();
				System.out.println("Enter the id of drinks you want to get: ");
				itemNum = sc.nextInt();
				rt = drinksMenu[itemNum];
				break;
			case "dessert":
				showDessert();
				System.out.println("Enter the id of dessert you want to get: ");
				itemNum = sc.nextInt();
				rt = dessertMenu[itemNum];
				break;
			default:
				System.out.println("No such type, please enter again.");
			}
		} while (!type.equals("maincourse") && !type.equals("drinks") && !type.equals("dessert"));

		return rt;
	}

	/**
	 * Another get item method, used in reading the text file.
	 * @author HuTianrun
	 * @param i
	 * @param j
	 * @return Item
	 */
	public static Item getItem(int i, int j) {
		Item rt = null;
		switch (i) { // ** requires initialization of the item class **
		case 0:
			rt = mainCourseMenu[j];
			break;
		case 1:
			rt = drinksMenu[j];
			break;
		case 2:
			rt = dessertMenu[j];
			break;
		}
		return rt;
	}

	/**
	 * Read the item list that stored in text file. This method makes sure previous data can be gotten when we open the system.
	 * @author HuTianrun
	 * @throws IOException
	 */
	static void getItemList() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ItemMenu.txt"));
		try {
			String line = br.readLine();
			String name, pr;
			double price;
			String description;
			while (line != null) {
				switch (line) {
				case "MainCourse":
					line = br.readLine();
					while (!line.equals("Drink")) {
						name = line;
						pr = br.readLine();
						price = Double.parseDouble(pr);
						description = br.readLine();
						mainCourseMenu[mainCourseCnt++] = new MainCourse(name, description, price);
						line = br.readLine();
					}
					break;
				case "Drink":
					line = br.readLine();
					while (!line.equals("Dessert")) {
						name = line;
						pr = br.readLine();
						price = Double.parseDouble(pr);
						description = br.readLine();
						drinksMenu[drinksCnt++] = new Drinks(name, description, price);
						line = br.readLine();
					}
					break;
				case "Dessert":
					line = br.readLine();
					while (line != null) {
						name = line;
						pr = br.readLine();
						price = Double.parseDouble(pr);
						description = br.readLine();
						dessertMenu[dessertCnt++] = new Dessert(name, description, price);
						line = br.readLine();
					}
					break;
				}
			}
		} finally {
			br.close();
		}
	}

	/**
	 * Store the item list into text file. This method makes sure the data will not lost after close the system
	 * @author HuTianrun
	 * @throws IOException
	 */
	static void storeItemList() throws IOException {
		FileWriter writer = new FileWriter("ItemMenu.txt");
		writer.write("MainCourse\n");
		for (int i = 0; i < mainCourseCnt; ++i)
			writer.write(mainCourseMenu[i].getName() + "\n" + mainCourseMenu[i].getPrice() + "\n"
					+ mainCourseMenu[i].getDescription() + "\n");

		writer.write("Drink\n");
		for (int i = 0; i < drinksCnt; ++i)
			writer.write(drinksMenu[i].getName() + "\n" + drinksMenu[i].getPrice() + "\n"
					+ drinksMenu[i].getDescription() + "\n");

		writer.write("Dessert\n");
		for (int i = 0; i < dessertCnt; ++i)
			writer.write(dessertMenu[i].getName() + "\n" + dessertMenu[i].getPrice() + "\n"
					+ dessertMenu[i].getDescription() + "\n");
		writer.close();
	}

	/**
	 * This is an auxiliary method to store and get information from text file.
	 * @author HuTianrun
	 * @param item
	 * @return int
	 */
	static int getInfo(Item item) {
		switch (item.getType()) {
		case "Main Course":
			for (int i = 0; i < mainCourseCnt; ++i)
				if (item == mainCourseMenu[i])
					return i;
			break;
		case "Drinks":
			for (int i = 0; i < drinksCnt; ++i)
				if (item == drinksMenu[i])
					return i;
			break;
		case "Dessert":
			for (int i = 0; i < dessertCnt; ++i)
				if (item == dessertMenu[i])
					return i;
			break;
		}
		return -1;
	}
}
