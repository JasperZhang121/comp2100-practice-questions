import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author nanwang 
 * 
 */
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private List<String> skills;

	public Employee(String name, List<String> skills) {
		this.name = name;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Employee) {
			Employee employee = (Employee) o;

			return this.name.equals(employee.name) && this.skills.equals(employee.skills);
		}

		return false;
	}
}
