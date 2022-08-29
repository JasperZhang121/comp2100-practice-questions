
public class Subtraction extends Operation {

	public Subtraction(double a, double b) {
		super(a, b);
	}

	@Override
	public double evaluate() {
		return a - b;
	}
}
