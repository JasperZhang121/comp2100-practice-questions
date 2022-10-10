
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ExecutorTest {

	private List<Person> persons = new LinkedList<>();

	private final DataBase db = DataBase.getInstance();

	@Before
	public void init() {
		this.persons.add(new Person("David", "male", 31, "engineer"));
		this.persons.add(new Person("Patrick", "male", 53, "professor"));
		this.persons.add(new Person("Lisa", "female", 28, "nurse"));
		this.persons.add(new Person("Michael", "male", 37, "doctor"));
		this.persons.add(new Person("Emma", "female", 26, "actress"));
		this.persons.add(new Person("Alice", "female", 17, "student"));

		this.db.save("persons", persons);
	}

	@After
	public void destruct() {
		File f = new File("persons.xml");
		if (f.exists()) {
			// HINT: You are allowed to comment this statement to see the file content
			f.delete();
		}

		this.persons.clear();
		this.db.clear();
	}

	/**
	 * 
	 * Note that in the given test cases, we only check whether the xml file exists
	 * instead of whether the file content is correct.
	 * 
	 * Passing the given test cases does not indicate the correctness of your
	 * solutions. Thus, you are encouraged to write your own test cases to check the
	 * file content.
	 * 
	 * We will check the file content in the marking test cases.
	 * 
	 */
	@Test(timeout=1000)
	public void testSave() {
		execute("SAVE persons TO persons.xml;");

		File f = new File("persons.xml");
		assertTrue(f.exists());
	}

	@Test(timeout=1000)
	public void testSaveLoad() {
		execute("SAVE persons TO persons.xml;LOAD persons FROM persons.xml;");

		File f = new File("persons.xml");
		assertTrue(f.exists());

		List<Person> loadedPersons = this.db.load("persons");

		assertTrue(personsCompare(this.persons, loadedPersons));
	}

	@Test(timeout=1000)
	public void testComplex() {
		execute("SAVE   persons   TO persons.xml   ;   LOAD persons  FROM  persons.xml;  ");

		File f = new File("persons.xml");
		assertTrue(f.exists());

		List<Person> loadedPersons = this.db.load("persons");

		assertTrue(personsCompare(this.persons, loadedPersons));
	}

	private void execute(String text) {
		Parser parser = new Parser(new Tokeniser(text));

		Executor executor = new Executor(parser.parseCmds());

		executor.execute();
	}

	private boolean personsCompare(List<Person> p1, List<Person> p2) {
		if (p1 == null && p2 != null) {
			return false;
		} else if (p1 != null && p2 == null) {
			return false;
		}

		if (p1.size() != p2.size()) {
			return false;
		}

		for (int i = 0; i < p1.size(); i++) {
			if (!p1.get(i).equals(p2.get(i))) {
				return false;
			}
		}

		return true;
	}
}
