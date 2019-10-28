package com.netcrackerLab1.Lab1;
import org.joda.time.*;
 
public class Person implements Comparable<Person> {
	/**
	 * ID Пользователя
	 */
	private int id;
	/**
	 * Имя Пользователя
	 */
    private String name;
    /**
	 * Фамилия Пользователя
	 */
    private String surname;
    /**
	 * Дата рождения год/месяц/день
	 */
	private LocalDate yourDate;
	
	/**
	 * Конструтор без параметров 
	 */
	private Gender gender; 
	public Person() {}
	
	/**
	 * Конструтор с 5 параметрами 
	 * @param id
	 *        id пользователя
	 * @param name
	 *         имя пользователя
	 * @param surname 
	 *        фамилия пользователя
	 * @param yourDate 
	 *        Дата рождения
	 * @param gender
	 *        пол
	 */
	public Person(int id, String name, String surname, LocalDate yourDate,Gender gender) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.yourDate = yourDate;
		this.gender=gender;
	}
	
	/**
	 * Конструтор с 4 параметрами 
	 * @param id
	 *        id пользователя
	 * @param name
	 *         имя пользователя
	 * @param surname 
	 *        фамилия пользователя
	 * @param gender
	 *        пол
	 */
	public Person(int id, String name, String surname,Gender gender) {
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.gender=gender;
	}	
	/**
	   Возвращает ID данного пользователя
	   @return ID пользователя
	 */
	public int getID(){
		return id;
	}
	
	/**
	   Устанавливает ID данного пользователя
	   @param id 
	          id пользователя
	 */
	public void setID(int id) {
	  this.id = id;
	}
	
	/**
	   Возвращает имя данного пользователя
	 */
	public String getName() {
		return name;
	}
	/**
	    Установливает имя данного пользователя
	    @param name 
	           имя пользователя
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
     Возвращает фамилия данного пользователя
     @return фамилия
    */
	public String getSurname() {
		return surname;
	}
	/**
      Устанавливает фамилия данного пользователя
      @param surname 
             фамилия
    */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
     Устанавливает дату рождения данного пользователя
     @return Дату
    */
	public LocalDate getYourDate() {
		return yourDate;
	}
	
	/**
    Устанавливает дату рождения данного пользователя
    @param yourDate
           Дата рождения
 */
	public void setYourDate(LocalDate yourDate) {
		this.yourDate = yourDate;
	}	
	
	/**
       Возвращает возраст пользователя
       return возраст
    */ 
	public int getAge()
	{
		LocalDate now=LocalDate.now();
		int year= now.minusYears(this.yourDate.getYear()).getYear();
		if(now.getDayOfYear()<this.yourDate.getDayOfYear())
			year--;
		return year;	
	}
	
	public int compareTo(Person personY)
	{
		if(this.getAge()>personY.getAge())
			return 1;
		if(this.getAge()<personY.getAge())
			return -1;
		return 0;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		result = prime * result + ((yourDate == null) ? 0 : yourDate.hashCode());
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
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (yourDate == null) {
			if (other.yourDate != null)
				return false;
		} else if (!yourDate.equals(other.yourDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Hello My Name Is"+ this.name;
	}
	
	

	
		
	
	
	
}