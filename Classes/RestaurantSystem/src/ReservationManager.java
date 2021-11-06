public class ReservationManager {

    private Reservation reservation;

    public ReservationManager(Reservation reservation) {
        this.reservation = reservation;
    }

    /**
     * @author Ian Chan
     * @author Chiam Chuen
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
     * @author Ian Chan
     * @author Ciam Chuen
     * @param date
     * @return Reservation
     */
    public Reservation addReservation(Timing date) {
        reservation.setReserveDate(date);
        return reservation;
    }

    
    /** 
     * @author Ian Chan
     * @return Reservation
     */
    public Reservation getReservation() {
        return reservation;
    }

}
