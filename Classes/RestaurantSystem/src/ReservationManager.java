import java.util.Scanner;

public class ReservationManager {
    Scanner sc = new Scanner(System.in);

    private Reservation reservation;
    
    public ReservationManager(Reservation r)
    {
        this.reservation = r;
    }

    public void viewReservation()
    {
        System.out.println(reservation.getReserveDate().toString());
    }

    public Reservation addReservation(Timing date)
    {
        reservation.setReserveDate(date);
        return reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }
    
}
