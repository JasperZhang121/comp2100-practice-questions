import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.After;
import org.junit.Test;

public class XMLTableTest {

	private XMLTable table = new XMLTable();
	
	@After
	public void tearDown() throws Exception {
		 Files.deleteIfExists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME)));
	}

	@Test
	public void testWithSingleCustomer() {

		int id = 1;
		Customer c1 = new Customer(id, "Firmin", "Rosslyn St", "Melbourne", "3003", "Australia");

		table.insert(Customer.TABLE_NAME, c1);

		assertTrue(Files.exists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME))));

		List<Customer> customers = table.load(Customer.TABLE_NAME);

		assertEquals(customers.size(), 1);
		assertEquals(customers.get(0), c1);
	}

	@Test
	public void testWithMultipleCustomers1() {

		Customer c1 = new Customer(1, "Firmin", "Rosslyn St", "Melbourne", null, null);
		table.insert(Customer.TABLE_NAME, c1);

		assertTrue(Files.exists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME))));

		List<Customer> customers = table.load(Customer.TABLE_NAME);
		
		assertEquals(customers.size(), 1);
		assertEquals(customers.get(0), c1);

		Customer c2 = new Customer(2, "John", null, null, null, "Australia");
		table.insert(Customer.TABLE_NAME, c2);
		
		assertTrue(Files.exists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME))));

		customers = table.load(Customer.TABLE_NAME);
		
		assertEquals(customers.size(), 2);
		assertEquals(customers.get(0), c1);
		assertEquals(customers.get(1), c2);
	}

	@Test
	public void testWithMultipleCustomers2() {

		Customer c1 = new Customer(7, "Firmin", "Rosslyn St", "Melbourne", "2004", "Australia");
		table.insert(Customer.TABLE_NAME, c1);

		assertTrue(Files.exists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME))));

		List<Customer> customers = table.load(Customer.TABLE_NAME);
		
		assertEquals(customers.size(), 1);
		assertEquals(customers.get(0), c1);

		Customer c2 = new Customer(8, "John", "Macus St", "Canberra", "2003", "Australia");
		table.insert(Customer.TABLE_NAME, c2);
		
		assertTrue(Files.exists(Paths.get(FileUtil.getTableFileName(Customer.TABLE_NAME))));

		customers = table.load(Customer.TABLE_NAME);
		
		assertEquals(customers.size(), 2);
		assertEquals(customers.get(0), c1);
		assertEquals(customers.get(1), c2);
	}
}
