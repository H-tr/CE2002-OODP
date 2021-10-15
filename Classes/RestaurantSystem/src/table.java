public class table {

	private int seatingCapacity;
	private int tableId;
	private boolean isReserved;
	private boolean isTaken;

	public boolean availability() {
		// TODO - implement table.availability
		throw new UnsupportedOperationException();
	}

	public int getCapacity() {
		// TODO - implement table.getCapacity
		throw new UnsupportedOperationException();
	}

	public int getTableId() {
		return this.tableId;
	}

	public int setTableId() {
		// TODO - implement table.setTableId
		throw new UnsupportedOperationException();
	}

	public int getSeatingCapacity() {
		return this.seatingCapacity;
	}

	public int setSeatingCapacity() {
		// TODO - implement table.setSeatingCapacity
		throw new UnsupportedOperationException();
	}

	public void viewOrder() {
		// TODO - implement table.viewOrder
		throw new UnsupportedOperationException();
	}

	public boolean getIsReserved() {
		return this.isReserved;
	}

	/**
	 * 
	 * @param isReserved
	 */
	public void setIsReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public boolean getIsTaken() {
		return this.isTaken;
	}

	/**
	 * 
	 * @param isTaken
	 */
	public void setIsTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}

}