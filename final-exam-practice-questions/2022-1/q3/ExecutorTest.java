
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Test;

public class ExecutorTest {

	private List<NodeCopy> execute(String text) {
		Parser parser = new Parser(new Tokeniser(text));

		Executor executor = new Executor(parser.parseCmds());

		return executor.execute();
	}

	@Test(timeout = 1000)
	public void testLoadNull() {
		String text = "LOAD a;";
		List<NodeCopy> list = execute(text);

		assertNull(list.get(0));
	}

	@Test(timeout = 1000)
	public void testSaveLoad1() {
		String text = "SAVE 5 TO b;LOAD a;";
		List<NodeCopy> list = execute(text);

		NodeCopy node = list.get(0);
		assertNotNull(node);
		assertEquals("b", node.key);
		assertEquals(5, node.value);

		assertNull(list.get(1));
	}

	@Test(timeout = 1000)
	public void testSaveLoad2() {
		String text = "SAVE 5 TO a;LOAD a;";
		List<NodeCopy> list = execute(text);

		NodeCopy node1 = list.get(0);
		assertNotNull(node1);
		assertEquals("a", node1.key);
		assertEquals(5, node1.value);

		NodeCopy node2 = list.get(1);
		assertEquals(node1, node2);
	}

	@Test(timeout = 1000)
	public void testSum() {
		String text = "Sum a* TO b;";
		List<NodeCopy> list = execute(text);

		NodeCopy node = list.get(0);
		assertNotNull(node);
		assertEquals("b", node.key);
		assertEquals(0, node.value);
	}

	@Test(timeout = 1000)
	public void testSaveSum() {
		String text = "Save 3 To abc ; SAVe 7 to amj  ; sAvE 100 TO aJE  ;   Sum a* TO b;";
		List<NodeCopy> list = execute(text);

		NodeCopy node = list.get(0);
		assertNotNull(node);
		assertEquals("abc", node.key);
		assertEquals(3, node.value);

		node = list.get(1);
		assertNotNull(node);
		assertEquals("amj", node.key);
		assertEquals(7, node.value);

		node = list.get(2);
		assertNotNull(node);
		assertEquals("aJE", node.key);
		assertEquals(100, node.value);

		node = list.get(3);
		assertNotNull(node);
		assertEquals("b", node.key);
		assertEquals(110, node.value);
	}

	@Test(timeout = 1000)
	public void testComplex1() {
		String text = "Save 3 To variable1 ; SAVe 7 to variable2  ; sAvE 100 TO variable2  ; SAVE 76 TO variable3  ;  Sum var* TO b;";
		List<NodeCopy> list = execute(text);

		NodeCopy node = list.get(0);
		assertNotNull(node);
		assertEquals("variable1", node.key);
		assertEquals(3, node.value);

		node = list.get(1);
		assertNotNull(node);
		assertEquals("variable2", node.key);
		assertEquals(7, node.value);

		node = list.get(2);
		assertNotNull(node);
		assertEquals("variable2", node.key);
		assertEquals(100, node.value);

		node = list.get(3);
		assertNotNull(node);
		assertEquals("variable3", node.key);
		assertEquals(76, node.value);

		node = list.get(4);
		assertNotNull(node);
		assertEquals("b", node.key);
		assertEquals(179, node.value);
	}

	@Test(timeout = 1000)
	public void testComplex2() {
		String text = "Save 3 To variable1 ; SAVe 7 to vvar  ; sAvE 100 TO bvar  ; SAVE 76 TO variable3  ;  Sum *var TO b;";
		List<NodeCopy> list = execute(text);

		NodeCopy node = list.get(0);
		assertNotNull(node);
		assertEquals("variable1", node.key);
		assertEquals(3, node.value);

		node = list.get(1);
		assertNotNull(node);
		assertEquals("vvar", node.key);
		assertEquals(7, node.value);

		node = list.get(2);
		assertNotNull(node);
		assertEquals("bvar", node.key);
		assertEquals(100, node.value);

		node = list.get(3);
		assertNotNull(node);
		assertEquals("variable3", node.key);
		assertEquals(76, node.value);

		node = list.get(4);
		assertNotNull(node);
		assertEquals("b", node.key);
		assertEquals(107, node.value);
	}

	@Test(timeout = 1000)
	public void testComplex3() {
		String text = "Save 3 To (~!@#)variable1 ; SAVe 7 to variable  ;sAvE%^@ 100 TO vbriable  ; SAVE 76 TO vcriable  ;  Sum v*able TO b;";
		List<NodeCopy> list = execute(text);

		NodeCopy node = list.get(0);
		assertNotNull(node);
		assertEquals("variable1", node.key);
		assertEquals(3, node.value);

		node = list.get(1);
		assertNotNull(node);
		assertEquals("variable", node.key);
		assertEquals(7, node.value);

		node = list.get(2);
		assertNotNull(node);
		assertEquals("vbriable", node.key);
		assertEquals(100, node.value);

		node = list.get(3);
		assertNotNull(node);
		assertEquals("vcriable", node.key);
		assertEquals(76, node.value);

		node = list.get(4);
		assertNotNull(node);
		assertEquals("b", node.key);
		assertEquals(183, node.value);
	}

	@Test(timeout = 1000)
	public void testComplex4() {
		String text = "Save 3 To (~!@#)variable1 ; SAVe 7 to variable  ;sAvE%^@ 100 TO vbriable  ; SAVE 76 TO vcriable  ;  Sum * TO b;";
		List<NodeCopy> list = execute(text);

		NodeCopy node = list.get(0);
		assertNotNull(node);
		assertEquals("variable1", node.key);
		assertEquals(3, node.value);

		node = list.get(1);
		assertNotNull(node);
		assertEquals("variable", node.key);
		assertEquals(7, node.value);

		node = list.get(2);
		assertNotNull(node);
		assertEquals("vbriable", node.key);
		assertEquals(100, node.value);

		node = list.get(3);
		assertNotNull(node);
		assertEquals("vcriable", node.key);
		assertEquals(76, node.value);

		node = list.get(4);
		assertNotNull(node);
		assertEquals("b", node.key);
		assertEquals(186, node.value);
	}
}
