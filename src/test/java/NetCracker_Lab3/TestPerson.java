package NetCracker_Lab3;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.Test;

import Classes.Person;

public class TestPerson {

	@Test
	public void testGetAge() {

		Person p=new Person(111,"Namex",LocalDate.of(1999,11,8));

		int age=p.getAge();

		Assert.assertEquals(20,age);

	}

}
