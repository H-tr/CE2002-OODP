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

	public void createOrder_reserved(Event reservation)
	{

	}

	public void createOrder_unreserved() throws IOException
	{
		int ch;
		System.out.println("Input Customer's Name: ");
		String custName = sc.next();
		System.out.println("Please enter the number of people");
		int peopleNum = sc.nextInt();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
		System.out.println("Which meal? [1] breakfast [2] launch [3] dinner");
		ch = sc.nextInt();
		Timing time = null;
		Table table = null;
		switch (ch) {
			case 1:
				time = new Timing(date, Timing.MealTime.BREAKFAST);
				break;
			case 2:
				time = new Timing(date, Timing.MealTime.LAUNCH);
				break;
			case 3:
				time = new Timing(date, Timing.MealTime.DINNER);
		}
		if (time == null) {
			System.out.println("Error input");
			return;
		}
		else
			table = TableManager.assignTable(peopleNum, time);
		if (table == null) {
			System.out.println("There is no available table");
			return;
		}
		
		Order O = new Order(peopleNum, custName, table);
		OrderManager OM = new OrderManager(O);

		OM.addToOrder();

		OM.viewOrder();
		events[eventCounter] = OM.getOrder();
		eventCounter++;

		return;
	}

	public void createReservation()
	{
		int ch;
		System.out.println("Please enter the number of people");
		int peopleNum = sc.nextInt();
		System.out.println("Please enter the year of reservation:");
		int year = sc.nextInt();
		System.out.println("Please enter the month of reservation:");
		int month = sc.nextInt();
		System.out.println("Please enter the day of reservation: ");
		int day = sc.nextInt();
		System.out.println("Input Customer's Name: ");
		String custName = sc.next();
		Calendar cal = Calendar.getInstance();
		cal.set(year, month-1, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
		System.out.println("Which meal? [1] breakfast [2] launch [3] dinner");
		ch = sc.nextInt();
		Timing time = null;
		Table table = null;
		switch (ch) {
			case 1:
				time = new Timing(date, Timing.MealTime.BREAKFAST);
				break;
			case 2:
				time = new Timing(date, Timing.MealTime.LAUNCH);
				break;
			case 3:
				time = new Timing(date, Timing.MealTime.DINNER);
		}
		if (time == null) {
			System.out.println("Error input");
			return;
		}
		else
			table = TableManager.assignTable(peopleNum, time);
		if (table == null) {
			System.out.println("There is no available table");
			return;
		}

		Reservation R = new Reservation(peopleNum, custName, table);
		ReservationManager RM = new ReservationManager(R);
		RM.addReservation(time);


		events[eventCounter] = RM.getReservation();
		eventCounter++;
		return;

	}
	

	public Event searchReservation()
	{
		System.out.println("Please enter your name: ");
		String custName = sc.next();
		Event target = null;
		int u;
		for (u=0; u<=eventCounter; u++)
		{
			if (events[u].returnType() == "Reservation")
			{
				if (events[u].getCustName() == custName)
				{
					Reservation r = (Reservation) events[u];
					ReservationManager RM = new ReservationManager(r);
					target = events[u];
					RM.viewReservation();
				}
			}
		}
		return target;
		
	}

	public void deleteReservation(Event event)
	{
		int u;
		for (u = 0; u<=eventCounter; u++)
		{
			if (events[u].returnType() == "Reservation")
			{
				if (events[u].getCustName() == event.getCustName())
				{
					break;
				}
			}
		}
		if (u==eventCounter)
		{
			System.out.println("There is not such reservation!");
		}
		for ( int j = u ; j< eventCounter; j++)
		{
			events[u] = events[u+1];
		}
		eventCounter--;
		System.out.println("Reservation has been deleted!");
	}

	//public Event editOrder()
	//{
		
	//}

	//public Event editReservation()
	//{

	//}

}
