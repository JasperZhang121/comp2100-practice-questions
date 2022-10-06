package tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task3Test {
	BST simpleBst;
	BST complexBst;

	@Before
	public void constructTree() {
		simpleBst = new BST();
		for (int i = 0; i < 10; i++) {
			simpleBst.insert(i);
		}

		complexBst = new BST();
		complexBst.insert(10);
		complexBst.insert(7);
		complexBst.insert(3);
		complexBst.insert(15);
		complexBst.insert(12);
		complexBst.insert(17);
		complexBst.insert(16);
		complexBst.insert(20);
	}
	
	@Test
	public void testSimpleSum1() {
		assertEquals(9, simpleBst.sumEvenNodes());
	}

	@Test
	public void testComplexSum1() {
		assertEquals(93, complexBst.sumEvenNodes());
	}
}
