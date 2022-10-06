package tree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Task1Test {
	BST simpleBst;
	BST complexBst;

	@Before
	public void constructTree() {
		simpleBst = new BST();
		for(int i=0; i<10; i++) {
			simpleBst.insert(i);
		}
		
		complexBst = new BST();
		complexBst.insert(10);
		complexBst.insert(5);
		complexBst.insert(7);
		complexBst.insert(12);
		complexBst.insert(11);
		complexBst.insert(4);
		complexBst.insert(8);
	}
	
	@Test
	public void testFindTrueSimple() {
		assertTrue(simpleBst.find(1));
		assertTrue(simpleBst.find(8));
	}
	
	@Test
	public void testFindFalseSimple() {
		assertFalse(simpleBst.find(10));
		assertFalse(simpleBst.find(11));
	}

	@Test
	public void testFindTrueComplex() {
		assertTrue(complexBst.find(10));
		assertTrue(complexBst.find(4));
	}

	@Test
	public void testFindFalseComplex() {
		assertFalse(complexBst.find(3));
		assertFalse(complexBst.find(20));
	}
	
}
