package Classes;
import ru.vsu.lab.repository.*;
import java.util.function.Predicate;

public abstract class RepositorySearch<T> {
	
	public  abstract IRepository<T> Search(Predicate<T> pred,IRepository<T> rep,int size);

}
