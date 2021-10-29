import java.io.IOException;
import java.util.Scanner;

public class MenuManager {
    public static void main(String[] args) throws IOException {
		ItemMenu.getItemList();
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
			System.out.println("[7] store menu list");
			System.out.println("[8] get menu list");
			System.out.println("[9] package manage");
			System.out.println("[10] exit");
			System.out.printf("Please enter your choice: ");
			choice = sc.nextInt();

			switch (choice) {
				case 1:
					ItemMenu.addItem();
					break;
				case 2:
					ItemMenu.removeItem();
					break;
				case 3:
					ItemMenu.showItems();
					break;
				case 4:
					PackageMenu.addPackage();
					break;
				case 5:
					PackageMenu.removePackage();
					break;
				case 6:
					PackageMenu.showPackage();
					break;
				case 7:
					ItemMenu.storeItemList();
					break;
				case 8:
					ItemMenu.getItemList();
                    break;
				case 9:
					PackageMenu.packageManager();
			}
		} while (choice < 10);
		
		sc.close();
	}
}
