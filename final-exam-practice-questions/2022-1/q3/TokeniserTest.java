
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
		String text = "LOAD a;";
		Tokeniser tokeniser = new Tokeniser(text);

		List<Token> tokens = new LinkedList<>();
		tokens.add(new Token(Token.Type.LOAD, "LOAD"));
		tokens.add(new Token(Token.Type.PARAMETER, "a"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));

		for (Token t : tokens) {
			generalTest(tokeniser, t);
		}
	}
	
	@Test(timeout=1000)
	public void testSave() {
		String text = "SAVE 500 TO a;";
		Tokeniser tokeniser = new Tokeniser(text);

		List<Token> tokens = new LinkedList<>();
		tokens.add(new Token(Token.Type.SAVE, "SAVE"));
		tokens.add(new Token(Token.Type.PARAMETER, "500"));
		tokens.add(new Token(Token.Type.TO, "TO"));
		tokens.add(new Token(Token.Type.PARAMETER, "a"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));

		for (Token t : tokens) {
			generalTest(tokeniser, t);
		}
	}
	
	@Test(timeout=1000)
	public void testSum() {
		String text = "Sum vari* To ret;";
		Tokeniser tokeniser = new Tokeniser(text);

		List<Token> tokens = new LinkedList<>();
		tokens.add(new Token(Token.Type.SUM, "Sum"));
		tokens.add(new Token(Token.Type.PARAMETER, "vari*"));
		tokens.add(new Token(Token.Type.TO, "To"));
		tokens.add(new Token(Token.Type.PARAMETER, "ret"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));

		for (Token t : tokens) {
			generalTest(tokeniser, t);
		}
	}

	@Test(timeout=1000)
	public void testComplex() {
		String text = "save   10 to&^  variable!@#$%^&   ; Load variable  ; Sum vari* To ret ; ";
		Tokeniser tokeniser = new Tokeniser(text);

		List<Token> tokens = new LinkedList<>();
		tokens.add(new Token(Token.Type.SAVE, "save"));
		tokens.add(new Token(Token.Type.PARAMETER, "10"));
		tokens.add(new Token(Token.Type.TO, "to"));
		tokens.add(new Token(Token.Type.PARAMETER, "variable"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));
		tokens.add(new Token(Token.Type.LOAD, "Load"));
		tokens.add(new Token(Token.Type.PARAMETER, "variable"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));
		tokens.add(new Token(Token.Type.SUM, "Sum"));
		tokens.add(new Token(Token.Type.PARAMETER, "vari*"));
		tokens.add(new Token(Token.Type.TO, "To"));
		tokens.add(new Token(Token.Type.PARAMETER, "ret"));
		tokens.add(new Token(Token.Type.TERMINATOR, ";"));

		for (Token t : tokens) {
			generalTest(tokeniser, t);
		}
	}
}
