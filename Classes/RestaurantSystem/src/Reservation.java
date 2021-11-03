import java.util.Calendar;
import java.util.*;

public class Reservation extends Event{

	private Calendar reserveDate;

	public Reservation(int pax, String custName, Table table)
	{
		super.setCustName(custName);
		super.setPax(pax);
		super.setTable(table);
	}

	public Calendar getReserveDate() {
		return reserveDate;
	}

	public void setReserveDate(int month, int day, int hour, boolean am) {

		Calendar c = Calendar.getInstance();
       //Date d1 = new Date();
      //System.out.println("Current date is " + d1);
       
       //c.set(Calendar.YEAR, Calendar.NOVEMBER, 15, 13, 50, 00);
		c.set(Calendar.MONTH, month);
		c.set(Calendar.DATE, day);
		c.set(Calendar.HOUR, hour);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		if (am)
		{
			c.set(Calendar.AM_PM, 0);
		}
		else
		{
			c.set(Calendar.AM_PM, 1);
		}

		this.reserveDate = c;
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