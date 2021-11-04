import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Table {
	public Table (int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	private int seatCapacity;
	private Timing timeOccupied = null;

	public void setSeatCapacity (int seatCapacity) {
		this.seatCapacity =  seatCapacity;
	}

	public int getSeatCapacity () {
		return this.seatCapacity;
	}

	public boolean checkAvailable(int Num, Timing time) {
		removePastOccupy();
		if (Num > this.seatCapacity)
			return false;

		for (Timing temp = timeOccupied; temp != null; temp = temp.next)
			if (time.equal(temp))
				return false;

		return true;
	}

	public void addTimeOccupy(Timing time) {
		if (timeOccupied == null)	// no item in the linked list
			timeOccupied = time;
		else {
			Timing temp;
			Timing pre = null;
			for (temp = timeOccupied; temp != null && temp.smallerThan(time); temp = temp.next) { // temp is the first node greater than time
				pre = temp;
			}

			if (pre == null) {	// time would be the first node in linked list
				time.next = timeOccupied;
				timeOccupied = time;
			}
			else {	// insert time into suitable place
				time.next = temp;
				pre.next = time;
			}
		}
	}

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
			System.out.println("Remove time successfally!");
		} else if (temp == null)
			System.out.println("No valid time in this table");
	}

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

	public void displayOccupiedTime() {
		removePastOccupy();
		for (Timing temp = timeOccupied; temp != null; temp = temp.next) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
            String strDate = dateFormat.format(temp.date);
			System.out.printf(strDate + " " + temp.time + ", ");
		}
	}

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
			case LAUNCH:
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
