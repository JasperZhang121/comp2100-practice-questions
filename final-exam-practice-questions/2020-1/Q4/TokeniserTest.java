import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 * 
 * @author nanwang
 *
 */
public class TokeniserTest {

	private void assertToken(String columns, String values) {
		String command = "INSERT INTO " + Customer.TABLE_NAME + " (" + columns + ") VALUES (" + values + ");";

		Tokeniser tokeniser = new Tokeniser(command.toString());

		Token token1 = tokeniser.takeNext();

		assertEquals("INSERT INTO " + Customer.TABLE_NAME + " (" + columns + ")", token1.originalTokenStr);
		assertEquals(Token.Type.INSERT_INTO, token1.type);
		assertEquals(Customer.TABLE_NAME + " (" + columns + ")", token1.value);

		Token token2 = tokeniser.takeNext();

		assertEquals("VALUES (" + values + ")", token2.originalTokenStr);
		assertEquals(Token.Type.VALUES, token2.type);
		assertEquals("(" + values + ")", token2.value);
	}

	private void assertNull(String columns, String values) {

		String command = "INSERT INTO " + Customer.TABLE_NAME + " " + columns + " VALUES " + values + ";";

		Tokeniser tokeniser = new Tokeniser(command);

		assertTrue(tokeniser.takeNext() == null || tokeniser.takeNext() == null);
	}

	@Test
	public void testWithPartialColumns() {

		String columns = String.join(",",
				Arrays.asList(Customer.KEY_ID, Customer.KEY_ADDRESS, Customer.KEY_CITY, Customer.KEY_POSTCODE));
		String values = "2, '1 Main St', 'Sydney', '2000'";

		assertToken(columns, values);
	}

	@Test
	public void testWithFullColumns() {

		String columns = String.join(",", Arrays.asList(Customer.KEY_ID, Customer.KEY_NAME, Customer.KEY_ADDRESS, Customer.KEY_CITY,
				Customer.KEY_POSTCODE, Customer.KEY_COUNTRY));
		String values = "3, 'J Doe', '1 Main St', 'Sydney', '2000', 'Australia'";

		assertToken(columns, values);
	}

	@Test
	public void testWithoutBrackets() {

		String columns = String.join(",", Arrays.asList(Customer.KEY_ID, Customer.KEY_NAME, Customer.KEY_ADDRESS, Customer.KEY_CITY,
				Customer.KEY_POSTCODE, Customer.KEY_COUNTRY));
		String values = "4, 'J Doe', '1 Main St', 'Sydney', '2000', 'Australia'";

		assertNull(columns, values);
	}
}
