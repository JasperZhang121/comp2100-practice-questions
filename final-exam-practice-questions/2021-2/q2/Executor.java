import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Executor {

	private final List<Command> commands;

	private final DataBase db = DataBase.getInstance();

	public Executor(List<Command> commands) {
		this.commands = commands;
	}

	public void execute() {
		for (Command c : this.commands) {
			if (c instanceof LoadCommand) {
				loadFrom((LoadCommand) c);
			} else if (c instanceof SaveCommand) {
				saveTo((SaveCommand) c);
			}
		}
	}

	/**
	 * save the persons from the database to the xml file
	 * 
	 * @param sac
	 */
	private void saveTo(SaveCommand sac) {

		List<Person> persons = this.db.load(sac.getKey());

		File f = new File(sac.getFileName());
		if (f.exists()) {
			f.delete();
		}


		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			// TODO
			// ########## YOUR CODE STARTS HERE ##########

			/*Element root_persons = doc.createElement("persons");
			doc.appendChild(root_persons);

			for (var person: persons){
				var node = doc.createElement("person");
				node.setAttribute("name",person.getName());
				node.setAttribute("gender", person.getGender());
				node.setAttribute("age",String.valueOf(person.getAge()));
				node.setAttribute("occupation",person.getOccupation());
				root_persons.appendChild(node);
			}*/

			Element root = doc.createElement("persons");
			doc.appendChild(root);

			for (var person: persons){

				var sub = doc.createElement("person");


				var name = doc.createElement("name");
				var nameText = doc.createTextNode(person.getName());
				name.appendChild(nameText);

				var gender = doc.createElement("gender");
				var genderText = doc.createTextNode(person.getGender());
				gender.appendChild(genderText);

				var age = doc.createElement("age");
				var ageText = doc.createTextNode(String.valueOf(person.getAge()));
				age.appendChild(ageText);

				var occupation = doc.createElement("occupation");
				var occupationText = doc.createTextNode(String.valueOf(person.getOccupation()));
				occupation.appendChild(occupationText);

				sub.appendChild(name);
				sub.appendChild(gender);
				sub.appendChild(age);
				sub.appendChild(occupation);
				root.appendChild(sub);
			}

			// ########## YOUR CODE ENDS HERE ##########

			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");

			// INDENT the xml file is optional, you can
			// uncomment the following statement if you would like the xml files to be more
			// readable
			// transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * load the persons from the xml file into the database
	 * 
	 * @param lc
	 */
	private void loadFrom(LoadCommand lc) {

		List<Person> persons = new LinkedList<>();

		File f = new File(lc.getFileName());
		if (!f.exists()) {
			return;
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);
			doc.getDocumentElement().normalize();

			// TODO
			// ########## YOUR CODE STARTS HERE ##########

			/*var nodeList  = doc.getElementsByTagName("person");
			for (int i = 0; i < nodeList.getLength(); i++) {
				var node = nodeList.item(i);
				if (node.getNodeType() == Node.ELEMENT_NODE){
					Element element = (Element) node;
					var name = element.getAttribute("name");
					var gender  = element.getAttribute("gender");
					var age = element.getAttribute("age");
					var occupation = element.getAttribute("occupation");
					Person person = new Person(name,gender,Integer.parseInt(age),occupation);
					persons.add(person);
				}
			}*/

			var nl = doc.getElementsByTagName("person");
			for (int i = 0; i < nl.getLength(); i++) {

				var n = nl.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE){
					Element sub = (Element) n;

					var nodes = sub.getChildNodes();
					String name = "";
					String gender="";
					int age = 0;
					String occupation ="";

					name = nodes.item(0).getTextContent();
					gender = nodes.item(1).getTextContent();
					age = Integer.parseInt(nodes.item(2).getTextContent());
					occupation = nodes.item(3).getTextContent();

					Person person = new Person(name,gender,age,occupation);
					persons.add(person);
				}
			}

			// ########## YOUR CODE ENDS HERE ##########

			this.db.save(lc.getKey(), persons);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<Command> getCommands() {
		return commands;
	}
}
