public interface ParcelHandler {

	public void safetyCheckOnItems(Parcel parcel) throws IllegalParcelItemException ;

	public double calculateQuote(Parcel parcel);
}
