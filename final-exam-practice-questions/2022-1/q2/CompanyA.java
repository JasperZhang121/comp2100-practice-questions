import java.util.List;

public class CompanyA extends ExpressCompany {

	public CompanyA(Point location, int deliveryRadius, List<ItemType> illegalItems) {
		super(location, deliveryRadius, illegalItems);
	}

	@Override
	public double calculateQuote(Parcel parcel) {

		double quote = 0;

		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		// ########## YOUR CODE ENDS HERE ##########

		return quote;
	}
}
