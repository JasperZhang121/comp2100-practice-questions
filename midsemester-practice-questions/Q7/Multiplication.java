
public class Multiplication extends Operation {

	public Multiplication(double a, double b) {
		super(a, b);
	}

	@Override
	public double evaluate() {
		return a * b;
	}
}
