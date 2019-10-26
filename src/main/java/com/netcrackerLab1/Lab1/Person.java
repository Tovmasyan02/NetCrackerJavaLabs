package com.netcrackerLab1.Lab1;
import org.joda.time.*;
 
public class Person {
	private int ID;
    private String Name;
    private String Surname;
	private LocalDate YourDate;
	public Person() {}
	public Person(int iD, String name, String surname, LocalDate yourDate) {
		ID = iD;
		Name = name;
		Surname = surname;
		YourDate = yourDate;
	}
	
	public Person(int iD, String name, String surname) {
		ID = iD;
		Name = name;
		Surname = surname;
	}
	public Person(int iD){
		ID = iD;
	}	
	public int getID(){
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public LocalDate getYourDate() {
		return YourDate;
	}
	public void setYourDate(LocalDate yourDate) {
		YourDate = yourDate;
	}	
	public int getAge()
	{
		LocalDate now=LocalDate.now();
		int year= now.minusYears(this.YourDate.getYear()).getYear();
		if(now.getDayOfYear()<this.YourDate.getDayOfYear())
			year--;
		return year;	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((Name == null) ? 0 : Name.hashCode());
		result = prime * result + ((Surname == null) ? 0 : Surname.hashCode());
		result = prime * result + ((YourDate == null) ? 0 : YourDate.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ID != other.ID)
			return false;
		if (Name == null) {
			if (other.Name != null)
				return false;
		} else if (!Name.equals(other.Name))
			return false;
		if (Surname == null) {
			if (other.Surname != null)
				return false;
		} else if (!Surname.equals(other.Surname))
			return false;
		if (YourDate == null) {
			if (other.YourDate != null)
				return false;
		} else if (!YourDate.equals(other.YourDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hello, My name is"+this.Name;
	}
	
	
	
}