package com.netcrackerLab1.Lab1;
import java.util.*;

public class PersonRepasitory implements Iterator<Person>, Iterable<Person>{
	/**
     массив для хранения экзмемпляров класса person
    */
  private Person[] Persons;
  /**
    
   */
  private int Capacity=16;
  
  /**
   Индекс следующей ячейки где должна программа добавить следю экземпляр при вызове 
   метода add
 */
  public int nextCallIndex=0;
  
  /**
    счетчик для итератора
  */
  private int iteratorIndex=0;
  
  /**
   реализация метода next() интерфейса Iterator
   @return следующий элемент в массиве
  */
  public Person next() {
	  this.iteratorIndex++;
	  return this.Persons[iteratorIndex-1];
	  
  }
  
  /**
    реализация метода hasNext интерфейса Iterator 
    @return существует следующий элемент или нет 
  */
  public boolean hasNext() {
	  if(this.iteratorIndex<this.nextCallIndex)
           return true;
	 this.iteratorIndex=0;
	  return false;
	  
  }
  
  
  /**
   реализация метода iterator интерфейса Iterable
   @return возвращает итерируемый объект
 */
  public Iterator<Person> iterator()
  {
	  return this;
  }
  
  public void remove() {}
  
  /**
   Конструктор без параметров
   создает массив в длинной Capacity(которая есть по умолчанию) 
 */
  public PersonRepasitory()
  {
	 this.Persons=new Person[Capacity];
  }
  
  /**
   Конструктор с 1 параметром
   @param capacity
          начальная длина массива 
   
 */
  public PersonRepasitory(int capacity)
  {
	  
	  this.Capacity=capacity;
	  this.Persons=new Person[Capacity];
  }
  /**
   Возвращает размер коллекции
   @return размер 
 */
  public int size()
  {
	  return this.nextCallIndex;
  }
  
  /**
    Добавляет новый экземпляр класса person в коллекцию
    @param person
           новый экземпляр который надо добавить 
 */
  public void add(Person person)
  {
	  Persons[this.nextCallIndex]=person;
	  if(++nextCallIndex>this.Capacity)
	  {
		  this.Capacity+=(this.Capacity*0.75);
		  Person[] arr=new Person[this.Capacity];
		  this.copyArray(arr, this.Persons);
		  this.Persons=arr;
	  }
  }
  
  /**
   Возвращает объект который находится в ячейка по номеру - index
   @param index 
          индекс ячейки 
   @return Person по индексу index
   
  */ 
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
  
  /**
    копирует данные из одного массива в другую
    @param nextArray
           новый массив
    @param previousArray
           старый массив
            
 */
  private void copyArray(Person[] nextArray,Person[] previousArray )
  {
    for(int i=0;i>previousArray.length;i++)
    {
    	nextArray[i]=previousArray[i];
    }
  }
  
  
}
