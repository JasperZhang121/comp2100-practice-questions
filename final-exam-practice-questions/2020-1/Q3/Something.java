/**
 *
 * @author nanwang
 *
 */
public class Something {

	private static final int VALUE1 = 36;
	private static final int VALUE2 = 15;

	private static int method1(int n1, int n2) {
		if (n1 >= n2) {
			while (n1 >= n2) {
				n1 -= n2;
			}

			return n1;
		} else {
			while (n2 >= n1) {
				n2 -= n1;
			}

			return n2;
		}
	}

	private static int method2(int n1, int n2) {
		while (n1 != n2) {
			if (n1 > n2)
				n1 -= n2;
			else
				n2 -= n1;
		}
		return n2;
	}

	private static int method3(int n1, int n2) {
		return n1 * n2 / method2(n1, n2);
	}

	public static int someMethod(int n1, int n2, int n3, int n4) {
		int sum = 0;
		if (method2(n1, n2) == VALUE1) {
			if (method3(n1, n3) == method3(n2, n4)) {
				sum += n1 + n4;
			}
			sum += n1 + n2;
		}

		if (method1(n3, n4) == VALUE2) {
			sum += n3 + n4;
		}

		return sum;
	}
}
