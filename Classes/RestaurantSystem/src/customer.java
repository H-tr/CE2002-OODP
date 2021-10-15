public class Customer extends Person {

	private boolean isMember;
	private int contNum;
	//private boolean isActive;

	public Customer(String name, String gender, boolean isMember, int contNum)
	{
		super(name, gender);
		this.isMember = isMember;
		this.contNum = contNum;
	}

	public boolean getMember() {
		return isMember;
	}

	/**
	 * 
	 * @param member
	 */
	public void setMember(boolean member) {
		this.isMember = member;
	}

	public int getContNum() {
		return this.contNum;
	}

	/**
	 * 
	 * @param contNum
	 */
	public void setContNum(int contNum) {
		this.contNum = contNum;
	}

	/*public boolean getIsActive() {
		return this.isActive;
	}*/

	/**
	 * 
	 * @param isActive
	 */
	/*public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}*/

}