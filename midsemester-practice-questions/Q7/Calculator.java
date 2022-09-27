public class Calculator {

	public double add(double a, double b) {
		Addition addition = new Addition(a,b);
		return addition.evaluate();
	}

	public double subtract(double a, double b) {

		Subtraction subtraction = new Subtraction(a,b);
		return subtraction.evaluate();
	}

	public double multiply(double a, double b) {

		Multiplication multiplication = new Multiplication(a,b);
		return multiplication.evaluate();
	}

	public double divide(double a, double b) {

		Division division = new Division(a,b);
		return division.evaluate();
	}
}
