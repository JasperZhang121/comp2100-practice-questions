import java.util.List;

public class Employee {

	private String name;

	private List<String> skills;
	
	public Employee(String name, List<String> skills) {
		this.name = name;
		this.skills = skills;
	}

	public String getName() {
		return name;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if(o instanceof Employee) {
			Employee student = (Employee) o;
			
			return this.name.equals(student.name) && this.skills.equals(student.skills);
		}
		
		return false;
	}
}
