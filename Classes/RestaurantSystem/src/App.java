import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);

        /*----------------------------- Getting info from Staff--------------------------------*/

        Restaurant restaurant = new Restaurant();


        System.out.println("Welcome to Restaurant Reservation and Point of Sale System (RRPSS)");
        System.out.println("Please input your staff ID: ");

        int staff_ID = sc.nextInt();

        //Check restaurant if there is a Staff with this ID?
        //If have: Retrieve information from restaurant
        //else: Get infor from user

        System.out.println("Please input your name and gender: ");
        
        String name = sc.next();
        String gender = sc.next();

        System.out.println("Please input your job title: ");

        String jobtitle =sc.next();
        
        Staff staff = new Staff(name, gender, staff_ID, jobtitle);

        //Add Staff to Restaurant

        /*----------------------------- Switch case for Functional Requirements--------------------------------*/

        int choice;

        do {
            System.out.println("Choose one of the 3 options: ");
            System.out.println("[1] Access menu item ");
            //System.out.println("2. Create/Update/Remove promotion ");
            System.out.println("[2] Manage the table in restaurant ");
            System.out.println("[3] Serve for customer ");

            System.out.println("Please enter your choice: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    MenuManager.menuManage();
                    break;
                case 2:
                    TableManager.tableManage();
                    break;
                case 3:
                    int ch;
                    System.out.println("[1] Create an order");
                    System.out.println("[2] Create a reservation");
                    System.out.println("[3] Remove a reservation");
                    System.out.println("[4] Finish an order");
                    System.out.println("Please enter your choice: ");
                    ch = sc.nextInt();
                    switch(ch){
                        case 1:
                            System.out.println("Do you have a reservation? [1]yes [2]no");
                            int hasRes = sc.nextInt();
                            switch(hasRes) {
                                case 1:
                                    // TODO in the restaurant, find out the corresponding reservation, check whether it is valid (the time). If valid, change that event from reservation to order, otherwise, return error message
                                    break;
                                case 2:
                                    //assign table first
                                    System.out.println("Please enter the number of people");
                                    int peopleNum = sc.nextInt();
                                    Calendar cal = Calendar.getInstance();
                                    cal.set(Calendar.HOUR_OF_DAY, 0);
                                    cal.set(Calendar.MINUTE, 0);
                                    cal.set(Calendar.SECOND, 0);
                                    cal.set(Calendar.MILLISECOND, 0);
                                    Date date = cal.getTime();
                                    System.out.println("Which meal? [1] breakfast [2] launch [3] dinner");
                                    ch = sc.nextInt();
                                    Timing time = null;
                                    Table table = null;
                                    switch (ch) {
                                        case 1:
                                            time = new Timing(date, Timing.MealTime.BREAKFAST);
                                            break;
                                        case 2:
                                            time = new Timing(date, Timing.MealTime.LAUNCH);
                                            break;
                                        case 3:
                                            time = new Timing(date, Timing.MealTime.DINNER);
                                    }
                                    if (time == null) {
                                        System.out.println("Error input");
                                        break;
                                    }
                                    else
                                        table = TableManager.assignTable(peopleNum, time);
                                    if (table == null) {
                                        System.out.println("There is no available table");
                                        break;
                                    }
                                    // TODO create the order in restaurant. Use the table(Table) and date(Timing)
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Please enter the number of people");
                            int peopleNum = sc.nextInt();
                            System.out.println("Please enter the year of reservation:");
                            int year = sc.nextInt();
                            System.out.println("Please enter the month of reservation:");
                            int month = sc.nextInt();
                            System.out.println("Please enter the day of reservation: ");
                            int day = sc.nextInt();
                            Calendar cal = Calendar.getInstance();
                            cal.set(year, month-1, day);
                            cal.set(Calendar.HOUR_OF_DAY, 0);
                            cal.set(Calendar.MINUTE, 0);
                            cal.set(Calendar.SECOND, 0);
                            cal.set(Calendar.MILLISECOND, 0);
                            Date date = cal.getTime();
                            System.out.println("Which meal? [1] breakfast [2] launch [3] dinner");
                            ch = sc.nextInt();
                            Timing time = null;
                            Table table = null;
                            switch (ch) {
                                case 1:
                                    time = new Timing(date, Timing.MealTime.BREAKFAST);
                                    break;
                                case 2:
                                    time = new Timing(date, Timing.MealTime.LAUNCH);
                                    break;
                                case 3:
                                    time = new Timing(date, Timing.MealTime.DINNER);
                            }
                            if (time == null) {
                                System.out.println("Error input");
                                break;
                            }
                            else
                                table = TableManager.assignTable(peopleNum, time);
                            if (table == null) {
                                System.out.println("There is no available table");
                                break;
                            }
                            // TODO create the reservation in restaurant. Use the table(Table) and date(Timing)
                            break;
                        case 3:
                            // TODO do it with restaurant
                            break;
                        case 4:
                            // TODO do it with restaurant, finish every work like print invoice
                    }
                    break;
            }

        } while (choice < 4);
    }

}
