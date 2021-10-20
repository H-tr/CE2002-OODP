import java.util.Date;

public class Reservation {

	private Date reserveDate;
	private Date reserveTime;
	private int pax;
	private Customer cust;

	public Reservation() 
	{
		// TODO - implement reservation.reservation
		this.reserveDate = null;
		this.reserveTime = null;
		this.pax = 0;
	}

	public void setReserveDate() 
	{
		// TODO - implement reservation.setReserveDate
		long millis = System.currentTimeMillis();  
		java.sql.Date date = new java.sql.Date(millis);  
		
		this.reserveDate = date;
		
		//System.out.println(this.reserveDate);  
	}

	public Date getReserveTime() 
	{
		return this.reserveTime;
	}

	public void setReserveTime() 
	{
		// TODO - implement reservation.setReserveTime
		long millis = System.currentTimeMillis();  
		java.sql.Time time = new java.sql.Time(millis);
		
		this.reserveTime = time;
		
		//System.out.println(this.reserveTime);
	}

	public Date getReserveDate() 
	{
		// TODO - implement reservation.getReserveDate
		return this.reserveDate;
	}

	public void setPax(int pax) 
	{
		// TODO - implement reservation.setPax
		this.pax = pax;
	}

	public int getPax() 
	{
		return this.pax;
	}

	public void removeReservation() 
	{
		// TODO - implement reservation.removeReservation
		this.reserveDate = null;
		this.reserveTime = null;
		this.pax = 0;
		System.out.println("Reservation is removed.");
	}

	public void checkReservation() 
	{
		// TODO - implement reservation.checkReservation
		System.out.println("Reservation by " + this.cust.getName());
		System.out.println("Reserved Date: " + this.reserveDate);
		System.out.println("Reserved Time: " + this.reserveTime);
		System.out.println("Pax: " + this.pax);
	}

	public Customer getCust() 
	{
		return this.cust;
	}

	public void setCust(Customer cust) 
	{
		this.cust = cust;
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