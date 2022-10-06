import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {
    @Test
    public void testOneDigit() {
        assertTrue(new Parser(new Tokeniser("2")).parseExp());
        assertFalse(new Parser(new Tokeniser("11")).parseExp());
    }

    @Test
    public void testMathOperation() {
        assertFalse(new Parser(new Tokeniser("2++3")).parseExp());
        assertTrue(new Parser(new Tokeniser("2+3")).parseExp());
    }

    @Test
    public void testChainOfMathOperations() {
        assertTrue(new Parser(new Tokeniser("2+3+7/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2+3+72")).parseExp());
    }

    @Test
    public void testChainOfMathOperationsMore() {
        assertTrue(new Parser(new Tokeniser("2+3+7/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2+3+72")).parseExp());
    }

    @Test
    public void testInvalidTokens() {
        assertFalse(new Parser(new Tokeniser("*+3+7/2")).parseExp());
        assertTrue(new Parser(new Tokeniser("2+3+7/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2>3+7/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2+)+7/2")).parseExp());
        assertFalse(new Parser(new Tokeniser("2+3+7/2.")).parseExp());
    }
}
