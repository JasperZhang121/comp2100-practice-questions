import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author nanwang
 *
 * You are allowed to add additional `asserts` and test cases to testify your programs in all test cases.
 * 
 */
public class TreesTest {

	@Test
	public void testSave1() {

		Tree tree1 = new Tree().withKind("Cedar").withDimension(new Dimension(2, 20)).withColor("red")
				.addType("Atlas cedar").addType("Deodar cedar");
		Tree tree2 = new Tree().withKind("Fir").withDimension(new Dimension(1, 15)).withColor("green")
				.addType("Bulgarian fir").addType("Greek fir");

		List<Tree> trees = Arrays.asList(tree1, tree2);

		TreeCollection treeCollection1 = new TreeCollection(trees);

		File file = new File("trees.xml");
		file.delete();

		treeCollection1.saveToFile(file);
		
		assertTrue(file.exists());

		file.delete();
	}

	@Test
	public void testLoad1() {

		Tree tree1 = new Tree().withKind("Cedar").withDimension(new Dimension(2, 20)).withColor("red")
				.addType("Atlas cedar").addType("Deodar cedar");
		Tree tree2 = new Tree().withKind("Fir").withDimension(new Dimension(1, 15)).withColor("green")
				.addType("Bulgarian fir").addType("Greek fir");
		List<Tree> trees = Arrays.asList(tree1, tree2);

		TreeCollection treeCollection1 = new TreeCollection(trees);

		File file = new File("trees.xml");
		file.delete();

		treeCollection1.saveToFile(file);
		
		assertTrue(file.exists());

		TreeCollection treeCollection2 = TreeCollection.loadFromFile(file);

		assertEquals(treeCollection1, treeCollection2);

		file.delete();
	}

	@Test
	public void testSave2() {

		Tree tree1 = new Tree().withKind("Cedar").withDimension(new Dimension(2, 20)).withColor("red");
		Tree tree2 = new Tree().withKind("Fir").withColor("green").addType("Bulgarian fir");

		List<Tree> trees = Arrays.asList(tree1, tree2);

		TreeCollection treeCollection1 = new TreeCollection(trees);

		File file = new File("trees.xml");
		file.delete();

		treeCollection1.saveToFile(file);
		
		assertTrue(file.exists());

		file.delete();
	}

	@Test
	public void testLoad2() {

		Tree tree1 = new Tree().withKind("Cedar").withDimension(new Dimension(2, 20)).withColor("red").addType("Atlas cedar");
		Tree tree2 = new Tree().withKind("Fir").withColor("green");

		List<Tree> trees = Arrays.asList(tree1, tree2);

		TreeCollection treeCollection1 = new TreeCollection(trees);

		File file = new File("trees.xml");
		file.delete();

		treeCollection1.saveToFile(file);
		
		assertTrue(file.exists());

		TreeCollection treeCollection2 = TreeCollection.loadFromFile(file);

		assertEquals(treeCollection1, treeCollection2);

		file.delete();
	}

	@Test
	public void testLoad3() {

		Tree tree1 = new Tree().withKind("Cedar").withDimension(new Dimension(2, 20));
		Tree tree2 = new Tree().withKind("Fir");

		List<Tree> trees = Arrays.asList(tree1, tree2);

		TreeCollection treeCollection1 = new TreeCollection(trees);

		File file = new File("trees.xml");
		file.delete();

		treeCollection1.saveToFile(file);
		
		assertTrue(file.exists());

		TreeCollection treeCollection2 = TreeCollection.loadFromFile(file);

		assertEquals(treeCollection1, treeCollection2);

		file.delete();
	}
}
