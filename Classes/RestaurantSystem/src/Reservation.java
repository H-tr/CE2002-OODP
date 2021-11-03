import java.util.Calendar;
import java.util.*;

public class Reservation extends Event{

	private Timing reserveDate;

	public Reservation(int pax, String custName, Table table)
	{
		super.setCustName(custName);
		super.setPax(pax);
		super.setTable(table);
	}

	public Timing getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(Timing date) {
		reserveDate = date;
		
	}

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