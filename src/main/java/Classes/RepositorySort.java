package Classes;
import ru.vsu.lab.repository.*;
import java.util.Comparator;

public interface RepositorySort<T> {
	
	public abstract IRepository<T> Sort(Comparator<T> comparator,IRepository<T> rep,int size);
}
