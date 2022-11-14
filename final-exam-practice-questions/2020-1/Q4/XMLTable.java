import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * IMPORTANT: This class is incomplete. Please look for "TODO" comments.
 * 
 * Save() method is already given. Please implement load() method to load XML
 * files and insert() method to insert a new customer to XML files.
 * 
 * Each customer must have an ID value, but may not have all the following column values:
 * Name, Address, City, Postcode, Country. Please see test cases in XMLTableTest.java.
 * 
 */
public class XMLTable {

	/**
	 * Save all records to the XML file
	 */
	public void save(String tableName, List<Customer> customers) {

		File f = new File(FileUtil.getTableFileName(tableName));

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		try {
			// make the xml tree
			// use factory to get the instance of document builder
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.newDocument();
			// Root element <customers>
			Element rootElem = doc.createElement(Customer.KEY_ROOT);
			doc.appendChild(rootElem);

			for (Customer customer : customers) {
				Element customerElem = doc.createElement(Customer.KEY_ELEMENT);
				rootElem.appendChild(customerElem);

				// child element <ID> under <customer>
				Element cid = doc.createElement(Customer.KEY_ID);
				cid.appendChild(doc.createTextNode(Integer.toString(customer.getId())));
				customerElem.appendChild(cid);

				if (customer.getName() != null) {
					Element name = doc.createElement(Customer.KEY_NAME);
					name.appendChild(doc.createTextNode(customer.getName()));
					customerElem.appendChild(name);
				}

				if (customer.getAddress() != null) {
					Element address = doc.createElement(Customer.KEY_ADDRESS);
					address.appendChild(doc.createTextNode(customer.getAddress()));
					customerElem.appendChild(address);
				}

				if (customer.getCity() != null) {
					Element city = doc.createElement(Customer.KEY_CITY);
					city.appendChild(doc.createTextNode(customer.getCity()));
					customerElem.appendChild(city);
				}

				if (customer.getPostCode() != null) {
					Element postCode = doc.createElement(Customer.KEY_POSTCODE);
					postCode.appendChild(doc.createTextNode(customer.getPostCode()));
					customerElem.appendChild(postCode);
				}

				if (customer.getCountry() != null) {
					Element country = doc.createElement(Customer.KEY_COUNTRY);
					country.appendChild(doc.createTextNode(customer.getCountry()));
					customerElem.appendChild(country);
				}
			}
			// save the xml file
			// Transformer is for process XML from a variety of sources and write the
			// transformation
			// output to a variety of sinks
			Transformer transformer = TransformerFactory.newInstance().newTransformer();

			// set xml encoding to utf-8
			transformer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
			// pretty print
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(f);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get all records from the XML file
	 */
	public List<Customer> load(String tableName) {

		List<Customer> customers = new ArrayList<>();

		File f = new File(FileUtil.getTableFileName(tableName));
		if (!f.exists()) {
			return customers;
		}

		// TODO: Complete this method
		// START YOUR CODE

		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db;

		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);
			Element root = doc.getDocumentElement();

			var nodeList = root.getElementsByTagName(Customer.KEY_ELEMENT);
			List<Element> customerNodes = new ArrayList<>();
			for (int i = 0; i < nodeList.getLength(); i++) {
				org.w3c.dom.Node node = nodeList.item(i);
				if (node.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE){
					Element element = (Element) node;
					customerNodes.add(element);
				}
			}
			for (var customerNode: customerNodes){
				String id = null;
				String name = null;
				String address = null;
				String city = null;
				String postCode = null;
				String country = null;

				if (customerNode.getElementsByTagName(Customer.KEY_ID).item(0)!=null){
					id = customerNode.getElementsByTagName(Customer.KEY_ID).item(0).getTextContent();
				}
				if (customerNode.getElementsByTagName(Customer.KEY_NAME).item(0)!=null){
					name = customerNode.getElementsByTagName(Customer.KEY_NAME).item(0).getTextContent();
				}
				if (customerNode.getElementsByTagName(Customer.KEY_ADDRESS).item(0)!=null){
					address=customerNode.getElementsByTagName(Customer.KEY_ADDRESS).item(0).getTextContent();
				}
				if (customerNode.getElementsByTagName(Customer.KEY_CITY).item(0)!=null){
					city = customerNode.getElementsByTagName(Customer.KEY_CITY).item(0).getTextContent();
				}
				if (customerNode.getElementsByTagName(Customer.KEY_POSTCODE).item(0)!=null){
					postCode = customerNode.getElementsByTagName(Customer.KEY_POSTCODE).item(0).getTextContent();
				}
				if (customerNode.getElementsByTagName(Customer.KEY_COUNTRY).item(0)!=null){
					country = customerNode.getElementsByTagName(Customer.KEY_COUNTRY).item(0).getTextContent();
				}

				Customer customer = new Customer(Integer.parseInt(id),name,address,city,postCode,country);
				customers.add(customer);
			}


		} catch (ParserConfigurationException | IOException | SAXException e) {
			e.printStackTrace();
		}


		// END YOUR CODE

		return customers;
	}

	/**
	 * Insert a new customer to XML files. 
	 * 
	 *
	 */
	public void insert(String tableName, Customer customer) {
		
		// TODO: Complete this method
		// START YOU CODE
		// HINT: insert the given customer to the XML file.
		// You can call the load() and save() methods

		var lis = load(tableName);
		lis.add(customer);
		save(tableName,lis);

		// END YOUR CODE
	}
}
