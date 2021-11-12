
/**    
 * This entity class is a subclass of the Person entity class, and stores additional information such as Employee Id and Job Title/Description.
 * @author Ian Chan
 */

public class Staff extends Person {

	private int employeeId;
	private String jobTitle;
	
	/**
	 * @author Ian Chan
	 * @param employeeId
	 */
	public Staff(String name, String gender, int employeeId, String jobtitle )
	{
		super(name, gender);
		this.employeeId = employeeId;
		this.jobTitle = jobtitle;
	}

	/**
	 * @author Ian Chan
	 * @param employeeId
	 */
	public int getEmployeeId() {
		return this.employeeId;
	}

	/**
	 * @author Ian Chan
	 * @param employeeId
	 */
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
		return;
	}

	/**
	 * @author Ian Chan
	 * @param employeeId
	 */
	public String getJobTitle() {
		return this.jobTitle;
	}

	/**
	 * @author Ian Chan
	 * @param jobTitle
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
		return;
	}

}
