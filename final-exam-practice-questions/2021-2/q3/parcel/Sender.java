package parcel;

public class Sender extends Person {

	public Sender(CartesianCoordinate location) {
		super(location);
	}

	public Sender(Sender sender) {
		super(sender);
	}

}
