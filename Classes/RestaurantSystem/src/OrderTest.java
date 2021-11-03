import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.*;

public class OrderTest {
    public static void main(String[] args) throws IOException {

        //ItemMenu.getItemList();
		//PackageMenu.getPacList();

        Table table = new Table();
        //Order O = new Order(2, "Ian", table);

        //OrderManager OM = new OrderManager(O);

       //OM.addItem();

       //OM.viewOrder();

        Reservation R = new Reservation(2, "Ian", table);
        ReservationManager RM = new ReservationManager(R);

        RM.addReservation();

    }


}
