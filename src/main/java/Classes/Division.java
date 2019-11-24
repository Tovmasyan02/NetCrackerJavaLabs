package Classes;
import ru.vsu.lab.entities.*;


public class Division implements IDivision {
	
	private Integer id;
	private String name;
	
	public Division(Integer id,String Name)
	{
		this.id=id;
		this.name=Name;
	}
	
	public Integer getId() {
		
		return this.id;
	}

	public void setId(Integer id) {
		this.id=id;
		
	}

	public String getName() {
		 return this.name;
	}

	public void setName(String name) {
		this.name=name;
		
	}
}
