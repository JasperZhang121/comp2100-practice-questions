import java.util.List;

public class Student {

	private String name;

	private List<String> courses;
	
	public Student(String name, List<String> courses) {
		this.name = name;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public List<String> getCourses() {
		return courses;
	}

	public void setCourses(List<String> courses) {
		this.courses = courses;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o) {
			return true;
		}
		
		if(o instanceof Student) {
			Student student = (Student) o;
			
			return this.name.equals(student.name) && this.courses.equals(student.courses);
		}
		
		return false;
	}
}
