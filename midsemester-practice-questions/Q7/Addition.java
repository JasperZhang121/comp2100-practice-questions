
public class Addition extends Operation {

	public Addition(double a, double b) {
		super(a, b);
	}

	@Override
	public double evaluate() {
		return this.a + this.b;
	}
}
