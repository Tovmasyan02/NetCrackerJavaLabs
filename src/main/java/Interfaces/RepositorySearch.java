package Interfaces;
import ru.vsu.lab.repository.*;
import java.util.function.Predicate;

public interface  RepositorySearch<T> {
	
	public  abstract IRepository<T> Search(Predicate<T> pred,IRepository<T> rep,int size);

}
