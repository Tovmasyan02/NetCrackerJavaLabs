package Classes;
import ru.vsu.lab.repository.*;
import ru.vsu.lab.entities.*;
import java.util.function.Predicate;
import java.util.Comparator;
import java.util.*;
import java.util.List;


public class PersonRepository extends PersonRepositoryIO implements IPersonRepository {
		
	
	    /*
	     * ������ (IPerson)
	     */
	
		private IPerson[] persons;
	    /*
	     * ������� �������
	     * ��������� �������=8
	     * 
	     */
		public int capacity = 8;
		/*
		 * ���������� ��������� � ������� persons
		 */
		private int size=0;
		

		/*
		 * ����������� ��� ���������� 
		 * ������ ������ � ������ - 8
		 *    
		 */
		public PersonRepository()
		{
			persons=new IPerson[capacity];
		}
		
		/**
		 * ���������� � 1 ����������
		 * ������������� �������� ��� ���� Capacity
		 * create an Array of type IPerson with 
		 */
		public PersonRepository(int capacity)
		{
			this.capacity=capacity;
			persons=new IPerson[this.capacity];
		}
		
		/*
		 * ��������� 1 ������� � ���������
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
		 * ��������� 1 ������� � ��������� 
		 * @param index
		 *        ������
		 * @param person
		 *        ��������
		 * @throw IndexOutOfBoundsException
		 *        ���� ������� ������ ��� ����� ���������
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
		 * ����� ���������
		 */
		public int getSize()
		{
			return size;
		}

		/*
		 *
		 * @throw IndexOutOfBoundsException
		 *        ���� ������� ������ ��� ����� ���������
		 */
		public IPerson get(int index) {
		    checkIndex(index);
			return persons[index];
		}


		/*
		 * ������������� ������� �� �������
		 * @throw IndexOutOfBoundsException
		 *        ���� ������� ������ ��� ����� ���������
		 * 
		 */
		public IPerson set(int index, IPerson person) {
			this.checkIndex(index);
			this.persons[index]=person;
			return person;
		}


		/*
		 * ���������� ������
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
		 * ������� ������� �� ������
		 * @throw IndexOutOfBoundsException
		 *        ���� ������� ������ ��� ����� ���������
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
		 * ��������� ��������� 
		 */
		public void sortBy(Comparator<IPerson> personAgeComparator) {
			
			PersonRepositorySort.bubbleSort(personAgeComparator, this, this.size);
			
		}
		
		
		/*
		 * ���������� ��� �������� ������� ������������� ������� ���������
		 */
		public IRepository<IPerson> searchBy(Predicate<IPerson> pred) {
		
			return PersonRepositorySearch.linearSearch(pred, this, this.size);
		}
		
		/*
		 * ���� ������ ������ ��� ����� ��������� �� ���������� ������
		 */
		private void checkIndex(int index)  
		{
			if(index>this.size)
			{ 
				throw new IndexOutOfBoundsException();
			}
		}
		
		/*
		 * �������� �������� �� ������ ������� � ������
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
