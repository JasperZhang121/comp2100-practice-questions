import static org.junit.Assert.*;

import org.junit.Test;

public class ParserTest {
    @Test
    public void testOneDigitNumbers() {
        assertTrue(new Parser(new Tokeniser("2")).parseExp());
        assertTrue(new Parser(new Tokeniser("1")).parseExp());
        assertFalse(new Parser(new Tokeniser("22")).parseExp());
        assertFalse(new Parser(new Tokeniser("11")).parseExp());
    }

    @Test
    public void testOddStartingWithEven() {
        assertTrue(new Parser(new Tokeniser("23")).parseExp());
        assertFalse(new Parser(new Tokeniser("33")).parseExp());
    }

    @Test
    public void testEvenStartingWithEven() {
        assertFalse(new Parser(new Tokeniser("66")).parseExp());
        assertTrue(new Parser(new Tokeniser("36")).parseExp());
    }

    @Test
    public void testMoreNumbers() {
        assertFalse(new Parser(new Tokeniser("44")).parseExp());
        assertTrue(new Parser(new Tokeniser("425")).parseExp());
        assertTrue(new Parser(new Tokeniser("1425")).parseExp());
        assertTrue(new Parser(new Tokeniser("146325")).parseExp());

        assertFalse(new Parser(new Tokeniser("88")).parseExp());
        assertTrue(new Parser(new Tokeniser("136")).parseExp());
        assertTrue(new Parser(new Tokeniser("1436")).parseExp());
        assertTrue(new Parser(new Tokeniser("146336")).parseExp());
    }

    @Test
    public void testInvalidTokens() {
        assertTrue(new Parser(new Tokeniser("146336")).parseExp());
        assertFalse(new Parser(new Tokeniser("14*6336")).parseExp());
        assertFalse(new Parser(new Tokeniser("146*336")).parseExp());
        assertFalse(new Parser(new Tokeniser("(146336")).parseExp());
        assertFalse(new Parser(new Tokeniser("146336)")).parseExp());
    }
}
