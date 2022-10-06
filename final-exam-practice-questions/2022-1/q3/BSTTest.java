import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

	private BST bst;

	@Before
	public void init() {
		this.bst = new BST();
	}

	@Test(timeout = 1000)
	public void testEmptyTree() {
		List<Node> keys = this.bst.invertedPreOrder();
		assertTrue(keys.size() == 0);
	}

	@Test(timeout = 1000)
	public void testFind() {
		Arrays.asList(new Node("uhv", 99), new Node("abc", 10), new Node("pie", 7), new Node("dfg", 11),
				new Node("rty", 10), new Node("afc", 2)).forEach(n -> this.bst.insert(n));

		Node node = this.bst.find("abc");

		assertNotNull(node);
		assertEquals(10, node.value);
	}

	@Test(timeout = 1000)
	public void testFindNull() {
		Arrays.asList(new Node("uhv", 99), new Node("abc", 10), new Node("pie", 7), new Node("dfg", 11),
				new Node("rty", 10), new Node("afc", 2)).forEach(n -> this.bst.insert(n));

		Node node = this.bst.find("abcasd");

		assertNull(node);
	}

	@Test(timeout = 1000)
	public void testInvertedPreOrder() {

		Arrays.asList(new Node("uhv", 99), new Node("abc", 10), new Node("pie", 7), new Node("dfg", 11),
				new Node("rty", 10), new Node("afc", 2)).forEach(n -> this.bst.insert(n));

		List<NodeCopy> expected = Arrays.asList(new NodeCopy("uhv", 99), new NodeCopy("abc", 10),
				new NodeCopy("pie", 7), new NodeCopy("rty", 10), new NodeCopy("dfg", 11), new NodeCopy("afc", 2));

		List<NodeCopy> actual = this.bst.invertedPreOrder().stream().map(n -> new NodeCopy(n))
				.collect(Collectors.toList());

		assertEquals(expected, actual);
	}
}
