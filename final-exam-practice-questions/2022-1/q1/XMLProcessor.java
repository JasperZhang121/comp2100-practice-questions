import java.io.File;
import java.util.Collections;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;

public class XMLProcessor {

	private static final String STATE_ROOT_ELEMENT = "States";

	public static List<List<String>> read(String fileName) {
		File f = new File(fileName);
		if (!f.exists()) {
			return Collections.emptyList();
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);

			doc.getDocumentElement().normalize();

			// TODO
			// ########## YOUR CODE STARTS HERE ##########
			// HINT: You can use getChildNodes() function in the XML library to obtain a
			// list of child nodes of the parent tag STATE_ROOT_ELEMENT.

			// ########## YOUR CODE ENDS HERE ##########
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Collections.emptyList();
	}

	public static void write(String fileName, List<String> keys, List<String> states) {
		File f = new File(fileName);
		if (f.exists()) {
			f.delete();
		}

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {

			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();

			// TODO
			// ########## YOUR CODE STARTS HERE ##########

			// ########## YOUR CODE ENDS HERE ##########

			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
