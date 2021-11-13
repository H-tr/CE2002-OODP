
/**    
 * This entity class is a subclass of the Person entity class, and stores additional information such as Employee Id and Job Title/Description.
 * @author Ian Chan
 */

public class Staff extends Person {

	private int employeeId;
	private String jobTitle;
	
	/**
	 * Build a new staff instance
	 * @param employeeId
	 */
	public Staff(String name, String gender, int employeeId, String jobtitle )
	{
		super(name, gender);
		this.employeeId = employeeId;
		this.jobTitle = jobtitle;
	}

	/**
	 * Get EmployeeId
	 * @param employeeId
	 * @return int
	 */
	public int getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * Set EmployeeId
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return;
	}

	/**
	 * Get job title
	 * @param employeeId
	 * @return String
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * Set job title
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
		return;
	}

}
