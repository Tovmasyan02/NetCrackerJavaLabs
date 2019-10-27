package com.netcrackerLab1.Lab1;
import org.joda.time.*;


public class App
{
    public static void main( String[] args )
    {
    	LocalDate d1=new LocalDate(1999,10,27);
    	LocalDate d2=new LocalDate(1949,5,6);
    	Person p1=new Person();
    	Person p2=new Person();
    	p1.setYourDate(d1);
    	p2.setYourDate(d2);
    	PersonRepasitory pr=new PersonRepasitory();
    	pr.add(p1);
    	pr.add(p2);
        
    	for(Person personx:pr)
    	{
    		System.out.println(personx.getAge());
    	}
    	
    	
    //	System.out.println(pr.nextCallIndex);
    	for(Person persony:pr)
    	{
    		System.out.println(persony.getAge());
    	}
    	
    	
        
    }
}
