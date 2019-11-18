package NetcrackerLab3.Lab3;

import org.junit.*;
import java.time.LocalDate;


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
