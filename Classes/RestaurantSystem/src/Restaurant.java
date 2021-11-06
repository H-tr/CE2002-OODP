import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Restaurant {

	private final int maxEventNum = 500;
	private int eventCounter = 0;

	private Event[] events = new Event[maxEventNum];

	Scanner sc = new Scanner(System.in);

	
	/** 
	 * @author Ian Chan
	 * @param reservation
	 * @param staff
	 * @throws IOException
	 */
	public void createOrder_reserved(Event reservation, Staff staff) throws IOException {
		String custName = reservation.getCustName();
		int pax = reservation.getPax();
		Table table = reservation.getTable();

		Reservation r = (Reservation) reservation;

		Order O = new Order(pax, custName, table);
		O.setStaff(staff);
		O.setOrderedTime(r.getReserveDate());
		OrderManager OM = new OrderManager(O);

		OM.addToOrder();

		OM.viewOrder();
		events[eventCounter] = OM.getOrder();
		eventCounter++;
		return;

	}

	
	/** 
	 * @author Ian Chan
	 * @author HuTianrun
	 * @author Chiam Chuen
	 * @param staff
	 * @throws IOException
	 */
	public void createOrder_unreserved(Staff staff) throws IOException {
		int ch;
		System.out.println("Input Customer's Name: ");
		String custName = sc.next();
		System.out.println("Please enter the number of people:");
		int peopleNum = sc.nextInt();
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
		System.out.println("Which meal? [1] breakfast [2] lunch [3] dinner");
		ch = sc.nextInt();
		Timing time = null;
		Table table = null;
		switch (ch) {
		case 1:
			time = new Timing(date, Timing.MealTime.BREAKFAST);
			break;
		case 2:
			time = new Timing(date, Timing.MealTime.LUNCH);
			break;
		case 3:
			time = new Timing(date, Timing.MealTime.DINNER);
		}
		if (time == null) {
			System.out.println("Error input");
			return;
		} else
			table = TableManager.assignTable(peopleNum, time);
		if (table == null) {
			System.out.println("ERROR: There is no available table");
			return;
		}

		Order O = new Order(peopleNum, custName, table);
		O.setStaff(staff);
		O.setOrderedTime(time);
		OrderManager OM = new OrderManager(O);

		OM.addToOrder();

		OM.viewOrder();
		events[eventCounter] = OM.getOrder();
		eventCounter++;

		return;
	}

	/**
	 * @author Ian Chan
	 * @author HuTianrun
	 * @author Chiam Chuen
	 */
	public void createReservation() {
		int ch;
		System.out.println("Please enter the number of people:");
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
		cal.set(year, month - 1, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();

		if (checkExpiry(date)) {
			System.out.println("ERROR: input a date that is after today");
			return;
		}

		System.out.println("Which meal? [1] breakfast [2] lunch [3] dinner");
		ch = sc.nextInt();
		Timing time = null;
		Table table = null;
		switch (ch) {
		case 1:
			time = new Timing(date, Timing.MealTime.BREAKFAST);
			break;
		case 2:
			time = new Timing(date, Timing.MealTime.LUNCH);
			break;
		case 3:
			time = new Timing(date, Timing.MealTime.DINNER);
		}
		if (time == null) {
			System.out.println("Error input");
			return;
		} else
			table = TableManager.assignTable(peopleNum, time);
		if (table == null) {
			System.out.println("ERROR: There is no available table");
			return;
		}

		Reservation R = new Reservation(peopleNum, custName, table);
		ReservationManager RM = new ReservationManager(R);
		RM.addReservation(time);

		events[eventCounter] = RM.getReservation();

		eventCounter++;
		return;

	}

	/**
	 * @author Ian Chan
	 * @author Chiam Chuen
	 */
	public void printReservations() {
		int u;
		int counter = 1;
		boolean check = false;
		for (u = 0; u < eventCounter; u++) {
			if (events[u].returnType() == "Reservation") {
				check = true;
				System.out.println("Reservation " + counter + " :");
				Reservation r = (Reservation) events[u];
				ReservationManager RM = new ReservationManager(r);
				RM.viewReservation();
				counter++;
			}
		}

		if (!check) {
			System.out.println("=====No reservations found=====");
		}
		return;
	}

	/**
	 * @author Ian Chan
	 * @author Chiam Chuen
	 */
	public void printOrders() {
		int u;
		int counter = 1;
		boolean check = false;
		for (u = 0; u < eventCounter; u++) {
			if (events[u].returnType().equals("Order")) {
				check = true;
				System.out.println("============================");
				System.out.println("Order " + counter + " :");
				System.out.println("Customer Name: " + events[u].getCustName());
				Order o = (Order) events[u];
				OrderManager OM = new OrderManager(o);
				OM.viewOrder();
				counter++;
				System.out.println("============================");
			}
		}

		if (!check) {
			System.out.println("======No orders found======");
		}
	}

	
	/** 
	 * @author Chiam Chuen
	 * @author Ian Chan
	 * @return Event
	 */
	public Event searchReservation() {
		System.out.println("Please enter your name: ");
		String custName = sc.next();
		Event target = null;
		int u;
		for (u = 0; u < eventCounter; u++) {

			if (events[u].returnType() == "Reservation") {
				if (events[u].getCustName().equals(custName)) {
					Reservation r = (Reservation) events[u];
					ReservationManager RM = new ReservationManager(r);
					target = events[u];
					RM.viewReservation();
				}
			}
		}

		return target;

	}

	
	/** 
	 * @author Chiam Chuen
	 * @author Ian Chan
	 * @return Event
	 */
	public Event searchOrder() {
		System.out.println("Please enter your name: ");
		String custName = sc.next();
		Event target = null;
		int u;
		for (u = 0; u < eventCounter; u++) {

			if (events[u].returnType() == "Order") {
				if (events[u].getCustName().equals(custName)) {
					Order r = (Order) events[u];
					OrderManager OM = new OrderManager(r);
					target = events[u];
					OM.viewOrder();
				}
			}
		}

		return target;

	}

	
	/** 
	 * @author Chiam Chuen
	 * @author Ian Chan
	 * @param event
	 */
	public void deleteReservation(Event event) {
		Event track = null;
		if (event == null) {
			System.out.println("ERROR: There is no such reservation!");
			return;
		}
		int u;
		for (u = 0; u < eventCounter; u++) {
			if (events[u].returnType() == "Reservation") {
				if (events[u].getCustName().equals(event.getCustName())) {
					Reservation R = (Reservation) events[u];
					TableManager.removeTime(R.getTable(), R.getReserveDate());
					track = events[u];
					break;
				}
			}
		}
		if (u == eventCounter) {
			System.out.println("ERROR: There is not such reservation!");
			return;
		}
		for (int j = u; j < eventCounter; j++) {
			events[u] = events[u + 1];
		}
		eventCounter--;

		System.out.println("Reservation for " + track.getCustName() + " has been deleted!");
	}

	
	/** 
	 * @author Chiam Chuen
	 * @author Ian Chan
	 * @param event
	 */
	public void deleteOrder(Event event) {
		Event track = null;
		if (event == null) {
			System.out.println("ERROR: There is no such Order!");
			return;
		}
		int u;
		for (u = 0; u < eventCounter; u++) {
			if (events[u].returnType() == "Order") {
				if (events[u].getCustName().equals(event.getCustName())) {
					Order O = (Order) events[u];
					TableManager.removeTime(O.getTable(), O.getOrderedTime());
					track = events[u];
					track = events[u];
					break;
				}
			}
		}
		if (u == eventCounter) {
			System.out.println("ERROR: There is no such Order!");
		}
		for (int j = u; j < eventCounter; j++) {
			events[u] = events[u + 1];
		}
		eventCounter--;

		System.out.println("Order for " + track.getCustName() + " has been deleted!");
	}

	
	/** 
	 * @author Chiam Chuen
	 * @author Ian Chan
	 * @param Order
	 * @throws IOException
	 */
	public void editOrder(Event Order) throws IOException {
		Order o = (Order) Order;
		OrderManager OM = new OrderManager(o);

		boolean exit = false;
		while (!exit) {
			System.out.println("What would you like to edit?");
			System.out.println("[1] Remove Item");
			System.out.println("[2] Remove Package");
			System.out.println("[3] Add Order");
			System.out.println("[4] Add Package");
			System.out.println("[5] Exit");
			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				OM.removeItem();
				break;
			case 2:
				OM.removePackage();
				break;
			case 3:
				OM.addToOrder();
				break;
			case 4:
				OM.addPackage();
				break;
			default:
				return;
			}
		}
		return;

	}

	
	/** 
	 * @author Ian Chan
	 * @author Chiam Chuen
	 * @param date
	 * @return boolean
	 */
	public boolean checkExpiry(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date cur_date = cal.getTime();
		return date.before(cur_date);
	}

	
	/** 
	 * @author Ian Chan
	 * @author Chiam Chuen
	 * @param event
	 * @return boolean
	 */
	public boolean checkCurrentDate(Event event) {

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date cur_date = cal.getTime();

		Reservation r = (Reservation) event;
		Date date = r.getReserveDate().getDate();

		if (!date.before(cur_date)) {
			if (!date.after(cur_date)) {
				return true;
			}
		}
		return false;
	}

	
	/** 
	 * @author Ian Chan
	 * @author Chiam Chuen
	 * @param reservation
	 */
	public void editReservation(Event reservation) {
		Timing time = null;
		int ch;
		Reservation r = (Reservation) reservation;
		ReservationManager RM = new ReservationManager(r);

		System.out.println("Edit the details: ");

		System.out.println("Please enter the year of reservation:");
		int year = sc.nextInt();
		System.out.println("Please enter the month of reservation:");
		int month = sc.nextInt();
		System.out.println("Please enter the day of reservation: ");
		int day = sc.nextInt();
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();

		if (checkExpiry(date)) {
			System.out.println("ERROR: Input a date that is after today");
			return;
		}

		System.out.println("Which meal? [1] breakfast [2] lunch [3] dinner");
		ch = sc.nextInt();
		switch (ch) {
		case 1:
			time = new Timing(date, Timing.MealTime.BREAKFAST);
			break;
		case 2:
			time = new Timing(date, Timing.MealTime.LUNCH);
			break;
		case 3:
			time = new Timing(date, Timing.MealTime.DINNER);
		}

		RM.addReservation(time);

		System.out.println("New details: ");
		RM.viewReservation();
	}

	
	/** 
	 * @author Ian Chan
	 * @author Chiam Chuen
	 * @param order
	 * @param staff
	 * @throws IOException
	 */
	public void finaliseOrder(Event order, Staff staff) throws IOException {
		Order O = (Order) order;
		OrderManager OM = new OrderManager(O);
		boolean isMember = false;

		System.out.println("Are you a member? [1] Yes  [2] No ");
		int choice = sc.nextInt();
		if (choice == 1) {
			isMember = true;
		}
		String total;
		total = OM.printOrderInvoice(isMember, staff);
		OM.saveOrder(total);
	}

	/**
	 * @author Ian Chan
	 * @author Chiam Chuen
	 */
	public void cleanReservation() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date cur_date = cal.getTime();

		int u;
		for (u = 0; u < eventCounter; u++) {
			if (events[u].returnType() == "Reservation") {
				Reservation r = (Reservation) events[u];
				Date date = r.getReserveDate().date;
				if (date.before(cur_date)) {
					deleteReservation(events[u]);
				}
			}
		}
	}

	
	/** 
	 * @author Chiam Chuen
	 * @throws ParseException
	 * @throws IOException
	 */
	public void revenueReport() throws ParseException, IOException {

		Date start, end;
		String strStart, strEnd;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Enter the START date and time (yyyy-mm-dd hh:mm:ss): ");
		strStart = sc.next();
		strStart = strStart + " " + sc.next();
		System.out.println("Enter the END date and time (yyyy-mm-dd hh:mm:ss): ");
		strEnd = sc.next();
		strEnd = strEnd + " " + sc.next();
		start = dateFormat.parse(strStart);
		end = dateFormat.parse(strEnd);
		String[] report = new String[3];
		BufferedReader br = new BufferedReader(new FileReader("Orders.txt"));
		try {
			String line = br.readLine();
			Date date;
			int num;
			String stuff = "";
			double price = 0.00;
			int index = 0;
			int tempIndex = 0;
			String[] stuffArray = new String[100];
			int[] stuffCountArray = new int[100];
			while (line != null) {
				date = dateFormat.parse(line);
				if (date.before(end) && date.after(start)) {
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					num = Integer.parseInt(line);
					while (num != 0) {
						line = br.readLine();
						if (!Arrays.stream(stuffArray).anyMatch(line::equals)) {
							stuffArray[index] = line;
							stuffCountArray[index] = 1;
							index++;
						} else {
							tempIndex = 0;
							while (!stuffArray[tempIndex].equals(line)) {
								tempIndex++;
							}
							if (tempIndex != 100) {
								stuffCountArray[tempIndex] += 1;
							}
						}
						num--;
					}
					line = br.readLine();
					if (line != null) {
						price += Double.parseDouble(line);
					}
				} else {
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					line = br.readLine();
					num = Integer.parseInt(line);
					while (num != 0) {
						line = br.readLine();
						num--;
					}
					line = br.readLine();
				}
				line = br.readLine();
			}
			if (index != 0) {
				for (int i = 0; i < index; i++) {
					stuff = stuff + stuffArray[i] + "\n" + " Amount Sold: " + stuffCountArray[i] + "\n";
				}
			} else {
				stuff = "No items sold during this period!";
			}
			String strStart1 = dateFormat.format(start);
			String strEnd1 = dateFormat.format(end);
			report[0] = strStart1 + " to " + strEnd1;
			report[1] = stuff;
			String totalPrice = String.valueOf(price);
			report[2] = totalPrice;
		} finally {
			br.close();
		}
		System.out.println("==============Revenue Report==============");
		for (int i = 0; i < 3; i++) {
			System.out.println(report[i]);
			System.out.println("==========================================");
		}
	}
}
