import java.io.File;
import java.util.List;

/**
 * 
 * @author nanwang
 * 
 The goal of this task is to write a program that loads/stores students of some college in JSON format. The `College.java` class has 
 a college name and a list of `Student` instances. Each student has a student name and a list of courses. There are some duplicates 
 of the students in the `college.json` file. You job is to implement the three methods in the `College.java` class:

* `loadFromJsonFile`  
* `mergeStudents`
* `saveToJsonFile`

in order to load from the given `college.json` file, merge the courses of the students with the same names and write the processed 
data into a JSON file, which should be the same as the given `college_processed.json` file. A `CollegeTest.java` is given to help you 
test your solutions. You are allowed to add additional asserts and test cases to test your solutions. **Please upload `College.java` 
file to wattle!**
 */
public class College {

	private String name;
	private List<Student> students;

	/**
	 * Implement this method to load json data from file to create a college
	 * 
	 * @param file
	 * @return
	 */
	public static College loadFromJsonFile(File file) {

		// START YOUR CODE



		// END YOUR CODE

		return null;
	}

	/**
	 * Implement this method to merge the courses of the students with the same
	 * names. Please refer to the given `college_processed.json`, which presents the
	 * data after merging.
	 */
	public void mergeStudents() {

		// START YOUR CODE



		// END YOUR CODE
	}

	/**
	 * Implement this method to write this college into a json file
	 * 
	 * @param file
	 */
	public void saveToJsonFile(File file) {

		// START YOUR CODE



		// END YOUR CODE
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof College) {
			College college = (College) o;

			return this.name.equals(college.name) && this.students.equals(college.students);
		}

		return false;
	}
}
