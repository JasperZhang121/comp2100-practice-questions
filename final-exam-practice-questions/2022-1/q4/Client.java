
public class Client {

	private Add add;
	private Subtract sub;
	private Multiply mul;
	private Divide div;
	private Exponentiate exp;

	public Client(Add add, Subtract sub, Multiply mul, Divide div, Exponentiate exp) {
		this.add = add;
		this.sub = sub;
		this.mul = mul;
		this.div = div;
		this.exp = exp;
	}

	public int compute() {
		if (this.add != null) {
			return this.add.calculate();
		}

		if (this.sub != null) {
			return this.sub.calculate();
		}

		if (this.mul != null) {
			return this.mul.calculate();
		}

		if (this.div != null) {
			return this.div.calculate();
		}

		if (this.exp != null) {
			return this.exp.calculate();
		}
		
		return 0;
	}
}
