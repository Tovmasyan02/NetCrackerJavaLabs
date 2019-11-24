package NetCracker_Lab3;

import static org.junit.Assert.*;

import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.vsu.lab.entities.*;
import ru.vsu.lab.repository.IPersonRepository;
import Classes.Person;
import Classes.PersonRepository;

public class TestPersonRepository {

private static PersonRepository myRepository;
	
	@Before
	public void BeforeMethod()
	{
		Person p1=new Person(1,"Name1");
		Person p2=new Person(2,"Name2");
		Person p3=new Person(3,"Name3");
		Person p4=new Person(4,"Name4");
		Person p5=new Person(5,"Name5");
		Person p6=new Person(6,"Name6");
		Person p7=new Person(7,"Name7");
		Person p8=new Person(8,"Name8");
		Person p9=new Person(9,"Name9");
		PersonRepository r=new PersonRepository();
		r.add(p1);
		r.add(p2);
		r.add(p3);
		r.add(p4);
		r.add(p5);
		r.add(p6);
		r.add(p7);
		r.add(p8);
		r.add(p9);
		myRepository=r;
	}
	
	
	@Test
	public void testReadAllFromCSV()
	{
		
		IPersonRepository rep=PersonRepository.readAllDataFromCSV("src\\main\\resources\\personsX.csv");
		//Person p=(Person)rep.get(2);
		//Assert.assertEquals("Aaleahya", p.getFirstName());
		
	}
	@Test 
	public void testAddIPerson() {
        int size=myRepository.getSize();
		Assert.assertEquals(size,9);
	}
	
	@Test 
	public void testGet()
	{
		Person p10=new Person(10,"Nam/e10");
		myRepository.add(p10);
	    IPerson px=myRepository.get(9);
	    Assert.assertEquals(px,p10);	
	}
	
    @Test(expected=IndexOutOfBoundsException.class)
	public void testGetError() 
	{
		myRepository.get(111);
	}
    
    @Test
    public void testDelete() {
    	IPerson p2=myRepository.get(2);
    	IPerson p3=myRepository.get(3);
    	IPerson pd=myRepository.delete(2);
    	Assert.assertEquals(p2, pd);
    	Assert.assertEquals(8, myRepository.getSize());
    	Assert.assertEquals(p3, myRepository.get(2));
    }
	
	@Test  
	public void testAddIPerson2()
	{
		Person px=new Person(111,"Namex");
		Person p3=(Person)myRepository.get(2);
		myRepository.add(2,px);	
		Assert.assertEquals(px,myRepository.get(2));
		Assert.assertEquals(p3,myRepository.get(3));
	}
	
	@Test
	public void TestGetSize()
	{
		int res=myRepository.getSize();
		Assert.assertEquals(res,9);		
	}
	
	
	@Test 
	public void testSet()
	{
		
		Person px=new Person(111,"Namex");
		myRepository.set(2, px);
		Assert.assertEquals(px,myRepository.get(2));	
	}
	
	
	@Test 
	public void testToList()
	{
		
		List<IPerson> lp=myRepository.toList();
		Assert.assertEquals(9,lp.size());
		Assert.assertEquals(myRepository.get(3),lp.get(3));
	    	

	}
	
	@Test 
	public void testSortBy()
	{
		Person zeroPerson=new Person(0,"Name0");
		myRepository.add(5,zeroPerson);
		myRepository.sortBy(new PersonAgeComparator());
		Assert.assertEquals(zeroPerson,myRepository.get(0));
		
	}
	
	@Test 
	public void testSearchBy()
	{
     PersonRepository x=(PersonRepository)myRepository.searchBy(personn -> personn.getId()>5);
     
     Assert.assertEquals(4,x.getSize());
		
	}
	
	
}

class PersonAgeComparator implements Comparator<IPerson>{
	  
    public int compare(IPerson aa, IPerson bb){
      
    	Person a=(Person)aa;
    	Person b=(Person)bb;
        if(a.getId()> b.getId())
            return 1;
        else if(a.getId()< b.getId())
            return -1;
        else
            return 0;
    }

}
