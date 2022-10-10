public class Divide {

	private final int a;
	private final int b;

	public Divide(int a, int b) {
		this.a = a;
		this.b = b;
	}

	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}

	public int calculate() {
		return this.a / this.b;
	}
}
