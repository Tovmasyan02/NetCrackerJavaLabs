package Classes;
import ru.vsu.lab.entities.*;
import ru.vsu.lab.entities.enums.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class Person implements IPerson {
	
       private int id;
	   private String firstName;
	   private String lastName;
	   private LocalDate birthdate;
	   private Gender genderx;
	   private BigDecimal salary;
	   private IDivision myDivision;
	   
	   /**
	    * Конструктор с 2  параметрами 
	    * 
	    * @param	id
	    * 			Person id 
	    * @param	firstName
	    * 			Person firstName
	    */
	   public Person(int id,String firstName)
	   {
		   this.id=id;
		   this.firstName=firstName;
	   }
	   
	   /**
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
		   this.id=id;
		   this.firstName=firstName;
		   this.birthdate=date;
	   }
	   
	   /**
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
	   public Person(int id,String firstName,Gender gender, LocalDate date,int salary,IDivision division)
	   {
		   this.id=id;
		   this.firstName=firstName;
		   this.birthdate=date;
		   this.genderx=gender;
		   this.myDivision=division;
		  //.salary=salary;
	   }
	   
	   /**
	    * Возвращает возраст
	    */
	   public Integer getAge() {
			LocalDate nowDate=LocalDate.now();
			int age=nowDate.getYear()-this.birthdate.getYear();
			if(nowDate.getDayOfYear()<this.birthdate.getDayOfYear())
				age--;
			return age;
		}

	   
	   /**
	    * Метод возращает значение поля ID 
	    * 	@return Person ID
	    */
		public Integer getId() {
			return this.id;
		}
		
		 /**
		   * Устанавливает значение для поля ID
		   *	 @param Person ID
		   */
		public void setId(Integer id) {
			this.id=id;		
		}

		 /**
		    * Метод возращает значение поля FirstName
		    * 	 @return Person FirstName
		    */
		public String getFirstName() {
		    return this.firstName;
		}

		 /**
		  * Метод устанавливает значение для поля FirstName
		  * 	@param Person FirstName
		  */
		public void setFirstName(String firstName) {
		   this.firstName=firstName;
		   
		}


		/**
		  *  Метод возращает значение поля LastName
		  * 	@return Person LastName
		 */
		public String getLastName() {
			return this.lastName;
		}

		 /**
		  * Метод устанавливает значение для поля LastName
		  * 	@param	lastname
		  * 		Person lastName
		  */
		public void setLastName(String lastName) {
			this.lastName=lastName;
			
		}
		

		 /*
		  *  Метод возращает значение поля BirthDate
		   * 	@return Person Birthdate
		  */
		public LocalDate getBirthdate() {
			return this.birthdate;
		}

		 /**
		    * Метод устанавливает значение для поля BirthDate
		    * 	@param	birthdate
		    * 			Person Birthdate
		  */
		public void setBirthdate(LocalDate birthdate) {
			this.birthdate=birthdate;
		}

		 /**
		    * Method return the age of a person
		    * @return Person age
		    * 
		  */
		

		/**
		 *  Метод возращает значение поля Gender
		 * @return Person Gender
		 */
		public Gender getGender() {
			return this.genderx;
		}

		
		/**
		 * Метод устанавливает значение для поля Gender
		 * @param	gender
		 * 			Person Gender
		 */
		public void setGender(Gender gender) {
			this.genderx=gender;
			
		}

		/**
		 *  Метод возращает значение поля Division
		 * 		@return IDivision
		 */
		public IDivision getDivision() {
			
			// ����
			return this.myDivision;
		}

		/**
		 *  Метод устанавливает значение для поля Division
		 * @param division
		 * 		  Division
		 */
		public void setDivision(IDivision division) {
			 this.myDivision=division; 	
		}

		/**
		 *  Метод возращает значение поля Salary
		 * @return Salary
		 */
		public BigDecimal getSalary() {
			return this.salary;
		}

		/**
		 * Метод устанавливает значение для поля salary
		 */
		public void setSalary(BigDecimal salary) {
			this.salary=salary;
			
		}

}
