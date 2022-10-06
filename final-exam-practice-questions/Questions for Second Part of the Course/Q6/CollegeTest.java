import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Test;

/**
 * 
 * @author nanwang
 * 
 * You are allowed to add additional `asserts` and test cases to testify your programs in all test cases.
 *
 */
public class CollegeTest {

	private static final String JSON_FILE = "college.json";
	private static final String PROCESSED_JSON_FILE = "college_processed.json";
	private static final String COLLEGE_NAME = "Computer Science";

	@Test
	public void testLoadFromFile1() throws Exception {

		File file = new File(JSON_FILE);

		College college = College.loadFromJsonFile(file);
		
		assertNotNull(college);
		assertEquals(college.getName(), COLLEGE_NAME);
		assertEquals(college.getStudents().size(), 8);
	}
	
	@Test
	public void testLoadFromFile2() throws Exception {

		File file = new File(PROCESSED_JSON_FILE);

		College college = College.loadFromJsonFile(file);
		
		assertNotNull(college);
		assertEquals(college.getName(), COLLEGE_NAME);
		assertEquals(college.getStudents().size(), 5);
	}

	@Test
	public void testSaveToFile() throws Exception {

		File file = new File(JSON_FILE);

		College college = College.loadFromJsonFile(file);

		assertNotNull(college);
		assertEquals(college.getName(), COLLEGE_NAME);
		assertEquals(college.getStudents().size(), 8);
		
		File newfile = new File("new_college.json");
		newfile.delete();

		college.saveToJsonFile(newfile);
		
		College newcollege = College.loadFromJsonFile(newfile);
		
		assertEquals(college, newcollege);
		
		newfile.delete();
	}

	@Test
	public void testMerge() throws Exception {
		File file = new File(JSON_FILE);

		College college = College.loadFromJsonFile(file);

		assertNotNull(college);
		assertEquals(college.getName(), COLLEGE_NAME);
		assertEquals(college.getStudents().size(), 8);
		
		college.mergeStudents();
		
		assertNotNull(college);
		assertEquals(college.getName(), COLLEGE_NAME);
		assertEquals(college.getStudents().size(), 5);
	}
	
	@Test
	public void testAll() throws Exception {
		File file = new File(JSON_FILE);

		College college = College.loadFromJsonFile(file);

		assertNotNull(college);
		assertEquals(college.getName(), COLLEGE_NAME);
		assertEquals(college.getStudents().size(), 8);
		
		college.mergeStudents();
		
		assertNotNull(college);
		assertEquals(college.getName(), COLLEGE_NAME);
		assertEquals(college.getStudents().size(), 5);
		
		File newfile = new File("new_college_processed.json");
		newfile.delete();

		college.saveToJsonFile(newfile);
		
		College newcollege = College.loadFromJsonFile(newfile);
		
		assertEquals(college, newcollege);
				
		newfile.delete();
	}
}
