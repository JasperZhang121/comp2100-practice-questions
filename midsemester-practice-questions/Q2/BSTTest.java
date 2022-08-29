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
	public void testEvenNodeSumTreeSingleRightPath() {
		for (int i = 1; i < 11; i++) {
			this.tree.insert(i);
		}
			
		assertEquals(10, (int) this.tree.evenNodeSum());
	}
	
	@Test
	public void testEvenNodeSumTreeInLeftAndRightPaths() {
		int[] treevals = {5, 2, 1, 7, 6, 8, 10};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(29, (int) this.tree.evenNodeSum());
	}
	
	@Test
	public void testEvenNodeSumTreeInLeftAndRightPathsRootChildren() {
		int[] treevals = {23, 30, 1, 42, 6, 51, 37};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(159, (int) this.tree.evenNodeSum());
	}	
	
	@Test
	public void testEvenNodeSumRootAndLeaves() {
		int[] treevals = {7, 6, 10};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(23, (int) this.tree.evenNodeSum());
	}
	
	@Test
	public void testEvenNodeSumOnlyRoot() {
		int[] treevals = {6};
		for(int i :treevals) {
			this.tree.insert(i);
		}
			
		assertEquals(6, (int) this.tree.evenNodeSum());
	}
}
