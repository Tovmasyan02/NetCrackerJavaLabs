package Classes;

import java.util.Comparator;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;
import com.opencsv.*;

import Enums.Gender;
import Interfaces.IPerson;
import Interfaces.IRepository;

public class Repository implements IRepository{
	
    /*
     * Array for Person Repository
     */
	private IPerson[] persons;
    /*
     * capacity for Repository 
     * set default value for capacity(capacity=8)
     */
	public int capacity = 8;
	/*
	 * count of items in the field persons
	 */
	private int size=0;
	

	/*
	 * constructor without parameters
	 * create an Array of type IPerson with capacity(8)    
	 */
	public Repository()
	{
		persons=new IPerson[capacity];
	}
	
	/*
	 * constructor with one parameter
	 * set the capacity field value
	 * create an Array of type IPerson with 
	 */
	public Repository(int capacity)
	{
		this.capacity=capacity;
		persons=new IPerson[this.capacity];
	}
	
	public void add(IPerson person) {
		if(size==capacity)
		{ 
		  this.capacity*=2;
		  IPerson[] newPersons=new IPerson[this.capacity];
		  this.copyArray(newPersons,this.persons);
		  this.persons=newPersons;
		}
		
		this.persons[size]=person;
		size++;
	}
	
	public void add(int index, IPerson person) {	     
		this.checkIndex(index);
		IPerson[] newPersons=new IPerson[this.capacity+5];
	    for(int i=0;i<index;i++)
	    {
	    	newPersons[i]=this.persons[i];
	    }
	    newPersons[index]=person;
	    for(int i=index;i<size;i++)
	    {
	    	newPersons[i+1]=this.persons[i];
	    }
	    this.size++;
	    this.persons=newPersons;
	}
	
	public int getSize()
	{
		return size;
	}

	public IPerson get(int index) {
	    checkIndex(index);
		return persons[index];
	}


	public void set(int index, IPerson person) {
		this.checkIndex(index);
		this.persons[index]=person;
		
	}


	public List<IPerson> toList() {
		ArrayList<IPerson> PersonList=new ArrayList<IPerson>();
		for(int i=0;i<this.size;i++)
		{
			PersonList.add(this.persons[i]);
		}
		
		return PersonList;
	}
	
	
	public IPerson delete(int index) {
		return null;
	}

	public void sortBy(Comparator<IPerson> comparator) {
		boolean needIteration = true;
		while (needIteration) {
			needIteration = false;

		for (int i = 1; i < size; i++) {
			if (comparator.compare(this.persons[i],this.persons[i-1])<0) {	
				swap(this.persons, i, i-1);
				needIteration = true;

				}
		 	}	
		}
	}
	
	private void swap(IPerson[] array, int index1, int index2) {
	    IPerson tmp = array[index1];
	    array[index1] = array[index2];
	    array[index2] = tmp;
	}

	public IRepository searchBy(Predicate<IPerson> pred) {
	
		Repository newRep=new Repository();
		for(int i=0;i<size;i++)
		{
			if(pred.test(this.persons[i]))
			{
				newRep.add(this.persons[i]); 
			}
		}
		
		return newRep;
	}
	
	
	private void checkIndex(int index)  
	{
		if(index>this.size)
		{ 
			throw new IndexOutOfBoundsException();
		}
	}
	private void copyArray(IPerson[] nextArray, IPerson[] previousArray) {
		for (int i = 0; i < previousArray.length; i++) {
			nextArray[i] = previousArray[i];
			
		}
	}
	
	@Override
	public Object clone(){
	     Repository newrap=new Repository(this.capacity);
	     for(int i=0;i<size;i++)
	     {
	    	 newrap.add(this.persons[i]);
	     }
	     return newrap;	}
	
	
	public static Repository readAllDataAtOnce(String file) 
	{ 
		Repository rep=new Repository();
		try { 
			FileReader filereader = new FileReader(file); 
			CSVReader csvReader = new CSVReaderBuilder(filereader) 
									.withSkipLines(1) 
									.build(); 
			List<String[]> allData = csvReader.readAll(); 
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
			for(int i=0;i<allData.size();i++)
			{
				String[] data=allData.get(i)[0].split(";");
				Person newPerson=new Person(
						Integer.parseInt(data[0]),
						data[1],
						Gender.mm(data[2]),
						LocalDate.parse(data[3], dtf),
						data[4],
						Integer.parseInt(data[5])
								);
				rep.add(newPerson);
			}
			
			
		   } 
		
		catch (Exception e) { 
			e.printStackTrace(); 
		}
		
		return rep;
		 
	} 

}
