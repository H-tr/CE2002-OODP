import java.util.*;
public class Menu {
	private static final int maxItemNum = 500; // max item menu size
	private static final int maxPackageNum = 50; // max package menu size

	private static Item[] itemMenu = new Item[maxItemNum]; // item menu
	private static Package[] packageMenu = new Package[maxPackageNum]; // package menu

	private static int itemcnt = 0; // used to point the first empty slot of item menu
	private static int paccnt = 0; // used to point the first empty slot of the package menu

	public static void addItem() {
        String type;
        Scanner sc = new Scanner(System.in);
		System.out.printf("The item types you can choose: maincourse, drinks and dessert.\n Please enter the type you want to choose: ");
		do {
			type = sc.next();
			switch (type) {	// ** requires initialization of the item class **
				case "maincourse":
					itemMenu[itemcnt++] = new MainCourse();
					break;
				case "drinks":
					itemMenu[itemcnt++] = new Drinks();
					break;
				case "dessert":
					itemMenu[itemcnt++] = new Dessert();
					break;
				default:
					System.out.println("No such type, please enter again.");
			}
		} while (!type.equals("maincourse") && !type.equals("drinks") && !type.equals("dessert"));
	}

	public static Item removeItem() { 
		Scanner sc = new Scanner(System.in);
		showItems();
		System.out.println("Enter the number of item you want to remove: ");
		int itemNum = sc.nextInt(); // itemNum is the index of item you want to remove in the list
		Item rt = itemMenu[itemNum];
		for (int i = itemNum; i < itemcnt; ++i)
			itemMenu[i] = itemMenu[i+1];
		
		itemcnt--;
		return rt;
	}
	
	public static void addPackage() {	// ** requires initialization of the package class **
		packageMenu[paccnt++] = new Package();
	}

	public static Package removePackage() {
		Scanner sc = new Scanner(System.in);
		showItems();
		System.out.println("Enter the number of package you want to remove: ");
		int packageNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Package rt = packageMenu[packageNum];
		for (int i = packageNum; i < paccnt; ++i)
			packageMenu[i] = packageMenu[i+1];
		
		paccnt--;
		return rt;
	}

	public static void showItems() {
		for (int i = 0; i < itemcnt; ++i)
			System.out.println(i + ":\t" + itemMenu[i].getName()
				+ "\n\tprince: " + itemMenu[i].getPrice()
				+ "\n\ttype: " + itemMenu[i].getType());
	}

	public static Item getItem(int itemID) {
		return itemMenu[itemID];
	}

	public static void showPackage() {
		for (int i = 0; i < paccnt; ++i)
			System.out.println(i + ":\t" + packageMenu[i].getDescriptions()
				+ ":\tprince: " + packageMenu[i].getPrice()
				+ ":\titems: " + packageMenu[i].getItem());
	}

	public static Package getPackage(int PackageID) {
		return packageMenu[PackageID];
	}
}