public class QuoteCalculator {

	public static Quote bestQuote(Parcel parcel, ExpressCompany a, ExpressCompany b) throws IllegalParcelItemException {

		Quote quote = null;

		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		a.safetyCheckOnItems(parcel);
		b.safetyCheckOnItems(parcel);


		var a_fee = a.calculateQuote(parcel);
		var b_fee = b.calculateQuote(parcel);

		if (a_fee<b_fee){
			quote = new Quote(a, a_fee);
		}else {
			quote = new Quote(b, b_fee);
		}



		// ########## YOUR CODE ENDS HERE ##########

		return quote;

	}
}
