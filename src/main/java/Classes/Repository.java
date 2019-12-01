package Classes;
import ru.vsu.lab.repository.*;
import ru.vsu.lab.entities.*;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.*;
import java.util.List;
import Annotations.InjectAnnotation;


public class Repository<T>  implements IRepository<T> {
		
	     @InjectAnnotation
	     private RepositorySort<T> sort;
	     private RepositorySearch<T> search=new RepositoryLinearSearch<T>();
	    /**
	     * массив (IPerson)
	     */

		private Object[] persons;
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
		 * создает массив с длинной- 8
		 *    
		 */
		public Repository()
		{
			persons=new Object[capacity];
		}
		
		/**
		 * Устанавливает значение для поля Capacity 
		 */
		public Repository(int capacity)
		{
			this.capacity=capacity;
			persons=new Object[this.capacity];
		}
		
		/**
		 * Добавляет один элемент в коллекцию
		 */
		public void add(T person) {
			if(size==capacity)
			{ 
			  this.capacity*=2;
			  Object[] newPersons=new Object[this.capacity];
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
		public void add(int index, T person) {	     
			this.checkIndex(index);
			Object[] newPersons=new Object[this.capacity+5];
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
		 * @throw IndexOutOfBoundsException
		 *        если индекс больше чем длина коллекции
		 */
		
		@SuppressWarnings("unchecked")
		private T getX(int index)
		{
			return (T)this.persons[index];
		}
		
		public T get(int index) {
		    checkIndex(index);
				return this.getX(index);
		}


		/**
		 * устанавливает элемент по индексу
		 * @throw IndexOutOfBoundsException
		 *        если индекс больше чем длина коллекции
		 * 
		 */
		public T set(int index, T person) {
			this.checkIndex(index);
			this.persons[index]=person;
			return person;
		}


		/**
		 * Возвращает список(List<IPerson>)
		 */
		public List<T> toList() {
			ArrayList<T> PersonList=new ArrayList<T>();
			for(int i=0;i<this.size;i++)
			{
				PersonList.add(this.getX(i));
			}
			
			return PersonList;
		}
		
		
		/**
		 * удаляет элемент из списка
		 * @throw IndexOutOfBoundsException
		 *        если индкест больше чем длина коллекции
		 * 
		 */
		public T delete(int index) {
			this.checkIndex(index);
			Object[] newRep=new Object[this.capacity];
			for(int i=0;i<index;i++)
				newRep[i]=this.persons[i];
			for(int i=index;i<this.size-1;i++)
				newRep[i]=this.persons[i+1];
			T p=this.getX(index);
			this.persons=newRep;
			size--;
			
			return p;
		}
		
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
		private void copyArray(Object[] nextArray, Object[] previousArray) {
			for (int i = 0; i < previousArray.length; i++) {
				nextArray[i] = previousArray[i];
				
			}
		}

		public IRepository<T> searchBy(Predicate<T> pred) {
		
			return this.search.Search(pred, this, this.size);
		
		}

		public void sortBy(Comparator<T> comp) {
			//this.sort=(RepositorySort<T>)this.sort;
			System.out.println(this.sort.getClass().getTypeName());
			this.sort.Sort(comp, this, this.size);
			
		}
		
	
}
