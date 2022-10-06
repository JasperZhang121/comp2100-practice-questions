import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {
    @Test
    public void testEmptyBrackets() {
        assertTrue(new Parser(new Tokeniser("()")).parseExp());
        assertFalse(new Parser(new Tokeniser("())")).parseExp());
    }

    @Test
    public void testEmptyBracketsWithNextExp() {
        assertFalse(new Parser(new Tokeniser("()())")).parseExp());
        assertTrue(new Parser(new Tokeniser("()()")).parseExp());
    }

    @Test
    public void testNonEmptyBrackets() {
        assertTrue(new Parser(new Tokeniser(")()(")).parseExp());
        assertFalse(new Parser(new Tokeniser(")()((")).parseExp());
    }

    @Test
    public void testNonEmptyBracketsWithNextExp() {
        assertFalse(new Parser(new Tokeniser(")()((")).parseExp());
        assertTrue(new Parser(new Tokeniser(")()(()")).parseExp());
    }

    @Test
    public void testNestedExpressionsAndInvalidTokens() {
        assertTrue(new Parser(new Tokeniser("))()()((")).parseExp());
        assertFalse(new Parser(new Tokeniser("))()()((())")).parseExp());
        assertFalse(new Parser(new Tokeniser("x))()()((())")).parseExp());
        assertFalse(new Parser(new Tokeniser("))()()((())x")).parseExp());
        assertFalse(new Parser(new Tokeniser(")y(")).parseExp());
    }
}
