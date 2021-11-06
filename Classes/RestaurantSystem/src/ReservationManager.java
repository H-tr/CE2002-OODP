public class ReservationManager {

    private Reservation reservation;

    public ReservationManager(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * Prints out information about the Reservation
     * @author Ian Chan
     */
    public void viewReservation() {
        System.out.println("=================================================");
        Timing time = reservation.getReserveDate();
        System.out.println(reservation.getCustName() + "'s reservation : ");
        System.out.println(time.getDate().toString());
        System.out.println(time.getTime());
        System.out.println("=================================================");

    }

    
    /** 
     * Gives timing to reservation class
     * @author Ian Chan
     * @param date
     * @return Reservation
     */
    public Reservation addReservation(Timing date) {
        reservation.setReserveDate(date);
        return reservation;
    }

    
    /** 
     * returns reservation
     * @author Ian Chan
     * @return Reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

}
