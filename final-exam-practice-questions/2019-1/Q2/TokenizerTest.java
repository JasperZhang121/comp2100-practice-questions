import static org.junit.Assert.*;

import org.junit.Test;

/**
 * You can use this to test your Tokenizer implementation.
 * NOTE: When marking your submission, there can be more tests.
 * 
 * @author huy.pham
 */
public class TokenizerTest {

	@Test
	public void testAllCommands() {
        String command = "LEFT; RIGHT; FORWARD(50); PENUP; PENDOWN; BACK(5);";

        Tokenizer tokenizer = new Tokenizer(command);
        
        assertEquals(tokenizer.hasNext(), true);
        
        Token token = tokenizer.takeNext();
        assertEquals("LEFT", token.originalTokenStr);
        assertEquals(Token.Type.LEFT, token.type);
        
        token = tokenizer.takeNext();
        assertEquals("RIGHT", token.originalTokenStr);
        assertEquals(Token.Type.RIGHT, token.type);
        
        token = tokenizer.takeNext();
        assertEquals("FORWARD(50)", token.originalTokenStr);
        assertEquals(Token.Type.FORWARD, token.type);
        assertEquals(50, token.value);
        
        token = tokenizer.takeNext();
        assertEquals("PENUP", token.originalTokenStr);
        assertEquals(Token.Type.PENUP, token.type);
        
        token = tokenizer.takeNext();
        assertEquals("PENDOWN", token.originalTokenStr);
        assertEquals(Token.Type.PENDOWN, token.type);
        
        token = tokenizer.takeNext();
        assertEquals("BACK(5)", token.originalTokenStr);
        assertEquals(Token.Type.BACK, token.type);
        assertEquals(5, token.value);
        
        assertEquals(false, tokenizer.hasNext());
	}
}
