package com.netcrackerLab1.Lab1;


import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import java.util.*;
//import static org.junit.Assert.*;

public class TestPerson {

	@Test
	public void testGetYourDate() {
		LocalDate date1=new LocalDate(1999,11,8);
		Person personx=new Person(1,"Nam1","Surname1",date1,Gender.MALE);
		LocalDate date2=personx.getYourDate();
		Assert.assertEquals(date1, date2);
		
	}
	
	@Test
	public void testSetYourDate() {
		LocalDate date1=new LocalDate(1999,11,8);
		Person personx=new Person();
		personx.setYourDate(date1);
		LocalDate date2=personx.getYourDate();
		Assert.assertEquals(date1, date2);
	}

	@Test
	public void testGetAge() {
		LocalDate date1=new LocalDate(1999,11,8);
		Person personx=new Person(1,"Nam1","Surname1",date1,Gender.MALE);
		int age=personx.getAge();
		Assert.assertEquals(age, 19);
	}

	@Test
	public void testCompareTo() {
		ArrayList<Person> PersonList=new ArrayList<Person>();
		Person personx=new Person(1,"Nam1","Surname1",new LocalDate(1999,11,8);,Gender.MALE);
		Person persony=new Person(1,"Nam1","Surname1",new LocalDate(1999,8,8);,Gender.MALE);
		PersonList.add(persony);
		PersonList.add(personx);
		Collections.sort(PersonList);
		Person pResult=PersonList.get(0);
		Assert.assertEquals(pResult, personx);
		
		
	}

}
