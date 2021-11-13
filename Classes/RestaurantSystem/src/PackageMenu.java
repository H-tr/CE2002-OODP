import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * PackageMenu contains all the package instances. 
 * It has a list of packages. It can add packages or remove packages from it. 
 * Customer would choose package from it.
 * @author Hu Tianrun
 */
public class PackageMenu {
	private static final int maxPackageNum = 50; // max package menu size
	private static int pacCnt = 0; // used to point the first empty slot of the package menu
	private static Package[] packageMenu = new Package[maxPackageNum]; // package menu

	/**
	 * This static class store a list of package. This method could add a new
	 * package to package list. It requires initialization of the package class
	 */
	public static void addPackage() { // ** requires initialization of the package class **
		Scanner sc = new Scanner(System.in);
		Package temp = packageMenu[pacCnt++] = new Package();
		System.out.println("Please enter the number of items: ");
		int num = sc.nextInt();
		for (int i = 0; i < num; ++i)
			temp.addItem();
	}

	/**
	 * Remove the package from package list
	 * @return Package
	 */
	public static Package removePackage() {
		Scanner sc = new Scanner(System.in);
		PackageMenu.showPackage();
		System.out.println("Enter the number of package you want to remove: ");
		int packageNum = sc.nextInt(); // packageNum is the index of package you want to remove in the list
		Package rt = packageMenu[packageNum];
		for (int i = packageNum; i < pacCnt; ++i)
			packageMenu[i] = packageMenu[i + 1];

		pacCnt--;
		return rt;
	}

	/**
	 * Display all the packages available
	 */
	public static void showPackage() {
		for (int i = 0; i < pacCnt; ++i)
			System.out.println(i + ":\t" + packageMenu[i].getDescription() + "\n\tprice: " + packageMenu[i].getPrice()
					+ "\n\titems: " + packageMenu[i].getItem());
	}

	/**
	 * User choose a package and return that package
	 * @return Package
	 */
	public static Package getPackage() {
		Scanner sc = new Scanner(System.in);
		showPackage();
		System.out.println("Enter the id of package you want to get: ");
		int PackageID = sc.nextInt();
		return packageMenu[PackageID];
	}

	/**
	 * The control method that manage a specific package in the package list
	 */
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
			System.out.println("Please enter your choice: ");
			ch = sc.nextInt();
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

	/**
	 * Store the package list into text file
	 * @throws IOException
	 */
	public static void storePacList() throws IOException {
		FileWriter writer = new FileWriter("PackageMenu.txt");
		for (int i = 0; i < pacCnt; ++i) {
			writer.write("Package\n");
			writer.write(packageMenu[i].getDescription() + "\n");
			writer.write(packageMenu[i].getPrice() + "\n");
			for (int j = 0; j < packageMenu[i].getItemCnt(); ++j) {
				writer.write(packageMenu[i].getInfo(j) + " " + ItemMenu.getInfo(packageMenu[i].getItem(j)) + "\n");
			}
		}
		writer.close();
	}

	/**
	 * Read the package list from text file to the array list in class
	 * @throws IOException
	 */
	public static void getPacList() throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("PackageMenu.txt"));
		try {
			String line = br.readLine();
			String pr;
			double price;
			String description;
			while (line != null) {
				description = br.readLine();
				pr = br.readLine();
				price = Double.parseDouble(pr);
				Package temp = packageMenu[pacCnt++] = new Package(description, price);
				line = br.readLine();
				while (line != null && !line.equals("Package")) {
					String[] parts = line.split(" ");
					int i = Integer.parseInt(parts[0]);
					int j = Integer.parseInt(parts[1]);
					temp.addItem(i, j);
					line = br.readLine();
				}
				;
			}
		} finally {
			br.close();
		}
	}
}
