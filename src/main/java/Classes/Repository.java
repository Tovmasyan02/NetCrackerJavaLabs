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
     * массив (IPerson)
     */
	private IPerson[] persons;
    /*
     * Ёмкость массива
     * начальная ёмкость=8
     * 
     */
	public int capacity = 8;
	/*
	 * количество элементов в массиве persons
	 */
	private int size=0;
	

	/*
	 * конструктор без параметров 
	 * создаёт массив с длиной - 8
	 *    
	 */
	public Repository()
	{
		persons=new IPerson[capacity];
	}
	
	/*
	 * конструтор с 1 параметром
	 * устанавливает значание для поля Capacity
	 * create an Array of type IPerson with 
	 */
	public Repository(int capacity)
	{
		this.capacity=capacity;
		persons=new IPerson[this.capacity];
	}
	
	/*
	 * Добавляет 1 элемент в коллекцию
	 */
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
	
	/*
	 * Добавляет 1 элемент в коллекцию 
	 * @param index
	 *        индекс
	 * @param person
	 *        элемнент
	 * @throw IndexOutOfBoundsException
	 *        если индкест больше чем длина коллекции
	 */
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
	
	/*
	 * длина коллекции
	 */
	public int getSize()
	{
		return size;
	}

	/*
	 * Возвращает элементу по индексу
	 * @throw IndexOutOfBoundsException
	 *        если индкест больше чем длина коллекции
	 */
	public IPerson get(int index) {
	    checkIndex(index);
		return persons[index];
	}


	/*
	 * устанавливает элемент по индексу
	 * @throw IndexOutOfBoundsException
	 *        если индкест больше чем длина коллекции
	 * 
	 */
	public void set(int index, IPerson person) {
		this.checkIndex(index);
		this.persons[index]=person;
		
	}


	/*
	 * Возврашает список
	 */
	public List<IPerson> toList() {
		ArrayList<IPerson> PersonList=new ArrayList<IPerson>();
		for(int i=0;i<this.size;i++)
		{
			PersonList.add(this.persons[i]);
		}
		
		return PersonList;
	}
	
	
	/*
	 * удаляет элемент из списка
	 * @throw IndexOutOfBoundsException
	 *        если индкест больше чем длина коллекции
	 * 
	 */
	public IPerson delete(int index) {
		this.checkIndex(index);
		IPerson[] newRep=new IPerson[this.capacity];
		for(int i=0;i<index;i++)
			newRep[i]=this.persons[i];
		for(int i=index;i<this.size-1;i++)
			newRep[i]=this.persons[i+1];
		IPerson p=this.persons[index];
		this.persons=newRep;
		size--;
		
		return p;
	}

	/*
	 * сортирует коллекцию 
	 */
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
	
	/*
	 * меняет местами 2 элемента
	 */
	private void swap(IPerson[] array, int index1, int index2) {
	    IPerson tmp = array[index1];
	    array[index1] = array[index2];
	    array[index2] = tmp;
	}

	/*
	 * возвращает все элементы которые удовлетворяют условию предиката
	 */
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
	
	/*
	 * если индекс больше чем длина коллекции то возвращает ошибку
	 */
	private void checkIndex(int index)  
	{
		if(index>this.size)
		{ 
			throw new IndexOutOfBoundsException();
		}
	}
	
	/*
	 * копирует значение из одного массива в другую
	 */
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
	
	
	/*
	 * Читает все данные из CSV Файла создает Repository, заполняет и возвращает.
	 */
	@SuppressWarnings("deprecation")
	public static Repository readAllDataFromCSV(String path) 
	{ 
		Repository rep=new Repository();
		try
		{
			
			FileReader filereader = new FileReader(path); 
			CSVReader reader = new CSVReader(filereader, ';');
			try { 
				
				List<String[]> allData = reader.readAll();
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d.MM.yyyy");
				for(int i=1;i<allData.size()-1;i++)
				{	
					Person newPerson=new Person(
							Integer.parseInt(allData.get(i)[0]),
							allData.get(i)[1],
							Gender.StringToGender(allData.get(i)[2]),
							LocalDate.parse(allData.get(i)[3], dtf),
							allData.get(i)[4],
							Integer.parseInt(allData.get(i)[5])
									);
					rep.add(newPerson);	
				}
			   } 
			
			catch (Exception e) { 
				
				e.printStackTrace(); 
				e.getClass();
			}
			finally
			{
				reader.close();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace(); 
		}
		
		return rep;
		 
	} 

}
