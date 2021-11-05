import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class TableManager {

    private static final int tableNum = 50;

    private static Table[] tableList = new Table[tableNum];
    private static int tableCnt = 0;

    /**
     * @auther HuTianrun
     * @throws IOException
     */
    public static void tableManage() throws IOException {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("<<<<< TABLE MENU >>>>>");
            System.out.println("[1] display table list");
            System.out.println("[2] add table");
            System.out.println("[3] remove table");
            System.out.println("[4] save");
            System.out.println("[5] exit");

            System.out.println("Please enter your choice:");
            while (!sc.hasNextInt()) {
                System.out.println("ERROR: Please use integers only!");
                sc.next();
            }
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                displayTableList();
                break;
            case 2:
                System.out.println("Please enter the capacity: ");
                while (!sc.hasNextInt()) {
                    System.out.println("ERROR: Please use integers only!");
                    sc.next();
                }
                int capacity = sc.nextInt();
                addTable(capacity);
                break;
            case 3:
                removeTable();
                break;
            case 4:
                storeList();
                break;
            }
        } while (choice < 5);
    }

    public static void displayTableList() {
        for (int i = 0; i < tableCnt; ++i) {
            System.out.printf("Table " + i + ", Capacity: " + tableList[i].getSeatCapacity() + " Occupied time: ");
            tableList[i].displayOccupiedTime();
            System.out.printf("\n");
        }
    }

    /**
     * @auther HuTianrun
     * @param capacity
     * @return Table
     */
    public static Table addTable(int capacity) {
        Table temp = tableList[tableCnt++] = new Table(capacity);
        return temp;
    }

    public static void removeTable() {
        Scanner sc = new Scanner(System.in);
        displayTableList();
        System.out.println("Please enter the table you want to remove: ");
        while (!sc.hasNextInt()) {
            System.out.println("ERROR: Please use integers only!");
            sc.next();
        }
        int choice = sc.nextInt();
        if (choice < 0 || choice >= tableCnt) {
            System.out.println("Invalid enter");
            return;
        }
        for (int i = choice; i < tableCnt - 1; ++i)
            tableList[i] = tableList[i + 1];
        --tableCnt;
    }

    /**
     * @auther HuTianrun
     * @param peopleNum
     * @param time
     * @return Table
     */
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
        while (!sc.hasNextInt()) {
            System.out.println("ERROR: Please use integers only!");
            sc.next();
        }
        int id = sc.nextInt();
        if (!tableList[id].checkAvailable(peopleNum, time)) {
            System.out.println("Not valid id, please enter again: ");
            id = sc.nextInt();
        }
        tableList[id].addTimeOccupy(time);
        return tableList[id];
    }

    /**
     * @auther HuTianrun
     * @param table
     * @param time
     */
    public static void removeTime(Table table, Timing time) {
        table.removeTime(time);
    }

    /**
     * @auther HuTianrun
     * @throws IOException
     */
    public static void storeList() throws IOException {
        FileWriter writer = new FileWriter("Table.txt");
        for (int i = 0; i < tableCnt; ++i) {
            writer.write("Table\n");
            writer.write(tableList[i].getSeatCapacity() + "\n");
            writer.write(tableList[i].timingList());
        }
        writer.close();
    }

    /**
     * @auther HuTianrun
     * @throws IOException
     */
    public static void getList() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("Table.txt"));
        try {
            String line = br.readLine();
            Table temp = null;
            while (line != null) {
                if (line.equals("Table")) {
                    line = br.readLine();
                    temp = addTable(Integer.parseInt(line));
                    line = br.readLine();
                    while (line != null && !line.equals("Table")) {
                        String[] con = line.split(" ");
                        Calendar cal = Calendar.getInstance();
                        int year = Integer.parseInt(con[0]);
                        int month = Integer.parseInt(con[1]);
                        int day = Integer.parseInt(con[2]);
                        int ch = Integer.parseInt(con[3]);
                        cal.set(year, month - 1, day);
                        cal.set(Calendar.HOUR_OF_DAY, 0);
                        cal.set(Calendar.MINUTE, 0);
                        cal.set(Calendar.SECOND, 0);
                        cal.set(Calendar.MILLISECOND, 0);
                        Date date = cal.getTime();
                        Timing time = null;
                        switch (ch) {
                        case 1:
                            time = new Timing(date, Timing.MealTime.BREAKFAST);
                            break;
                        case 2:
                            time = new Timing(date, Timing.MealTime.LUNCH);
                            break;
                        case 3:
                            time = new Timing(date, Timing.MealTime.DINNER);
                        }
                        if (time == null) {
                            System.out.println("Error input");
                            return;
                        } else
                            temp.addTimeOccupy(time);
                        line = br.readLine();
                    }
                }
            }
        } finally {
            br.close();
        }
    }
}
