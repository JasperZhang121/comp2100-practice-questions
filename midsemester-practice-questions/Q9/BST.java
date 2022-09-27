import java.util.ArrayList;
import java.util.List;

public class BST {

	private Node root;

	public BST() {
		this.root = null;
	}

	public void insert(Key key) {
		Node parent = null;
		Node current = this.root;
		while (current != null) {
			if (current.key.compareTo(key) < 0) {
				parent = current;
				current = current.right;
			} else if (current.key.compareTo(key) > 0) {
				parent = current;
				current = current.left;
			}
		}

		if (parent == null && current == null) {
			this.root = new Node(key);
		} else {
			Node newNode = new Node(key);
			if (parent.key.compareTo(key) < 0) {
				parent.right = newNode;
			} else if (parent.key.compareTo(key) > 0) {
				parent.left = newNode;
			}
		}
	}

	public List<Key> invertedPreOrder() {
		// TODO
		// HINT: Use recursion
		// START YOUR CODE
		// END YOUR CODE

		var lis = new ArrayList<Key>();
		helper(this.root,lis);
		return lis;
	}

	public void helper(Node node, ArrayList<Key> lis){
		if (node==null)return;
		lis.add(node.key);
		helper(node.right,lis);
		helper(node.left,lis);
	}

}