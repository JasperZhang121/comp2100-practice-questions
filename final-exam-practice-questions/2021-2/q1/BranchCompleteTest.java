import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BranchCompleteTest {

	@Test(timeout = 1000)
	public void test() {

		// TODO
		// START YOUR CODE
		// HINT: assertTrue(BranchComplete.findSomething(a, b, c));
		// OR assertFalse(BranchComplete.findSomething(a, b, c));

		assertTrue(BranchComplete.findSomething(-1,0, 0));
		assertFalse(BranchComplete.findSomething(0,0,-1));

		// END YOUR CODE
	}
}
