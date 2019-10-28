package com.netcrackerLab1.Lab1;
import org.joda.time.*;


public class App
{
    public static void main( String[] args )
    {
    	Person p1=new Person(1,"Nam1","Surname1",new LocalDate(1999,8,8),Gender.MALE);
    	Person p2=new Person(2,"Nam2","Surname2",new LocalDate(1997,10,1),Gender.MALE);
    	Person p3=new Person(3,"Nam3","Surname3",new LocalDate(1976,6,11),Gender.MALE);
    	Person p4=new Person(4,"Nam4","Surname4",new LocalDate(1968,1,1),Gender.FEMALE);
    	Person p5=new Person(5,"Nam5","Surname5",new LocalDate(1974,2,8),Gender.FEMALE);

    	PersonRepasitory pr=new PersonRepasitory(4);
       
        pr.add(p1);
        pr.add(p2);
        pr.add(p3);
        pr.add(p4);
        pr.add(p5);
        //System.out.println(pr.capacity); 
        
        for(Person p:pr)
        {
        	System.out.println(p);
        }
        
        
    }
}
