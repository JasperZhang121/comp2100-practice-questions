package parcel;

public class Recipient extends Person {

	public Recipient(CartesianCoordinate location) {
		super(location);
	}
	public Recipient(Recipient recipient) {
		super(recipient);
	}
}
