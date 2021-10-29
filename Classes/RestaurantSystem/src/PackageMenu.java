import java.util.Scanner;

public class PackageMenu {
    private static final int maxPackageNum = 50; // max package menu size
    private static int pacCnt = 0; // used to point the first empty slot of the package menu
    private static Package[] packageMenu = new Package[maxPackageNum]; // package menu

    public static void addPackage() { // ** requires initialization of the package class **
		packageMenu[pacCnt++] = new Package();
	}

	public static Package removePackage() {
		Scanner sc = new Scanner(System.in);
		ItemMenu.showItems();
		System.out.println("Enter the number of package you want to remove: ");
		int packageNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Package rt = packageMenu[packageNum];
		for (int i = packageNum; i < pacCnt; ++i)
			packageMenu[i] = packageMenu[i + 1];

		pacCnt--;
		return rt;
	}

    public static void showPackage() {
		for (int i = 0; i < pacCnt; ++i)
			System.out.println(i + ":\t" + packageMenu[i].getDescription() + "\n\tprince: " + packageMenu[i].getPrice()
					+ "\n\titems: " + packageMenu[i].getItem());
	}

	public static Package getPackage() {
		Scanner sc = new Scanner(System.in);
		showPackage();
		System.out.println("Enter the id of package you want to get: ");
		int PackageID = sc.nextInt();
		return packageMenu[PackageID];
	}

	public static void packageManager() {
		Scanner sc = new Scanner(System.in);
		showPackage();
		System.out.println("Please enter the package you want to manage: ");
		int ch = sc.nextInt();
		Package temp = packageMenu[ch];
		do {
			System.out.println("[1] display items in the package");
			System.out.println("[2] add an item to package");
			System.out.println("[3] remove an item from package");
			System.out.println("[4] reset the description");
			System.out.println("[5] reset the price");
			System.out.println("[6] exit");
			switch (ch) {
				case 1:
					temp.displayPackage();
					break;
				case 2:
					temp.addItem();
					break;
				case 3:
					temp.removeItem();
					break;
				case 4:
					temp.setDescription();
					break;
				case 5:
					temp.setPrice();
					break;
			}
		} while (ch < 6);
	}

    public static void storePacList() {

    }

    public static void getPacList() {

    }
}
