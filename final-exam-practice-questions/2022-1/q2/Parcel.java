import java.util.LinkedList;
import java.util.List;

public class Parcel {

	private final List<ItemType> items = new LinkedList<>();
	private final int weight;
	private final Point destination;

	public Parcel(List<ItemType> items, int weight, Point destination) {
		this.items.addAll(items);
		this.weight = weight;
		this.destination = destination;
	}

	public int getWeight() {
		return weight;
	}

	public Point getDestination() {
		return destination;
	}

	public List<ItemType> getItems() {
		return items;
	}
}
