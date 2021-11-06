public class Person {

	private String name;
	private String gender;
	
	public Person(String name, String gender){
		this.name = name;
		this.gender = gender;
	}

	
	/** 
	 * @return String
	 */
	public String getName()
	{
		return this.name;
	}

	
	
	/** 
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
		return;
	}

	
	/** 
	 * @return String
	 */
	public String getGender() {
		return this.gender;
	}
	
	
	
	/** 
	 * @param gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
		return;
	}

}
