
public class Person {

	public static final String KEY_ROOT = "persons";
	public static final String KEY_ELEMENT = "person";
	public static final String KEY_NAME = "name";
	public static final String KEY_GENDER = "gender";
	public static final String KEY_AGE = "age";
	public static final String KEY_OCCUPATION = "occupation";

	private String name;

	private String gender;

	private int age;

	private String occupation;

	public Person() {
	}

	public Person(String name, String gender, int age, String occupation) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.occupation = occupation;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public int getAge() {
		return age;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof Person) {
			Person p = (Person) o;

			if (this.name != null) {
				if (!this.name.equals(p.name)) {
					return false;
				}
			} else if (p.name != null) {
				return false;
			}

			if (this.gender != null) {
				if (!this.gender.equals(p.gender)) {
					return false;
				}
			} else if (p.gender != null) {
				return false;
			}

			if (this.age != p.age) {
				return false;
			}

			if (this.occupation != null) {
				if (!this.occupation.equals(p.occupation)) {
					return false;
				}
			} else if (p.occupation != null) {
				return false;
			}
		}

		return true;
	}
}
