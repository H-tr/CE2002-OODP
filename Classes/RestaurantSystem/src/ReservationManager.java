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
        System.out.println(reservation.getReserveDate().getTime());
    }

    public Reservation addReservation()
    {
        int hour1 = 12;
        System.out.println("Input month: (0 = Jan, 11 = Dec) ");
        int month = sc.nextInt();
        System.out.println("Input date: ");
        int date = sc.nextInt();
        System.out.println("Input hour");
        int hour = sc.nextInt();
        boolean AM = false;
        if (hour > 12)
        {
            hour1 = hour - 12;
        }
        else
        {
            hour1 = hour;
            AM = true;
        }

        reservation.setReserveDate(month, date, hour1, AM);

        System.out.println(reservation.getReserveDate().getTime());

        return reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }
    
}
