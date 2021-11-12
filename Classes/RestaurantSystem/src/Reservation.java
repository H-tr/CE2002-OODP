/**    
 * This entity class is a subclass of the Event entity class, and stores all information relevant to a reservation such as DateTime, Customer Name, Pax and Table.
 * @author Ian Chan
 * @param args
 */

public class Reservation extends Event{

	private Timing reserveDate;

	/** 
	 * Contructor for Reservation
	 * @author Ian Chan
	 */
	public Reservation(int pax, String custName, Table table)
	{
		super.setCustName(custName);
		super.setPax(pax);
		super.setTable(table);
	}

	
	/** 
	 * @author Ian Chan
	 * @return Timing
	 */
	public Timing getReserveDate() {
		return reserveDate;
	}

	
	/** 
	 * @author Ian Chan
	 * @param date
	 */
	public void setReserveDate(Timing date) {
		reserveDate = date;
	}

	
	/** 
	 * Used to show this is a reservation class (From array of Events)
	 * @author Ian Chan
	 * @return String
	 */
	public String returnType()
	{
		return "Reservation";
	}
}


// //Reservation()
// //setReserveDate() 
// //getReserveTime()
// //setReserveTime()
// //getReserveDate()
// //setPax()
// //getPax() 
// //removeReservation()
// //checkReservation()
// //getCust() : Customer
// //setCust - cust:Customer