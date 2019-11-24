package Classes;
import ru.vsu.lab.repository.*;
import ru.vsu.lab.entities.*;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.*;
import java.util.List;


public class PersonRepository extends PersonRepositoryIO implements IPersonRepository {
		
	
	    /**
	     * массив (IPerson)
	     */
	
		private IPerson[] persons;
	    /**
	     * Ёмкость массива
	     * Емкость по умолчанию=8
	     * 
	     */
		public int capacity = 8;
		
		/**
		 * количество элементов в массиве persons
		 */
		private int size=0;
		

		/**
		 * Конструктор без параметров
		 * создает массив с длинной- 8
		 *    
		 */
		public PersonRepository()
		{
			persons=new IPerson[capacity];
		}
		
		/**
		 * Конструктор с 1  параметром
		 * Устанавливает значение для поля Capacity 
		 */
		public PersonRepository(int capacity)
		{
			this.capacity=capacity;
			persons=new IPerson[this.capacity];
		}
		
		/**
		 * Добавляет один элемент в коллекцию
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
		
		/**
		 *  Добавляет один элемент в коллекцию
		 * @param index
		 *        индекс
		 * @param person
		 *        элемент
		 * @throw IndexOutOfBoundsException
		 *         если индкест больше чем длина коллекции
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
		
		/**
		 * длина коллекции
		 */
		public int getSize()
		{
			return size;
		}

		/*
		 * 
		 * @throw IndexOutOfBoundsException
		 *        если индекс больше чем длина коллекции
		 */
		public IPerson get(int index) {
		    checkIndex(index);
			return persons[index];
		}


		/**
		 * устанавливает элемент по индексу
		 * @throw IndexOutOfBoundsException
		 *        если индекс больше чем длина коллекции
		 * 
		 */
		public IPerson set(int index, IPerson person) {
			this.checkIndex(index);
			this.persons[index]=person;
			return person;
		}


		/**
		 * Возвращает список(List<IPerson>)
		 */
		public List<IPerson> toList() {
			ArrayList<IPerson> PersonList=new ArrayList<IPerson>();
			for(int i=0;i<this.size;i++)
			{
				PersonList.add(this.persons[i]);
			}
			
			return PersonList;
		}
		
		
		/**
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
		
		/**
		 * сортирует коллекцию 
		 */
		public void sortBy(Comparator<IPerson> personAgeComparator) {
			
			PersonRepositorySort.bubbleSort(personAgeComparator, this, this.size);
			
		}
		
		
		/**
		 * возвращает все элементы которые удовлетворяют условию предиката
		 */
		public IRepository<IPerson> searchBy(Predicate<IPerson> pred) {
		
			return PersonRepositorySearch.linearSearch(pred, this, this.size);
		}
		
		
		/**
		 * если индекс больше чем длина коллекции то возвращает ошибку
		 */
		private void checkIndex(int index)  
		{
			if(index>this.size)
			{ 
				throw new IndexOutOfBoundsException();
			}
		}
		
		
		/**
		 * копирует элементы из одного массива в другую
		 */
		private void copyArray(IPerson[] nextArray, IPerson[] previousArray) {
			for (int i = 0; i < previousArray.length; i++) {
				nextArray[i] = previousArray[i];
				
			}
		}
		
		@Override
		public Object clone(){
		     PersonRepository newrap=new PersonRepository(this.capacity);
		     for(int i=0;i<size;i++)
		     {
		    	 newrap.add(this.persons[i]);
		     }
		     return newrap;	
		     }
		
}
