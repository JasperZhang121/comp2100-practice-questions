package tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tree.BST.Node;

public class Task2Test {
	BST simpleBst;
	BST complexBst;

	public static String preOrderTraversal(Node node) {
		if (node.left == null && node.right == null)
			return node.value.toString();
		else {
			String leftStr = "";
			String rightStr = "";
			if (node.left != null) {
				leftStr = preOrderTraversal(node.left);
			}
			if (node.right != null) {
				rightStr = preOrderTraversal(node.right);
			}
			return node.value.toString() + (leftStr.isEmpty() ? leftStr : " " + leftStr)
					+ (rightStr.isEmpty() ? rightStr : " " + rightStr);
		}
	}

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
	public void deleteSimpleTest1() {
		simpleBst.delete(1);
		assertEquals("0 2 3 4 5 6 7 8 9", preOrderTraversal(simpleBst.root).trim());
	}
	
	@Test
	public void deleteSimpleTest2() {
		simpleBst.delete(9);
		assertEquals("0 1 2 3 4 5 6 7 8", preOrderTraversal(simpleBst.root).trim());
	}

	@Test
	public void deleteComplexTest1() {
		complexBst.delete(15);
		assertEquals("10 7 3 16 12 17 20", preOrderTraversal(complexBst.root).trim());
	}
	
	@Test
	public void deleteComplexTest2() {
		complexBst.delete(10);
		assertEquals("12 7 3 15 17 16 20", preOrderTraversal(complexBst.root).trim());
	}
}
