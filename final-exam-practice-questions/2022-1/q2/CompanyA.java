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

		var weight = parcel.getWeight();
		var distance = calculateDistance(parcel);

		var weight_fee = 0.0;
		var distance_fee = 0.0;

		if (distance>deliveryRadius){
			distance_fee+= distance;
		}
		if (weight<=20){
			weight_fee = weight*1.3;
		}
		if (weight>20 && weight<=40){
			weight_fee = 20*1.3 + (weight-20)*1.7;
		}
		if (weight>40 && weight<=60){
			weight_fee = 20*1.3 + 20*1.7 + (weight-40)*2.4;
		}
		if (weight>60){
			weight_fee = 20*1.3 + 20*1.7 + 20*2.4 + (weight-60)*3.2;
		}

		quote = weight_fee+distance_fee;

		// ########## YOUR CODE ENDS HERE ##########

		return quote;
	}
}
