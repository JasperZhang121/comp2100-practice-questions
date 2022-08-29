import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {
	
	BST tree;
	
	@Before
	public void init() {
		this.tree = new BST();
	}
	
	@Test
	public void testOddNodeSumTreeSingleRightPath() {
		for (int i = 1; i < 11; i++) {
			this.tree.insert(i);
		}
			
		assertEquals(45, (int) this.tree.oddNodeSum());
	}
	
	@Test
	public void testOddNodeSumTreeInLeftAndRightPaths() {
		int[] treevals = {5, 2, 1, 7, 6, 8, 10};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(10, (int) this.tree.oddNodeSum());
	}
	
	@Test
	public void testOddNodeSumTreeInLeftAndRightPathsRootChildren() {
		int[] treevals = {23, 30, 1, 42, 6, 51, 37};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(31, (int) this.tree.oddNodeSum());
	}	
	
	@Test
	public void testOddNodeSumNoOdd() {
		int[] treevals = {8, 5, 9};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(0, (int) this.tree.oddNodeSum());
	}
	
	@Test
	public void testOddNodeSumOnlyRoot() {
		int[] treevals = {8};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(0, (int) this.tree.oddNodeSum());
	}
}
