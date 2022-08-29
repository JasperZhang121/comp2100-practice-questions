import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RBTreeTest {
	
	RBTree<Integer> tree;
	
	@Before
	public void init() {
		//Note that for checking properties, we do not need to have a complete RB tree. 
		//Here the insertion is the same as the binary tree. Read the RBTree methods
		this.tree = new RBTree<Integer>();
		
		this.tree.insert(7);
		this.tree.insert(3);
		this.tree.insert(1);
		this.tree.insert(0);
		this.tree.insert(2);
		this.tree.insert(5);
		this.tree.insert(4);
		this.tree.insert(6);
		this.tree.insert(11);
		this.tree.insert(9);
		this.tree.insert(8);
		this.tree.insert(10);
		this.tree.insert(15);
		this.tree.insert(13);
		this.tree.insert(12);
		this.tree.insert(14);
		this.tree.insert(17);
		this.tree.insert(16);
		this.tree.insert(18);
		this.tree.insert(19);
		
		// adjust colours (Prop 1 is satisfied)
        this.tree.search(3).setColour(true);
        this.tree.search(11).setColour(true);
        this.tree.search(13).setColour(true);
        this.tree.search(17).setColour(true);
        this.tree.search(19).setColour(true);
	}
	
	@Test
	public void testRoot() {
        this.tree.search(7).setColour(true);
        assertEquals(false, this.tree.testProp1());
	}
	
	@Test 
	public void testLeftLeaf() {
        this.tree.search(10).left.setColour(true);
        assertEquals(false, this.tree.testProp1());
	}
	
	@Test 
	public void testRightLeaf() {
        this.tree.search(16).right.setColour(true);
        assertEquals(false, this.tree.testProp1());
	}
	
	@Test 
	public void testParent() {
        this.tree.search(9).setColour(true);
        assertEquals(false, this.tree.testProp2());
	}
	
	@Test 
	public void testBoth() {
        assertEquals(true, this.tree.testProp1() && this.tree.testProp2());
	}
}
