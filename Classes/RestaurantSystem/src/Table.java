import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Table {
	public Table(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	private int seatCapacity;
	private Timing timeOccupied = null;

	
	/** 
	 * Set seat capacity of the table
	 * @author HuTianrun
	 * @param seatCapacity
	 */
	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	
	/** 
	 * Get seat capacity of the table
	 * @author HuTianrun
	 * @return int
	 */
	public int getSeatCapacity() {
		return this.seatCapacity;
	}

	
	/** 
	 * Check whether this table is available in both number of people and time
	 * @author HuTianrun
	 * @param Num
	 * @param time
	 * @return boolean
	 */
	public boolean checkAvailable(int Num, Timing time) {
		removePastOccupy();
		if (Num > this.seatCapacity)
			return false;

		for (Timing temp = timeOccupied; temp != null; temp = temp.next)
			if (time.equal(temp))
				return false;

		return true;
	}

	
	/** 
	 * Add a time in occupied time list to show that table is occupied 
	 * @author HuTianrun
	 * @param time
	 */
	public void addTimeOccupy(Timing time) {
		if (timeOccupied == null) // no item in the linked list
			timeOccupied = time;
		else {
			Timing temp;
			Timing pre = null;
			for (temp = timeOccupied; temp != null && temp.smallerThan(time); temp = temp.next) { // temp is the first node greater than time
				pre = temp;
			}

			if (pre == null) { // time would be the first node in linked list
				time.next = timeOccupied;
				timeOccupied = time;
			} else { // insert time into suitable place
				time.next = temp;
				pre.next = time;
			}
		}
	}

	
	/** 
	 * Remove occupied time of this table when corresponding reservation is removed
	 * @author HuTianrun
	 * @param time
	 */
	public void removeTime(Timing time) {
		Timing temp, pre = null;
		for (temp = timeOccupied; temp != null && temp != time; temp = temp.next) {
			pre = temp;
		}
		if (temp == time) {
			if (temp == timeOccupied)
				timeOccupied = temp.next;
			else
				pre.next = temp.next;
			System.out.println("Remove time successfully!");
		} else if (temp == null)
			System.out.println("No valid time in this table");
	}

	/**
	 * Remove all the past occupied time in the table
	 * @author HuTianrun
	 */
	public void removePastOccupy() {
		Calendar cal = Calendar.getInstance(); // locale-specific
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
		for (Timing temp = timeOccupied; temp != null; temp = temp.next) {
			if (date.compareTo(temp.date) > 0)
				timeOccupied = temp.next;
			else
				break;
		}
	}

	/**
	 * Display all the occupied time of this table
	 * @author HuTianrun
	 */
	public void displayOccupiedTime() {
		removePastOccupy();
		for (Timing temp = timeOccupied; temp != null; temp = temp.next) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String strDate = dateFormat.format(temp.date);
			System.out.printf(strDate + " " + temp.time + ", ");
		}
	}

	
	/** 
	 * Return all the occupied time of this table as a string. This method is used to store table into text file
	 * @author HuTianrun
	 * @return String
	 */
	public String timingList() {
		String result = "";
		for (Timing temp = timeOccupied; temp != null; temp = temp.next) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy MM dd");
			String strDate = dateFormat.format(temp.date);
			result += strDate;
			switch (temp.time) {
			case BREAKFAST:
				result += " 1";
				break;
			case LUNCH:
				result += " 2";
				break;
			case DINNER:
				result += " 3";
				break;
			}
			result += "\n";
		}
		return result;
	}
}
