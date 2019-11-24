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
	   
	   /*
	    * ����������� � 2 ����������� 
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
	   
	   /*
	    * ����������� � 3 �����������
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
	   
	   /*
	    * ����������� � 6 �����������
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
	   
	   /*
	    * ����� ���������� �������
	    */
	   public Integer getAge() {
			LocalDate nowDate=LocalDate.now();
			int age=nowDate.getYear()-this.birthdate.getYear();
			if(nowDate.getDayOfYear()<this.birthdate.getDayOfYear())
				age--;
			return age;
		}

	   
	   /*
	    * ����� ���������� �������� ���� ID 
	    * @return Person ID
	    */
		public Integer getId() {
			return this.id;
		}
		
		 /*
		   * ����� ������������� �������� ��� ���� ID
		   * @param Person ID
		   */
		public void setId(Integer id) {
			this.id=id;		
		}

		 /*
		    * ����� ���������� �������� ���� FirstName
		    * @return Person FirstName
		    */
		public String getFirstName() {
		    return this.firstName;
		}

		 /*
		    * ����� ������������� �������� ��� ���� FirstName
		    * @param Person FirstName
		  */
		public void setFirstName(String firstName) {
		   this.firstName=firstName;
		   
		}


		/*
		  * ����� ���������� �������� ���� LastName
		  * @return Person LastName
		 */
		public String getLastName() {
			return this.lastName;
		}

		 /*
		  * ����� ������������� �������� ��� ���� LastName
		  * @param	lastname
		  * 		Person lastName
		  */
		public void setLastName(String lastName) {
			this.lastName=lastName;
			
		}
		

		 /*
		    * ����� ���������� �������� ��� ���� BirthDate
		    * @return Person Birthdate
		  */
		public LocalDate getBirthdate() {
			return this.birthdate;
		}

		 /*
		    * ����� ������������� �������� ��� ���� BirthDate
		    * @param	birthdate
		    * 			Person Birthdate
		  */
		public void setBirthdate(LocalDate birthdate) {
			this.birthdate=birthdate;
		}

		 /*
		    * Method return the age of a person
		    * @return Person age
		    * 
		  */
		

		/*
		 * ����� ���������� �������� ���� Gender
		 * @return Person Gender
		 */
		public Gender getGender() {
			return this.genderx;
		}

		
		/*
		 * ����� �������������  �������� ��� ���� Gender
		 * @param	gender
		 * 			Person Gender
		 */
		public void setGender(Gender gender) {
			this.genderx=gender;
			
		}

		/*
		 * ����� ���������� �������� ��� ���� Division
		 * @return IDivision
		 */
		public IDivision getDivision() {
			
			// ����
			return this.myDivision;
		}

		/*
		 * ����� ������������� �������� ��� ���� Division
		 * @param division
		 * 		  Division
		 */
		public void setDivision(IDivision division) {
			 this.myDivision=division; 	
		}

		/*
		 * ����� ����������� �������� ���� Salary
		 * @return Salary
		 */
		public BigDecimal getSalary() {
			return this.salary;
		}

		/*
		 * ����� ������������� �������� ��� ���� salary
		 */
		public void setSalary(BigDecimal salary) {
			this.salary=salary;
			
		}

}
