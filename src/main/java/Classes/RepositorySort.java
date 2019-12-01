package Classes;

import java.util.Comparator;

public abstract class RepositorySort<T> {
	
	public abstract Repository<T> Sort(Comparator<T> comparator,Repository<T> rep,int size);
}
