
public class PostOffice {

	public PostOffice() {
	}

	public void registerParcel(Parcel parcel) {
		Status.REGISTERED.setStatus(parcel);
	}
}
