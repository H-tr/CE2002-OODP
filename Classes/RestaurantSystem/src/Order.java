import java.util.*;
public class Order {

	private Item[] orderItems;
	private Package[] orderPackage;
	private Staff staff;
	private boolean isMember;
	private Date date;
	private Date time;

	/**
	 * 
	 * @param item
	 */
	public void addItem(Item item) {
		// TODO - implement order.addItem
		throw new UnsupportedOperationException();
	}

	public Item removeItem() {
		// TODO - implement order.removeItem
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param package_add
	 */
	public void addPackage(Package package_add) {
		// TODO - implement order.addPackage
		throw new UnsupportedOperationException();
	}

	public Package removePackage() {
		// TODO - implement order.removePackage
		throw new UnsupportedOperationException();
	}

	public String displayOrder() {
		// TODO - implement order.displayOrder
		throw new UnsupportedOperationException();
	}

	public String displayInvoice() {
		// TODO - implement order.displayInvoice
		throw new UnsupportedOperationException();
	}

	public boolean getIsMember() {
		return this.isMember;
	}

	/**
	 * 
	 * @param isMember
	 */
	public void setIsMember(boolean isMember) {
		this.isMember = isMember;
	}

	public Date getTime() {
		return this.time;
	}

	/**
	 * 
	 * @param time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	public Date getDate() {
		return this.date;
	}

	/**
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

}
