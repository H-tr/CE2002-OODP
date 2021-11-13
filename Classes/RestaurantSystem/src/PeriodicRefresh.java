
/**
     * PeriodicRefresh is the class that is responsible for running the cleanReservation() method every set interval time
     * It will take in the restaurant class as its attribute to be able to use the cleanReservation()
     * run() is what calls the cleanReservation() and adds the period interval
     * 
     * @author Ian Chan
     
*/

public class PeriodicRefresh extends Thread {

    private Restaurant restaurant;

    /** 
     * Constructor for PeriodicRefresh class
     */
    PeriodicRefresh(Restaurant restaurant)
    {
        this.restaurant = restaurant;
    }

    /** 
     * Method that runs in the background while the application is active
     * Method will call the cleanReservation function and then wait for 10min(600000ms) and then repeat
     */
    @Override
    public void run() {
        while (true) {
            restaurant.cleanReservation();
            try {
                Thread.sleep(600000);   //10min in ms period (600000)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
