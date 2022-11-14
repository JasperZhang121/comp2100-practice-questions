import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class BranchCompleteTest {

	@Test
	public void test() {
		// TODO
		// START YOUR CODE
		// HINT: assertEquals(result, BranchComplete.findSomething(a, b, c, d));

		// END YOUR CODE

		assertEquals(-20,BranchComplete.findSomething(-10,5,5,5));
		assertEquals(-150,BranchComplete.findSomething(-10,5,-15,5));
		assertEquals(1,BranchComplete.findSomething(2,1,0,0));
		assertEquals(6,BranchComplete.findSomething(10,5,6,6));
	}
}
