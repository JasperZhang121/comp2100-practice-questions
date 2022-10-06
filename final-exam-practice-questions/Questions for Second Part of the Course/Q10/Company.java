import java.io.File;
import java.util.List;

/**
 * 
 * @author nanwang
 * 
The goal of this task is to write a program that loads/stores a college in JSON format. The `Company.java` has a company name and a 
list of `Employee` instances. Each employee has an employee name and a list of skills. There are some duplicates of the employees in 
the `company.json` file. Your job is to implement the three methods in the `Company` class:

* `loadFromJsonFile`
* `mergeEmployees`
* `saveToJsonFile`

in order to load from the given `company.json` file, merge the skills of the employees with the same names, and write the processed 
data into a JSON file, which should be the same as the given `company_processed.json` file. A `CompanyTest.java` is given to help you 
test your solutions. You are allowed to add additional asserts and test cases to test your solutions. **Please upload `Company.java` 
file to wattle!**
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
	 * Implement this method to merge the skills of the employees with the same
	 * names. Please refer to the given `company_processed.json`, which presents the
	 * data after merging.
	 */
	public void mergeEmployees() {

		// START YOUR CODE



		// END YOUR CODE
	}

	/**
	 * Implement this method to save this company object into a JSON file
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
