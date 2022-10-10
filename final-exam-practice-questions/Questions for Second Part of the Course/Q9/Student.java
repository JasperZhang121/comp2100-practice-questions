import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author nanwang
 *
 */
public class Student {

	private String name;

	private Integer age;

	private Integer height;

	private Integer weight;

	private List<Course> courses;

	public Student() {
	}

	public String getName() {
		return name;
	}

	public Student withName(String name) {
		this.name = name;
		return this;
	}

	public Integer getAge() {
		return age;
	}

	public Student withAge(Integer age) {
		this.age = age;
		return this;
	}

	public Integer getHeight() {
		return height;
	}

	public Student withHeight(Integer height) {
		this.height = height;
		return this;
	}

	public Integer getWeight() {
		return weight;
	}

	public Student withWeight(Integer weight) {
		this.weight = weight;
		return this;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public Student addCourse(Course course) {
		if (this.courses == null) {
			this.courses = new ArrayList<>();
		}
		this.courses.add(course);
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Student) {
			Student student = (Student) o;

			if (!this.name.equals(student.name)) {
				return false;
			}

			if (!this.age.equals(student.age)) {
				return false;
			}

			if ((this.height != null && !this.height.equals(student.height))
					|| (student.height != null && !student.height.equals(this.height))) {
				return false;
			}

			if ((this.weight != null && !this.weight.equals(student.weight))
					|| (student.weight != null && !student.weight.equals(this.weight))) {
				return false;
			}

			if ((this.courses != null && !this.courses.equals(student.courses))
					|| (student.courses != null && !student.courses.equals(this.courses))) {
				return false;
			}
		}

		return true;
	}
}
