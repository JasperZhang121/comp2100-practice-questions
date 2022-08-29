import static org.junit.Assert.assertEquals;

import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class GroceryTest {

	@Test
	public void test() {
		List<Fruit> fruits = new LinkedList<>(EnumSet.allOf(Fruit.class));

		Grocery<Fruit> grocery = new GreenGrocery();
		grocery.restock(fruits);
		
		List<Fruit> list = new LinkedList<>();
		
		Iterator<Fruit> iterator = grocery.getIterator();
		while(iterator.hasNext()) {
			list.add(iterator.next());
		}
		
		assertEquals(fruits, list);
	}
}
