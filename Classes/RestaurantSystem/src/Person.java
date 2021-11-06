public class Person {

	private String name;
	private String gender;
	
	public Person(String name, String gender){
		this.name = name;
		this.gender = gender;
	}

	
	/** 
	 * @author Ian Chan
	 * @return String
	 */
	public String getName()
	{
		return this.name;
	}

	
	
	/** 
	 * @author Ian Chan
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
		return;
	}

	
	/** 
	 * @author Ian Chan
	 * @return String
	 */
	public String getGender() {
		return this.gender;
	}
	
	
	
	/** 
	 * @author Ian Chan
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
		return;
	}

}
