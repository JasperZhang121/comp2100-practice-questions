
public abstract class Operation {
	
	protected double a;
	
	protected double b;
	
	public Operation(double a, double b) {
		this.a = a;
		this.b = b;
	}
	
	public abstract double evaluate();
}
