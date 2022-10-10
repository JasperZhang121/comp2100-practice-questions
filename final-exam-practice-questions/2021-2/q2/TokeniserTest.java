
import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

public class TokeniserTest {

	private static void generalTest(Tokeniser tokeniser, Token token) {
		assertEquals(token, tokeniser.current());
		tokeniser.next();
	}

	@Test(timeout=1000)
	public void testLoad() {
		String text = "LOAD persons FROM persons.xml;";
		Tokeniser tokeniser = new Tokeniser(text);

		List<Token> tokens = new LinkedList<>();
		tokens.add(new Token(Token.Type.LOAD, "LOAD"));
		tokens.add(new Token(Token.Type.PARAMETER, "persons"));
		tokens.add(new Token(Token.Type.FROM, "FROM"));
		tokens.add(new Token(Token.Type.PARAMETER, "persons.xml"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));

		for (Token t : tokens) {
			generalTest(tokeniser, t);
		}
	}

	@Test(timeout=1000)
	public void testSave() {
		String text = "SAVE persons TO persons.xml;";
		Tokeniser tokeniser = new Tokeniser(text);

		List<Token> tokens = new LinkedList<>();
		tokens.add(new Token(Token.Type.SAVE, "SAVE"));
		tokens.add(new Token(Token.Type.PARAMETER, "persons"));
		tokens.add(new Token(Token.Type.TO, "TO"));
		tokens.add(new Token(Token.Type.PARAMETER, "persons.xml"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));

		for (Token t : tokens) {
			generalTest(tokeniser, t);
		}
	}

	@Test(timeout=1000)
	public void testComplex() {
		String text = "save   persons   to persons.xml   ; LOAD persons  FROM  persons.xml;  ";
		Tokeniser tokeniser = new Tokeniser(text);

		List<Token> tokens = new LinkedList<>();
		tokens.add(new Token(Token.Type.SAVE, "save"));
		tokens.add(new Token(Token.Type.PARAMETER, "persons"));
		tokens.add(new Token(Token.Type.TO, "to"));
		tokens.add(new Token(Token.Type.PARAMETER, "persons.xml"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));
		tokens.add(new Token(Token.Type.LOAD, "LOAD"));
		tokens.add(new Token(Token.Type.PARAMETER, "persons"));
		tokens.add(new Token(Token.Type.FROM, "FROM"));
		tokens.add(new Token(Token.Type.PARAMETER, "persons.xml"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));

		for (Token t : tokens) {
			generalTest(tokeniser, t);
		}
	}
}
