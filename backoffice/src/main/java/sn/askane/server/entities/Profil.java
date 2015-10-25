package sn.askane.server.entities;


public class Profil extends Entity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 11218754546L;
	private Long userApplicationId;
	private String name;
	
	public Profil() {
		super();
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private String description;

	public void setUserApplicationId(Long userApplicationId) {
		this.userApplicationId = userApplicationId;
	}

	public Long getUserApplicationId() {
		return userApplicationId;
	}
	
	public String getName(){
		return name;
	}
	
	public String getDescription(){
		return description;
	}
	
}
