
public class BranchComplete {

	public static boolean findSomething(int a, int b, int c) {
		if (a < 0 || b < 0) {
			return a < b || a > c;
		}

		return a < b && a > c;
	}
}
