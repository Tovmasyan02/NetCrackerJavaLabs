package Classes;
import Interfaces.IDivision;


public class Division implements IDivision {

	private Integer Id;
	private String Name;
	
	public Division(Integer id,String Name)
	{
		this.Id=id;
		this.Name=Name;
	}
	
	public Integer getId() {
		
		return this.Id;
	}

	public void setId(Integer id) {
		this.Id=id;
		
	}

	public String getName() {
		 return this.Name;
	}

	public void setName(String name) {
		this.Name=name;
		
	}
	
}
