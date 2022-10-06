
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import static org.junit.Assert.*;

public class ApplicationTest {

    Application application;

    @Before
    public void before() {
        application = new Application();
    }

    @Test(timeout = 1000)
    public void testCreateTreeEmptyList() {
        RBTree<Integer, Person> tree = application.createTree(null);
        assertTrue(tree == null || tree.inorder().isEmpty());
    }

    @Test(timeout = 3000)
    public void testCreateTree() {
        Random random = new Random();
        int index = random.nextInt(50);
        List<Person> personList = new ArrayList<>();
        for(int i = index; i < (index +  20); i++) {
            Integer id = i;
            String name = UUID.randomUUID().toString();
            Integer age = random.nextInt(100);
            String occupation = UUID.randomUUID().toString();
            Person person = new Person(id, name, age, occupation);
            personList.add(person);
        }
        RBTree<Integer, Person> tree = application.createTree(personList);
        assertNotNull(tree);
        List<Node> nodeList = tree.inorder();
        assertNotNull(nodeList);
        assertEquals(personList.size(), nodeList.size());
        for(int i = 0; i < personList.size(); i++) {
            assertNotNull(nodeList.get(i));
            assertNotNull(nodeList.get(i).getKey());
            assertTrue(nodeList.get(i).getKey() instanceof Integer);
            Person person = tree.getData((Integer) nodeList.get(i).getKey());
            assertEquals(personList.get(i).getId(), person.getId());
            assertEquals(personList.get(i).getName(), person.getName());
            assertEquals(personList.get(i).getAge(), person.getAge());
            assertEquals(personList.get(i).getOccupation(), person.getOccupation());
        }
    }

    @Test(timeout = 2000)
    public void testReadCsv() throws IOException {
        File tempFile = File.createTempFile("person", ".csv");
        String content = "id;name;age;occupation";
        Random random = new Random();
        int index = random.nextInt(50);
        List<Person> personList = new ArrayList<>();
        for(int i = index; i < (index +  40); i++) {
            Integer id = i;
            String name = UUID.randomUUID().toString();
            Integer age = random.nextInt(100);
            String occupation = UUID.randomUUID().toString();
            Person person = new Person(id, name, age, occupation);
            content = content + "\n";
            content = content + person.getId() + ";" + person.getName()  +";" + person.getAge() + ";" + person.getOccupation() ;
            personList.add(person);
        }
        try (PrintWriter out = new PrintWriter(tempFile.getAbsolutePath())) {
            out.println(content);
        }
        List<Person> result = application.readCsv(tempFile.getAbsolutePath());
        assertNotNull(result);
        assertEquals(personList.size(), result.size());
        for(int i = 0; i < personList.size(); i++) {
            Person p1 = personList.get(i);
            Person p2 = result.get(i);
            assertEquals(p1.getId(), p2.getId());
            assertEquals(p1.getAge(), p2.getAge());
            assertEquals(p1.getOccupation(), p2.getOccupation());
            assertEquals(p1.getName(), p2.getName());
        }
    }

    @Test(timeout = 2000)
    public void testSaveXml() throws IOException, ParserConfigurationException, SAXException {
        File tempFile = File.createTempFile("person", ".csv");
        String content = "id;name;age;occupation";

        Person p1 = new Person(33, "John", 20, "Student");
        Person p2 = new Person(11, "Jerry", 40, "Lecturer");
        Person p3 = new Person(88, "Tom", 21, "Student");
        Person p4 = new Person(10, "Mary", 35, "Manager");
        Person p5 = new Person(16, "Paul", 40, "Programmer");
        Person p6 = new Person(43, "Ben", 45, "Youtuber");
        List<Person> personList  = Arrays.asList(p1, p2, p3, p4, p5, p6);
        for(Person person : personList) {
            content = content + "\n";
            content = content + person.getId() + ";" + person.getName()  +";" + person.getAge() + ";" + person.getOccupation() ;
        }
        try (PrintWriter out = new PrintWriter(tempFile.getAbsolutePath())) {
            out.println(content);
        }

        application.saveXML(application.createTree(application.readCsv(tempFile.getAbsolutePath())));

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File("people.xml"));
        Element root = doc.getDocumentElement();

        NodeList nl = root.getElementsByTagName("person");
        List<Element> personNodes = new ArrayList<>();
        for (int i = 0; i < nl.getLength(); i++) {
            org.w3c.dom.Node n = nl.item(i);
            if (n.getNodeType() == org.w3c.dom.Node.ELEMENT_NODE) {
                Element elem = (Element) n;
                personNodes.add(elem);
            }
        }
        assertEquals(6, personNodes.size());

        assertEquals(33, Integer.parseInt(personNodes.get(0).getElementsByTagName("id").item(0).getTextContent())) ;
        assertEquals(20, Integer.parseInt(personNodes.get(0).getElementsByTagName("age").item(0).getTextContent())) ;
        assertEquals("John", personNodes.get(0).getElementsByTagName("name").item(0).getTextContent()) ;
        assertEquals("Student", personNodes.get(0).getElementsByTagName("occupation").item(0).getTextContent()) ;

        assertEquals(88, Integer.parseInt(personNodes.get(1).getElementsByTagName("id").item(0).getTextContent())) ;
        assertEquals(21, Integer.parseInt(personNodes.get(1).getElementsByTagName("age").item(0).getTextContent())) ;
        assertEquals("Tom", personNodes.get(1).getElementsByTagName("name").item(0).getTextContent()) ;
        assertEquals("Student", personNodes.get(1).getElementsByTagName("occupation").item(0).getTextContent()) ;

        assertEquals(11, Integer.parseInt(personNodes.get(2).getElementsByTagName("id").item(0).getTextContent())) ;
        assertEquals(40, Integer.parseInt(personNodes.get(2).getElementsByTagName("age").item(0).getTextContent())) ;
        assertEquals("Jerry", personNodes.get(2).getElementsByTagName("name").item(0).getTextContent()) ;
        assertEquals("Lecturer", personNodes.get(2).getElementsByTagName("occupation").item(0).getTextContent());

        assertEquals(43, Integer.parseInt(personNodes.get(3).getElementsByTagName("id").item(0).getTextContent())) ;
        assertEquals(45, Integer.parseInt(personNodes.get(3).getElementsByTagName("age").item(0).getTextContent())) ;
        assertEquals("Ben", personNodes.get(3).getElementsByTagName("name").item(0).getTextContent()) ;
        assertEquals("Youtuber", personNodes.get(3).getElementsByTagName("occupation").item(0).getTextContent());

        assertEquals(16, Integer.parseInt(personNodes.get(4).getElementsByTagName("id").item(0).getTextContent())) ;
        assertEquals(40, Integer.parseInt(personNodes.get(4).getElementsByTagName("age").item(0).getTextContent())) ;
        assertEquals("Paul", personNodes.get(4).getElementsByTagName("name").item(0).getTextContent()) ;
        assertEquals("Programmer", personNodes.get(4).getElementsByTagName("occupation").item(0).getTextContent());

        assertEquals(10, Integer.parseInt(personNodes.get(5).getElementsByTagName("id").item(0).getTextContent())) ;
        assertEquals(35, Integer.parseInt(personNodes.get(5).getElementsByTagName("age").item(0).getTextContent())) ;
        assertEquals("Mary", personNodes.get(5).getElementsByTagName("name").item(0).getTextContent()) ;
        assertEquals("Manager", personNodes.get(5).getElementsByTagName("occupation").item(0).getTextContent());
    }
}
