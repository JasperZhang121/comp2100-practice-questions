
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.LinkedList;
import java.util.List;


public class Application {

	public RBTree<Integer, Person> createTree(List<Person> personList) {

		RBTree<Integer, Person> tree = new RBTree<>();

		// ########## YOUR CODE STARTS HERE ##########
		if (personList==null)return tree;

		for (var person:personList) {
			tree.insert(person.id,person);
		}
		// ########## YOUR CODE ENDS HERE ##########

		return tree;
	}

	public List<Person> readCsv(String fileName) {

		List<Person> list = new LinkedList<>();

		// ########## YOUR CODE STARTS HERE ##########
		String line = "";
		String splitBy = ";";
		int skip = 0;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
			while ((line = bufferedReader.readLine())!=null){
				if (skip==0){
					skip+=1;
					continue;
				}
				String[] p = line.split(splitBy);
				Person person = new Person(Integer.parseInt(p[0]),p[1],Integer.parseInt(p[2]),p[3]);
				list.add(person);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		// ########## YOUR CODE ENDS HERE ##########

		return list;
	}

	public void saveXML(RBTree<Integer, Person> tree) {

		if (tree == null) {
			return;
		}

		List<Node> list = tree.levelTraversal();

		// ########## YOUR CODE STARTS HERE ##########

		File f = new File("people.xml");
		if (f.exists()) {
			f.delete();
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			Element root = doc.createElement("people");
			doc.appendChild(root);


			for (int i = 0; i < list.size(); i++) {
				var n = list.get(i);
				var p = (Person)n.data;

				Element person = doc.createElement("person");

				// id
				Element id = doc.createElement("id");
				Text idValue = doc.createTextNode(String.valueOf(p.id));
				id.appendChild(idValue);
				//id.appendChild(idValue);

				// name
				Element name = doc.createElement("name");
				Text nameValue = doc.createTextNode(p.name);
				name.appendChild(nameValue);
				//name.appendChild(nameValue);

				// age
				Element age = doc.createElement("age");
				Text ageValue = doc.createTextNode(String.valueOf(p.age));
				age.appendChild(ageValue);
				//age.appendChild(ageValue);

				// occupation
				Element occupation = doc.createElement("occupation");
				Text occupationValue = doc.createTextNode(p.occupation);
				occupation.appendChild(occupationValue);
				//occupation.appendChild(occupationValue);

				person.appendChild(id);
				person.appendChild(name);
				person.appendChild(age);
				person.appendChild(occupation);
				root.appendChild(person);

			}
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");


			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
		

		// ########## YOUR CODE ENDS HERE ##########
	}

}
