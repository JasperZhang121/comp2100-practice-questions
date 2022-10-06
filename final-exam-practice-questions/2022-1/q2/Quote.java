
public class Quote {

	private final ExpressCompany company;
	private final double quote;

	public Quote(ExpressCompany company, double quote) {
		this.company = company;
		this.quote = quote;
	}

	public ExpressCompany getCompany() {
		return company;
	}

	public double getQuote() {
		return quote;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Quote) {
			Quote bq = (Quote) o;

			return this.company == bq.company && this.quote == bq.quote;
		}

		return false;
	}

	@Override
	public String toString() {
		return this.company + ":" + this.quote;
	}
}
