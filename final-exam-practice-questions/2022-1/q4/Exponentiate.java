public class Exponentiate {

	private final int a;
	private final int b;

	public Exponentiate(int a, int b) {
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
		int ret = this.a;
		for (int i = 0; i < this.b - 1; i++) {
			ret *= i;
		}

		return ret;
	}
}
