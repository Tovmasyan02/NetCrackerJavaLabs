package com.netcrackerLab1.Lab1;
import org.joda.time.*;
 
public class Person {
	/**
	 * ID Пользователя
	 */
	private int ID;
	/**
	 * Имя Пользователя
	 */
    private String Name;
    /**
	 * Фамилия Пользователя
	 */
    private String Surname;
    /**
	 * Дата рождения год/месяц/день
	 */
	private LocalDate YourDate;
	
	/**
	 * Конструтор без параметров 
	 */
	public Person() {}
	
	/**
	 * Конструтор с 4 параметрами 
	 * @param id
	 *        id пользователя
	 * @param name
	 *         имя пользователя
	 * @param surname 
	 *        фамилия пользователя
	 * @param yourDate 
	 *        Дата рождения
	 */
	public Person(int id, String name, String surname, LocalDate yourDate) {
		ID = id;
		Name = name;
		Surname = surname;
		YourDate = yourDate;
	}
	
	/**
	 * Конструтор с 3 параметрами 
	 * @param id
	 *        id пользователя
	 * @param name
	 *         имя пользователя
	 * @param surname 
	 *        фамилия пользователя
	 */
	public Person(int id, String name, String surname) {
		ID = id;
		Name = name;
		Surname = surname;
	}
	/**
	 * Конструтор с 1 параметром 
	 * @param id
	 *        id пользователя
	 */
	public Person(int id){
		ID = id;
	}	
	
	/**
	   Возвращает ID данного пользователя
	   @return ID пользователя
	 */
	public int getID(){
		return ID;
	}
	
	/**
	   Устанавливает ID данного пользователя
	   @param id 
	          id пользователя
	 */
	public void setID(int id) {
		ID = id;
	}
	
	/**
	   Возвращает имя данного пользователя
	 */
	public String getName() {
		return Name;
	}
	/**
	    Установливает имя данного пользователя
	    @param name 
	           имя пользователя
	 */
	public void setName(String name) {
		Name = name;
	}
	/**
     Возвращает фамилия данного пользователя
     @return фамилия
    */
	public String getSurname() {
		return Surname;
	}
	/**
      Устанавливает фамилия данного пользователя
      @param surname 
             фамилия
    */
	public void setSurname(String surname) {
		Surname = surname;
	}
	/**
     Устанавливает дату рождения данного пользователя
     @return Дату
    */
	public LocalDate getYourDate() {
		return YourDate;
	}
	
	/**
    Устанавливает дату рождения данного пользователя
    @param yourDate
           Дата рождения
 */
	public void setYourDate(LocalDate yourDate) {
		YourDate = yourDate;
	}	
	
	/**
       Возвращает возраст пользователя
       return возраст
    */ 
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