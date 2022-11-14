import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class ExpressCompany implements ParcelHandler {

	protected final Point location;
	protected final int deliveryRadius;
	protected final List<ItemType> illegalItems = new LinkedList<>();

	public ExpressCompany(Point location, int deliveryRadius, List<ItemType> illegalItems) {
		this.location = location;
		this.deliveryRadius = deliveryRadius;
		this.illegalItems.addAll(illegalItems);
	}

	public double handle(Parcel parcel) throws IllegalParcelItemException {
		safetyCheckOnItems(parcel);

		return calculateQuote(parcel);
	}

	@Override
	public void safetyCheckOnItems(Parcel parcel) throws IllegalParcelItemException {

		// TODO
		// ########## YOUR CODE STARTS HERE ##########
		for(var item: parcel.getItems()){
			if (illegalItems.contains(item)) throw new IllegalParcelItemException();
		}
		// ########## YOUR CODE ENDS HERE ##########
	}

	public int calculateDistance(Parcel parcel) {

		int distance = 0;

		// TODO
		// HINT: You can use the functions in Math library, e.g. Math.ceil(),
		// Math.sqrt(), Math.pow()
		// ########## YOUR CODE STARTS HERE ##########

		var res = Math.sqrt(Math.pow((location.x-parcel.getDestination().x),2)+Math.pow(location.y-parcel.getDestination().y,2));
		distance = (int)Math.ceil(res);

		// ########## YOUR CODE ENDS HERE ##########

		return distance;
	}

	public abstract double calculateQuote(Parcel parcel);
}
