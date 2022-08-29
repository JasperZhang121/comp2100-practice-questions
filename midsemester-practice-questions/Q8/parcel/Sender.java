
public class Sender {

	public Sender() {
	}

	public Parcel order(int weight, int allowedDelay, Recipient recipient) {
		return new Parcel(weight, allowedDelay, this, recipient);
	}
}
