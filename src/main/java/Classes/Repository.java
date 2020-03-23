package Classes;
import ru.vsu.lab.repository.*;
import ru.vsu.lab.entities.*;
import java.util.function.Predicate;

import javax.xml.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;
import java.util.*;
import java.util.List;
import Annotations.InjectAnnotation;
import Interfaces.RepositorySearch;
import Interfaces.RepositorySort;


@XmlRootElement(name="repository")
@XmlSeeAlso({Person.class})
public class Repository<T>  implements IRepository<T> {
	
	private static Logger logger = LoggerFactory.getLogger(Repository.class);
	@InjectAnnotation
	private RepositorySort<T> sort;
	     
    @InjectAnnotation
    private RepositorySearch<T> search;
     
	@XmlElementWrapper(name = "studentList")
	@XmlElement(name="persons")
 	private Object[] persons;

    @XmlTransient
	public int capacity = 8;
	

    @XmlTransient
	private int size=0;

	public Repository()
	{
		persons=new Object[capacity];
	}
	

	public Repository(int capacity)
	{
		this.capacity=capacity;
		persons=new Object[this.capacity];
	}
	

	public void add(T person) {
		logger.trace("New Person {} ", person);
		
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
	

	public void add(int index, T person) {	 
		logger.trace("New Person on index {},{} ", index,person);
		
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
	

	public int getSize()
	{
		return size;
	}

	
	@SuppressWarnings("unchecked")
	private T getX(int index)
	{
		return (T)this.persons[index];
	}
	
	public T get(int index) {
	    checkIndex(index);
			return this.getX(index);
	}



	public T set(int index, T person) {
		this.checkIndex(index);
		this.persons[index]=person;
		return person;
	}
	

	public List<T> toList() {
		ArrayList<T> PersonList=new ArrayList<T>();
		for(int i=0;i<this.size;i++)
		{
			PersonList.add(this.getX(i));
		}
		
		return PersonList;
	}
	

	public T delete(int index) {
		logger.trace("Method delete, index - {}", index);
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
			logger.error("index>size  - IndexOutOfBoundsException");
			throw new IndexOutOfBoundsException();
		}
		
	}
	
	
	private void copyArray(Object[] nextArray, Object[] previousArray) {
		for (int i = 0; i < previousArray.length; i++) {
			nextArray[i] = previousArray[i];
			
		}
	}

	public IRepository<T> searchBy(Predicate<T> pred) {
	
		return this.search.Search(pred, this, this.size);
	
	}

	public void sortBy(Comparator<T> comp) {
		
		this.sort.Sort(comp, this, this.size);
		
	}


	
	
}
