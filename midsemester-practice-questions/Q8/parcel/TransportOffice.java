
public class TransportOffice {

	private static TransportOffice instance;

	private TransportOffice() {
	}

	public static TransportOffice getInstance() {
		if (instance==null) instance = new TransportOffice();
		return instance;
	}

	public Transport transportBy(Parcel parcel) {
		if (parcel.getAllowedDays()<=1 && parcel.getWeight()<=20) {parcel.setStatus(Status.TRANSFERRING); return Transport.AIRPLANE;}
		else if ( parcel.getAllowedDays()>1 && parcel.getAllowedDays()<7) {parcel.setStatus(Status.TRANSFERRING);return Transport.TRAIN;}
		else if (parcel.getAllowedDays()>=7){ parcel.setStatus(Status.TRANSFERRING); return Transport.SHIP;}
		else {parcel.setStatus(Status.RETURNED); return null;}
	}
}
