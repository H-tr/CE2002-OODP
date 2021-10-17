public class Staff extends Person {

	private int employeeId;
	private String jobTitle;
	
	public Staff(String name, String gender, int employeeId, String jobtitle )
	{
		super(name, gender);
		this.employeeId = employeeId;
		this.jobTitle = jobtitle;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * 
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return;
	}

	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * 
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
		return;
	}

}
