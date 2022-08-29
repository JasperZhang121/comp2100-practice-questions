import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RBTreeTest {

	RBTree<Integer> tree;
	
	@Before
	public void init() {
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
		
		// adjust colours
        this.tree.search(3).setColour(true);
        this.tree.search(11).setColour(true);
        this.tree.search(13).setColour(true);
        this.tree.search(17).setColour(true);
        this.tree.search(19).setColour(true);
	}
	
	@Test
	public void testProp3IsMet() {
        assertEquals(true, this.tree.testProp3());
	}
	
	@Test 
	public void testProp3IsNotMetAddErrorRightLeftNode() {
        this.tree.search(9).setColour(true);
        assertEquals(false, this.tree.testProp3());
	}
	
	@Test 
	public void testProp3IsNotMetAddErrorLeftNode() {
        this.tree.search(1).setColour(true);
        assertEquals(false, this.tree.testProp3());
	}
	
	@Test
	public void testProp3IsNotMetAddErrorRightNode() {
        this.tree.search(15).setColour(true);
        assertEquals(false, this.tree.testProp3());
	}
	
	@Test 
	public void testProp3IsNotMetAddErrorRightLastNode() {
        this.tree.search(19).setColour(false);
        assertEquals(false, this.tree.testProp3());
	}
	
	@Test
	public void testProp3RootRightChildAddError() {
        this.tree.search(11).setColour(false);
        assertEquals(false, this.tree.testProp3());
	}
}
