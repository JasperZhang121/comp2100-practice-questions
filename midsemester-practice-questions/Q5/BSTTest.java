import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

	BST tree;

	private boolean isSameIgnoringOrder(String expected, String actual) {
		if (expected.length() != actual.length()) return false;

		StringBuilder sbActual = new StringBuilder(actual);

		for (int i = 0; i < expected.length(); i++) {
			String tmp = sbActual.toString();
			int j = 0;
			while (j < tmp.length()) {
				if (tmp.charAt(j) == expected.charAt(i)) break;
				j++;
			}

			if (j < tmp.length()) {
				sbActual.deleteCharAt(j);
			} else {
				return false;
			}
		}

		return true;
	}

	@Before
	public void init() {
		this.tree = new BST();

		this.tree.insert(50, 'A');

		this.tree.insert(30, 'C');
		this.tree.insert(25, 'T');
		this.tree.insert(12, 'A');
		this.tree.insert(35, 'G');

		this.tree.insert(70, 'G');
		this.tree.insert(78, 'C');
		this.tree.insert(75, 'A');
		this.tree.insert(72, 'C');
		this.tree.insert(85, 'T');
	}

	@Test(timeout=1000)
	public void testNodeWithOddChildren() {
		assertEquals("T", this.tree.DNAGenerator(25));
	}

	@Test(timeout=1000)
	public void testNodeWithEvenChildren() {
		assertEquals("T", this.tree.DNAGenerator(30));
	}

	@Test(timeout=1000)
	public void testNonexistentNode() {
		assertEquals("CGTA", this.tree.DNAGenerator(17));
	}

	@Test(timeout=1000)
	public void testHigherNodeWithOddChildren() {
		assertTrue(isSameIgnoringOrder("AG", this.tree.DNAGenerator(70)));
	}

	@Test(timeout=1000)
	public void testNodeWithNoChildren() {
		assertNull(this.tree.DNAGenerator(12));
	}
}
