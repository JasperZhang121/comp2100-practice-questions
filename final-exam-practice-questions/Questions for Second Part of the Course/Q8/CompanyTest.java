import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.File;

import org.junit.Test;

/**
 * 
 * @author nanwang
 * 
 * You are allowed to add additional `asserts` and test cases to testify your programs in all test cases.
 *
 */
public class CompanyTest {
	
	private static final String JSON_FILE = "company.json";
	private static final String PROCESSED_JSON_FILE = "company_processed.json";
	private static final String COMPANY_NAME = "ACT Software";

	@Test
	public void testLoadFromJsonFile() {
		File jsonfile = new File(JSON_FILE);

		Company company = Company.loadFromJsonFile(jsonfile);

		assertNotNull(company);
		assertEquals(company.getName(), COMPANY_NAME);
		assertEquals(company.getEmployees().size(), 5);
	}

	@Test
	public void testSaveJsonFile() {
		File jsonfile1 = new File(JSON_FILE);

		Company company = Company.loadFromJsonFile(jsonfile1);

		assertNotNull(company);
		assertEquals(company.getName(), COMPANY_NAME);
		assertEquals(company.getEmployees().size(), 5);

		File jsonfile2 = new File("new_company.json");
		jsonfile2.delete();

		company.saveToJsonFile(jsonfile2);

		Company newCompany = Company.loadFromJsonFile(jsonfile2);

		assertEquals(company, newCompany);

		jsonfile2.delete();
	}

	@Test
	public void testSerialization() {
		File jsonfile = new File(JSON_FILE);

		Company company = Company.loadFromJsonFile(jsonfile);

		assertNotNull(company);
		assertEquals(company.getName(), COMPANY_NAME);
		assertEquals(company.getEmployees().size(), 5);

		File serFile = new File("company.ser");
		serFile.delete();

		company.serializeToFile(serFile);

		assertTrue(serFile.exists());

		Company newCompany = new Company();

		newCompany.deserializeFromFile(serFile);

		assertEquals(company, newCompany);

		serFile.delete();
	}

	@Test
	public void testRemoveEmployeeWhoDoNotKnowJava1() {
		File jsonfile1 = new File(JSON_FILE);

		Company company = Company.loadFromJsonFile(jsonfile1);

		assertNotNull(company);
		assertEquals(company.getName(), COMPANY_NAME);
		assertEquals(company.getEmployees().size(), 5);

		company.removeEmployeesWhoDoNotKnowJava();
		
		assertNotNull(company);
		assertEquals(company.getName(), COMPANY_NAME);
		assertEquals(company.getEmployees().size(), 3);

		for (Employee employee : company.getEmployees()) {
			if (!employee.getSkills().contains(Company.JAVA_SKILL)) {
				fail();
			}
		}
	}

	@Test
	public void testRemoveEmployeeWhoDoNotKnowJava2() {
		File jsonfile1 = new File(JSON_FILE);

		Company company = Company.loadFromJsonFile(jsonfile1);

		assertNotNull(company);
		assertEquals(company.getName(), COMPANY_NAME);
		assertEquals(company.getEmployees().size(), 5);

		company.removeEmployeesWhoDoNotKnowJava();
		
		assertNotNull(company);
		assertEquals(company.getName(), COMPANY_NAME);
		assertEquals(company.getEmployees().size(), 3);

		File jsonfile2 = new File(PROCESSED_JSON_FILE);

		Company newCompany = Company.loadFromJsonFile(jsonfile2);

		assertEquals(company, newCompany);
	}
}
