import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class ParserTest {

	private XMLTable table = new XMLTable();

	@After
	public void tearDown() throws Exception {
		Files.deleteIfExists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME)));
	}

	@Test
	public void testWithOneCommand() {

		String columns = String.join(",", Arrays.asList(Customer.KEY_ID, Customer.KEY_NAME, Customer.KEY_ADDRESS, Customer.KEY_CITY,
				Customer.KEY_POSTCODE, Customer.KEY_COUNTRY));
		String values = "1, 'J Doe', '1 Main St', 'Sydney', '2000', 'Australia'";

		String command = "INSERT INTO " + Customer.TABLE_NAME + " (" + columns + ") VALUES (" + values + ");";

		Parser parser = new Parser(new Tokeniser(command), table);

		parser.parseExp();

		assertTrue(Files.exists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME))));

		List<Customer> newcustomers = table.load(Customer.TABLE_NAME);

		Customer c = new Customer();
		c.setId(1);
		c.setName("J Doe");
		c.setAddress("1 Main St");
		c.setCity("Sydney");
		c.setPostCode("2000");
		c.setCountry("Australia");
		
		assertEquals(newcustomers.size(), 1);
		assertEquals(newcustomers.get(0), c);
	}

	@Test
	public void testWithTwoCommands() {

		// first command
		String columns = String.join(",", Arrays.asList(Customer.KEY_ID, Customer.KEY_NAME, Customer.KEY_ADDRESS,
				Customer.KEY_CITY, Customer.KEY_POSTCODE, Customer.KEY_COUNTRY));
		String values = "3, 'J Doe', '1 Main St', 'Sydney', '2000', 'Australia'";

		String command1 = "INSERT INTO " + Customer.TABLE_NAME + " (" + columns + ") VALUES (" + values + ");";

		Parser parser = new Parser(new Tokeniser(command1), table);
		parser.parseExp();

		assertTrue(Files.exists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME))));

		List<Customer> newcustomers = table.load(Customer.TABLE_NAME);

		Customer c1 = new Customer();
		c1.setId(3);
		c1.setName("J Doe");
		c1.setAddress("1 Main St");
		c1.setCity("Sydney");
		c1.setPostCode("2000");
		c1.setCountry("Australia");

		assertEquals(newcustomers.size(), 1);
		assertEquals(newcustomers.get(0), c1);

		// second command
		columns = String.join(",", Arrays.asList(Customer.KEY_ID, Customer.KEY_NAME, Customer.KEY_ADDRESS,
				Customer.KEY_CITY, Customer.KEY_POSTCODE, Customer.KEY_COUNTRY));
		values = "4, 'John', 'Macus St', 'Canberra', '2003', 'Australia'";

		String command2 = "INSERT INTO " + Customer.TABLE_NAME + " (" + columns + ") VALUES (" + values + ");";

		parser = new Parser(new Tokeniser(command2), table);
		parser.parseExp();

		assertTrue(Files.exists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME))));

		newcustomers = table.load(Customer.TABLE_NAME);

		Customer c2 = new Customer();
		c2.setId(4);
		c2.setName("John");
		c2.setAddress("Macus St");
		c2.setCity("Canberra");
		c2.setPostCode("2003");
		c2.setCountry("Australia");

		assertEquals(newcustomers.size(), 2);
		assertEquals(newcustomers.get(0), c1);
		assertEquals(newcustomers.get(1), c2);
	}

	@Test
	public void testWithWrongColumnNames() {

		String columns = String.join(",", Arrays.asList(Customer.KEY_ID, Customer.KEY_NAME, Customer.KEY_ADDRESS,
				Customer.KEY_CITY + "1", Customer.KEY_POSTCODE, Customer.KEY_COUNTRY + "2"));
		String values = "5, 'J Doe', '1 Main St', 'Sydney', '2000', 'Australia'";

		String command = "INSERT INTO " + Customer.TABLE_NAME + " (" + columns + ") VALUES (" + values + ");";

		Parser parser = new Parser(new Tokeniser(command), table);

		parser.parseExp();

		List<Customer> newcustomers = table.load(Customer.TABLE_NAME);

		assertEquals(newcustomers.size(), 0);
	}
}
