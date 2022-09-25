import java.util.ArrayList;
import java.util.List;

public class GreenGrocery implements Grocery<Fruit> {

	private final List<Fruit> fruits = new ArrayList<>();

	public GreenGrocery() {
	}

	public List<Fruit> getFruits() {
		return fruits;
	}

	@Override
	public void restock(List<Fruit> fruits) {
		this.fruits.addAll(fruits);
	}

	@Override
	public Iterator<Fruit> getIterator() {
		return new FruitIterator(this);
	}

	public class FruitIterator implements Iterator<Fruit> {

		private final GreenGrocery grocery;

		public FruitIterator(GreenGrocery grocery) {
			this.grocery = grocery;
		}

		int index;

		@Override
		public boolean hasNext() {
			if (grocery.fruits.size()!=0 && index<grocery.fruits.size())return true;
			return false;

		}

		@Override
		public Fruit next() {
			if (hasNext())return grocery.fruits.get(index++);
			return null;
		}
	}
}
