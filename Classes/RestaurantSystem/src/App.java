import java.util.Scanner;

public class App {
    public static void main(String[] args) 
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

        boolean exit = false;

        while(!exit)
        {
            System.out.println("Choose one of the 10 options: ");
            System.out.println("1. Create/Update/Remove menu item ");
            System.out.println("2. Create/Update/Remove promotion ");
            System.out.println("3. Create order ");
            System.out.println("4. View order ");
            System.out.println("5. Add/Remove order item/s to/from order ");
            System.out.println("6. Create reservation booking ");
            System.out.println("7. Check/Remove reservation booking ");
            System.out.println("8. Check table availability ");
            System.out.println("9. Print order invoice ");
            System.out.println("10. Print sale revenue report by period (eg day or month)");
            System.out.println("11. Exit System");
            

            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    //Create/Update/Remove menu item
                    break;

                case 2:
                    //Create/Update/Remove promotion
                    break;

                case 3:
                    //Create order
                    break;

                case 4:
                    //View order
                    break;

                case 5:
                    //Add/Remove order item/s to/from order
                    break;

                case 6:
                    //Create reservation booking
                    break;

                case 7:
                    //Check/Remove reservation booking
                    break;

                case 8:
                    //Check table availability
                    break;

                case 9:
                    //Print order invoice
                    break;

                case 10:
                    //Print sale revenue report by period (eg day or month)
                    break;

                case 11:
                    exit = true;        //Exit Switch Case
                    break;
            }

        }
    }
}
