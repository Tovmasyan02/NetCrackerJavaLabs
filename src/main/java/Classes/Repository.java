package Classes;

import java.util.Comparator;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;


import Interfaces.IPerson;
import Interfaces.IRepository;

public class Repository implements IRepository {
	
	private IPerson[] persons;
	public int capacity = 2;
	private int size=0;
	
	   
	public Repository()
	{
		persons=new IPerson[capacity];
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
	    this.size=newPersons.length;
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
		// TODO Auto-generated method stub
		
	}

	public IRepository searchBy(Predicate<IPerson> condition) {
		// TODO Auto-generated method stub
		return null;
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
	
}
