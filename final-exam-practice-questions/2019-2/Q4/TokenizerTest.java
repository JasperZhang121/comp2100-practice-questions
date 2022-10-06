package parser;
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
        String command = "LEFT; RIGHT; FORWARD(50); PENUP; BACK_TO_END; PENDOWN; BACK(5); FORWARD_TO_END;";

        Tokenizer tokenizer = new Tokenizer(command);
        
        assertEquals(tokenizer.hasNext(), true);
        
        Token token = tokenizer.current();
        assertEquals("LEFT", token.originalTokenStr);
        assertEquals(Token.Type.LEFT, token.type);
        
        tokenizer.next();
        token = tokenizer.current();
        assertEquals("RIGHT", token.originalTokenStr);
        assertEquals(Token.Type.RIGHT, token.type);
        
        tokenizer.next();
        token = tokenizer.current();
        assertEquals("FORWARD(50)", token.originalTokenStr);
        assertEquals(Token.Type.FORWARD, token.type);
        assertEquals(50, token.value);
        
        tokenizer.next();
        token = tokenizer.current();
        assertEquals("PENUP", token.originalTokenStr);
        assertEquals(Token.Type.PENUP, token.type);
        
        tokenizer.next();
        token = tokenizer.current();
        assertEquals("BACK_TO_END", token.originalTokenStr);
        assertEquals(Token.Type.BACK_TO_END, token.type);
                
        tokenizer.next();
        token = tokenizer.current();
        assertEquals("PENDOWN", token.originalTokenStr);
        assertEquals(Token.Type.PENDOWN, token.type);
        
        tokenizer.next();
        token = tokenizer.current();
        assertEquals("BACK(5)", token.originalTokenStr);
        assertEquals(Token.Type.BACK, token.type);
        assertEquals(5, token.value);

        tokenizer.next();
        token = tokenizer.current();
        assertEquals("FORWARD_TO_END", token.originalTokenStr);
        assertEquals(Token.Type.FORWARD_TO_END, token.type);
        
        tokenizer.next();
        assertEquals(false, tokenizer.hasNext());
	}
}
