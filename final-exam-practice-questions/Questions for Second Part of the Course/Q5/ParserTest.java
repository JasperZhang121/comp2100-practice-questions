import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {
    @Test
    public void testEvenNumber() {
        assertTrue(new Parser(new Tokeniser("2")).parseExp());
        assertFalse(new Parser(new Tokeniser("22")).parseExp());
    }

    @Test
    public void testMathOperation() {
        assertFalse(new Parser(new Tokeniser("2++4")).parseExp());
        assertTrue(new Parser(new Tokeniser("2+4")).parseExp());
    }

    @Test
    public void testChainOfMathOperations() {
        assertTrue(new Parser(new Tokeniser("2+4+0/6")).parseExp());
        assertFalse(new Parser(new Tokeniser("2+4+62")).parseExp());
    }

    @Test
    public void testChainOfMathOperationsMore() {
        assertTrue(new Parser(new Tokeniser("2+4+6/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2+4+62")).parseExp());
    }

    @Test
    public void testInvalidTokens() {
        assertFalse(new Parser(new Tokeniser("3+4+6/2")).parseExp());
        assertTrue(new Parser(new Tokeniser("2+4+6/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2.4+6/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2+5+6/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2+4+6/2.")).parseExp());
    }
}
