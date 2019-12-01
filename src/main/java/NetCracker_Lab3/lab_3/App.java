package NetCracker_Lab3.lab_3;


import Classes.*;
import java.lang.String;
import ru.vsu.lab.entities.*;
import java.lang.reflect.*;
import java.util.Comparator;
/**
 * Hello world!
 *
 */

class PersonAgeComparator implements Comparator<IPerson>{
	  
    public int compare(IPerson aa, IPerson bb){
      
    	IPerson a=aa;
    	IPerson b=bb;
        if(a.getId()> b.getId())
            return 1;
        else if(a.getId()< b.getId())
            return -1;
        else
            return 0;
    }

}

public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
    {
    	
    	Repository<IPerson> sjjj=new Repository<IPerson>();
    	Repository<IPerson> x=Inject.<Repository<IPerson>>InjectMethod(sjjj);
    	x.sortBy(new PersonAgeComparator());
    	System.out.println("Xxx");
    }
}
