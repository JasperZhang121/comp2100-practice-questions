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
		assertEquals(0,BranchComplete.findSomething(1,2,0,0));
		assertEquals(5,BranchComplete.findSomething(10,5,5,0));
	}
}
