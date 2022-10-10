import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You can use this to test your BST implementation.
 * NOTE: When marking your submission, there can be more tests.
 * 
 * @author huy.pham
 */
public class BSTTest {

	@Test
	public void testSimple() {
		BST bst = new BST();

		bst.insert("a");
		bst.insert("b");

		assertEquals("a", bst.printOddNodes().trim());
		assertEquals(null, bst.find("aa"));
		assertEquals("b", bst.find("b").value);
	}
	
	@Test
	public void testPrintOddNodes() {
		BST bst = new BST();
		
		bst.insert("cccb");
		bst.insert("c");
		bst.insert("b");
		bst.insert("a");
		bst.insert("d");
		bst.insert("e");

		assertEquals("c b d", bst.printOddNodes().trim());
	}
}
