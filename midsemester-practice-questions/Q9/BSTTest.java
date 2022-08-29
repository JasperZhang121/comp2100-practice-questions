import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {

	private Character character;
	private BST bst;

	@Before
	public void init() {
		this.character = new Character();
		this.bst = new BST();
	}

	@Test(timeout = 1000)
	public void testEmptyTree() {
		List<Key> keys = this.bst.invertedPreOrder();
		assertTrue(keys.size() == 0);
	}

	@Test(timeout = 1000)
	public void testInvertedPreOrder1() {
		Arrays.asList(Key.A, Key.DOWN, Key.C, Key.S, Key.RIGHT, Key.D, Key.LEFT, Key.W, Key.X, Key.UP, Key.Z)
				.forEach(k -> this.bst.insert(k));

		List<Key> expected = Arrays.asList(Key.A, Key.C, Key.S, Key.X, Key.Z, Key.W, Key.DOWN, Key.RIGHT, Key.D,
				Key.LEFT, Key.UP);

		List<Key> actual = this.bst.invertedPreOrder();

		assertEquals(expected, actual);
	}

	@Test(timeout = 1000)
	public void testInvertedPreOrder2() {
		Arrays.asList(Key.A, Key.DOWN, Key.C, Key.S, Key.RIGHT, Key.D, Key.LEFT, Key.W, Key.X, Key.UP, Key.Z)
				.forEach(k -> this.bst.insert(k));

		List<Key> keys = this.bst.invertedPreOrder();

		List<State> expected = Arrays.asList(StandState.getInstance(), StandState.getInstance(),
				StandState.getInstance(), StandState.getInstance(), StandState.getInstance(), StandState.getInstance(),
				SquatState.getInstance(), SquatState.getInstance(), SquatState.getInstance(), SquatState.getInstance(),
				StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}
}
