import java.util.*;

public class Menu {
	private static final int maxItemNum = 500; // max item menu size
	private static final int maxPackageNum = 50; // max package menu size

	private static Item[] mainCourseMenu = new Item[maxItemNum]; // main course menu
	private static Item[] drinksMenu = new Item[maxItemNum]; // drinks menu
	private static Item[] dessertMenu = new Item[maxItemNum]; // dessert menu
	private static Package[] packageMenu = new Package[maxPackageNum]; // package menu

	private static int mainCourseCnt = 0; // used to point the first empty slot of item menu
	private static int drinksCnt = 0; // used to point the first empty slot of item menu
	private static int dessertCnt = 0; // used to point the first empty slot of item menu
	private static int pacCnt = 0; // used to point the first empty slot of the package menu

	public static void menu_interface() {
		System.out.println("Create a menu.");
		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("[1] add an item to the menu");
			System.out.println("[2] remove an item");
			System.out.println("[3] display the items");
			System.out.println("[4] add a package");
			System.out.println("[5] remove a package");
			System.out.println("[6] diaplay the packages");
			System.out.println("[7] exit");
			System.out.printf("Please enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					addItem();
					break;
				case 2:
					removeItem();
					break;
				case 3:
					showItems();
					break;
				case 4:
					addPackage();
					break;
				case 5:
					removePackage();
					break;
				case 6:
					showPackage();
					break;
			}
		} while (choice < 7);
		
		sc.close();
	}

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
				name = sc.next();
				System.out.println("Please enter description of this item:");
				description = sc.next();
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

	public static void addPackage() { // ** requires initialization of the package class **
		showItems();
		packageMenu[pacCnt++] = new Package();
	}

	public static Package removePackage() {
		Scanner sc = new Scanner(System.in);
		showItems();
		System.out.println("Enter the number of package you want to remove: ");
		int packageNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Package rt = packageMenu[packageNum];
		for (int i = packageNum; i < pacCnt; ++i)
			packageMenu[i] = packageMenu[i + 1];

		pacCnt--;
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

	private static void showMainCourse() {
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

	public static void showPackage() {
		for (int i = 0; i < pacCnt; ++i)
			System.out.println(i + ":\t" + packageMenu[i].getDescription() + ":\tprince: " + packageMenu[i].getPrice()
					+ ":\titems: " + packageMenu[i].getItem());
	}

	public static Package getPackage() {
		Scanner sc = new Scanner(System.in);
		showPackage();
		System.out.println("Enter the id of package you want to get: ");
		int PackageID = sc.nextInt();
		return packageMenu[PackageID];
	}
}
