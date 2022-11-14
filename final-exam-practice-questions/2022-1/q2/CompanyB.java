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

		var weight = parcel.getWeight();
		var distance = calculateDistance(parcel);

		var weight_fee = 0.0;
		var distance_fee = 0.0;

		if (distance>deliveryRadius) distance_fee= (distance)*1.1;

		if (weight<=30){
			weight_fee = 46;
		}
		if (weight>30 && weight<=40){
			weight_fee = 46+ (weight-30)*1.5;
		}
		if (weight>40 && weight<=50){
			weight_fee = 46+ 10*1.5+(weight-40)*2.1;
		}
		if (weight>50 && weight<=60){
			weight_fee = 46+ 10*1.5+10*2.1+(weight-50)*2.9;
		}
		if (weight>60){
			weight_fee = 46+ 10*1.5+10*2.1+10*2.9+(weight-60)*3.6;
		}
		quote = weight_fee+distance_fee;

		// ########## YOUR CODE ENDS HERE ##########

		return quote;
	}
}
