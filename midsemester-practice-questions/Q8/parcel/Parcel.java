public class Parcel {

	private final int weight;

	private final int allowedDays;

	private final Sender sender;

	private final Recipient recipient;

	private Status status;

	public Parcel(int weight, int allowedDays, Sender sender, Recipient recipient) {
		this.weight = weight;
		this.allowedDays = allowedDays;
		this.sender = sender;
		this.recipient = recipient;
		this.status = Status.ORDERED;
	}

	public int getWeight() {
		return weight;
	}

	public int getAllowedDays() {
		return allowedDays;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Sender getSender() {
		return sender;
	}

	public Recipient getRecipient() {
		return recipient;
	}
}
