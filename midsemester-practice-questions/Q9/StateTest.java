import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class StateTest {

	private Character character;

	@Before
	public void init() {
		this.character = new Character();
	}

	@Test(timeout = 1000)
	public void testAllStates() {

		List<Key> keys = Arrays.asList(Key.DOWN, Key.UP, Key.RIGHT, Key.LEFT, Key.UP, Key.DOWN);
		List<State> expected = Arrays.asList(SquatState.getInstance(), StandState.getInstance(),
				WalkState.getInstance(), StandState.getInstance(), SuspendState.getInstance(), StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testStatesWithRandomKeys1() {

		List<Key> keys = Arrays.asList(Key.DOWN, Key.DOWN, Key.UP, Key.RIGHT, Key.DOWN, Key.LEFT, Key.UP);
		List<State> expected = Arrays.asList(SquatState.getInstance(), SquatState.getInstance(),
				StandState.getInstance(), WalkState.getInstance(), WalkState.getInstance(), StandState.getInstance(),
				SuspendState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testStatesWithRandomKeys2() {

		List<Key> keys = Arrays.asList(Key.LEFT, Key.UP, Key.DOWN, Key.RIGHT, Key.UP, Key.DOWN);
		List<State> expected = Arrays.asList(StandState.getInstance(), SuspendState.getInstance(),
				StandState.getInstance(), WalkState.getInstance(), WalkState.getInstance(), WalkState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}
}
