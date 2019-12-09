package NetCracker_Lab3.lab_3;


import Classes.*;

import java.io.IOException;
import java.lang.String;
import ru.vsu.lab.entities.*;
import ru.vsu.lab.repository.IRepository;
import java.util.*;
import java.lang.reflect.*;
import java.util.Comparator;
import java.util.stream.Collectors;
/**
 * Hello world!
 *
 */


public class App 
{
    public static void main( String[] args ) 
    {
    
        ///////////////1///////////////////////////////////////////
    	IRepository<IPerson> rep=PersonRepositoryIO.readAllDataFromCSV("src\\main\\resources\\personsX.csv");
    	List<IPerson> persons=rep.toList();
    	/*
    	Map<IDivision,Integer> mapp=persons.stream()
    	.collect(Collectors.groupingBy(IPerson::getDivision,Collectors.summingInt(p->{
    		Person pp=(Person)p;
    		return  pp.getSalary().intValue();
    	})));
    	 for(Map.Entry<IDivision, Integer> item : mapp.entrySet()){
    		 System.out.println(item.getKey().getName());
             System.out.println(item.getValue());
         } 
    	 
    	 //////////////////////2/////////////////////////
    	 */
    	/*
    	 persons.stream()
    	 .filter(pp->{
    		 Person p=(Person)pp;
    		 return p.getAge()>35 && p.getSalary().intValue()>3000 && p.getFirstName().contains("a");
    		 })
    	 .forEach(e->
    	 {
    		 System.out.println(e.getAge()+"  "+e.getSalary()+"    "+e.getFirstName());
         });
    	 ;
    	*/
    	/*
    	 Map<Integer,Long> map3=persons.stream()
    	 .collect(Collectors.groupingBy(p->
    	 {
    		 Person pp=(Person)p; 
    	 return pp.getBirthdate().getYear();
    	 }, Collectors.counting()));
    	 
    	 for(Map.Entry<Integer,Long> item : map3.entrySet()){
    		 System.out.println(item.getKey());
             System.out.println(item.getValue());
         }
         */
    	
    	persons.stream()
    	.filter(e->e.getFirstName().matches(".re*aa.re*"))
    	.forEach(e-> System.out.println(e.getFirstName()));
    }
}
