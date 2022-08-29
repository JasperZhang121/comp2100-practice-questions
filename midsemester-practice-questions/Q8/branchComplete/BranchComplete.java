
public class BranchComplete {

	public static int findSomething(int a, int b, int c, int d) {

		int x = 0;

		if (a < 0 || b < 0 || c < 0 || d < 0) {
			x = a + b - c;
		}

		if (a < b) {
			if (a < c) {
				return a + x;
			} else {
				return c * x;
			}
		} else if (b > c || b > d) {
			return b + x;
		} else {
			return c - x;
		}
	}
}
