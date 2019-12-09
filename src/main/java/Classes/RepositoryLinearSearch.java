package Classes;

import java.util.function.Predicate;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.*;

public class  RepositoryLinearSearch<T> extends RepositorySearch<T> {
	
    public  IRepository<T> Search(Predicate<T> pred,IRepository<T> rep,int size)
    {
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
