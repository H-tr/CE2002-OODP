package Classes.RestaurantSystem.src;
import java.util.*;
public class Restaurant {

	private Order[] order;
	private Staff[] staffs;

	public Table[] getEmptyTable() {
		return null;
		// TODO - implement restaurant.getEmptyTable
	}

	/**
	 * 
	 * @param pax
	 * @param custName
	 */
	public int assignTable(int pax, String custName) {
		return pax;
		// TODO - implement restaurant.assignTable
	}

	/**
	 * 
	 * @param time
	 * @param pax
	 * @param custName
	 * @param contact
	 */
	public void setReservation(Date time, int pax, String custName, String contact) {
		// TODO - implement restaurant.setReservation
	}

	/**
	 * 
	 * @param pax
	 * @param staffId
	 * @param items
	 * @param packages
	 */
	public void setOrder(int pax, int staffId, Item items, Package packages) {
		// TODO - implement restaurant.setOrder
	}

	/**
	 * 
	 * @param custID
	 */
	public void removeReservation(int custID) {
		// TODO - implement restaurant.removeReservation
		throw new UnsupportedOperationException();
	}

	private void addOrder() {
		// TODO - implement restaurant.addOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param start
	 * @param end
	 */
	public void RevenueReport(Date start, Date end) {
		// TODO - implement restaurant.RevenueReport
	}

}
