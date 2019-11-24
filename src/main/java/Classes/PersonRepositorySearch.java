package Classes;

import java.util.function.Predicate;

import ru.vsu.lab.entities.IPerson;
import ru.vsu.lab.repository.*;

public class  PersonRepositorySearch {
	
    public static IPersonRepository BubbleSearch(Predicate<IPerson> pred,IPersonRepository rep,int size)
    {
    	PersonRepository newRep=new PersonRepository();
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
