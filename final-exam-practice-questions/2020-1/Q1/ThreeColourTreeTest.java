import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author nanwang
 *
 */
public class ThreeColourTreeTest {
	
	ThreeColourTree<Integer> tree;
	
	@Before
	public void init() {
		this.tree = new ThreeColourTree<Integer>();
		
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
		this.tree.insert(16);      
	}
	
	@Test
	public void test1() {		
		assertTrue(this.tree.testProp1());
		assertTrue(this.tree.testProp2());
	}
	
	@Test
	public void test2() {
		this.tree.search(1).setColour(Colour.PURPLE);
		this.tree.search(5).setColour(Colour.PURPLE);
		this.tree.search(9).setColour(Colour.PURPLE);
		this.tree.search(15).setColour(Colour.PURPLE);
				
		assertTrue(this.tree.testProp1());
		assertTrue(this.tree.testProp2());
		assertTrue(this.tree.testProp3());
	}
	
	@Test
	public void test3() {
		this.tree.search(0).setColour(Colour.VIOLET);
		this.tree.search(6).setColour(Colour.PURPLE);
		this.tree.search(7).setColour(Colour.PURPLE);
		this.tree.search(10).setColour(Colour.MAGENTA);
		
		assertTrue(!this.tree.testProp1());
		assertTrue(!this.tree.testProp2());
		assertTrue(!this.tree.testProp3());
	}
	
	@Test
	public void test4() {
		this.tree.search(3).setColour(Colour.MAGENTA);
		this.tree.search(11).setColour(Colour.VIOLET);
		this.tree.search(1).setColour(Colour.PURPLE);
		this.tree.search(15).setColour(Colour.PURPLE);
				
		assertTrue(!this.tree.testProp1());
		assertTrue(this.tree.testProp2());
		assertTrue(!this.tree.testProp3());
		assertTrue(this.tree.testProp4());
	}
	
	@Test
	public void test5() {
		this.tree.search(7).setColour(Colour.MAGENTA);
		this.tree.search(1).setColour(Colour.PURPLE);
		this.tree.search(5).setColour(Colour.PURPLE);
		this.tree.search(9).setColour(Colour.PURPLE);
		this.tree.search(15).setColour(Colour.PURPLE);
				
		assertTrue(this.tree.testProp1());
		assertTrue(!this.tree.testProp2());
		assertTrue(this.tree.testProp3());
		assertTrue(!this.tree.testProp4());
		assertTrue(this.tree.testProp5());
	}
}
