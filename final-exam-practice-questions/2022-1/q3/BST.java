import java.util.LinkedList;
import java.util.List;

public class BST {

	private Node root;

	public BST() {
		this.root = null;
	}

	public void insert(Node node) {
		if (this.root == null) {
			this.root = node;
		} else {
			Node parent = null;
			Node current = this.root;
			while (current != null) {
				if (current.key.compareTo(node.key) < 0) {
					parent = current;
					current = current.right;
				} else if (current.key.compareTo(node.key) > 0) {
					parent = current;
					current = current.left;
				} else {
					break;
				}
			}

			if (parent.key.compareTo(node.key) < 0) {
				parent.right = node;
			} else if (parent.key.compareTo(node.key) > 0) {
				parent.left = node;
			}
		}
	}

	public Node find(String key) {

		Node node = null;

		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		var current = this.root;

		while (current!=null){
			if (current.key.compareTo(key)<0){
				current = current.right;
			}
			else if (current.key.compareTo(key)>0){
				current = current.left;
			}
			else if (current.key.equals(key)){
				return current;
			}
		}
		// ########## YOUR CODE ENDS HERE ##########

		return node;
	}

	public List<Node> invertedPreOrder() {

		List<Node> list = new LinkedList<>();

		// TODO
		// ########## YOUR CODE STARTS HERE ##########

		var temp = this.root;
		if (root!=null){
			list.add(root);
			root = root.right;
			list.addAll(invertedPreOrder());
			root = temp;
			root =root.left;
			list.addAll(invertedPreOrder());
		}

		// ########## YOUR CODE ENDS HERE ##########

		return list;
	}

}