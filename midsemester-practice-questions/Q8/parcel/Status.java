
public enum Status {

	ORDERED, REGISTERED, TRANSFERRING, DELIVERED, RETURNED;

	private boolean called;

	public void setStatus(Parcel parcel) {
		parcel.setStatus(this);

		if (this == Status.TRANSFERRING || this == Status.DELIVERED || this == Status.RETURNED) {
			called = true;
		}
	}

	public boolean isCalled() {
		return called;
	}
}
