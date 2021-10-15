public class person {

	private String name;
	private String gender;
	
	public person(String name, String gender){
		this.name = name;
		this.gender = gender;
	}

	public String getName()
	{
		return this.name;
	}

	
	public void setName(String name)
	{
		this.name = name;
		return;
	}

	public String getGender() {
		return this.gender;
	}
	
	
	public void setGender(String gender) {
		this.gender = gender;
		return;
	}

}