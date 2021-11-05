import java.util.Scanner;

public class ReservationManager {

    private Reservation reservation;

    public ReservationManager(Reservation r) {
        this.reservation = r;
    }

    public void viewReservation() {
        System.out.println("=================================================");
        Timing time = reservation.getReserveDate();
        System.out.println(reservation.getCustName() + "'s reservation : ");
        System.out.println(time.getDate().toString());
        System.out.println(time.getTime());
        System.out.println("=================================================");

    }

    public Reservation addReservation(Timing date) {
        reservation.setReserveDate(date);
        return reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }

}
