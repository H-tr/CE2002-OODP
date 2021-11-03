import java.util.concurrent.ThreadLocalRandom;

public class Table {

	private int seatingCapacity;
	private int capacity;
	private int numOfTables;
	private int tableId;
	private boolean isReserved;
	private boolean isTaken;
	
	private Reservation reservation;
	private Order order;
	
	public Table() 
	{
		// TODO - implement reservation.reservation
			
		this.tableId = 2;
		this.capacity = 5;
		this.isReserved = false;
		this.isTaken = false;
	}
	
	public boolean availability() 
	{
		// TODO - implement table.availability
		
		boolean available;
		
		if (isReserved || isTaken)
		{
			available = false;
		}
		
		else
			available = true;
		
		return available;
	}

	public int getCapacity() 
	{
		// TODO - implement table.getCapacity
		return this.capacity;
	}

	public int getTableId() 
	{
		return this.tableId;
	}

	public int setTableId(int pax) 
	{
		// TODO - implement table.setTableId
		for (int i = 0; i < this.numOfTables; i++)
		{
			if (this.capacity >= this.seatingCapacity)
			{
				return this.tableId;
			}
		}
		
		return -1;
	}

	public int getSeatingCapacity() 
	{
		return this.seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) 
	{
		// TODO - implement table.setSeatingCapacity
		this.seatingCapacity = seatingCapacity;
	}

	

	public boolean getIsReserved() 
	{
		return this.isReserved;
	}

	public void setIsReserved(boolean isReserved) 
	{
		this.isReserved = isReserved;
	}

	public boolean getIsTaken() 
	{
		return this.isTaken;
	}

	public void setIsTaken(boolean isTaken) 
	{
		this.isTaken = isTaken;
	}
	
	public Reservation getReservation()
	{
		return this.reservation;
	}
	
	public void setReservation(Reservation reservation)
	{
		this.reservation = reservation;
	}
	
	public Order getOrder()
	{
		return this.order;
	}
	
	public void setOrder(Order order) 
	{
		this.order = order;
	}
}


// //availability
// //getCapacity
// //getTableId
// setTableId
// //getSeatingCapacity
// //setSeatingCapacity
// //viewOrder
// //getIsReserved
// //setIsReserved
// //getIsTaken
// //setIsTaken
// //getReservation
// //setReservation
// //getOrder
// //setOrder
// //Table
