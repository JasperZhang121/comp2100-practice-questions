import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nanwang
 *
The goal of this task is to write a program that loads/stores a list of students in XML format. `StudentCollection.java` class contains
a list of `Student` instances. Each student has his/her `age` and `name`, which need to be saved as attributes of XML node. Additionally,
each student can have three possible properties: `height`, `weight` and `courses`. `courses` property contains a list of `course` elements.
Each course has a course `name` attribute and a `grade` value. Note that not every student has all three properties. Some properties of students may be missing
(for example, see the test cases in StudentsTest.java). You job is to implement the below two methods in `StudentCollection.java`:

* `saveToFile`
* `loadFromFile`

Note that these methods should take into account the available properties of a given student. You are allowed to add additional asserts
and test cases to test your solutions. You can use `getAttribute(String name)` and `setAttribute(String name, String value)` of `Element`
class to get and set the attributes of XML node. **Please upload `StudentCollection.java` to wattle!**
 */
public class StudentCollection {

	private final List<Student> students;

	public StudentCollection(List<Student> students) {
		this.students = students;
	}

	public List<Student> getStudents() {
		return students;
	}

	/**
	 * Implement this method to save the list of students to XML file
	 * HINT: `setAttribute(String name, String value)` in `Element` can be used to set `name` and `age` properties
	 * @param file
	 */
	public void saveToFile(File file) {
		//START YOUR CODE

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			var root = doc.createElement("Students");
			doc.appendChild(root);
			for (var student : students) {
				var sub = doc.createElement("student");
				sub.setAttribute("age",String.valueOf(student.getAge()));
				sub.setAttribute("name",student.getName());
				if (student.getHeight()!=null){
					sub.setAttribute("Height",String.valueOf(student.getHeight()));
				}
				if (student.getWeight()!=null){
					sub.setAttribute("Weight",String.valueOf(student.getWeight()));
				}
				if (student.getCourses()!=null){
					StringBuilder temp = new StringBuilder();
					for (int i = 0; i < student.getCourses().size(); i++) {
						temp.append(student.getCourses().get(i).getName()).append(" ");
						temp.append(student.getCourses().get(i).getGrade().toString()).append(" ");
					}
					sub.setAttribute("Course",temp.toString());
				}
				root.appendChild(sub);
			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(file);
			transformer.transform(source, result);

		} catch (ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}


		//END YOUR CODE
	}

	/**
	 * Implement this method to load from the XML file to create a `StudentCollection`
	 * HINT: `getAttribute(String name)`in `Element` can be used to get `name` and `age` properties
	 * @param file
	 * @return
	 */
	public static StudentCollection loadFromFile(File file) {
		//START YOUR CODE
		var res = new ArrayList<Student>();
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();
			var nl = doc.getElementsByTagName("student");
			for (int i = 0; i < nl.getLength(); i++) {
				var n = (Element) nl.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE){
					String age = n.getAttribute("age");
					String name = n.getAttribute("name");
					Integer height = null;
					if (!n.getAttribute("Height").equals("")){
						height = Integer.parseInt(n.getAttribute("Height"));
					}
					Integer weight = null;
					if (!n.getAttribute("Weight").equals("")){
						weight = Integer.parseInt(n.getAttribute("Weight"));
					}
					var courses = new ArrayList<Course>();
					String [] each = null;
					if (!n.getAttribute("Course").equals("")){
						each = n.getAttribute("Course").split(" ");
						for (int j = 0; j < each.length; j+=2) {
							var courseName = each[j];
							var courseGrade = Integer.parseInt(each[j+1]);
							Course course = new Course(courseName,courseGrade);
							courses.add(course);
						}
					}
					Student student = new Student();
					student.withAge(Integer.parseInt(age)).withName(name).withHeight(height).withWeight(weight);
					for (var course: courses){
						student.addCourse(course);
					}
					res.add(student);
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return new StudentCollection(res);
		//END YOUR CODE
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof StudentCollection) {
			StudentCollection studentCollection = (StudentCollection) o;
			return this.students.equals(studentCollection.students);
		}

		return false;
	}
}
