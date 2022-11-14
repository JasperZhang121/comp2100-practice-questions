import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Fill in the items below with your UID and name:
 * @author: Hao Zhang
 * @UID: u6523462
 */

public class BSTBranchCompleteTest {


	@Test(timeout=1000)
	public void test() {
		
		BranchComplete bc = new BranchComplete();

		// START YOUR CODE
		//HINT: assertEquals(xx, bc.DNATreeCalc(xx, xx, xx));
		
		// END YOUR CODE

		assertEquals(205,bc.DNATreeCalc(209,207,-3));  // TTT
		assertEquals(0,bc.DNATreeCalc(207,209,3)); 	// FFF
		assertEquals(417,bc.DNATreeCalc(209,209,1)); 	// TFF

	}
}
