import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import exceptions.NullCharacterException;
import exceptions.NullKeyEventException;

public class ExceptionTest {

	private Character character;

	@Before
	public void init() {
		this.character = new Character();
	}

	@Test(expected = NullKeyEventException.class, timeout = 1000)
	public void testNullKeyException() {
		// TODO
		// START YOUR CODE
		// END YOUR CODE

		this.character.getState().check(character,null);

	}

	@Test(expected = NullCharacterException.class, timeout = 1000)
	public void testNullCharacterException() {
		// TODO
		// START YOUR CODE
		// END YOUR CODE
		this.character.getState().check(null,Key.UP);
	}
}
