import java.util.List;

public interface Grocery<T> {
	public Iterator<T> getIterator();
	
	public void restock(List<T> list);
}
