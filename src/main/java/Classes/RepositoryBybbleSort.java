package Classes;
import java.util.Comparator;

import ru.vsu.lab.entities.IPerson;
import  ru.vsu.lab.repository.*;

public class RepositoryBybbleSort<T> implements RepositorySort<T>{
	
	public  IRepository<T> Sort(Comparator<T> comparator,IRepository<T> rep,int size)
	{
		IRepository<T> rep2=rep;
		boolean needIteration = true;
		while (needIteration) {
			needIteration = false;

		for (int i = 1; i < size; i++) {
			if (comparator.compare(rep2.get(i),rep.get(i-1))<0) {	
				swap(rep2, i, i-1);
				needIteration = true;

				}
		 	}	
		}
		
		return rep2;
	}
	
	private void swap(IRepository<T> rep, int index1, int index2) {
		T tmp = rep.get(index1);
		rep.set(index1, rep.get(index2));
		rep.set(index2,tmp);
	}
}
