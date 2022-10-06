import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedList;
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

		List<Key> keys = Arrays.asList(Key.DOWN, Key.RIGHT, Key.LEFT, Key.S, Key.RESET, Key.RIGHT, Key.LEFT);
		List<State> expected = Arrays.asList(LieProneState.getInstance(), CrawlState.getInstance(),
				LieProneState.getInstance(), ShootState.getInstance(), StandState.getInstance(), RunState.getInstance(),
				StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testStatesWithRandomKeys1() {

		List<Key> keys = Arrays.asList(Key.DOWN, Key.DOWN, Key.S, Key.RESET, Key.RIGHT, Key.DOWN, Key.RESET, Key.UP);
		List<State> expected = Arrays.asList(LieProneState.getInstance(), LieProneState.getInstance(),
				ShootState.getInstance(), StandState.getInstance(), RunState.getInstance(), RunState.getInstance(),
				StandState.getInstance(), StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testStatesWithRandomKeys2() {

		List<Key> keys = Arrays.asList(Key.LEFT, Key.UP, Key.DOWN, Key.L, Key.RIGHT, Key.UP, Key.DOWN, Key.RESET);
		List<State> expected = Arrays.asList(StandState.getInstance(), StandState.getInstance(),
				LieProneState.getInstance(), LieProneState.getInstance(), CrawlState.getInstance(),
				CrawlState.getInstance(), CrawlState.getInstance(), StandState.getInstance());

		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			assertTrue(this.character.getState() == expected.get(i));
		}
	}

	@Test(timeout = 1000)
	public void testWriteXML() {

		List<Key> keys = Arrays.asList(Key.DOWN, Key.DOWN, Key.S, Key.RESET, Key.RIGHT, Key.DOWN, Key.RESET, Key.UP);

		List<String> keyNames = new LinkedList<>();
		List<String> states = new LinkedList<>();
		for (int i = 0; i < keys.size(); i++) {
			this.character.getState().handle(this.character, keys.get(i));
			keyNames.add(keys.get(i).name());
			states.add(this.character.getState().getStateName());
		}

		XMLProcessor.write(Constants.FILE_NAME, keyNames, states);

		File file = new File(Constants.FILE_NAME);

		/**
		 * We only check the existence of the file, but we will check the content
		 * correctness officially in the marking test cases. Please make sure the
		 * correctness of the file content by yourself.
		 **/
		assertTrue(file.exists());
	}

	@Test(timeout = 1000)
	public void testReadXML() {

		List<String> expectedKeys = Arrays.asList("DOWN", "DOWN", "S", "RESET", "RIGHT", "DOWN", "RESET", "UP");
		List<String> expectedStates = Arrays.asList("LieProneState", "LieProneState", "ShootState", "StandState",
				"RunState", "RunState", "StandState", "StandState");

		List<List<String>> result = XMLProcessor.read(Constants.EXAMPLE_FILE_NAME);

		assertEquals(expectedKeys, result.get(0));
		assertEquals(expectedStates, result.get(1));
	}
}
