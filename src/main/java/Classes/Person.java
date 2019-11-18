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
    * Конструктор с 2 параметрами 
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
    * Конструктор с 3 параметрами
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
   
   /*
    * Конструктор с 6 параметрами
    *   @param	id
    * 			Person id 
    *   @param	firstName
    * 			Person firstName
    *   @param	date 
    * 			Person Birthday
    *	@param gender
    *          Person Gender
    *   @param salary
    *   	   Person Salary 
    *	
    * 
    */
   public Person(int id,String firstName,Gender gender, LocalDate date,String div,int salary)
   {
	   this.Id=id;
	   this.FirstName=firstName;
	   this.Birthdate=date;
	   this.Genderx=gender;
	  // this.Salary=salary;
   }
   
   /*
    * Метод возвращает возраст
    */
   public Integer getAge() {
		LocalDate nowDate=LocalDate.now();
		int age=nowDate.getYear()-this.Birthdate.getYear();
		if(nowDate.getDayOfYear()<this.Birthdate.getDayOfYear())
			age--;
		return age;
	}

   
   /*
    * Метод возвращает значение поля ID 
    * @return Person ID
    */
	public Integer getId() {
		return this.Id;
	}
	
	 /*
	   * Метод устанавливает значение для поля ID
	   * @param Person ID
	   */
	public void setId(Integer id) {
		this.Id=id;		
	}

	 /*
	    * Метод возвращает значение поля FirstName
	    * @return Person FirstName
	    */
	public String getFirstName() {
	    return this.FirstName;
	}

	 /*
	    * Метод устанавливает значение для поля FirstName
	    * @param Person FirstName
	  */
	public void setFirstName(String firstName) {
	   this.FirstName=firstName;
	   
	}


	/*
	  * Метод возвращает значение поля LastName
	  * @return Person LastName
	 */
	public String getLastName() {
		return this.LastName;
	}

	 /*
	  * Метод устанавливает значение для поля LastName
	  * @param	lastname
	  * 		Person lastName
	  */
	public void setLastName(String lastName) {
		this.LastName=lastName;
		
	}
	

	 /*
	    * Метод возвращает значение для поля BirthDate
	    * @return Person Birthdate
	  */
	public LocalDate getBirthdate() {
		return this.Birthdate;
	}

	 /*
	    * Метод устанавливает значение для поля BirthDate
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


	/*
	 * Метод возвращает значение поля Gender
	 * @return Person Gender
	 */
	public Gender getGender() {
		return this.Genderx;
	}

	
	/*
	 * Метод устанавливает  значение для поля Gender
	 * @param	gender
	 * 			Person Gender
	 */
	public void setGender(Gender gender) {
		this.Genderx=gender;
		
	}

	/*
	 * Метод возвращает значение для поля Division
	 * @return IDivision
	 */
	public IDivision getDivision() {
		
		return new Division(this.Id,this.FirstName);
	}

	/*
	 * Метод устанавливает значение для поля Division
	 * @param division
	 * 		  Division
	 */
	public void setDivision(IDivision division) {
		 this.setId(division.getId());
		 this.setFirstName(division.getName());    	
	}

	/*
	 * Метод возвраещает значение поля Salary
	 * @return Salary
	 */
	public BigDecimal getSalary() {
		return this.Salary;
	}

	/*
	 * Метод устанавливает значения для поля salary
	 */
	public void setSalary(BigDecimal salary) {
		this.Salary=salary;
		
	}

}
