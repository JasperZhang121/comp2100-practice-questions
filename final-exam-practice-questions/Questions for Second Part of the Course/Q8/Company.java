import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nanwang
 * 
The goal of this task is to write a program that loads/stores a company via JSON and Serializable. The `Company.java` has a company 
name and a list of `Employee` instances. Each employee has an employee name and a list of skills. Your job is to implement the four 
methods in the `Company` class:

* `loadFromJsonFile`
* `saveToJsonFile`,
* `serializeToFile`,
* `removeEmployeesWhoDoNotKnowJava`

in order to load from the given `company.json` file, remove the employees who do not know Java and write the processed data to files 
via JSON and Serializable. Please implement the `serializeToFile` method based on the given `deserializeFromFile` method. The processed 
json file should be the same as the given `company_processed.json` file. A `CompanyTest.java` is given to help you test your solutions. 
You are allowed to add additional asserts and test cases to test your solutions. **Please upload `Company.java` file to wattle!**
 */
public class Company {

	private String name;
	private List<Employee> employees;

	/**
	 * Implement this method to load json data from file to create a company
	 * 
	 * @param file
	 * @return
	 */
	public static Company loadFromJsonFile(File file) {

		// START YOUR CODE



		// END YOUR CODE

		return null;
	}
	/**
	 * Implement this method to serialize this company into the given file
	 * Refer to the given `deserializeFromFile` method.
	 * @param file
	 */
	public void serializeToFile(File file) {

		// START YOUR CODE



		// END YOUR CODE
	}
	
	/**
	 * Deserialize the company from the given file
	 * @param file
	 */
	public void deserializeFromFile(File file) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			this.name = (String) ois.readObject();
			int size = ois.readInt();
			this.employees = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				this.employees.add((Employee) ois.readObject());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Implement this method to write this company into a JSON file
	 * 
	 * @param file
	 */
	public void saveToJsonFile(File file) {

		// START YOUR CODE



		// END YOUR CODE
	}

	public static final String JAVA_SKILL = "Java";
	
	/**
	 * Implment this method to remove the employees of this company who do not know Java
	 */
	public void removeEmployeesWhoDoNotKnowJava() {
		// START YOUR CODE



		// END YOUR CODE
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Company) {
			Company company = (Company) o;

			return this.name.equals(company.name) && this.employees.equals(company.employees);
		}

		return false;
	}
}
