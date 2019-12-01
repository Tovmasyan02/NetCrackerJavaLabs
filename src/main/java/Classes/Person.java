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
	    * Конструктор 
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
	    * Конструктор 
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
	    * Конструктор 
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
	    * 	@return Person ID
	    */
		public Integer getId() {
			return this.id;
		}
		
		 /**
		   *	 @param Person ID
		   */
		public void setId(Integer id) {
			this.id=id;		
		}

		 /**
		    * 	 @return Person FirstName
		    */
		public String getFirstName() {
		    return this.firstName;
		}

		 /**
		  * 	@param Person FirstName
		  */
		public void setFirstName(String firstName) {
		   this.firstName=firstName;
		   
		}


		/**
		  * 	@return Person LastName
		 */
		public String getLastName() {
			return this.lastName;
		}

		 /**
		  * 	@param	lastname
		  * 		Person lastName
		  */
		public void setLastName(String lastName) {
			this.lastName=lastName;
			
		}
		

		 /*
		   * 	@return Person Birthdate
		  */
		public LocalDate getBirthdate() {
			return this.birthdate;
		}

		 /**
		    * 	@param	birthdate
		    * 			Person birthdate
		  */
		public void setBirthdate(LocalDate birthdate) {
			this.birthdate=birthdate;
		}
		

		/**
		 * @return Person Gender
		 */
		public Gender getGender() {
			return this.genderx;
		}

		
		/**
		 * @param	gender
		 * 			Person Gender
		 */
		public void setGender(Gender gender) {
			this.genderx=gender;
			
		}

		/**
		 * 		@return Person division
		 */
		public IDivision getDivision() {
			
			// ����
			return this.myDivision;
		}

		/**
		 * @param division
		 * 		  Division
		 */
		public void setDivision(IDivision division) {
			 this.myDivision=division; 	
		}

		/**
		 * @return Salary
		 */
		public BigDecimal getSalary() {
			return this.salary;
		}

		/**
		 * @param Salary
		 * 		  Person salaray
		 */
		public void setSalary(BigDecimal salary) {
			this.salary=salary;
			
		}

}
