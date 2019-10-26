package com.netcrackerLab1.Lab1;
import java.util.*;

public class PersonRepasitory implements Iterator<Person>, Iterable<Person>{
  private Person[] Persons;
  private int Capacity=16;
  private int nextCall=0;
  private int iteratorIndex=0;
  
  public Person next() {
	  this.iteratorIndex++;
	  return this.Persons[iteratorIndex-1];
	  
  }
  public boolean hasNext() {
	  if(this.iteratorIndex<this.nextCall)
           return true;
	  return false;
  }
  
  public Iterator<Person> iterator()
  {
	  return this;
  }
  public void remove() {}
  
  public PersonRepasitory()
  {
	 this.Persons=new Person[Capacity];
  }
  
  public PersonRepasitory(int capacity)
  {
	  
	  this.Capacity=capacity;
	  this.Persons=new Person[Capacity];
  }
  
  public int size()
  {
	  return this.nextCall;
  }
  
  public void add(Person person)
  {
	  Persons[this.nextCall]=person;
	  if(++nextCall>this.Capacity)
	  {
		  this.Capacity+=(this.Capacity*0.75);
		  Person[] arr=new Person[this.Capacity];
		  this.copyArray(arr, this.Persons);
		  this.Persons=arr;
	  }
  }
  
  public Person get(int index)
  {
	  Person p;
	  try
	  {
		  p=Persons[index];
	  }
	  catch(ArrayIndexOutOfBoundsException e)
	  {
		  return null;
	  }
	  return p;  	  
  }
  
  
  private void copyArray(Person[] nextArray,Person[] previousArray )
  {
    for(int i=0;i>previousArray.length;i++)
    {
    	nextArray[i]=previousArray[i];
    }
  }
  
  
}
