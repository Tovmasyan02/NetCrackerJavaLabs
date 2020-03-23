package Algorithms;

import java.util.function.Predicate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Classes.Repository;
import Interfaces.RepositorySearch;
import ru.vsu.lab.repository.*;

public class  RepositoryLinearSearch<T> implements RepositorySearch<T> {
	
	private static Logger logger = LoggerFactory.getLogger(RepositoryLinearSearch.class);
    public  IRepository<T> Search(Predicate<T> pred,IRepository<T> rep,int size)
    {
    	logger.trace("LinearSearch");
    	IRepository<T> newRep=new Repository<T>();
		for(int i=0;i<size;i++)
		{
			if(pred.test(rep.get(i)))
			{
				newRep.add(rep.get(i)); 
			}
		}
		return newRep;	
    }
    
}
