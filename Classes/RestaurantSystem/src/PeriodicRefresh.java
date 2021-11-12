import javax.swing.JFrame;

/**
     * App is the user interface for staff to use. It is divided into three parts:
     * restaurant management, customer service, and display revenue report.
     * Considering if a staff login this system, he can choose manage the restaurant
     * resources, serve customer, or display revenue. If he manage the resources, he
     * can handle menu and restaurant. If he serve the customer, he can create an
     * order, reservation, terminal the order, cancel the reservation or so on.
     * 
     * @author Ian Chan
     * @author Hu Tianrun
     * @author Chiam Chuen
     * @param args
     
*/

public class PeriodicRefresh extends Thread {

    private Restaurant restaurant;

    PeriodicRefresh(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        while (true) {
            restaurant.cleanReservation();
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
