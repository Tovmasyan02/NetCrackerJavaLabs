package NetcrackerLab3.Lab3;

import org.junit.*;
import java.util.*;
import Interfaces.IPerson;
import Classes.*;
public class TestRepository  {

	@Test
	public void testAddIPerson() {
		Person p1=new Person(1,"Name1");
		Person p2=new Person(2,"Name2");
		Person p3=new Person(3,"Name3");
		Person p4=new Person(4,"Name4");
		Repository r=new Repository();
		r.add(p1);
		r.add(p2);
		r.add(p3);
		r.add(p4);
        int size=r.getSize();
		Assert.assertEquals(size,4);
	}
	
	@Test
	
	public void testAddIPerson2()
	{
		Person p1=new Person(1,"Name1");
		Person p2=new Person(2,"Name2");
		Person p3=new Person(3,"Name3");
		Person p4=new Person(4,"Name4");
		Repository r=new Repository();
		r.add(p1);
		r.add(p2);
		r.add(p3);
		r.add(p4);
		Person px=new Person(111,"Namex");
		r.add(2,px);	
		Assert.assertEquals(px,r.get(2));
		Assert.assertEquals(p3,r.get(3));
	}
	
	@Test
	public void TestGetSize()
	{
		Person p1=new Person(1,"Name1");
		Person p2=new Person(2,"Name2");
		Person p3=new Person(3,"Name3");
		Person p4=new Person(4,"Name4");
		Repository r=new Repository();
		r.add(p1);
		r.add(p2);
		r.add(p3);
		r.add(p4);
		int res=r.getSize();
		Assert.assertEquals(res,4);
		
	}
	
	@Test
	public void testGet()
	{
		Person p1=new Person(1,"Name1");
		Person p2=new Person(2,"Name2");
		Person p3=new Person(3,"Name3");
		Person p4=new Person(4,"Name4");
		Repository r=new Repository();
		r.add(p1);
		r.add(p2);
		r.add(p3);
		r.add(p4);
		
	   Person px=(Person)r.get(2);
	   Assert.assertEquals(px,p3);	
	}
	
	@Test
	public void testSet()
	{
		Person p1=new Person(1,"Name1");
		Person p2=new Person(2,"Name2");
		Person p3=new Person(3,"Name3");
		Person p4=new Person(4,"Name4");
		Repository r=new Repository();
		r.add(p1);
		r.add(p2);
		r.add(p3);
		r.add(p4);
		Person px=new Person(111,"Namex");
		r.set(2, px);
		Assert.assertEquals(px,r.get(2));	
	}
	
	
	@Test
	public void testToList()
	{
		Person p1=new Person(1,"Name1");
		Person p2=new Person(2,"Name2");
		Person p3=new Person(3,"Name3");
		Person p4=new Person(4,"Name4");
		Repository r=new Repository();
		r.add(p1);
		r.add(p2);
		r.add(p3);
		r.add(p4);
		List<IPerson> lp=r.toList();
		Assert.assertEquals(4,lp.size());
		Assert.assertEquals(p4,lp.get(3));
	    	
		
	}
	
	
}
