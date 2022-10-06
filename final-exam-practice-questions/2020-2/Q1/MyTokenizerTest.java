
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MyTokenizerTest {

    @Test(timeout = 1000)
    public void testLowerCaseTokenizer() {
        String text = "i";
        MyTokenizer myTokenizer = new MyTokenizer(text);
        assertEquals("i", myTokenizer.current().getValue());
        Assert.assertEquals(Token.Type.LOWER_CASE_WORD, myTokenizer.current().getType());
    }

    @Test(timeout = 1000)
    public void testShortCamelCaseTokenizer() {
        String text = "Am";
        MyTokenizer myTokenizer = new MyTokenizer(text);
        assertEquals("Am", myTokenizer.current().getValue());
        assertEquals(Token.Type.SHORT_CAMEL_CASE_WORD, myTokenizer.current().getType());
    }

    @Test(timeout = 1000)
    public void testLongCamelCaseTokenizer() {
        String text = "CasTle";
        MyTokenizer myTokenizer = new MyTokenizer(text);
        assertEquals("CasTle", myTokenizer.current().getValue());
        assertEquals(Token.Type.LONG_CAMEL_CASE_WORD, myTokenizer.current().getType());
    }

    @Test(timeout = 1000)
    public void testUpperCaseTokenizer() {
        String text = "KING";
        MyTokenizer myTokenizer = new MyTokenizer(text);
        assertEquals("KING", myTokenizer.current().getValue());
        Assert.assertEquals(Token.Type.UPPER_CASE_WORD, myTokenizer.current().getType());
    }

    @Test(timeout = 1000)
    public void testIntegerTokenizer() {
        String text = "11";
        MyTokenizer myTokenizer = new MyTokenizer(text);
        assertEquals("11", myTokenizer.current().getValue());
        Assert.assertEquals(Token.Type.INTEGER_NUMBER, myTokenizer.current().getType());
    }

    @Test(timeout = 1000)
    public void testNonAlphanumericTokenizer() {
        String text = "#";
        MyTokenizer myTokenizer = new MyTokenizer(text);
        assertEquals("#", myTokenizer.current().getValue());
        Assert.assertEquals(Token.Type.NON_ALPHANUMERIC, myTokenizer.current().getType());
    }


    @Test(timeout = 1000)
    public void testSentenceTokenizer() {
        String text = "i Am the KING of THE 10 castle. The caStle is my HOME.@# 21";
        MyTokenizer myTokenizer = new MyTokenizer(text);

        assertEquals("i", myTokenizer.current().getValue());
        Assert.assertEquals(Token.Type.LOWER_CASE_WORD, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("Am", myTokenizer.current().getValue());
        assertEquals(Token.Type.SHORT_CAMEL_CASE_WORD, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("the", myTokenizer.current().getValue());
        assertEquals(Token.Type.LOWER_CASE_WORD, myTokenizer.current().getType());


        myTokenizer.next();

        assertEquals("KING", myTokenizer.current().getValue());
        assertEquals(Token.Type.UPPER_CASE_WORD, myTokenizer.current().getType());


        myTokenizer.next();

        assertEquals("of", myTokenizer.current().getValue());
        assertEquals(Token.Type.LOWER_CASE_WORD, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("THE", myTokenizer.current().getValue());
        assertEquals(Token.Type.UPPER_CASE_WORD, myTokenizer.current().getType());


        myTokenizer.next();

        assertEquals("10", myTokenizer.current().getValue());
        assertEquals(Token.Type.INTEGER_NUMBER, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("castle", myTokenizer.current().getValue());
        assertEquals(Token.Type.LOWER_CASE_WORD, myTokenizer.current().getType());


        myTokenizer.next();

        assertEquals(".", myTokenizer.current().getValue());
        assertEquals(Token.Type.NON_ALPHANUMERIC, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("The", myTokenizer.current().getValue());
        assertEquals(Token.Type.SHORT_CAMEL_CASE_WORD, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("caStle", myTokenizer.current().getValue());
        assertEquals(Token.Type.LONG_CAMEL_CASE_WORD, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("is", myTokenizer.current().getValue());
        assertEquals(Token.Type.LOWER_CASE_WORD, myTokenizer.current().getType());


        myTokenizer.next();

        assertEquals("my", myTokenizer.current().getValue());
        assertEquals(Token.Type.LOWER_CASE_WORD, myTokenizer.current().getType());


        myTokenizer.next();

        assertEquals("HOME", myTokenizer.current().getValue());
        assertEquals(Token.Type.UPPER_CASE_WORD, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals(".", myTokenizer.current().getValue());
        assertEquals(Token.Type.NON_ALPHANUMERIC, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("@", myTokenizer.current().getValue());
        assertEquals(Token.Type.NON_ALPHANUMERIC, myTokenizer.current().getType());


        myTokenizer.next();

        assertEquals("#", myTokenizer.current().getValue());
        assertEquals(Token.Type.NON_ALPHANUMERIC, myTokenizer.current().getType());

        myTokenizer.next();

        assertEquals("21", myTokenizer.current().getValue());
        assertEquals(Token.Type.INTEGER_NUMBER, myTokenizer.current().getType());

        myTokenizer.next();
        assertFalse(myTokenizer.hasNext());

    }
}
