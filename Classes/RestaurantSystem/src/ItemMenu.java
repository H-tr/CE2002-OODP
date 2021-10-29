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

	public static void showItems() {
		System.out.println("\t\tThe main course list:");
		showMainCourse();
		System.out.println("\t\tThe drink list:");
		showDrinks();
		System.out.println("\t\tThe dessert list:");
		showDessert();
	}

	static void showMainCourse() {
		for (int i = 0; i < mainCourseCnt; ++i)
			System.out.println(i + ":\t" + mainCourseMenu[i].getName() + "\n\tprince: " + mainCourseMenu[i].getPrice()
					+ "\n\ttype: " + mainCourseMenu[i].getType());
	}

	private static void showDrinks() {
		for (int i = 0; i < drinksCnt; ++i)
			System.out.println(i + ":\t" + drinksMenu[i].getName() + "\n\tprince: " + drinksMenu[i].getPrice()
					+ "\n\ttype: " + drinksMenu[i].getType());
	}

	private static void showDessert() {
		for (int i = 0; i < dessertCnt; ++i)
			System.out.println(i + ":\t" + dessertMenu[i].getName() + "\n\tprince: " + dessertMenu[i].getPrice()
					+ "\n\ttype: " + dessertMenu[i].getType());
	}

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

	static void getItemList() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("ItemMenu.txt"));
		try {
			String line = br.readLine();
			String name, pr;
			double price;
			String description;
			while (line != null) {
				switch (line) {
				case "MainCourse" :
					line = br.readLine();
					if (!line.equals("Drink")) {
						name = line;
						pr = br.readLine();
						price = Double.parseDouble(pr);
						description = br.readLine();
						mainCourseMenu[mainCourseCnt++] = new MainCourse(name, description, price);
						line = br.readLine();
					}
					break;
				case "Drink" :
					line = br.readLine();
					if (!line.equals("Dessert")) {
						name = line;
						pr = br.readLine();
						price = Double.parseDouble(pr);
						description = br.readLine();
						drinksMenu[drinksCnt++] = new Drinks(name, description, price);
						line = br.readLine();
					}
					break;
				case "Dessert" :
					line = br.readLine();
					if (line != null) {
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

	static void storeItemList() throws IOException {
		FileWriter writer = new FileWriter("ItemMenu.txt");
		writer.write("MainCourse\n");
		for (int i = 0; i < mainCourseCnt; ++i)
			writer.write(mainCourseMenu[i].getName() + "\n" + mainCourseMenu[i].getPrice()
					+ "\n" + mainCourseMenu[i].getDescription() + "\n");

		writer.write("Drink\n");
		for (int i = 0; i < drinksCnt; ++i)
			writer.write(drinksMenu[i].getName() + "\n" + drinksMenu[i].getPrice()
					+ "\n" + drinksMenu[i].getDescription() + "\n");

		writer.write("Dessert\n");
		for (int i = 0; i < dessertCnt; ++i)
			writer.write(dessertMenu[i].getName() + "\n" + dessertMenu[i].getPrice()
					+ "\n" + dessertMenu[i].getDescription() + "\n");
		writer.close();
	}
}
