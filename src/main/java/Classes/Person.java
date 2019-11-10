package Classes;
import java.math.BigDecimal;
import java.time.LocalDate;

import Enums.Gender;
import Interfaces.IDivision;
import Interfaces.IPerson;
import Classes.Division;

public class Person implements IPerson
{
   private int Id;
   private String FirstName;
   private String LastName;
   private LocalDate Birthdate;
   private Gender Genderx;
   private BigDecimal Salary;
   
   public Person(int id,String firstName)
   {
	   this.Id=id;
	   this.FirstName=firstName;
	   
   }
   
	public Integer getId() {
		return this.Id;
	}

	public void setId(Integer id) {
		this.Id=id;		
	}

	public String getFirstName() {
	    return this.FirstName;
	}

	public void setFirstName(String firstName) {
	   this.FirstName=firstName;
	   
	}

	public String getLastName() {
		return this.LastName;
	}

	public void setLastName(String lastName) {
		this.LastName=lastName;
		
	}

	public LocalDate getBirthdate() {
		return this.Birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.Birthdate=birthdate;
	}

	public Integer getAge() {
		// TODO Auto-generated method stub
		return null;
	}

	public Gender getGender() {
		return this.Genderx;
	}

	public void setGender(Gender gender) {
		this.Genderx=gender;
		
	}

	public IDivision getDivision() {
		
		return new Division(this.Id,this.FirstName);
	}

	public void setDivision(IDivision division) {
		 //  не ебу че за Division
	     	
	}

	public BigDecimal getSalary() {
		return this.Salary;
	}

	public void setSalary(BigDecimal salary) {
		this.Salary=salary;
		
	}

}
