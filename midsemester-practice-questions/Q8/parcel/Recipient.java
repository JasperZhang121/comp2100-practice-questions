
public class Recipient {

	public Recipient() {
	}

	public void receive(Parcel parcel) {
		if (this== parcel.getRecipient()) parcel.setStatus(Status.DELIVERED);
		else parcel.setStatus(Status.RETURNED);
	}
}
