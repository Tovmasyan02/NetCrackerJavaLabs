package Classes;

import java.util.function.Predicate;

public abstract class RepositorySearch<T> {
	
	public  abstract Repository<T> Search(Predicate<T> pred,Repository<T> rep,int size);

}
