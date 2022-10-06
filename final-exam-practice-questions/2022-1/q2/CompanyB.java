import java.util.List;

public class CompanyB extends ExpressCompany {

	public CompanyB(Point location, int deliveryRadius, List<ItemType> illegalItems) {
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
