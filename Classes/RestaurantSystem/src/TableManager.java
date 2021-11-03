import java.util.Scanner;

public class TableManager {

    private static final int tableNum = 50;

    private static Table[] tableList = new Table[tableNum];
    private static int tableCnt = 0;

    public static void tableManage() {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("[1] display table list");
            System.out.println("[2] add table");
            System.out.println("[3] remove table");
            System.out.println("[4] exit");

            System.out.println("Please enter your choice:");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    displayTableList();
                    break;
                case 2:
                    System.out.println("Please enter the capacity: ");
                    int capacity = sc.nextInt();
                    addTable(capacity);
                    break;
                case 3:
                    removeTable();
                    break;
            }
        } while (choice < 4);
    }

    public static void displayTableList() {
        for (int i = 0; i < tableCnt; ++i) {
            System.out.printf("Table " + i + ", Capacity: " + tableList[i].getSeatCapacity() + " Occupied time: ");
            tableList[i].displayOccupiedTime();
            System.out.printf("\n");
        }
    }

    public static void addTable(int capacity) {
        tableList[tableCnt++] = new Table(capacity);
    }

    public static void removeTable() {
        Scanner sc = new Scanner(System.in);
        displayTableList();
        System.out.println("Please enter the table you want to remove: ");
        int choice = sc.nextInt();
        for (int i = choice; i < tableCnt - 1; ++i)
            tableList[i] = tableList[i + 1];
        --tableCnt;
    }

    public static Table assignTable(int peopleNum, Timing time) {
        Scanner sc = new Scanner(System.in);
        boolean valid = false;
        System.out.println("The available table id: ");
        for (int i = 0; i < tableCnt; ++i) {
            if (tableList[i].checkAvailable(peopleNum, time)) {
                valid = true;
                System.out.println(i + " ");
            }
        }
        if (!valid)
            return null;

        System.out.println("Please choose the table you want: ");
        int id = sc.nextInt();
        if (!tableList[id].checkAvailable(peopleNum, time)) {
            System.out.println("Not valid id, please enter again: ");
            id = sc.nextInt();
        }
        tableList[id].addTimeOccupy(time);
        return tableList[id];
    }
}
