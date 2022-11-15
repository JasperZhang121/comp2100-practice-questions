import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nanwang
 *
 The goal of this task it to write a program that loads/stores a list of trees in XML format. `TreeCollection.java` class contains a
 list of `Tree` instances. Each tree has its own `kind`, which needs to be saved as an attribute of XML node. Additionally, each tree
 can have three possible properties: `dimension`, `color` and `types`. `dimension` property has two integer attributes: `diameter` and
 `height`. `types` property has a list of `type` elements. Note that not every tree has all three properties. Some properties of trees
 may be missing (for example, see the test cases in TreesTest.java). You job is to implement the below methods in `TreeCollection.java`:

* `saveToFile`
* `loadFromFile`

Note that these methods should take into account the available properties of a given tree. You are allowed to add additional asserts
and test cases to test your solutions. You can use `getAttribute(String name)` and `setAttribute(String name, String value)` of `Element`
class to get and set the attributes of XML node. **Please upload `TreeCollection.java` file to wattle!**
 *
 */
public class TreeCollection {

	private final List<Tree> trees;

	public TreeCollection(List<Tree> trees) {
		this.trees = trees;
	}

	public List<Tree> getTrees() {
		return trees;
	}

	/**
	 * Implement this method to save the list of trees to XML file
	 * HINT: `setAttribute(String name, String value)` in `Element` can be used to set `kind`, `diameter` and `height` properties
	 * @param file
	 */
	public void saveToFile(File file) {
		//START YOUT CODE

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = null;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			Element root = doc.createElement("trees");
			doc.appendChild(root);
			for (var tree: trees){
				Element sub = doc.createElement("Tree");
				sub.setAttribute("Kind",tree.getKind());
				if (tree.getDimension()!=null){
					sub.setAttribute("Dimension",tree.getDimension().getDiameter()+" "+ tree.getDimension().getHeight());
				}
				if (tree.getColor()!=null){
					sub.setAttribute("Color", tree.getColor());
				}
				if (tree.getTypes()!=null){
					StringBuilder types = new StringBuilder();
					for (int i = 0; i < tree.getTypes().size(); i++) {
						if (i==0){
							types.append(tree.getTypes().get(i));
						}else {
							types.append(";").append(tree.getTypes().get(i));
						}
					}
					sub.setAttribute("Types", types.toString());
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
		//END YOUT CODE
	}

	/**
	 * Implement this method to load from the XML file to create a `TreeCollection`
	 * HINT: `getAttribute(String name)`in `Element` can be used to get `kind`, `diameter` and `height` properties
	 * @param file
	 * @return
	 */
	public static TreeCollection loadFromFile(File file) {
		//START YOUT CODE

		var res = new ArrayList<Tree>();

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(file);
			doc.getDocumentElement().normalize();

			var nl = doc.getElementsByTagName("Tree");
			for (int i = 0; i < nl.getLength(); i++) {
				var n = nl.item(i);
				if (n.getNodeType() == Node.ELEMENT_NODE){
					Element sub = (Element) n;
					String kind = sub.getAttribute("Kind");
					String dimensionString = sub.getAttribute("Dimension");
					Dimension dimension = null;
					if (!dimensionString.equals("")){
						dimension = new Dimension(Integer.parseInt(dimensionString.split(" ")[0]),Integer.parseInt(dimensionString.split(" ")[1]));
					}
					String colour = null;
					if (!sub.getAttribute("Color").equals("")){
						colour = sub.getAttribute("Color");
					}
					String [] types = null;
					if (!sub.getAttribute("Types").equals("")){
						types=sub.getAttribute("Types").split(";");
					}
					Tree tree = new Tree();
					tree.withKind(kind).withColor(colour).withDimension(dimension);
					if (types!=null){
						for (var type: types){
							tree.addType(type);
						}
					}
					res.add(tree);
				}
			}
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return new TreeCollection(res);
		//END YOUT CODE	
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o instanceof TreeCollection) {
			TreeCollection treeCollection = (TreeCollection) o;
			return this.trees.equals(treeCollection.trees);
		}

		return false;
	}
}
