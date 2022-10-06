/**
 * 
 * @author nanwang
 *
 */
public class Course {

	private String name;
	private Integer grade;

	public Course(String name, Integer grade) {
		this.name = name;
		this.grade = grade;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Course) {
			Course course = (Course) o;
			return this.name.equals(course.name) && this.grade.equals(course.grade);
		}

		return false;
	}
}
