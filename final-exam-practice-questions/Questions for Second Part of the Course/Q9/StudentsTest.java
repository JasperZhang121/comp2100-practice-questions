import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * 
 * @author nanwang
 * 
 * You are allowed to add additional `asserts` and test cases to testify your programs in all test cases.
 *
 */
public class StudentsTest {

	@Test
	public void testSave1() {

		Student student1 = new Student().withName("Henry").withAge(20).withHeight(176).withWeight(63)
				.addCourse(new Course("network", 76)).addCourse(new Course("math", 80))
				.addCourse(new Course("database", 74));

		Student student2 = new Student().withName("Emma").withAge(19).withHeight(165).withWeight(53)
				.addCourse(new Course("network", 79)).addCourse(new Course("math", 84))
				.addCourse(new Course("database", 77));

		List<Student> students = Arrays.asList(student1, student2);

		StudentCollection studentCollection = new StudentCollection(students);

		File file = new File("students.xml");
		file.delete();

		studentCollection.saveToFile(file);
		
		assertTrue(file.exists());

		file.delete();
	}

	@Test
	public void testLoad1() {

		Student student1 = new Student().withName("Henry").withAge(20).withHeight(176).withWeight(63)
				.addCourse(new Course("network", 76)).addCourse(new Course("math", 80))
				.addCourse(new Course("database", 74));

		Student student2 = new Student().withName("Emma").withAge(19).withHeight(165).withWeight(53)
				.addCourse(new Course("network", 79)).addCourse(new Course("math", 84))
				.addCourse(new Course("database", 77));

		List<Student> students = Arrays.asList(student1, student2);

		StudentCollection studentCollection1 = new StudentCollection(students);

		File file = new File("students.xml");
		file.delete();

		studentCollection1.saveToFile(file);
		
		assertTrue(file.exists());

		StudentCollection studentCollection2 = StudentCollection.loadFromFile(file);

		assertEquals(studentCollection1, studentCollection2);

		file.delete();
	}

	@Test
	public void testSave2() {

		Student student1 = new Student().withName("Henry").withAge(20).addCourse(new Course("network", 76))
				.addCourse(new Course("math", 80)).addCourse(new Course("database", 74));

		Student student2 = new Student().withName("Emma").withAge(19).withHeight(165)
				.addCourse(new Course("network", 79)).addCourse(new Course("database", 77));

		List<Student> students = Arrays.asList(student1, student2);

		StudentCollection studentCollection = new StudentCollection(students);

		File file = new File("students.xml");
		file.delete();

		studentCollection.saveToFile(file);
		
		assertTrue(file.exists());

		file.delete();
	}

	@Test
	public void testLoad2() {

		Student student1 = new Student().withName("Henry").withAge(20).withHeight(176).withWeight(63)
				.addCourse(new Course("network", 76)).addCourse(new Course("math", 80));

		Student student2 = new Student().withName("Emma").withAge(19).addCourse(new Course("math", 84))
				.addCourse(new Course("database", 77));

		List<Student> students = Arrays.asList(student1, student2);

		StudentCollection studentCollection1 = new StudentCollection(students);

		File file = new File("students.xml");
		file.delete();

		studentCollection1.saveToFile(file);
		
		assertTrue(file.exists());

		StudentCollection studentCollection2 = StudentCollection.loadFromFile(file);

		assertEquals(studentCollection1, studentCollection2);

		file.delete();
	}
	
	@Test
	public void testLoad3() {

		Student student1 = new Student().withName("Henry").withAge(20);
				
		Student student2 = new Student().withName("Emma").withAge(19).addCourse(new Course("math", 84))
				.addCourse(new Course("database", 77));

		List<Student> students = Arrays.asList(student1, student2);

		StudentCollection studentCollection1 = new StudentCollection(students);

		File file = new File("students.xml");
		file.delete();

		studentCollection1.saveToFile(file);
		
		assertTrue(file.exists());

		StudentCollection studentCollection2 = StudentCollection.loadFromFile(file);

		assertEquals(studentCollection1, studentCollection2);

		file.delete();
	}
}
