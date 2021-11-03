import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.naming.spi.ResolveResult;


public class Restaurant {

	private final int maxEventNum = 500;
	private int eventCounter = 0;

	private Event[] events = new Event[maxEventNum];
	Scanner sc = new Scanner(System.in);

	public Event createOrder() throws IOException
	{

		System.out.println("Input PAX: ");
		int pax = sc.nextInt();
		System.out.println("Input Customer's Name: ");
		String custName = sc.next();
		
		Table table = new Table();
		//Get Table reference



		Order O = new Order(pax, custName, table);
		OrderManager OM = new OrderManager(O);

		OM.addToOrder();

		OM.viewOrder();
		events[eventCounter] = OM.getOrder();

		return OM.getOrder();
	}

	public Event createReservation()
	{
		System.out.println("Input PAX: ");
		int pax = sc.nextInt();
		System.out.println("Input Customer's Name: ");
		String custName = sc.next();

		Table table = new Table();
		//Get Table reference



		Reservation R = new Reservation(pax, custName, table);
		ReservationManager RM = new ReservationManager(R);
		RM.addReservation();


		return RM.getReservation();

	}

	//public Event searchEvent(Table table)
	//{

	//}

	//public Event editOrder()
	//{
		
	//}

	//public Event editReservation()
	//{

	//}

}
