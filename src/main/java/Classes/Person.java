package Classes;
import ru.vsu.lab.entities.*;
import ru.vsu.lab.entities.enums.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import XmlAdapters.*;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person implements IPerson {
	
	   @XmlTransient
       private int id;
	   
       @XmlAttribute
	   private String firstName;
       
       @XmlTransient
	   private String lastName;
       
       @XmlAttribute(name="date")
       @XmlJavaTypeAdapter(value = DateAdapter.class)
	   private LocalDate birthdate;
       
       @XmlAttribute
	   private Gender genderx;
       
       @XmlAttribute
	   private BigDecimal salary;
       
       @XmlAttribute(name="division")
       @XmlJavaTypeAdapter(value = DivisionAdapter.class)
	   private IDivision myDivision;
	   

	 	   
	   public Person() {}
	   public Person(int id,String firstName)
	   {
		   this.id=id;
		   this.firstName=firstName;
	   }
	   

	   public Person(int id,String firstName,LocalDate date)
	   {
		   this.id=id;
		   this.firstName=firstName;
		   this.birthdate=date;
	   }
	   

	   public Person(int id,String firstName,Gender gender, LocalDate date,BigDecimal salary,IDivision division)
	   {
		   this.id=id;
		   this.firstName=firstName;
		   this.birthdate=date;
		   this.genderx=gender;
		   this.myDivision=division;
		   this.salary=salary;
	   }
	   
	   public Integer getAge() {
			LocalDate nowDate=LocalDate.now();
			int age=nowDate.getYear()-this.birthdate.getYear();
			if(nowDate.getDayOfYear()<this.birthdate.getDayOfYear())
				age--;
			return age;
		}

		public Integer getId() {
			return this.id;
		}
		
		public void setId(Integer id) {
			this.id=id;		
		}

		
		public String getFirstName() {
		    return this.firstName;
		}

		public void setFirstName(String firstName) {
		   this.firstName=firstName;
		   
		}

		public String getLastName() {
			return this.lastName;
		}

		public void setLastName(String lastName) {
			this.lastName=lastName;
			
		}
				
		public LocalDate getBirthdate() {
			return this.birthdate;
		}

		public void setBirthdate(LocalDate birthdate) {
			this.birthdate=birthdate;
		}
		

		public Gender getGender() {
			return this.genderx;
		}

		public void setGender(Gender gender) {
			this.genderx=gender;
			
		}

		public IDivision getDivision() {
					
			return this.myDivision;
		}


		public void setDivision(IDivision division) {
			 this.myDivision=division; 	
		}
		

		public BigDecimal getSalary() {
			return this.salary;
		}

		public void setSalary(BigDecimal salary) {
			this.salary=salary;
			
		}
		

}
