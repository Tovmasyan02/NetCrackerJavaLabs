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
   
   /*
    * Constructor sets values for fields - Id and FirstName
    * 
    * @param	id
    * 			Person id 
    * @param	firstName
    * 			Person firstName
    */
   public Person(int id,String firstName)
   {
	   this.Id=id;
	   this.FirstName=firstName;
   }
   
   /*
    * Constructor sets values for fields - Id,FirstName,Birthdate
    * 
    * @param	id
    * 			Person id 
    * @param	firstName
    * 			Person firstName
    * @param	date 
    * 			Person Birthday
    */
   public Person(int id,String firstName,LocalDate date)
   {
	   this.Id=id;
	   this.FirstName=firstName;
	   this.Birthdate=date;
   }
   
   public Person(int id,String firstName,Gender gender, LocalDate date,String div,int salary)
   {
	   this.Id=id;
	   this.FirstName=firstName;
	   this.Birthdate=date;
	   this.Genderx=gender;
	  // this.Salary=salary;
   }
   
   
   //id;name;gender;BirtDate;Division;Salary
   
   /*
    * Method get value of the ID field
    * @return Person ID
    */
	public Integer getId() {
		return this.Id;
	}
	
	 /*
	   * Method set the ID field value
	   * @param Person ID
	   */
	public void setId(Integer id) {
		this.Id=id;		
	}

	 /*
	    * Method get value of the FirstName field
	    * @return Person FirstName
	    */
	public String getFirstName() {
	    return this.FirstName;
	}

	 /*
	    * Method set the ID field value
	    * @param Person FirstName
	  */
	public void setFirstName(String firstName) {
	   this.FirstName=firstName;
	   
	}


	/*
	  * Method get value of the LastName field
	  * @return Person LastName
	 */
	public String getLastName() {
		return this.LastName;
	}

	 /*
	    * Method set the lastName field value
	    * @param	lastname
	    * 			Person lastName
	  */
	public void setLastName(String lastName) {
		this.LastName=lastName;
		
	}
	

	 /*
	    * Method get value of the BirthDate field
	    * @return Person Birthdate
	  */
	public LocalDate getBirthdate() {
		return this.Birthdate;
	}

	 /*
	    * Method set the Birthdate field value
	    * @param	birthdate
	    * 			Person Birthdate
	  */
	public void setBirthdate(LocalDate birthdate) {
		this.Birthdate=birthdate;
	}

	 /*
	    * Method return the age of a person
	    * @return Person age
	    * 
	  */
	public Integer getAge() {
		LocalDate nowDate=LocalDate.now();
		int age=nowDate.getYear()-this.Birthdate.getYear();
		if(nowDate.getDayOfYear()<this.Birthdate.getDayOfYear())
			age--;
		return age;
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
		 this.setId(division.getId());
		 this.setFirstName(division.getName());    	
	}

	public BigDecimal getSalary() {
		return this.Salary;
	}

	public void setSalary(BigDecimal salary) {
		this.Salary=salary;
		
	}

}
