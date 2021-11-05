import java.io.IOException;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException, ParseException {
        Scanner sc = new Scanner(System.in);

        /*----------------------------- Getting info from Staff--------------------------------*/

        Restaurant restaurant = new Restaurant();
        restaurant.cleanReservation();

        System.out.println("Welcome to Restaurant Reservation and Point of Sale System (RRPSS)");
        System.out.println("Please input your staff ID (integers only): ");
        int staff_ID;
        while (!sc.hasNextInt()) {
            System.out.println("Please reenter your ID using integers ONLY");
            sc.next();
        }
        staff_ID = sc.nextInt();

        // Check restaurant if there is a Staff with this ID?
        // If have: Retrieve information from restaurant
        // else: Get infor from user

        System.out.println("Please input your name and gender: ");

        String name = sc.next();
        String gender = sc.next();

        System.out.println("Please input your job title: ");

        String jobtitle = sc.next();

        Staff staff = new Staff(name, gender, staff_ID, jobtitle);
        TableManager.getList();

        // Add Staff to Restaurant

        /*----------------------------- Switch case for Functional Requirements--------------------------------*/

        int choice;

        do {
            System.out.println("<<<<< MAIN MENU >>>>>");
            System.out.println("Choose one of the 3 options: ");
            System.out.println("[1] Access menu item ");
            System.out.println("[2] Manage the table in restaurant ");
            System.out.println("[3] Serve the customer ");
            System.out.println("[4] Revenue report");

            System.out.println("Please enter your choice: ");
            while (!sc.hasNextInt()) { // Error checking for wrong input field: INTEGER
                System.out.println("ERROR: Please use integers only!");
                sc.next();
            }
            choice = sc.nextInt();
            while (!(choice > 0 && choice < 5)) {
                System.out.println("Please reenter your choice");
                choice = sc.nextInt();
            }

            switch (choice) {
            case 1:
                MenuManager.menuManage();
                break;
            case 2:
                TableManager.tableManage();
                break;
            case 3:
                int ch;
                System.out.println("<<<<< SERVICE MENU >>>>>");
                System.out.println("[1] Create an order");
                System.out.println("[2] Create a reservation");
                System.out.println("[3] Remove a reservation");
                System.out.println("[4] Finish an order");
                System.out.println("[5] View reservations");
                System.out.println("[6] View orders");
                System.out.println("[7] edit reservation");
                System.out.println("[8] edit orders");
                System.out.println("[9] Remove past reservations");
                System.out.println("[10] Exit");
                System.out.println("Please enter your choice: ");
                while (!sc.hasNextInt()) {
                    System.out.println("ERROR: Please use integers only!");
                    sc.next();
                }
                ch = sc.nextInt();
                switch (ch) {
                case 1:
                    System.out.println("Do you have a reservation? [1]yes [2]no");
                    while (!sc.hasNextInt()) {
                        System.out.println("ERROR: Please use integers only!");
                        sc.next();
                    }
                    int hasRes = sc.nextInt();
                    switch (hasRes) {
                    case 1:
                        // DONE in the restaurant, find out the corresponding reservation, check whether
                        // it is valid (the time). If valid, change that event from reservation to
                        // order, otherwise, return error message
                        Event reservation = restaurant.searchReservation();
                        if (reservation == null) {
                            System.out.println("ERROR: No reservation was made under this name.");
                            break;
                        }
                        if (!restaurant.checkCurrentDate(reservation)) // Check if reservation for today
                        {
                            System.out.println("ERROR: This reservation is not for today!");
                            break;
                        } else {
                            restaurant.deleteReservation(reservation);
                            // DONE Reservation found and take the order
                            restaurant.createOrder_reserved(reservation, staff);

                        }
                        break;
                    case 2:
                        restaurant.createOrder_unreserved(staff);
                        // DONE create the order in restaurant. Use the table(Table) and date(Timing)
                        break;
                    }
                    break;
                case 2:
                    // DONE create the reservation in restaurant. Use the table(Table) and
                    // time(Timing)
                    restaurant.createReservation();
                    break;
                case 3:
                    Event reservation = restaurant.searchReservation();
                    restaurant.deleteReservation(reservation);
                    // DONE do it with restaurant
                    break;
                case 4:
                    Event order = restaurant.searchOrder();
                    if (order == null) {
                        System.out.println("=====Unable to find order!=====");
                        break;
                    }
                    restaurant.finaliseOrder(order, staff);
                    restaurant.deleteOrder(order);
                    break;
                case 5:
                    restaurant.printReservations();
                    break;
                case 6:
                    restaurant.printOrders();
                    break;

                case 7: // edit reservation
                    Event reservation_1 = restaurant.searchReservation();
                    if (reservation_1 == null) {
                        System.out.println("ERROR: No Reservation under this name was found.");
                        break;
                    }
                    restaurant.editReservation(reservation_1);
                    break;

                case 8: // edit Order
                    Event reservation_2 = restaurant.searchOrder();
                    if (reservation_2 == null) {
                        System.out.println("No Order under this name was found.");
                        break;
                    }
                    restaurant.editOrder(reservation_2);
                    break;

                case 9: // Remove past reservations that is past today
                    restaurant.cleanReservation();
                    break;

                default:
                    System.out.println("Exiting Service Page...");
                    break;

                }
                break;

            case 4:
                // Retrieve Orders from Revenue report
                // Display individual sale items
                // Total revenue
                restaurant.revenueReport();
                break;

            }

        } while (choice < 5);
    }

}
