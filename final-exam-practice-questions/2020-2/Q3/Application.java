
import java.util.LinkedList;
import java.util.List;


public class Application {

	public RBTree<Integer, Person> createTree(List<Person> personList) {

		RBTree<Integer, Person> tree = new RBTree<>();

		// ########## YOUR CODE STARTS HERE ##########

		
		
		// ########## YOUR CODE ENDS HERE ##########

		return tree;
	}

	public List<Person> readCsv(String fileName) {

		List<Person> list = new LinkedList<>();

		// ########## YOUR CODE STARTS HERE ##########
		
		

		// ########## YOUR CODE ENDS HERE ##########

		return list;
	}

	public void saveXML(RBTree<Integer, Person> tree) {

		if (tree == null) {
			return;
		}

		List<Node> list = tree.levelTraversal();

		// ########## YOUR CODE STARTS HERE ##########
		
		

		// ########## YOUR CODE ENDS HERE ##########
	}

}
